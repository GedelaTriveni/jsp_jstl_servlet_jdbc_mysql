package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.swiggy;

public class swiggyservices {
	private Connection conn;

	public swiggyservices(Connection conn) {
		super();
		this.conn = conn;
	}
	
	// Method for posting of data
	public boolean adding(swiggy sw) {
		boolean f = false;
		try {
			String sql = "insert into swiggyregistration (name, email, password, confirmpassword) values(?, ?, ?, ?)";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setString(1, sw.getName());
			pmst.setString(2, sw.getEmail());
			pmst.setString(3, sw.getPassword());
			pmst.setString(4, sw.getConfirmpassword());
			
			 int i = pmst.executeUpdate();
			 if (i > 0) {
				  f = true;
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	// Method for getting data
	public List<swiggy> getall(){
		List<swiggy> ll = new ArrayList<swiggy>();
		swiggy s = null;
		try {
			String sql = "select * from swiggyregistration";
			PreparedStatement pmst = conn.prepareStatement(sql);
			ResultSet RS = pmst.executeQuery();
			while (RS.next()) {
				s = new swiggy();
				s.setId(RS.getInt(1));
				s.setName(RS.getString(2));
				s.setEmail(RS.getString(3));
				s.setPassword(RS.getString(4));
				s.setConfirmpassword(RS.getString(5));
				ll.add(s);		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ll;
	}
	
	// Method for getting data from Id
	public swiggy getbyId(int Id) {
		swiggy s = null;
		try {
			String sql = "select * from swiggyregistration where id = ?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setInt(1, Id);
			ResultSet RS = pmst.executeQuery();
			while (RS.next()) {
				s = new swiggy();
				s.setId(RS.getInt(1));
				s.setName(RS.getString(2));
				s.setEmail(RS.getString(3));
				s.setPassword(RS.getString(4));
				s.setConfirmpassword(RS.getString(5));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
		
	}
	
	// Method for deleting data through Id
	public boolean deletebyId(int Id) {
		boolean f = false;
		try {
			String sql = "delete from swiggyregistration where id = ?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setInt(1, Id);
			int i = pmst.executeUpdate();
			if (i > 0) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	// Method for deleting data through Email
	public boolean deleteByEmail(String email) {
	    boolean f = false;
	    try {
	        String sql = "DELETE FROM swiggyregistration WHERE email = ?";
	        PreparedStatement pmst = conn.prepareStatement(sql);
	        pmst.setString(1, email);
	        int i = pmst.executeUpdate();
	        if (i > 0) {
	            f = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return f;
	}

	// Method for update data through Id
	public boolean updateswiggy(swiggy sw) {
		boolean f = false;
		try {
			String sql = "update swiggyregistration set name = ?, email = ?, password = ?,confirmpassword = ? where id = ?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setString(1, sw.getName());
			pmst.setString(2, sw.getEmail());
			pmst.setString(3, sw.getPassword());
			pmst.setString(4, sw.getConfirmpassword());
			pmst.setInt(5, sw.getId());
			int i = pmst.executeUpdate();
			if (i > 0) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
}
