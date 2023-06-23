<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Patients</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
 <p class="mt-4"><a href="AddPatientController" class="px-2">New Patient</a></p>
 <table class="table table-striped">
  <thead class="">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Vaccine</th>
      <th scope="col">1st Dose</th>
      <th scope="col">2nd Dose</th>
      
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${patients}" var="p">
    <tr>
      <td>${p.id}</td>
      <td>${p.name}</td>
      <td>${p.vaccineName}</td>
      <td>${p.firstDoseDate}</td>
      <!--SECOND DOSE TESTS  -->
      <td>
      <c:choose>
      	<c:when test="${p.vaccineDosesRequired == 1}">-</c:when>
      	<c:when test="${empty p.secondDoseDate}"><a href="RecievedController?id=${p.id}">Recieved</a></c:when>
      	<c:otherwise>${p.secondDoseDate}</c:otherwise>
      </c:choose>
      </td>
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