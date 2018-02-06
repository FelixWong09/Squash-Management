package DataAccess;

import java.security.interfaces.RSAKey;
import java.sql.*;
import java.util.Vector;

import org.omg.CORBA.PRIVATE_MEMBER;

public class DataAccess {

	private Connection connection;
	private ResultSet resultSet;
	private Statement statement;
	private ResultSetMetaData resultSetMetaData;
	private int column = 0;
	Vector rows = new Vector();
	
	public Object[][] readData(String sql) throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//load MYSQL JDBC 驱动程序
			System.out.println("Success loading Mysql Driver!");
		} catch (Exception e) {
			System.out.println("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(
					 "jdbc:mysql://localhost:3306/squash","root","123456");
			System.out.println("Success connect Mysql server!");
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			resultSetMetaData = resultSet.getMetaData();
			while(resultSet.next()){
				Vector currentRow = new Vector();
				column = resultSetMetaData.getColumnCount();
				for (int i = 1; i < column+1; i++) {
					currentRow.addElement(resultSet.getString(i));
				}
				rows.addElement(currentRow);
			}
		} catch (Exception e) {
			System.out.println("get data error!");
			e.printStackTrace();
		}
		Object[][] data = new Object[rows.size()][column];
		System.out.println(resultSetMetaData.getColumnName(1));
		for (int j = 0; j < column; j++) {
			data[0][j] = resultSetMetaData.getColumnName(j+1);
		}
		for (int i = 1; i < rows.size(); i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = ((Vector) rows.get(i)).get(j);
			}
		}
		resultSet.close();
		statement.close();
		connection.close();
		return data;
		
	}
public Object[][] readData2(String sql) throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//load MYSQL JDBC 驱动程序
			System.out.println("Success loading Mysql Driver!");
		} catch (Exception e) {
			System.out.println("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(
					 "jdbc:mysql://localhost:3306/squash","root","123456");
			System.out.println("Success connect Mysql server!");
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			resultSetMetaData = resultSet.getMetaData();
			while(resultSet.next()){
				Vector currentRow = new Vector();
				column = resultSetMetaData.getColumnCount();
				for (int i = 1; i < column+1; i++) {
					currentRow.addElement(resultSet.getString(i));
				}
				rows.addElement(currentRow);
			}
		} catch (Exception e) {
			System.out.println("get data error!");
			e.printStackTrace();
		}
		Object[][] data = new Object[rows.size()][column];
		System.out.println(resultSetMetaData.getColumnName(1));
		
		for (int i = 0; i < rows.size(); i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = ((Vector) rows.get(i)).get(j);
			}
		}
		resultSet.close();
		statement.close();
		connection.close();
		return data;
		
	}
}
