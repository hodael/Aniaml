import org.json.JSONObject;

public interface DataBase {
	
	public JSONObject add(cat c,JSONObject json);
	public JSONObject add(dog d,JSONObject json);
	public JSONObject add(goat g,JSONObject json);
	 
	public JSONObject delete(cat c,JSONObject json);
	public JSONObject delete(dog d,JSONObject json);
	public JSONObject delete(goat g,JSONObject json);
	
	public JSONObject update(cat c,JSONObject json);
	public JSONObject update(dog d,JSONObject json);
	public JSONObject update(goat g,JSONObject json);
	
	public JSONObject get(cat c,JSONObject json);
	public JSONObject get(dog d,JSONObject json);
	public JSONObject get(goat g,JSONObject json);
	
}
