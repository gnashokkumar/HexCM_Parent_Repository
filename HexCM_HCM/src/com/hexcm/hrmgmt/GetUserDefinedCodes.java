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

@WebServlet(name = "GetUserDefinedCodes", urlPatterns = { "/GetUserDefinedCodes" })
public class GetUserDefinedCodes extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Entered Servlet...");

		PrintWriter out_GetUDC = res.getWriter();
		String var_CodeType_RequestFromJSP = req.getParameter("emp_master_code_type");
		int var_SystemCodeRequest_from_JSP=00; 
		String var_FunctionCodeRequest_from_JSP="TES";
		
		//---------HARD CODING User Defined Codes here------------
		//---Supervisor, Mentor, Job Type, Job Step, Pay Grade, Pay Step 
		//--will all have their own search and select forms
		
		if (var_CodeType_RequestFromJSP.equalsIgnoreCase("company_codes")) {
			var_SystemCodeRequest_from_JSP = 11;
			var_FunctionCodeRequest_from_JSP = "COM";
		}
		
		if (var_CodeType_RequestFromJSP.equalsIgnoreCase("business_unit_codes")) {
			var_SystemCodeRequest_from_JSP = 11;
			var_FunctionCodeRequest_from_JSP = "BUS";
		}

		if (var_CodeType_RequestFromJSP.equalsIgnoreCase("division_codes")) {
			var_SystemCodeRequest_from_JSP = 11;
			var_FunctionCodeRequest_from_JSP = "DIV";

		}
		
		if (var_CodeType_RequestFromJSP.equalsIgnoreCase("pay_status_codes")) {
			var_SystemCodeRequest_from_JSP = 11;
			var_FunctionCodeRequest_from_JSP = "PAS";
			
		}
		
		if (var_CodeType_RequestFromJSP.equalsIgnoreCase("pay_frequency_codes")) {
			var_SystemCodeRequest_from_JSP = 11;
			var_FunctionCodeRequest_from_JSP = "PAF";
		}
		
		if (var_CodeType_RequestFromJSP.equalsIgnoreCase("benefit_status_codes")) {
			var_SystemCodeRequest_from_JSP = 11;
			var_FunctionCodeRequest_from_JSP = "BST";
			
		}
				
		if (var_CodeType_RequestFromJSP.equalsIgnoreCase("country_codes")) {
			var_SystemCodeRequest_from_JSP = 11;
			var_FunctionCodeRequest_from_JSP = "CTY";
		}
		
		if (var_CodeType_RequestFromJSP.equalsIgnoreCase("gender_codes")) {
			var_SystemCodeRequest_from_JSP = 11;
			var_FunctionCodeRequest_from_JSP = "GEN";
		}
		
		if (var_CodeType_RequestFromJSP.equalsIgnoreCase("marital_status_codes")) {
			var_SystemCodeRequest_from_JSP = 11;
			var_FunctionCodeRequest_from_JSP = "MTS";
		}
		
		if (var_CodeType_RequestFromJSP.equalsIgnoreCase("employment_status_codes")) {
			var_SystemCodeRequest_from_JSP = 11;
			var_FunctionCodeRequest_from_JSP = "EMS";
		}
		
		if (var_CodeType_RequestFromJSP.equalsIgnoreCase("shift_code_codes")) {
			var_SystemCodeRequest_from_JSP = 11;
			var_FunctionCodeRequest_from_JSP = "SHC";
		}
		
				

		try (Connection getUDC_conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hexcm_business_tables",
				"Ashok", "Itanium@123");) {

			Statement fetchUDCQueryStatement = getUDC_conn.createStatement();
			
			// Building a query that will return user defined codes and related information to JSP file
			
			String fetchUDCQuery = "select codes_table_key, codes_system_code, codes_function_code, codes_code_value, codes_desc_1, codes_desc_2, codes_desc_3, "
									+"codes_flexcode_1, codes_flexcode_2 from codes_master where codes_system_code="
									+ var_SystemCodeRequest_from_JSP + " AND codes_function_code='" + var_FunctionCodeRequest_from_JSP + "';";
			
			// Testing the query by printing it on the console
			System.out.println(fetchUDCQuery);
			
			ResultSet fetchUDCResultSet = fetchUDCQueryStatement.executeQuery(fetchUDCQuery);
			System.out.println("Fetch employee query executed...");

			
			  int var_GetUDC_codes_system_code, var_GetUDC_codes_table_key; 
			  
			  String var_GetUDC_codes_function_code,
			  var_GetUDC_codes_code_value, var_GetUDC_codes_desc_1,
			  var_GetUDC_codes_desc_2, var_GetUDC_codes_desc_3,
			  var_GetUDC_codes_flexcode_1, var_GetUDC_codes_flexcode_2;
			  
			  
			 

			JSONArray jsonArray_Get_UDC = new JSONArray();

			while (fetchUDCResultSet.next()) {

				JSONObject jsonObj_GetUDC = new JSONObject();
				
				var_GetUDC_codes_table_key= fetchUDCResultSet.getInt("codes_table_key");
				var_GetUDC_codes_system_code = fetchUDCResultSet.getInt("codes_system_code");
				var_GetUDC_codes_function_code = fetchUDCResultSet.getString("codes_function_code");
				var_GetUDC_codes_code_value = fetchUDCResultSet.getString("codes_code_value");
				var_GetUDC_codes_desc_1 = fetchUDCResultSet.getString("codes_desc_1");
				var_GetUDC_codes_desc_2 = fetchUDCResultSet.getString("codes_desc_2"); 
				var_GetUDC_codes_desc_3 = fetchUDCResultSet.getString("codes_desc_3");
				var_GetUDC_codes_flexcode_1 = fetchUDCResultSet.getString("codes_flexcode_1"); 
				var_GetUDC_codes_flexcode_2 = fetchUDCResultSet.getString("codes_flexcode_2"); 
				
//				System.out.println("Flex Code 2 : " + var_GetUDC_codes_flexcode_2);
				
				jsonObj_GetUDC.put("var_GetUDC_codes_table_key", var_GetUDC_codes_table_key);
				jsonObj_GetUDC.put("var_GetUDC_codes_system_code", var_GetUDC_codes_system_code);
			
				
				
				  if(var_GetUDC_codes_function_code != null) {
				  jsonObj_GetUDC.put("var_GetUDC_codes_function_code",
				  var_GetUDC_codes_function_code); } else {
				  jsonObj_GetUDC.put("var_GetUDC_codes_function_code", ""); }
				  
				  if(var_GetUDC_codes_code_value != null) {
					  jsonObj_GetUDC.put("var_GetUDC_codes_code_value",
							  var_GetUDC_codes_code_value); } else {
					  jsonObj_GetUDC.put("var_GetUDC_codes_code_value", ""); }
				 
				  if(var_GetUDC_codes_desc_1 != null) {
					  jsonObj_GetUDC.put("var_GetUDC_codes_desc_1",
							  var_GetUDC_codes_desc_1); } else {
					  jsonObj_GetUDC.put("var_GetUDC_codes_desc_1", ""); }
				  
				  if(var_GetUDC_codes_desc_2 != null) {
					  jsonObj_GetUDC.put("var_GetUDC_codes_desc_2",
							  var_GetUDC_codes_desc_2); } else {
					  jsonObj_GetUDC.put("var_GetUDC_codes_desc_2", ""); }
				  
				  if(var_GetUDC_codes_desc_3 != null) {
					  jsonObj_GetUDC.put("var_GetUDC_codes_desc_3",
							  var_GetUDC_codes_desc_3); } else {
					  jsonObj_GetUDC.put("var_GetUDC_codes_desc_3", ""); }
				
				  if(var_GetUDC_codes_flexcode_1!=null) {
					  jsonObj_GetUDC.put("var_GetUDC_codes_flexcode_1",
					  var_GetUDC_codes_flexcode_1); } else {
					  jsonObj_GetUDC.put("var_GetUDC_codes_flexcode_1", ""); }
																
				  if(var_GetUDC_codes_flexcode_2!=null) {
				  jsonObj_GetUDC.put("var_GetUDC_codes_flexcode_2",
				  var_GetUDC_codes_flexcode_2); } else {
				  jsonObj_GetUDC.put("var_GetUDC_codes_flexcode_2", ""); }
				 

				jsonArray_Get_UDC.put(jsonObj_GetUDC);
			}

				res.setContentType("application/json;charset=UTF-8");
				String jsonString_GetUDC = jsonArray_Get_UDC.toString();
				System.out.println("jsonString:" + jsonString_GetUDC);
				res.getWriter().write(jsonString_GetUDC);

				Map<String, Object> jsonMap = new HashMap<String, Object>();
				jsonMap.put("Status", "Success");
				jsonMap.put("Rows", 100);
				
				//Test printing user defined code request from JQuery
				System.out.println("Code type requested through AJAX = " + var_CodeType_RequestFromJSP);

				getUDC_conn.close();

			

		} catch (SQLException e) {

			e.printStackTrace();

			out_GetUDC.println("<html>");
			out_GetUDC.println("<body>");
			out_GetUDC.println("There is an error in the program --> sql_Exception");
			out_GetUDC.println("</body>");
			out_GetUDC.println("</html>");

		} catch (JSONException e) {

			e.printStackTrace();

			out_GetUDC.println("<html>");
			out_GetUDC.println("<body>");
			out_GetUDC.println("There is an error in the program --> json_Exception");
			out_GetUDC.println("</body>");
			out_GetUDC.println("</html>");
		} finally {

			out_GetUDC.close();

		}

	}

}
