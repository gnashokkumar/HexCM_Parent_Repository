<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="HexCM_HumanResources_Style.css">
<link rel="shortcut icon" href="#" />
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<title>EE Master Entry</title>
</head>
<body>
<form action="insertEmployeeRecord" method="post">
<label for="emp_ab_num">Employee Number </label>  <input type="text" id="emp_ab_num" name="emp_ab_num"> </br>
<label for="emp_alpha_name">Alpha Name </label>  <input type=text id=emp_alpha_name name=emp_alpha_name> </br>
<label for="emp_tax_id">Tax ID </label>  <input type=text id=emp_tax_id name=emp_tax_id> </br>
<label for="emp_alt_num">Alternate Number </label>  <input type=text id=emp_alt_num name=emp_alt_num> </br>
<label for="emp_home_company">Home Company </label>  <input type="text" id="emp_home_company" name="emp_home_company"> 

<!-- All the search buttons in this form pass 3 parameters to the onclick javascript function. 
1. Connection keyword between jsp and servlet so that query returns the right user defined code.
2. Heading text of modal
3. Has the element id of the input field where value is returned to the respective input field.  -->

<input type="button" class="button" id = "get_home_company" name="get_home_company" value = "Search" onclick="callModal('company_codes','Company Codes','emp_home_company')"> </br>

<!-- The Modal -->
<div id="myModal" class="modal">

<!-- Modal content -->
  <div class="modal-content" id="modal_content">
    <div class="modal-header" id="modal_header">
      <span class="close">&times;</span>
      <h2 id="modal_heading">Modal Header</h2>
    </div>
    <div class="modal-body">
      
      
      <!-- Following input field is to store source of modal trigger. 
      This helps the javascript function to return selection to the right field -->
      
      <div> <input type="text" id="stores_source_of_modal" name="stores_source_of_modal" hidden="hidden" value=""> </div>
      <table>
				<thead>
					<tr>
						<th>Select</th>
						<th hidden = "hidden">Unique Key</th>
						<th>System Code</th>
						<th>Function Code</th>
						<th>User Defined Code</th>
						<th>Description 1</th>
						<th>Description 2</th>
						<th>Description 3</th>
						<th>Flex. Code 1</th>
						<th>Flex. Code 2</th>
					</tr>
				</thead>
				<tbody class="display_company_codes">
					<!--  <div class="display-data"> -->

					<!-- Ajax call comes here -->

					<!--  </div>  -->
				</tbody>

				<tfoot>

				</tfoot>
			</table>
      
    </div>
    <div class="modal-footer">
      <input type="button" id="select_home_company" name="select_home_company" value="Select" onclick="returnSelectedCode()">
    </div>
  </div>
</div>
<label for="emp_home_bu">Business Unit </label>  <input type=text id=emp_home_bu name=emp_home_bu> 
<input type="button" class="button" id = "get_business_unit" name="get_business_unit" value = "Search" onclick="callModal('business_unit_codes','Business Unit Codes','emp_home_bu')"> </br>


<label for="emp_division">Division </label>  <input type=text id=emp_division name=emp_division> 
<input type="button" class="button" id = "get_division" name="get_division" value = "Search" onclick="callModal('division_codes','Division Codes','emp_division')"> </br>


<label for="emp_location">Location </label>  <input type=text id=emp_location name=emp_location> </br>

<label for="emp_pay_status">Pay Status </label>  <input type=text id=emp_pay_status name=emp_pay_status>
<input type="button" class="button" id = "get_pay_status" name="get_pay_status" value = "Search" onclick="callModal('pay_status_codes','Pay Status Codes','emp_pay_status')"> </br>

<label for="emp_pay_freq">Pay Frequency </label>  <input type=text id=emp_pay_freq name=emp_pay_freq> 
<input type="button" class="button" id = "get_pay_frequency" name="get_pay_frequency" value = "Search" onclick="callModal('pay_frequency_codes','Pay Frequency Codes','emp_pay_freq')"></br>

<label for="emp_ben_status">Benefit Status </label>  <input type=text id=emp_ben_status name=emp_ben_status> 
<input type="button" class="button" id = "get_benefit status" name="get_benefit_status" value = "Search" onclick="callModal('benefit_status_codes','Benefit Status Codes','emp_ben_status')"></br>


<label for="emp_ben_group">Benefit Group </label>  <input type=text id=emp_ben_group name=emp_ben_group> </br>

<label for="emp_date_hired">Date - Hired </label>  <input type=date id=emp_date_hired name=emp_date_hired> </br>
<label for="emp_date_started">Date - Started </label>  <input type=date id=emp_date_started name=emp_date_started> </br>
<label for="emp_date_pay_starts">Date - Pay Starts </label>  <input type=date id=emp_date_pay_starts name=emp_date_pay_starts> </br>
<label for="emp_date_term">Date - Terminated </label>  <input type=date id=emp_date_term name=emp_date_term> </br>
<label for="emp_date_pay_stops">Date - Pay Stops </label>  <input type=date id=emp_date_pay_stops name=emp_date_pay_stops> </br>

<label for="emp_country_employment">Country of Employment </label>  <input type=text id=emp_country_employment name=emp_country_employment> 
<input type="button" class="button" id = "get_country_of_employment" name="get_country_of_employment" value = "Search" onclick="callModal('country_codes','Country Codes','emp_country_employment')"></br>


<label for="emp_date_dob">Date of Birth </label>  <input type=date id=emp_date_dob name=emp_date_dob> </br>

<label for="emp_gender">Gender </label>  <input type=text id=emp_gender name=emp_gender> 
<input type="button" class="button" id = "get_gender_codes" name="get_gender_codes" value = "Search" onclick="callModal('gender_codes','Gender Codes','emp_gender')"></br>


<label for="emp_marital_status">Marital Status </label>  <input type=text id=emp_marital_status name=emp_marital_status> 
<input type="button" class="button" id = "get_marital_status" name="get_marital_status" value = "Search" onclick="callModal('marital_status_codes','Marital Status Codes','emp_marital_status')"></br>


<label for="emp_alt_name">Alternate Name </label>  <input type=text id=emp_alt_name name=emp_alt_name> </br>

<label for="emp_country_birth">Country - Birth </label>  <input type=text id=emp_country_birth name=emp_country_birth> 
<input type="button" class="button" id = "get_country_of_birth" name="get_country_of_birth" value = "Search" onclick="callModal('country_codes','Country Codes','emp_country_birth')"></br>


<label for="emp_nationality">Nationality </label>  <input type=text id=emp_nationality name=emp_nationality> 
<input type="button" class="button" id = "get_country_nationatity" name="get_country_nationatity" value = "Search" onclick="callModal('country_codes','Country Codes','emp_nationality')"></br>


<label for="emp_supervisor">Supervisor </label>  <input type=text id=emp_supervisor name=emp_supervisor> </br>
<label for="emp_mentor">Mentor </label>  <input type=text id=emp_mentor name=emp_mentor> </br>
<label for="emp_position_id">Position ID </label>  <input type=text id=emp_position_id name=emp_position_id> </br>
<label for="emp_job_type">Job Type </label>  <input type=text id=emp_job_type name=emp_job_type> </br>
<label for="emp_job_step">Job Step </label>  <input type=text id=emp_job_step name=emp_job_step> </br>
<label for="emp_job_title">Job Title </label>  <input type=text id=emp_job_title name=emp_job_title> </br>

<label for="emp_emp_status">Employment Status </label>  <input type=text id=emp_emp_status name=emp_emp_status>
<input type="button" class="button" id = "get_employment_status_codes" name="get_employment_status_codes" value = "Search" onclick="callModal('employment_status_codes','Employment Status Codes','emp_emp_status')"></br>


<label for="emp_shift_code">Shift Code </label>  <input type=text id=emp_shift_code name=emp_shift_code> 
<input type="button" class="button" id = "get_employment_status_codes" name="get_employment_status_codes" value = "Search" onclick="callModal('shift_code_codes','Employment Status Codes','emp_shift_code')"></br>


<label for="emp_fte">Full Time Equivalent </label>  <input type=text id=emp_fte name=emp_fte> </br>
<label for="emp_pay_class">Pay Class </label>  <input type=text id=emp_pay_class name=emp_pay_class> </br>
<label for="emp_pay_grade">Pay Grade </label>  <input type=text id=emp_pay_grade name=emp_pay_grade> </br>
<label for="emp_pay_step">Pay Step </label>  <input type=text id=emp_pay_step name=emp_pay_step> </br>
<label for="emp_sal_annual">Salary - Annual </label>  <input type=text id=emp_sal_annual name=emp_sal_annual> </br>
<label for="emp_hourly_rate">Hourly Rate </label>  <input type=text id=emp_hourly_rate name=emp_hourly_rate> </br>
<label for="emp_sal_period">Salary - Pay Period </label>  <input type=text id=emp_sal_period name=emp_sal_period> </br>
<label for="emp_std_hrs_year">Std. Hours Per Year </label>  <input type=text id=emp_std_hrs_year name=emp_std_hrs_year> </br>
<label for="emp_std_hrs_period">Std Hours Per Pay Period </label>  <input type=text id=emp_std_hrs_period name=emp_std_hrs_period> </br>
<label for="emp_pay_on_std_hrs">Pay On Standard Hours ? </label>  <input type=text id=emp_pay_on_std_hrs name=emp_pay_on_std_hrs> </br>

<input type=submit value="Submit">
</form>
</body>

<script type="text/javascript">
 // Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("get_home_company");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

 // When the user clicks the button, open the modal 
/* btn.onclick = function() {
	
  modal.style.display = "block";
  fetchDataAndDisplay();
}  */

//TEST CODE -- HOPE IT WORKS
function callModal(codeType, tableHeading, sourceElementId) {
	
	modal.style.display = "block";
	document.getElementById("modal_heading").innerHTML=tableHeading;
	fetchDataAndDisplay(codeType);
	document.getElementById("stores_source_of_modal").value = sourceElementId;
}


// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
} 
</script> 

<script>

// Following code is an AJAX code block to get user defined codes for respective fields

/*  $("#get_home_company").click(function() {
	// alert('Button Clicked');
	fetchDataAndDisplay();
	//modal.style.display = "block";
});   */   

  

/*   window.onload = function() {
	fetchDataAndDisplay();
	
} 
 */
function fetchDataAndDisplay(codeType) {
	$
			.ajax({
				url : "GetUserDefinedCodes",
				method : "POST",
				data: {"emp_master_code_type" : codeType}
			})
			.done(
					function(data) {
						
						var str = '';
						for (var i = 0; i < data.length; i++) {  //replaced data.length with 24 to display a max of 25 rows 
							str += '<tr>'
									+ '<td><input type="radio" id='+i+' name="udcRow" value = '+data[i].var_GetUDC_codes_code_value+'> </input></td>'
									+ '<td hidden = "hidden">' + data[i].var_GetUDC_codes_table_key + '</td>'
									+ '<td>' + data[i].var_GetUDC_codes_system_code + '</td>'
									+ '<td>' + data[i].var_GetUDC_codes_function_code
									+ '</td>' + '<td id="'+data[i].var_GetUDC_codes_table_key+'">'
									+ data[i].var_GetUDC_codes_code_value + '</td>'
									+ '<td>' + data[i].var_GetUDC_codes_desc_1
									+ '</td>' + '<td>'
									+ data[i].var_GetUDC_codes_desc_2 + '</td>'
									+ '<td>' + data[i].var_GetUDC_codes_desc_3
									+ '</td>' + '<td>'
									+ data[i].var_GetUDC_codes_flexcode_1 + '</td>'  + '<td>'
									+ data[i].var_GetUDC_codes_flexcode_2 + '</td>'
									+ '</tr>';

						}

				
						$(".display_company_codes").empty();
						$(".display_company_codes").append(str);
					})
					 /* .success(function() {
						alert("Success"); 
					}) */
					.fail(function() {
				alert("error");
			})
}
 
 // Function to return selected value to Modal
 
 function returnSelectedCode() { 
            var element_Code = document.getElementsByName('udcRow'); 
            var targetElementIdForCodesReturn = document.getElementById("stores_source_of_modal").value
              
            for(udcRowNum = 0; udcRowNum < element_Code.length; udcRowNum++) { 
                if(element_Code[udcRowNum].checked) 
                document.getElementById(targetElementIdForCodesReturn).value = element_Code[udcRowNum].value; 
            } 
            
            modal.style.display = "none"
        } 

</script>


</html>