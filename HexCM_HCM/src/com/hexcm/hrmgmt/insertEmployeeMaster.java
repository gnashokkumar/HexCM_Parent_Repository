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

public class insertEmployeeMaster extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int var_empMaster_emp_ab_num;
	public static String var_empMaster_emp_alpha_name;
	public static int var_empMaster_emp_tax_id;
	public static int var_empMaster_emp_alt_num;
	public static String var_empMaster_emp_gender;
	public static int var_empMaster_emp_home_company;
	public static String var_empMaster_emp_home_bu;
	public static String var_empMaster_emp_division;
	public static String var_empMaster_emp_location;
	public static String var_empMaster_emp_pay_status;
	public static String var_empMaster_emp_pay_freq;
	public static String var_empMaster_emp_ben_status;
	public static String var_empMaster_emp_ben_group;
	public static String var_empMaster_emp_date_hired;
	public static String var_empMaster_emp_date_started;
	public static String var_empMaster_emp_date_pay_starts;
	public static String var_empMaster_emp_date_term;
	public static String var_empMaster_emp_date_pay_stops;
	public static String var_empMaster_emp_country_employment;
	public static String var_empMaster_emp_date_dob;
	public static String var_empMaster_emp_marital_status;
	public static String var_empMaster_emp_alt_name;
	public static String var_empMaster_emp_country_birth;
	public static String var_empMaster_emp_nationality;
	public static int var_empMaster_emp_supervisor;
	public static int var_empMaster_emp_mentor;
	public static String var_empMaster_emp_position_id;
	public static String var_empMaster_emp_job_type;
	public static String var_empMaster_emp_job_step;
	public static String var_empMaster_emp_job_title;
	public static String var_empMaster_emp_emp_status;
	public static String var_empMaster_emp_shift_code;
	public static float var_empMaster_emp_fte;
	public static String var_empMaster_emp_pay_class;
	public static String var_empMaster_emp_pay_grade;
	public static String var_empMaster_emp_pay_step;
	public static float var_empMaster_emp_sal_annual;
	public static float var_empMaster_emp_hourly_rate;
	public static float var_empMaster_emp_sal_period;
	public static float var_empMaster_emp_std_hrs_year;
	public static float var_empMaster_emp_std_hrs_period;
	public static String var_empMaster_emp_pay_on_std_hrs;
	public static String var_empMaster_emp_last_mod_by;
	public static String var_empMaster_emp_last_mod_date;
	public static String var_empMaster_emp_last_mod_time;
	public static String var_empMaster_emp_last_mod_app;
	public static String var_empMaster_emp_last_mod_machine;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		// Assigning variables with information received from jsp page.

		if (req.getParameter("emp_ab_num") != null ||  !"".equals(req.getParameter("emp_ab_num"))) {

			var_empMaster_emp_ab_num = Integer.parseInt(req.getParameter("emp_ab_num"));
		} else {
			System.out.println("Employee number is a mandatory field...");
		}

		var_empMaster_emp_alpha_name = req.getParameter("emp_alpha_name");

		System.out.println(var_empMaster_emp_ab_num + " : " + var_empMaster_emp_alpha_name);
		
		System.out.println("Entering tax id assignment...");
		
		// Consider checking --!req.getParameter("emp_tax_id").trim().equals(null)-- in the future if there 
		// is a null value passed instead of empty string from the web page.

		if (!req.getParameter("emp_tax_id").trim().isEmpty()) {
			var_empMaster_emp_tax_id = Integer.parseInt(req.getParameter("emp_tax_id"));
		} else {
			var_empMaster_emp_tax_id = 0;
		}
		
		// Consider checking --!req.getParameter("emp_alt_num").trim().equals(null)-- in the future if there 
		// is a null value passed instead of empty string from the web page.
		
		if (!req.getParameter("emp_alt_num").trim().isEmpty()) {
			var_empMaster_emp_alt_num = Integer.parseInt(req.getParameter("emp_alt_num"));
		} else {
			var_empMaster_emp_alt_num = 0;
		}

		var_empMaster_emp_gender = req.getParameter("emp_gender");
		
		// Consider checking --!req.getParameter("emp_home_company").trim().equals(null)-- in the future if there 
		// is a null value passed instead of empty string from the web page.

		if (!req.getParameter("emp_home_company").trim().isEmpty()) {
			var_empMaster_emp_home_company = Integer.parseInt(req.getParameter("emp_home_company"));
		} else {
			System.out.println("Home Company - Mandatory Field");
			var_empMaster_emp_home_company = 0;
		}

		var_empMaster_emp_home_bu = req.getParameter("emp_home_bu");
		var_empMaster_emp_division = req.getParameter("emp_division");
		var_empMaster_emp_location = req.getParameter("emp_location");
		var_empMaster_emp_pay_status = req.getParameter("emp_pay_status");
		var_empMaster_emp_pay_freq = req.getParameter("emp_pay_freq");
		var_empMaster_emp_ben_status = req.getParameter("emp_ben_status");
		var_empMaster_emp_ben_group = req.getParameter("emp_ben_group");

		if (req.getParameter("emp_date_hired").equals("")
				|| req.getParameter("emp_date_hired").equalsIgnoreCase(null)) {
			var_empMaster_emp_date_hired = "0000-00-00";
		} else {
			var_empMaster_emp_date_hired = req.getParameter("emp_date_hired");
		}

		if (req.getParameter("emp_date_started").equals("")
				|| req.getParameter("emp_date_started").equalsIgnoreCase(null)) {
			var_empMaster_emp_date_started = "0000-00-00";
		} else {
			var_empMaster_emp_date_started = req.getParameter("emp_date_started");
		}

		if (req.getParameter("emp_date_pay_starts").equals("")
				|| req.getParameter("emp_date_pay_starts").equalsIgnoreCase(null)) {
			var_empMaster_emp_date_pay_starts = "0000-00-00";
		} else {
			var_empMaster_emp_date_pay_starts = req.getParameter("emp_date_pay_starts");
		}

		if (req.getParameter("emp_date_term").equals("") || req.getParameter("emp_date_term").equalsIgnoreCase(null)) {
			var_empMaster_emp_date_term = "0000-00-00";
		} else {
			var_empMaster_emp_date_term = req.getParameter("emp_date_term");
		}

		if (req.getParameter("emp_date_pay_stops").equals("")
				|| req.getParameter("emp_date_pay_stops").equalsIgnoreCase(null)) {
			var_empMaster_emp_date_pay_stops = "0000-00-00";
		} else {
			var_empMaster_emp_date_pay_stops = req.getParameter("emp_date_pay_stops");
		}

		var_empMaster_emp_country_employment = req.getParameter("emp_country_employment");

		if (req.getParameter("emp_date_dob").equals("") || req.getParameter("emp_date_dob").equalsIgnoreCase(null)) {
			var_empMaster_emp_date_dob = "0000-00-00";
		} else {
			var_empMaster_emp_date_dob = req.getParameter("emp_date_dob");
		}

		var_empMaster_emp_marital_status = req.getParameter("emp_marital_status");
		var_empMaster_emp_alt_name = req.getParameter("emp_alt_name");
		var_empMaster_emp_country_birth = req.getParameter("emp_country_birth");
		var_empMaster_emp_nationality = req.getParameter("emp_nationality");
		
		// Consider checking --!req.getParameter("emp_supervisor").trim().equals(null)-- in the future if there 
		// is a null value passed instead of empty string from the web page.

		if (!req.getParameter("emp_supervisor").trim().isEmpty()) {
			var_empMaster_emp_supervisor = Integer.parseInt(req.getParameter("emp_supervisor"));
		} else {
			var_empMaster_emp_supervisor=0;
		}
		
		// Consider checking --!req.getParameter("emp_mentor").trim().equals(null)-- in the future if there 
		// is a null value passed instead of empty string from the web page.

		if (!req.getParameter("emp_mentor").trim().isEmpty()) {
			var_empMaster_emp_mentor = Integer.parseInt(req.getParameter("emp_mentor"));
		} else {
			var_empMaster_emp_mentor=0;
		}

		var_empMaster_emp_position_id = req.getParameter("emp_position_id");
		var_empMaster_emp_job_type = req.getParameter("emp_job_type");
		var_empMaster_emp_job_step = req.getParameter("emp_job_step");
		var_empMaster_emp_job_title = req.getParameter("emp_job_title");
		var_empMaster_emp_emp_status = req.getParameter("emp_emp_status");
		var_empMaster_emp_shift_code = req.getParameter("emp_shift_code");
		
		// Consider checking --!req.getParameter("emp_fte").trim().equals(null)-- in the future if there 
		// is a null value passed instead of empty string from the web page.

		if (!req.getParameter("emp_fte").trim().isEmpty()) {
			var_empMaster_emp_fte = Float.parseFloat(req.getParameter("emp_fte"));
		} else {
			var_empMaster_emp_fte=0;
		}

		var_empMaster_emp_pay_class = req.getParameter("emp_pay_class");
		var_empMaster_emp_pay_grade = req.getParameter("emp_pay_grade");
		var_empMaster_emp_pay_step = req.getParameter("emp_pay_step");
		
		// Consider checking --!req.getParameter("emp_sal_annual").trim().equals(null)-- in the future if there 
		// is a null value passed instead of empty string from the web page.

		if (!req.getParameter("emp_sal_annual").trim().isEmpty()) {
			var_empMaster_emp_sal_annual = Float.parseFloat(req.getParameter("emp_sal_annual"));
		} else {
			System.out.println("Employee Salary is a mandatory field");
			var_empMaster_emp_sal_annual=0;
		}
		
		// Consider checking --!req.getParameter("emp_hourly_rate").trim().equals(null)-- in the future if there 
		// is a null value passed instead of empty string from the web page.

		if (!req.getParameter("emp_hourly_rate").trim().isEmpty()) {
			var_empMaster_emp_hourly_rate = Float.parseFloat(req.getParameter("emp_hourly_rate"));
		} else {
			var_empMaster_emp_hourly_rate=0;
		}
		
		// Consider checking --!req.getParameter("emp_sal_period").trim().equals(null)-- in the future if there 
		// is a null value passed instead of empty string from the web page.

		if (!req.getParameter("emp_sal_period").trim().isEmpty()) {
			var_empMaster_emp_sal_period = Float.parseFloat(req.getParameter("emp_sal_period"));
		} else {
			var_empMaster_emp_sal_period=0;
		}
		
		// Consider checking --!req.getParameter("emp_std_hrs_year").trim().equals(null)-- in the future if there 
		// is a null value passed instead of empty string from the web page.

		if (!req.getParameter("emp_std_hrs_year").trim().isEmpty()) {
			var_empMaster_emp_std_hrs_year = Float.parseFloat(req.getParameter("emp_std_hrs_year"));
		} else {
			var_empMaster_emp_std_hrs_year=0;
		}
		
		// Consider checking --!req.getParameter("emp_std_hrs_period").trim().equals(null)-- in the future if there 
		// is a null value passed instead of empty string from the web page.

		if (!req.getParameter("emp_std_hrs_period").trim().isEmpty()) {
			var_empMaster_emp_std_hrs_period = Float.parseFloat(req.getParameter("emp_std_hrs_period"));
		} else {
			var_empMaster_emp_std_hrs_period=0;
		}

		var_empMaster_emp_pay_on_std_hrs = req.getParameter("emp_pay_on_std_hrs");

		// Audit information for table

		var_empMaster_emp_last_mod_by = "demoUser";
		var_empMaster_emp_last_mod_date = java.time.LocalDate.now().toString();
		var_empMaster_emp_last_mod_time = java.time.LocalTime.now().toString();
		var_empMaster_emp_last_mod_app = "employeeMaster";
		var_empMaster_emp_last_mod_machine = "Local";
		
	      // Set the response message's MIME type
	      res.setContentType("text/html;charset=UTF-8");
	      // Allocate a output writer to write the response message into the network socket
	      PrintWriter out = res.getWriter();

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hexcm_business_tables", "Ashok",
				"Itanium@123"); Statement stmt = conn.createStatement();) {
			
			String checkIfRecordExist = "select COUNT(emp_alpha_name) from emp_master where emp_ab_num in ("+ var_empMaster_emp_ab_num + ");";
			ResultSet employeeExists = stmt.executeQuery(checkIfRecordExist);
						
			employeeExists.next();
			int countRow = Integer.parseInt(employeeExists.getString(1));
			
			System.out.println("ResultSet = " + countRow);
			
			if(countRow == 0) { // To check if employee number is not already present in table
			
			
			String insertQuery = "insert into emp_master (emp_ab_num,emp_alpha_name,emp_tax_id,emp_alt_num,"
					+ "emp_gender,emp_home_company,emp_home_bu,emp_division,emp_location,emp_pay_status,"
					+ "emp_pay_freq,emp_ben_status,emp_ben_group,"
					+ "emp_date_hired,emp_date_started,emp_date_pay_starts,"
					+ "emp_date_term,emp_date_pay_stops,emp_country_employment,"
					+ "emp_date_dob,emp_marital_status,emp_alt_name,"
					+ "emp_country_birth,emp_nationality,emp_supervisor,emp_mentor,emp_position_id,emp_job_type,"
					+ "emp_job_step,emp_job_title,emp_emp_status,emp_shift_code,emp_fte,emp_pay_class,"
					+ "emp_pay_grade,emp_pay_step,emp_sal_annual,emp_hourly_rate,emp_sal_period,emp_std_hrs_year,"
					+ "emp_std_hrs_period,emp_pay_on_std_hrs,emp_last_mod_by,"
					+ "emp_last_mod_date,emp_last_mod_time,emp_last_mod_app,emp_last_mod_machine) values ("
					+ var_empMaster_emp_ab_num + ",'" + var_empMaster_emp_alpha_name + "','" + var_empMaster_emp_tax_id
					+ "'," + var_empMaster_emp_alt_num + ",'" + var_empMaster_emp_gender + "',"
					+ var_empMaster_emp_home_company + ",'" + var_empMaster_emp_home_bu + "','"
					+ var_empMaster_emp_division + "','" + var_empMaster_emp_location + "','"
					+ var_empMaster_emp_pay_status + "','" + var_empMaster_emp_pay_freq + "','"
					+ var_empMaster_emp_ben_status + "','" + var_empMaster_emp_ben_group + "','"
					+ var_empMaster_emp_date_hired + "','" + var_empMaster_emp_date_started + "','"
					+ var_empMaster_emp_date_pay_starts + "','" + var_empMaster_emp_date_term + "','"
					+ var_empMaster_emp_date_pay_stops + "','" + var_empMaster_emp_country_employment + "','"
					+ var_empMaster_emp_date_dob + "','" + var_empMaster_emp_marital_status + "','"
					+ var_empMaster_emp_alt_name + "','" + var_empMaster_emp_country_birth + "','"
					+ var_empMaster_emp_nationality + "'," + var_empMaster_emp_supervisor + ","
					+ var_empMaster_emp_mentor + ",'" + var_empMaster_emp_position_id + "','"
					+ var_empMaster_emp_job_type + "','" + var_empMaster_emp_job_step + "','"
					+ var_empMaster_emp_job_title + "','" + var_empMaster_emp_emp_status + "','"
					+ var_empMaster_emp_shift_code + "'," + var_empMaster_emp_fte + ",'" + var_empMaster_emp_pay_class
					+ "','" + var_empMaster_emp_pay_grade + "','" + var_empMaster_emp_pay_step + "',"
					+ var_empMaster_emp_sal_annual + "," + var_empMaster_emp_hourly_rate + ","
					+ var_empMaster_emp_sal_period + "," + var_empMaster_emp_std_hrs_year + ","
					+ var_empMaster_emp_std_hrs_period + ",'" + var_empMaster_emp_pay_on_std_hrs + "','"
					+ var_empMaster_emp_last_mod_by + "','" + var_empMaster_emp_last_mod_date + "','"
					+ var_empMaster_emp_last_mod_time + "','" + var_empMaster_emp_last_mod_app + "','"
					+ var_empMaster_emp_last_mod_machine + "');";

			// Check query by printing it into console. Enable code below while testing.
			// System.out.println(insertQuery);

			// Execute record insert into employee master
			stmt.executeUpdate(insertQuery);
			
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
			out.close(); // closing output writer.
		}

	}
}
