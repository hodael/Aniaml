import org.json.JSONObject;

public class goat implements animal {



	public JSONObject add(DataBase db, JSONObject json) {
		return db.add(this, json);
		
	}

	
	public JSONObject delete(DataBase db, JSONObject json) {
		return db.delete(this, json);
		
	}
 
	public JSONObject update(DataBase db, JSONObject json) {
		return db.update(this, json);
		
	}
 
	public JSONObject get(DataBase db, JSONObject json) {
		return db.get(this, json);
		
	}

}

