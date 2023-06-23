<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Doses</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
 <form action="NewDosesController" method="post">
 	<div class="form-group">
 		<label for="name">Vaccine</label>
 		<select name="name" class="form-control">
 			<c:forEach items="${vaccines}" var="v">
 			<option value="${v.vaccineName}">${v.vaccineName}</option>
 			</c:forEach>
 		</select>
 	</div>
 	<div class="form-group">
 		<label for="doses">New Doses Recieved</label>
 		<input type="number" name="doses" class="form-control">
 	</div>
 	<div class="form-group">
 		<button type="submit" class="btn btn-primary">Save</button>
 	</div>
 </form>
 </div>
 
 <!-- BOOTSTRAP REQUIREMENT -->
 <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>