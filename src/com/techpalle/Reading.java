package com.techpalle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Reading {
	private static Connection con=null;
	private static Statement s=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	private static final String url ="jdbc:mysql://localhost:3306/jdbc";
	private static final String username ="root";
	private static final String password ="admin";
	
	public static ArrayList<Employee> getAllTableData(int number) 
	{
		ArrayList<Employee> al = new ArrayList<Employee>();
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");//Driver class can do, it converts java code to database in specific language(understandable code)
			
			con=DriverManager.getConnection(url, username, password);
		
			s=con.createStatement();
			
			rs=s.executeQuery("select * from employee");
			
			while(rs.next()) 
			{
				int id=rs.getInt("eid");
				String name=rs.getString("ename");
				int salary=rs.getInt("esalary");
				String mail=rs.getString("email");
				
				Employee emp = new Employee(id, name, salary, mail);
				al.add(emp);
			}
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
				if(rs!=null) 
				{
					rs.close();
				}
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
		return al;
	}

	public static void A() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url, username, password);
			
			//String querie ="select ename from employee";
			
			s=con.createStatement();
			
			rs=s.executeQuery("select ename from employee");
			
			while(rs.next()==true) 
			{
				System.out.println(rs.getString("ename"));
			}
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
				if(rs!=null) 
				{
					rs.close();
				}
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
	/*public static void getAllTableData(int number) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url, username, password);
			
			String querie="select * from employee where eid=?";
			
			ps=con.prepareStatement(querie);
			ps.setInt(1, number);
			
			rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				System.out.println(rs.getInt("eid"));
				System.out.println(rs.getString("ename"));
				System.out.println(rs.getString("esalary"));
				System.out.println(rs.getString("email"));
			}
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
				if(rs!=null) 
				{
					rs.close();
				}
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
	}*/
}
