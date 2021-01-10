import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import org.apache.commons.dbcp2.BasicDataSource;
import org.json.JSONObject;

public class handleRequest implements Runnable {

	Socket client; 
	BufferedReader reader;
	BasicDataSource bds;

	public handleRequest(Socket client,BasicDataSource bds) {
		super();
		this.client = client;
		this.reader = null;
		this.bds = bds;
	}
	@Override
	public void run() {

		String requestBody = getRequestBody();
		JSONObject jsonResult = new JSONObject().put("status", "problem in servers");
		if(!requestBody.equals("500")) {
			parser parser = new parser();


			JSONObject  json = parser.parse(requestBody);


			doOperator oper = new doOperator(json,bds);

			jsonResult = oper.operate();
		}

		sendResponse(jsonResult);




	}	

	public String getRequestBody() {

		StringBuilder body = null;

		try {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream(), StandardCharsets.ISO_8859_1));
			String line = "";
			int length = 0;
			if (reader != null) {
				while ((line = reader.readLine()) != null) {
					if (line.equals("")) {
						break;
					}
					if (line.startsWith("Content-Length: ") || line.startsWith("content-length:")) {
						int index = line.indexOf(':') + 1;
						String len = line.substring(index).trim();
						length = Integer.parseInt(len);

					}

				}

			}

			body = new StringBuilder();

			if (length > 0) {
				int read;
				while ((read = reader.read()) != -1) {

					body.append((char) read);

					if (body.length() == length) {
						break;
					}

				}
			}



		} catch (Exception e) {
			e.printStackTrace();
			return "500";
		}

		return body.toString();
	}



	public void sendResponse(JSONObject json) {
		StringBuilder response = null;


		try {

			response = new StringBuilder();

			DataOutputStream output = new DataOutputStream(client.getOutputStream());

			if (output != null) {
				response.append("HTTP/1.1 200 OK\r\n");
				response.append("Content-Type:application/json\r\n");
				response.append("Content-Length:"+json.toString().length());
				response.append("\r\n\r\n");
				response.append(json);
				output.write(response.toString().getBytes(StandardCharsets.ISO_8859_1));
			}


			reader.close();
			client.close();
			output.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}




}
