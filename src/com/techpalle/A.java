package com.techpalle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class A {
	
	Connection con=null;
	Statement s=null;
	PreparedStatement ps=null;
	
	public static String url ="jdbc:mysql://localhost:3306/jdbc";
	public static String username ="root";
	public static String password ="admin";
	
	public void creating() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url, username, password);
			
			s=con.createStatement();
			
			s.executeUpdate("create table employee(eid int primary key auto_increment,"
					+ "ename varchar(40)not null,esalary int,email varchar(40)not null)");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(s!=null) 
				{
					s.close();
				}
				if(con!=null) 
				{
					con.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	public void inserting(String ename,int esalary,String email) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url, username, password);
			
			ps=con.prepareStatement("insert into employee(ename,esalary,email)values(?,?,?)");
			ps.setString(1, ename);
			ps.setInt(2, esalary);
			ps.setString(3, email);
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public void updating(int eid,String ename,String email) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url, username, password);
			
			ps=con.prepareStatement("update employee set ename=?,email=? where eid=?");
			ps.setString(1, ename);
			ps.setString(2, email);
			ps.setInt(3, eid);
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public void deleting(int eid) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url, username, password);
			
			ps=con.prepareStatement("delete from employee where eid=?");
			ps.setInt(1, eid);
			
			ps.executeUpdate();
		
			ps.close();
			con.close();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
