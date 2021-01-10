import org.apache.commons.dbcp2.BasicDataSource;
import org.json.JSONException;
import org.json.JSONObject;

public class doOperator {

	private JSONObject json;
	BasicDataSource bds;

	public doOperator(JSONObject json,BasicDataSource bds) {
		super();
		this.json = json;
		this.bds = bds;
	}


	public JSONObject operate() {
		
		
		try {
			String op = "";
			String tableName = "";
			try {
				op = json.getString("operator");
				tableName = json.getString("table");
			

			}catch (Exception e) {
				e.printStackTrace();
				return new  JSONObject().put("status", e.getMessage());
				
			}
			
			sqlDb db = new sqlDb(bds);
			animal an = null;	
			switch (tableName) {
			case "dogs":
			{
				an = new dog(); 
				switch (op)
				{
				case "get":
					return an.get(db,json);
				case "add":
					return an.add(db,json);
				case "delete":
					return an.delete(db,json);
				case "update":
					return an.update(db,json);
					
				default: 
					return new JSONObject().put("status", "operator "+op+" not exist");

				}
			}
			
			case "cats":
			{
				an = new cat(); 
				switch (op)
				{
				case "get":
					return an.get(db,json);

				case "add":
					return an.add(db,json);

				case "delete":
					return an.delete(db,json);

				case "update":
					return an.update(db,json);

				default: 
					return new JSONObject().put("status", "operator "+op+" not exist");

				}
			}
			
			case "goats":
			{
				an = new goat(); 
				switch (op)
				{
				case "get":
					return an.get(db,json);
					
				case "add":
					return an.add(db,json);
					
				case "delete":
					return an.delete(db,json);
					
				case "update":
					return an.update(db,json);
					
				default: 
					return new JSONObject().put("status", "operator "+op+" not exist");

				}
			}
			


			default:
				return new JSONObject().put("status", "table not exist");	 
			}

		} catch (JSONException e) {
			e.printStackTrace();
			return new JSONObject().put("status", "500");
		}


		


	}




}
