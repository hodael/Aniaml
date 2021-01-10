import org.json.JSONObject;

public interface animal {
	public JSONObject get(DataBase db,JSONObject json );
	public JSONObject add(DataBase db,JSONObject json );
	public JSONObject delete(DataBase db,JSONObject json);
	public JSONObject update(DataBase db,JSONObject json); 

}
