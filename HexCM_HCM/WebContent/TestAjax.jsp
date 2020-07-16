<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="HexCM_HumanResources_Style.css">
<link rel="shortcut icon" href="#" />
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<title>Test JSP</title>
</head>
<body>
<button type = "button" id = "get_home_company" name="Ajax Call" value = "Search"> Search </button>

 <table>
				<thead>
					<tr>
						<th>Select</th>
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
				<tbody class="display-data">
					<!--  <div class="display-data"> -->

					<!-- Ajax call comes here -->

					<!--  </div>  -->
				</tbody>

				<tfoot>

				</tfoot>
</table>

</body>

<script type="text/javascript">

// Following code is an AJAX code block to get user defined codes for respective fields

 $("#get_home_company").click(function() {
	alert('Button Clicked');
	fetchDataAndDisplay();
  });    

  

/*   window.onload = function() {
	fetchDataAndDisplay();
	
} 
 */
function fetchDataAndDisplay() {
	$
			.ajax({
				url : "GetUserDefinedCodes",
				method : "POST"
			})
			.done(
					function(data) {
						
						var str = '';
						for (var i = 0; i < data.length; i++) {  //replaced data.length with 24 to display a max of 25 rows 
							str += '<tr>'
									+ '<td><input type="radio" name="EmployeeGrid"> </input></td>'
									+ '<td>' + data[i].var_GetUDC_codes_system_code + '</td>'
									+ '<td>' + data[i].var_GetUDC_codes_function_code
									+ '</td>' + '<td>'
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

				
						$(".display-data").empty();
						$(".display-data").append(str);
					})
					
					.fail(function() {
				alert("error");
			})
}

</script>
</html>