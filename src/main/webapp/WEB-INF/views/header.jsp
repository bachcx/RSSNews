<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RSS News</title>

<spring:theme code="stylesheet" var="themeName" />
<link href='<spring:url value="/resources/css/${themeName}"/>'
	rel="stylesheet" />

<link href='<spring:url value="/resources/css/style.css"/>'
	rel="stylesheet" />

</head>

<body>
	<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-primary">
		<a class="navbar-brand" href="/">RSS News</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/">Home
						<span class="sr-only"></span>
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="/addRss">Add Rss
						<span class="sr-only"></span>
				</a></li>
			</ul>
		</div>
	</nav>