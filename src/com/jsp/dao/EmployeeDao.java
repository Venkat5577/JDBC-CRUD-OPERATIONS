package com.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.Employee;

public class EmployeeDao {

	public void createTable() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud", "root",
					"root");
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"create table employee1( id int primary key, name varchar(30) not null, phoneNo bigint(10) not null, sal double not null, email varchar(20) not null,password varchar(8) not null );");
			connection.close();
			System.out.println("table created");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();

		} catch (SQLException e1) {
			e1.printStackTrace();

		}
	}

	public Employee saveEmployee(Employee e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud", "root",
					"root");
			PreparedStatement ps = connection.prepareStatement("insert into Employee1 values(?,?,?,?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setLong(3, e.getPhoneNo());
			ps.setDouble(4, e.getSal());
			ps.setString(5, e.getEmail());
			ps.setString(6, e.getPassword());
			ps.executeUpdate();
			connection.close();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}

	public int updateEmployee(Employee e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud", "root",
					"root");
			PreparedStatement ps = connection
					.prepareStatement("update Employee1 set name=?,phoneNo=?,sal=?,email=?,password=? where id=?");
			ps.setString(1, e.getName());
			ps.setLong(2, e.getPhoneNo());
			ps.setDouble(3, e.getSal());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getPassword());
			ps.setInt(6, e.getId());
			int res = ps.executeUpdate();
			connection.close();
			return res;
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return 0;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return 0;
		}
	}

	public int deleteEmployee(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud", "root",
					"root");
			PreparedStatement ps = connection.prepareStatement("delete from Employee where id=?");

			ps.setInt(1, id);

			int res = ps.executeUpdate();
			connection.close();
			return res;
		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
			return 0;
		} catch (SQLException e1) {
//			e1.printStackTrace();
			return 0;
		}
	}
	
	public List<Employee> getAllEmployee(){
		List<Employee> li=new ArrayList<Employee>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud", "root",
					"root");
			Statement statement = connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from employee");
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				long phoneNo=rs.getLong(3);
				double sal=rs.getDouble(4);
				String email=rs.getString(5);
				String password=rs.getString(6);
				Employee employee=new Employee();
				employee.setId(id);
				employee.setEmail(email);
				employee.setName(name);
				employee.setPassword(password);
				employee.setPhoneNo(phoneNo);
				employee.setSal(sal);
				li.add(employee);
			}
			connection.close();
			
		return li;
		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
			return null;

		} catch (SQLException e1) {
//			e1.printStackTrace();
			return null;
		}
	}
		
		public Employee getEmployeeById(int id) {
			Employee employee=new Employee();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud", "root",
						"root");
				PreparedStatement ps = connection.prepareStatement("select * from Employee where id=?");

				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					int id1=rs.getInt(1);
					String name=rs.getString(2);
					long phoneNo=rs.getLong(3);
					double sal=rs.getDouble(4);
					String email=rs.getString(5);
					String pasword=rs.getString(6);
					
					employee.setId(id1);
					employee.setEmail(email);
					employee.setName(name);
					employee.setPassword(pasword);
					employee.setPhoneNo(phoneNo);
					employee.setSal(sal);
				}
				connection.close();
				
			return employee;
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
				return null;

			} catch (SQLException e1) {
				e1.printStackTrace();
				return null;
			}
	}
	public Employee login(String userName,String password) {
		Employee employee=new Employee();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud", "root",
					"root");
			PreparedStatement ps = connection.prepareStatement("select * from Employee where email=? and password=?");
			
			ps.setString(1,userName);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id1=rs.getInt(1);
				String name=rs.getString(2);
				long phoneNo=rs.getLong(3);
				double sal=rs.getDouble(4);
				String email=rs.getString(5);
				
				employee.setId(id1);
				employee.setName(name);
				employee.setPhoneNo(phoneNo);
				employee.setSal(sal);
				employee.setEmail(email);
			}
			connection.close();
			return employee;
		} catch (ClassNotFoundException e1) {
			return null;
		} catch (SQLException e1) {
			return null;
		}
	}
		
}
