<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src='https://meet.jit.si/external_api.js'></script>
	<style>
		*{
			margin:0px;
			padding:0px;   
		}
	</style>
</head>
<body> 
<div class="showRedirecting">Redirecting to videoCalling...</div> 
	<form>
		<input  type="hidden" name="name" id="enteredName" value="${roomname}" readonly="">
		<!--  <input type="button" onClick="onButtonClick()">-->
	</form>
</body>

<script>
	$(document).ready(function(){
		onButtonClick();
		$(".showRedirecting").hide();
	})
	function onButtonClick(){
		var enteredData = $("#enteredName").val();
		
		//var enteredData = roomname;
		
		const domain = 'meet.jit.si';
		const options = {
		    
		    roomName: enteredData,
		    	width: 1355,
				   height: 655,
		};
		const api = new JitsiMeetExternalAPI(domain, options);
	}
</script>

</html>