<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Codes Master Entry</title>
</head>
<body>
<form action="insertCodesRecord" method="post">
<label for="codes_system_code">System Code </label>  <input type=text id=codes_system_code name=codes_system_code> </br>
<label for="codes_function_code">Function code </label>  <input type=text id=codes_function_code name=codes_function_code> </br>
<label for="codes_code_value">User Defined Code </label>  <input type=text id=codes_code_value name=codes_code_value> </br>
<label for="codes_desc_1">Description 1 </label>  <input type=text id=codes_desc_1 name=codes_desc_1> </br>
<label for="codes_desc_2">Description 2 </label>  <input type=text id=codes_desc_2 name=codes_desc_2> </br>
<label for="codes_desc_3">Description 3 </label>  <input type=text id=codes_desc_3 name=codes_desc_3> </br>
<label for="codes_flexcode_1">Flex. Code 1 </label>  <input type=text id=codes_flexcode_1 name=codes_flexcode_1> </br>
<label for="codes_flexcode_2">Flex. Code 2 </label>  <input type=text id=codes_flexcode_2 name=codes_flexcode_2> </br>

<input type=submit value="Submit">
</form>

</body>
</html>