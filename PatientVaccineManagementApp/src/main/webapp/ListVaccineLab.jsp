<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Vaccine</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
 <p class="mt-4"><a href="NewVaccineController" class="px-2">New Vaccine</a>|<a href="NewDosesLab.jsp" class="px-2">New Doses</a></p>
 <table class="table table-striped">
  <thead class="">
    <tr>
      <th scope="col">Vaccine</th>
      <th scope="col">Doses Required</th>
      <th scope="col">Days Between Doses</th>
      <th scope="col">Total Doses Recieved</th>
      <th scope="col">Total Doses Left</th>
      
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${vaccines}" var="vaccine">
    <tr>
      <td>${vaccine.vaccineName}</td>
      <td>${vaccine.dosesRequired}</td>
      <td>
      	<c:choose>
      		<c:when test="${vaccine.daysBetweenDoses > 1}">${vaccine.daysBetweenDoses}</c:when>
      		<c:otherwise>-</c:otherwise>
      	</c:choose>
      </td>
      <td>${vaccine.dosesRecieved}</td>
      <td>${vaccine.dosesLeft}</td>
      <td><a href="EditVaccineController?id=${vaccine.id}">Edit</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<p class="my-5"><a href="FrontPageDisplay.jsp">Go Back To Front Page</a></p>
 </div>
 
 <!-- BOOTSTRAP REQUIREMENT -->
 <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>