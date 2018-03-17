package com.example.firstbootapp.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstMvcController {

	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "First MVC Controller";
	}
	
	@RequestMapping("/data")
	@ResponseBody
	public String data() {
		String rez = "";
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/intens?user=root&password=roottt");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select name "
										+ "from t_product");
			while (rs.next()) 
				rez = rez + rs.getString(1) + "<br>";
			rs.close();
			st.close();
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   return rez;
	}	
}
