



import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;



public class poolDataSource {

	private static BasicDataSource  ds = null ;
	private static poolDataSource  instance ;

	private poolDataSource() {

		try {
			ds = new BasicDataSource();
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost/animals?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
			ds.setUsername("root");
			ds.setPassword("c7491654");
			ds.setInitialSize(10);
			ds.setMaxTotal(20);
		}
		catch (Exception e) {
			e.printStackTrace();
		}



	}

	public BasicDataSource getDataSource() {
		return ds;
	}

	public static poolDataSource getInstance() {
		if(instance == null) {
			instance = new poolDataSource();
		}
		return instance;
	}




}
