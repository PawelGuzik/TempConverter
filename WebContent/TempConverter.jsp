<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style>
		p{color: green; font-size: 20pt; background-color: aqua;text-align: center; }
		#form{color: blue; font-size: 20pt;   text-align: center; background:lime; }
		h1{color: red;text-align: center;  text-overflow: ellipsis; background-color: yellow;  ;}
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Temperatura po konwersji</title>
</head>
<body>
	<h1>Konwerter temperatury</h1>
	<form id="form" action="TempServlet" method="get">
		<label for="temp">Temperatura: </label>
		<input type="number" value="0" name="tempValue" required>
		<select name="skale">
			<option value="C">C</option>
			<option value="F">F</option>
		</select>
		<input type="submit" name="send" value="Przelicz">
	</form>
	
	<%! String getResultTemp(HttpServletRequest request){
		if(request.getParameter("tempValue")!=null) 
			return   request.getParameter("tempValue") + " "+"<sup>o</sup>" +  request.getParameter("skale") 
			 + " to " + request.getAttribute("result");
		return "Podaj dane do konwersji";
		}%>
	
	<p><label id="wynik"> <%= getResultTemp(request) %>  </label></p>


</body>
</html>