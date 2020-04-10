package JDBC;

import java.sql.ResultSet;

import ApplicationModel.Session_Detail;

public class Session_Table {
	DBConnection dbCon;
	ResultSet rs;
	
	public Session_Table() {
		// TODO Auto-generated constructor stub
		dbCon = new DBConnection();
	}
	
	public boolean insertNewSession(Session_Detail newSession){return true;}
	
	public ResultSet retreievSessions() {
		return rs;
	}
	
}
