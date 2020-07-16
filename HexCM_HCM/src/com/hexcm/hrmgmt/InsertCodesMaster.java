package com.hexcm.hrmgmt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertCodesMaster extends HttpServlet {

//	public static int var_codesMaster_codes_table_key;
	public static int var_codesMaster_codes_system_code;
	public static String var_codesMaster_codes_function_code;
	public static String var_codesMaster_codes_code_value;
	public static String var_codesMaster_codes_desc_1;
	public static String var_codesMaster_codes_desc_2;
	public static String var_codesMaster_codes_desc_3;
	public static String var_codesMaster_codes_flexcode_1;
	public static String var_codesMaster_codes_flexcode_2;
	public static String var_codesMaster_codes_last_mod_by;
	public static String var_codesMaster_codes_last_mod_date;
	public static String var_codesMaster_codes_last_mod_time;
	public static String var_codesMaster_codes_last_mod_app;
	public static String var_codesMaster_codes_last_mod_machine;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		// Assigning variables with information received from jsp page.

		if (!req.getParameter("codes_system_code").trim().isEmpty()) {
			var_codesMaster_codes_system_code = Integer.parseInt(req.getParameter("codes_system_code"));
		} else {
			System.out.println("System code can't be blank...");
		}

		var_codesMaster_codes_function_code = req.getParameter("codes_function_code");

		var_codesMaster_codes_code_value = req.getParameter("codes_code_value");

		var_codesMaster_codes_desc_1 = req.getParameter("codes_desc_1");

		var_codesMaster_codes_desc_2 = req.getParameter("codes_desc_2");

		var_codesMaster_codes_desc_3 = req.getParameter("codes_desc_3");

		var_codesMaster_codes_flexcode_1 = req.getParameter("codes_flexcode_1");

		var_codesMaster_codes_flexcode_2 = req.getParameter("codes_flexcode_2");

		var_codesMaster_codes_last_mod_by = "demoUser";
		var_codesMaster_codes_last_mod_date = java.time.LocalDate.now().toString();
		var_codesMaster_codes_last_mod_time = java.time.LocalTime.now().toString();
		var_codesMaster_codes_last_mod_app = "codesMasterApp";
		var_codesMaster_codes_last_mod_machine = "Local";

		// Set the response message's MIME type
		res.setContentType("text/html;charset=UTF-8");
		// Allocate a output writer to write the response message into the network
		// socket
		PrintWriter out = res.getWriter();

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hexcm_business_tables", "Ashok",
				"Itanium@123"); Statement stmt = conn.createStatement();) {

			String checkIfRecordExist = "SELECT COUNT(codes_system_code) FROM codes_master WHERE codes_system_code in ('"
					+ var_codesMaster_codes_system_code + "') AND codes_function_code in ('"
					+ var_codesMaster_codes_function_code + "') AND codes_code_value in ('"
					+ var_codesMaster_codes_code_value + "');";

			ResultSet codeExists = stmt.executeQuery(checkIfRecordExist);

			codeExists.next();
			int countRow = Integer.parseInt(codeExists.getString(1));

			System.out.println("ResultSet - Codes = " + countRow);

			if (countRow == 0) {
				String insertCodeQuery = "insert into codes_master (codes_system_code,codes_function_code,codes_code_value,codes_desc_1,"
						+ "codes_desc_2,codes_desc_3,codes_flexcode_1,codes_flexcode_2,codes_last_mod_by,codes_last_mod_date,"
						+ "codes_last_mod_time,codes_last_mod_app,codes_last_mod_machine" + ") values ("
						+ var_codesMaster_codes_system_code + ",'" + var_codesMaster_codes_function_code + "','"
						+ var_codesMaster_codes_code_value + "','" + var_codesMaster_codes_desc_1 + "','"
						+ var_codesMaster_codes_desc_2 + "','" + var_codesMaster_codes_desc_3 + "','"
						+ var_codesMaster_codes_flexcode_1 + "','" + var_codesMaster_codes_flexcode_2 + "','"
						+ var_codesMaster_codes_last_mod_by + "','" + var_codesMaster_codes_last_mod_date + "','"
						+ var_codesMaster_codes_last_mod_time + "','" + var_codesMaster_codes_last_mod_app + "','"
						+ var_codesMaster_codes_last_mod_machine + "');";

				// Check query by printing it into console. Enable code below while testing.
//				System.out.println(insertCodeQuery);

				// Execute record insert into code_master
					stmt.executeUpdate(insertCodeQuery);
					
					

			} else {
				System.out.println("Insert failed. Duplicate employee record...");

				// Following html will be deleted after maturing this code.
				out.println("<html>");
				out.println("<body>");
				out.println("Insert failed. Duplicate employee record...");
				out.println("</body>");
				out.println("</html>");

			}

		} catch (SQLException e) {

			e.printStackTrace();

			out.println("<html>");
			out.println("<body>");
			out.println("There is an error in the program --> sqlException");
			out.println("</body>");
			out.println("</html>");

		} finally {

			out.close();
		}

	}

}
