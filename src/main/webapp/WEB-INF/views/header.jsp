<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>BORAJI.COM</title>

	<spring:theme code="stylesheet" var="themeName" />
	<link href='<spring:url value="/resources/css/${themeName}"/>' rel="stylesheet" />
	
	<link href='<spring:url value="/resources/css/style.css"/>' rel="stylesheet" />
	
</head>