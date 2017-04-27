<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head></head>
<body>
<form:form modelAttribute="person"  action="person">
    <!-- bind to the creams property of person -->
    <!-- create check boxes for all available ice creams -->
    <!-- any already in person.creams should be automatically checked -->
    <form:checkboxes path="favouriteIceCreams" items="${iceCreams}" />
    <input type="hidden" value="${person.id}" name="personId"/>
    <input type="Submit" value="Submit">
</form:form>
</body>
</html>
