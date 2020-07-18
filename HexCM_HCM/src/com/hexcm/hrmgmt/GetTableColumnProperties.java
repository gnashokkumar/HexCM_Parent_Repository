package com.hexcm.hrmgmt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet(name = "GetTableColumnProperties", urlPatterns = { "/GetTableColumnProperties" })
public class GetTableColumnProperties extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Entered Servlet...");
		PrintWriter out_GetColumn_Properties = res.getWriter();
		
		String queryWhereClauseFromJsp = req.getParameter("QuerySubString");
		
		try (Connection getColumnProperties_conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hexcm_business_tables",
				"Ashok", "Itanium@123");) {
			
			Statement getColumnProperties_stmt = getColumnProperties_conn.createStatement();
			
			String getColumnProperties_Query = "select column_name, data_type,character_maximum_length, numeric_precision from hexcm_table_columns"  
					+ " where column_name in ("+ queryWhereClauseFromJsp +");";
			
			// Testing the query by printing it on the console
			System.out.println(getColumnProperties_Query);
						
			ResultSet getColumnProperties_ResultSet = getColumnProperties_stmt.executeQuery(getColumnProperties_Query);
			System.out.println("Fetch employee query executed...");
			
			String var_GetTabColProperties_ColumnName, var_GetTabColProperties_DataType;
			int var_GetTabColProperties_CharMaxLen, var_GetTabColProperties_NumPrecision;
			
			JSONArray jsonArray_GetTabColProp = new JSONArray();
			
			while (getColumnProperties_ResultSet.next()) {
				
				JSONObject jsonObj_GetTabColProp = new JSONObject();
				
				var_GetTabColProperties_ColumnName = getColumnProperties_ResultSet.getString("column_name");
				var_GetTabColProperties_DataType = getColumnProperties_ResultSet.getString("data_type");
				var_GetTabColProperties_CharMaxLen = getColumnProperties_ResultSet.getInt("character_maximum_length");
				var_GetTabColProperties_NumPrecision = getColumnProperties_ResultSet.getInt("numeric_precision");
				
				jsonObj_GetTabColProp.put("var_GetTabColProperties_ColumnName", var_GetTabColProperties_ColumnName);
				jsonObj_GetTabColProp.put("var_GetTabColProperties_DataType", var_GetTabColProperties_DataType);
				
				// Coded only for data types varchar, int and decimal... This might need additional code in the future to 
				// accomodate more data types.
				
				if (var_GetTabColProperties_DataType.equalsIgnoreCase("varchar")){
					jsonObj_GetTabColProp.put("var_Field_Max_Length", var_GetTabColProperties_CharMaxLen);
				}
				if (var_GetTabColProperties_DataType.equalsIgnoreCase("int") || var_GetTabColProperties_DataType.equalsIgnoreCase("decimal")){
					jsonObj_GetTabColProp.put("var_Field_Max_Length", var_GetTabColProperties_NumPrecision);
				}
				
				
				//Writing JSON object containing of data from 4 variables to a JSON array.
				jsonArray_GetTabColProp.put(jsonObj_GetTabColProp);
				
			}
			// Printing the JSON array to console to test values
			System.out.println(jsonArray_GetTabColProp);
			
			res.setContentType("application/json;charset=UTF-8");
			String jsonString_GetTabColProp = jsonArray_GetTabColProp.toString();
			System.out.println("jsonString:" + jsonString_GetTabColProp);
			res.getWriter().write(jsonString_GetTabColProp);

			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("Status", "Success");
			jsonMap.put("Rows", 100);
			
			getColumnProperties_conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			out_GetColumn_Properties.println("<html>");
			out_GetColumn_Properties.println("<body>");
			out_GetColumn_Properties.println("There is an error in the program --> sql_Exception");
			out_GetColumn_Properties.println("</body>");
			out_GetColumn_Properties.println("</html>");
		} 
			  catch (JSONException e) { e.printStackTrace(); out_GetColumn_Properties.println("<html>");
			  out_GetColumn_Properties.println("<body>");
			  out_GetColumn_Properties.println("There is an error in the program --> json_Exception");
			  out_GetColumn_Properties.println("</body>"); out_GetColumn_Properties.println("</html>"); }
			 
		finally {
			out_GetColumn_Properties.close();
		}
	}
	
}
