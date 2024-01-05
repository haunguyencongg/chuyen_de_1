package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import utils.DBConnectionUtils;

public class TestDBConnection {

	  public static void main(String[] args) throws SQLException {
	    Connection conn = null;

	    try {
	      conn = DBConnectionUtils.getConnection();
	      
	      if (conn != null) {
	        System.out.println("Kết nối thành công!");
	      } else {
	        System.out.println("Không thể kết nối đến cơ sở dữ liệu"); 
	      }
	    } finally {
	      if (conn != null) {
	        try {
	          conn.close();
	        } catch (SQLException ex) {
	          System.out.println(ex.getMessage());
	        }
	      }
	    }
	  }

	}