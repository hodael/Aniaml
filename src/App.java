
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.dbcp2.BasicDataSource;



public class App {

	public static void main(String[] args) {
		try {
			BasicDataSource mySqlPool = poolDataSource.getInstance().getDataSource();

			ServerSocket serverSocket = new ServerSocket(8080);
			System.out.println("server is listening");
			ExecutorService executorService = Executors.newFixedThreadPool(100);
	        Socket client = null;
	        
	        while (true) {
	        	client = serverSocket.accept();
	        	System.out.println("client in");
	        	executorService.submit(new handleRequest(client,mySqlPool));
	        	
			}

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
