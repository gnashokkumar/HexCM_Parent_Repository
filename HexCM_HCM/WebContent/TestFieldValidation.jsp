<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Field Validation</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body onload="fieldProperties()">

<!-- Input field ids and names should be equal to the table column name all the time -->

<form method="post" action="/validateFields">
<label for="emp_ab_num">Employee Number </label>  <input type="text" id="emp_ab_num" name="emp_ab_num"> </br>
<label for="emp_alpha_name">Alpha Name </label>  <input type=text id=emp_alpha_name name=emp_alpha_name> </br>
<label for="emp_tax_id">Tax ID </label>  <input type=text id=emp_tax_id name=emp_tax_id> </br>
<label for="emp_alt_num">Alternate Number </label>  <input type=text id=emp_alt_num name=emp_alt_num> </br>
<label for="emp_home_company">Home Company </label>  <input type="text" id="emp_home_company" name="emp_home_company"> </br>

<input type="submit" value=submit id=form_submit> 
</form>


</body>

<script type="text/javascript"> </script>

<script>
function fieldProperties() {
	getInputFields();
	
	
}

function getInputFields() {
	var inputFields, index, whereQueryClause='';

	inputFields = document.getElementsByTagName("input");
	for (index = 0; index < inputFields.length; ++index) {
		
		if(index != inputFields.length - 1) {
			whereQueryClause += "'" + inputFields[index].getAttribute("id") + "',";
		} else {
			whereQueryClause += "'" + inputFields[index].getAttribute("id") + "'";
		}
		
			
	}
	console.log(whereQueryClause);
	ajaxGetinputFieldProperties(whereQueryClause);
}

function ajaxGetinputFieldProperties(whereQueryClause) {
	var var_GetTabColProperties_ColumnName, var_GetTabColProperties_DataType, var_Field_Max_Length;
	 $.ajax
     ({
         url:'GetTableColumnProperties',
         data:{ QuerySubString : whereQueryClause }, //whereQueryClause contains all input field IDs from this form.
         type:'POST',
         cache:false,
         success:function(data){
        	 	console.log(data);
        	 		for( var jsonIndex=0;jsonIndex<data.length;jsonIndex++) {
        	 		var_GetTabColProperties_ColumnName = data[jsonIndex].var_GetTabColProperties_ColumnName;
        	 		var_GetTabColProperties_DataType = data[jsonIndex].var_GetTabColProperties_DataType;
        	 		var_Field_Max_Length = data[jsonIndex].var_Field_Max_Length;
        	 		
        	 		//Following function inserts max length to all input fields that have identical ids as in table.
        	 		insertMaxLengthToInputElements(var_GetTabColProperties_ColumnName, var_GetTabColProperties_DataType, var_Field_Max_Length);
        	 		 
        		 
        		}
        	 },
         error:function(){alert('Error receiving JSON');}
     });
}

 function insertMaxLengthToInputElements(var_GetTabColProperties_ColumnName, var_GetTabColProperties_DataType, var_Field_Max_Length) {
	
	//JQuery to create maxlength attribute and set its value passed on by servlet.
	$("#"+var_GetTabColProperties_ColumnName).attr("maxlength",var_Field_Max_Length);
	
	
} 


</script>
</html>