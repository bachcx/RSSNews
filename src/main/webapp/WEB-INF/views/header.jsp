<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>RSS News</title>

<spring:theme code="stylesheet" var="themeName" />
<link href='<spring:url value="/resources/css/${themeName}"/>'
	rel="stylesheet" />

<link href='<spring:url value="/resources/css/style.css"/>'
	rel="stylesheet" />

</head>

<body>
	<div class="navbar navbar-expand-lg fixed-top navbar-light bg-light">
		<div class="container">
			<a class="navbar-brand" href="/">RSS News</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarCollapse" aria-controls="navbarCollapse"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="nav navbar-nav ml-auto" style = "font-size: 15px">
					<li class="nav-item"><a class="nav-link" href="/home">HOME
							<span class="sr-only"></span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="/">ADD RSS <span class="sr-only"></span>
					</a></li>
				</ul>
			</div>
		</div>
	</div>