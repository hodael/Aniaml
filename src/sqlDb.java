import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;
import org.json.JSONObject;

public class sqlDb implements DataBase {
	private BasicDataSource bs;

	public sqlDb(BasicDataSource bs) {
		this.bs = bs;
	}

	@Override
	public JSONObject add(cat c, JSONObject json) {
		JSONObject jsonResult = new JSONObject();
		String name ="", type = "", age = "", weight = "";
		try {
			name = json.getString("name"); 
			type = json.getString("type"); 
			age = json.getString("age"); 
			weight = json.getString("weight");  
		} catch (Exception e) {
			String status = e.getMessage();
			jsonResult.put("status", status);
			return jsonResult;
		}
		try(Connection con = bs.getConnection()){
			String query = "insert into cats "
					+ "(cat_name, cat_type, cat_weight, cat_age)"
					+" values (?, ?, ?, ?)";
			try(PreparedStatement ps = con.prepareStatement(query)) {
				 ps.setString (1, name);
				 ps.setString (2, type);
				 ps.setString (3, weight);
				 ps.setString (4, age);
				
				 ps.execute();
				 String status = "200";
				 jsonResult.put("status", status);
				 return jsonResult;
				 
			} catch (Exception e) {
				e.printStackTrace();
				String status = "500";
				jsonResult.put("status", status);
				return jsonResult;
			}


		}catch (Exception e) {
			e.printStackTrace();
			String status = "500";
			jsonResult.put("status", status);
			return jsonResult;
		}
	}

	@Override
	public JSONObject add(dog d, JSONObject json) {
		JSONObject jsonResult = new JSONObject();
		String name ="", type = "", age = "", weight = "";
		try {
			name = json.getString("name"); 
			type = json.getString("type"); 
			age = json.getString("age"); 
			weight = json.getString("weight");  
		} catch (Exception e) {
			String status = e.getMessage();
			jsonResult.put("status", status);
			return jsonResult;
		}
		try(Connection con = bs.getConnection()){
			String query = "insert into dogs "
					+ "(dog_name, dog_age, dog_weight, dog_type)"
					+" values (?, ?, ?, ?)";
			try(PreparedStatement ps = con.prepareStatement(query)) {
				 ps.setString (1, name);
				 ps.setString (2, type);
				 ps.setString (3, weight);
				 ps.setString (4, age);
				
				 ps.execute();
				 String status = "200";
				 jsonResult.put("status", status);
				 return jsonResult;
				 
			} catch (Exception e) {
				e.printStackTrace();
				String status = "500";
				jsonResult.put("status", status);
				return jsonResult;
			}


		}catch (Exception e) {
			e.printStackTrace();
			String status = "500";
			jsonResult.put("status", status);
			return jsonResult;
		}
	}

	@Override
	public JSONObject add(goat g, JSONObject json) {
		JSONObject jsonResult = new JSONObject();
		String name ="", type = "", age = "", weight = "";
		try {
			name = json.getString("name"); 
			type = json.getString("type"); 
			age = json.getString("age"); 
			weight = json.getString("weight");  
		} catch (Exception e) {
			String status = e.getMessage();
			jsonResult.put("status", status);
			return jsonResult;
		}
		try(Connection con = bs.getConnection()){
			String query = "insert into goats "
					+ "(goat_name, goat_age, goat_weight, goat_type)"
					+" values (?, ?, ?, ?)";
			try(PreparedStatement ps = con.prepareStatement(query)) {
				 ps.setString (1, name);
				 ps.setString (2, type);
				 ps.setString (3, weight);
				 ps.setString (4, age);
				
				 ps.execute();
				 String status = "200";
				 jsonResult.put("status", status);
				 return jsonResult;
				 
			} catch (Exception e) {
				e.printStackTrace();
				String status = "500";
				jsonResult.put("status", status);
				return jsonResult;
			}


		}catch (Exception e) {
			e.printStackTrace();
			String status = "500";
			jsonResult.put("status", status);
			return jsonResult;
		}
	}

	@Override
	public JSONObject delete(cat c, JSONObject json) {
		JSONObject jsonResult = new JSONObject();
		String id = "";
		try {
			id = json.getString("id"); 
		} catch (Exception e) {
			String status = e.getMessage();
			jsonResult.put("status", status);
			return jsonResult;
		}
		
		try(Connection con = bs.getConnection()){
			try(PreparedStatement st = con.prepareStatement("DELETE FROM cats WHERE id ="+id)  ){
				int rowAffected = st.executeUpdate();
				
				if(rowAffected<1) {
					String status = "404";
					jsonResult.put("status", status);
					return jsonResult;

				}else {
					String status = "200";
					jsonResult.put("status", status);
					return jsonResult;

				}


			}catch (Exception e) {
				e.printStackTrace();
				String status = "500";
				jsonResult.put("status", status);
				return jsonResult;
			}


		}catch (Exception e) {
			e.printStackTrace();
			String status = "500";
			jsonResult.put("status", status);
			return jsonResult;
		}

	}

	@Override
	public JSONObject delete(dog d, JSONObject json) {
		JSONObject jsonResult = new JSONObject();
		String id = "";
		try {
			id = json.getString("id"); 
		} catch (Exception e) {
			String status = e.getMessage();
			jsonResult.put("status", status);
			return jsonResult;
		} 
		try(Connection con = bs.getConnection()){
			try(PreparedStatement st = con.prepareStatement("DELETE FROM dogs WHERE id ="+id)  ){
				int rowAffected = st.executeUpdate();
				
				if(rowAffected<1) {
					String status = "404";
					jsonResult.put("status", status);
					return jsonResult;

				}else {
					String status = "200";
					jsonResult.put("status", status);
					return jsonResult;

				}


			}catch (Exception e) {
				e.printStackTrace();
				String status = "500";
				jsonResult.put("status", status);
				return jsonResult;
			}


		}catch (Exception e) {
			e.printStackTrace();
			String status = "500";
			jsonResult.put("status", status);
			return jsonResult;
		}

	}

	@Override
	public JSONObject delete(goat g, JSONObject json) {
		JSONObject jsonResult = new JSONObject();
		String id = "";
		try {
			id = json.getString("id"); 
		} catch (Exception e) {
			String status = e.getMessage();
			jsonResult.put("status", status);
			return jsonResult;
		}
		try(Connection con = bs.getConnection()){
			try(PreparedStatement st = con.prepareStatement("DELETE FROM goats WHERE id ="+id)  ){
				int rowAffected = st.executeUpdate();
				
				if(rowAffected<1) {
					String status = "404";
					jsonResult.put("status", status);
					return jsonResult;

				}else {
					String status = "200";
					jsonResult.put("status", status);
					return jsonResult;

				}


			}catch (Exception e) {
				e.printStackTrace();
				String status = "500";
				jsonResult.put("status", status);
				return jsonResult;
			}


		}catch (Exception e) {
			e.printStackTrace();
			String status = "500";
			jsonResult.put("status", status);
			return jsonResult;
		}

	}

	@Override
	public JSONObject update(cat c, JSONObject json) {
		JSONObject jsonResult = new JSONObject();
		String name ="", type = "", age = "", weight = "", id = "";
		try {
			name = json.getString("name"); 
			type = json.getString("type"); 
			age = json.getString("age"); 
			weight = json.getString("weight");  
			id = json.getString("id");  
		} catch (Exception e) {
			String status = e.getMessage();
			jsonResult.put("status", status);
			return jsonResult;
		}
		try(Connection con = bs.getConnection()){
			String query = "update cats set cat_name=?, cat_type=?, cat_weight=?, cat_age=? where id ="+id; 
			try(PreparedStatement ps = con.prepareStatement(query)) {
				 ps.setString (1, name);
				 ps.setString (2, type);
				 ps.setString (3, weight);
				 ps.setString (4, age);
				
				 int rowAffected =  ps.executeUpdate();
				 String status = "200";
				 if(rowAffected != 1) {
					 status = "404";
				 }
				 jsonResult.put("status", status);
				 return jsonResult;
				 
			} catch (Exception e) {
				e.printStackTrace();
				String status = "500";
				jsonResult.put("status", status);
				return jsonResult;
			}


		}catch (Exception e) {
			e.printStackTrace();
			String status = "500";
			jsonResult.put("status", status);
			return jsonResult;
		}
		
	}

	@Override
	public JSONObject update(dog d, JSONObject json) {
		JSONObject jsonResult = new JSONObject();
		String name ="", type = "", age = "", weight = "", id = "";
		try {
			name = json.getString("name"); 
			type = json.getString("type"); 
			age = json.getString("age"); 
			weight = json.getString("weight");  
			id = json.getString("id");  
		} catch (Exception e) {
			String status = e.getMessage();
			jsonResult.put("status", status);
			return jsonResult;
		}
		try(Connection con = bs.getConnection()){
			String query = "update dogs set dog_name=?, dog_type=?, dog_weight=?, dog_age=? where id ="+id; 
			try(PreparedStatement ps = con.prepareStatement(query)) {
				 ps.setString (1, name);
				 ps.setString (2, type);
				 ps.setString (3, weight);
				 ps.setString (4, age);
				
				 int rowAffected =  ps.executeUpdate();
				 String status = "200";
				 if(rowAffected != 1) {
					 status = "404";
				 }
				 jsonResult.put("status", status);
				 return jsonResult;
				 
			} catch (Exception e) {
				e.printStackTrace();
				String status = "500";
				jsonResult.put("status", status);
				return jsonResult;
			}


		}catch (Exception e) {
			e.printStackTrace();
			String status = "500";
			jsonResult.put("status", status);
			return jsonResult;
		}
	}

	@Override
	public JSONObject update(goat g, JSONObject json) {
		JSONObject jsonResult = new JSONObject();
		String name ="", type = "", age = "", weight = "", id = "";
		try {
			name = json.getString("name"); 
			type = json.getString("type"); 
			age = json.getString("age"); 
			weight = json.getString("weight");  
			id = json.getString("id");  
		} catch (Exception e) {
			String status = e.getMessage();
			jsonResult.put("status", status);
			return jsonResult;
		}
		try(Connection con = bs.getConnection()){
			String query = "update goats set goat_name=?, goat_type=?, goat_weight=?, goat_age=? where id ="+id; 
			try(PreparedStatement ps = con.prepareStatement(query)) {
				 ps.setString (1, name);
				 ps.setString (2, type);
				 ps.setString (3, weight);
				 ps.setString (4, age);
				
				 int rowAffected =  ps.executeUpdate();
				 String status = "200";
				 if(rowAffected != 1) {
					 status = "404";
				 }
				 jsonResult.put("status", status);
				 return jsonResult;
				 
			} catch (Exception e) {
				e.printStackTrace();
				String status = "500";
				jsonResult.put("status", status);
				return jsonResult;
			}


		}catch (Exception e) {
			e.printStackTrace();
			String status = "500";
			jsonResult.put("status", status);
			return jsonResult;
		}
	}

	@Override
	public JSONObject get(cat c, JSONObject json) {
		JSONObject jsonResult = new JSONObject();
		String id = "";
		try {
			id = json.getString("id"); 
		} catch (Exception e) {
			String status = e.getMessage();
			jsonResult.put("status", status);
			return jsonResult;
		}
		try(Connection con = bs.getConnection()){
			try(Statement stmt=con.createStatement() ){
				try (ResultSet rs=stmt.executeQuery("select * from cats where id ="+id)){
					if(!rs.next()) {
						String status = "404";
						jsonResult.put("status", status);
						return jsonResult;
					}
					else {
						String catName = rs.getString("cat_name");
						String catType = rs.getString("cat_type");
						String catWeight = rs.getString("cat_weight");
						String catAge = rs.getString("cat_age");
						jsonResult.put("id", id);
						jsonResult.put("cat_name", catName);
						jsonResult.put("cat_type", catType);
						jsonResult.put("cat_weight", catWeight);
						jsonResult.put("cat_age", catAge);
						jsonResult.put("status", "200");
						return jsonResult;
					}


				} catch (Exception e) {
					e.printStackTrace();
					String status = "500";
					jsonResult.put("status", status);
					return jsonResult;

				}


			}catch (Exception e) {
				e.printStackTrace();
				String status = "500";
				jsonResult.put("status", status);
				return jsonResult;
			}




		}catch (SQLException  e) {
			e.printStackTrace();
			String status = "500";
			jsonResult.put("status", status);
			return jsonResult;
		}
	}

	@Override
	public JSONObject get(dog d, JSONObject json) {
		JSONObject jsonResult = new JSONObject();
		String id = "";
		try {
			id = json.getString("id"); 
		} catch (Exception e) {
			String status = e.getMessage();
			jsonResult.put("status", status);
			return jsonResult;
		}
		try(Connection con = bs.getConnection()){
			try(Statement stmt=con.createStatement() ){
				try (ResultSet rs=stmt.executeQuery("select * from dogs where id ="+id)){
					if(!rs.next()) {
						String status = "404";
						jsonResult.put("status", status);
						return jsonResult;
					}
					else {
						String dogName = rs.getString("dog_name");
						String dogType = rs.getString("dog_type");
						String dogWeight = rs.getString("dog_weight");
						String dogAge = rs.getString("dog_age");
						jsonResult.put("id", id);
						jsonResult.put("dog_name", dogName);
						jsonResult.put("dog_type", dogType);
						jsonResult.put("dog_weight", dogWeight);
						jsonResult.put("dog_age", dogAge);
						jsonResult.put("status", "200");
						return jsonResult;
					}


				} catch (Exception e) {
					e.printStackTrace();
					String status = "500";
					jsonResult.put("status", status);
					return jsonResult;

				}


			}catch (Exception e) {
				e.printStackTrace();
				String status = "500";
				jsonResult.put("status", status);
				return jsonResult;
			}




		}catch (SQLException  e) {
			e.printStackTrace();
			String status = "500";
			jsonResult.put("status", status);
			return jsonResult;
		}
	}

	@Override
	public JSONObject get(goat g, JSONObject json) {
		JSONObject jsonResult = new JSONObject();
		String id = "";
		try {
			id = json.getString("id"); 
		} catch (Exception e) {
			String status = e.getMessage();
			jsonResult.put("status", status);
			return jsonResult;
		}
		try(Connection con = bs.getConnection()){
			try(Statement stmt=con.createStatement() ){
				try (ResultSet rs=stmt.executeQuery("select * from goats where id ="+id)){
					if(!rs.next()) {
						String status = "404";
						jsonResult.put("status", status);
						return jsonResult;
					}
					else {
						String goatName = rs.getString("goat_name");
						String goatType = rs.getString("goat_type");
						String goatWeight = rs.getString("goat_weight");
						String goatAge = rs.getString("goat_age");
						jsonResult.put("id", id);
						jsonResult.put("goat_name", goatName);
						jsonResult.put("goat_type", goatType);
						jsonResult.put("goat_weight", goatWeight);
						jsonResult.put("goat_age", goatAge);
						jsonResult.put("status", "200");
						return jsonResult;
					}


				} catch (Exception e) {
					e.printStackTrace();
					String status = "500";
					jsonResult.put("status", status);
					return jsonResult;

				}


			}catch (Exception e) {
				e.printStackTrace();
				String status = "500";
				jsonResult.put("status", status);
				return jsonResult;
			}




		}catch (SQLException  e) {
			e.printStackTrace();
			String status = "500";
			jsonResult.put("status", status);
			return jsonResult;
		}
	}






}
