<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>:: Project Aspecto - AOP ::</title>
		<script type="text/javascript">
		
			var curDt = new Date();         
			function disablementFunction(day){         
				if (day.isWeekend) 
					return false;         
				if (curDt==undefined){         
					curDt = day.date.getDate();         
				}         
				if (curDt.getTime() - day.date.getTime() > 0) 
					return true; 
				else 
					return false;         
				}         
			
			function disabledClassesProv(day){         
				if (curDt.getTime() - day.date.getTime() >= 0) 
					return 'rf-cal-boundary-day';         
				var res = '';         
				if (day.isWeekend) res+='weekendBold ';         
				if (day.day%3==0) res+='everyThirdDay';         
				return res;         
				}     
			
			</script>
	</head>
	<body>
		<div align="center">
			<img align="top" alt="" src="img/logo_A&L_03.jpg">

