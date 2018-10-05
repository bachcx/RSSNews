<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<jsp:include page="header.jsp"></jsp:include>

<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		<a class="navbar-brand" href="#">BORAJI.COM</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only"></span>
				</a></li>
			</ul>
		</div>
	</nav>

	<div role="main" class="container">
		<div class="jumbotron">
			<h1>Spring MVC 5</h1>
			<p class="lead">This is an example of using theme resolver in
				Spring MVC.</p>


			<div class="dropdown">
				<button class="btn btn-danger dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">Change Theme</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					<a class="dropdown-item" href="?theme=cerulean">Cerulean</a> <a
						class="dropdown-item" href="?theme=pulse">Pulse</a>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<div class="bs-component">

					<c:forEach var="article" items="${articleList1}">

						<div class="card mb-3">
							<h3 class="card-header">A1</h3>
							<div class="card-body">
								<h5 class="card-title">${article.title}</h5>
								<h6 class="card-subtitle text-muted">Support card subtitle</h6>
							</div>
							<div>
								<img class="article-img"
									<c:if test="${empty article.imgLink}">
										src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22318%22%20height%3D%22180%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20318%20180%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_158bd1d28ef%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A16pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_158bd1d28ef%22%3E%3Crect%20width%3D%22318%22%20height%3D%22180%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22129.359375%22%20y%3D%2297.35%22%3EImage%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E"
									</c:if>
									<c:if test="${not empty article.imgLink}">
								    	src="${article.imgLink}"
									</c:if>
									alt="Card image">
							</div>
							<div class="card-body">
								<p class="card-text">${article.shortContent}</p>
							</div>
							<div class="card-body">
								<a href="${article.link}" class="card-link" target="_blank">Card link</a> <a
									href="#" class="card-link">Another link</a>
							</div>
							<div class="card-footer text-muted">${article.pubDate}</div>
						</div>
					</c:forEach>
				</div>
			</div>

			<div class="col-lg-4">
				<div class="bs-component">

					<c:forEach var="article" items="${articleList2}">

						<div class="card mb-3">
							<h3 class="card-header">A2</h3>
							<div class="card-body">
								<h5 class="card-title">${article.title}</h5>
								<h6 class="card-subtitle text-muted">Support card subtitle</h6>
							</div>
							<img class="article-img"
								<c:if test="${empty article.imgLink}">
									src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22318%22%20height%3D%22180%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20318%20180%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_158bd1d28ef%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A16pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_158bd1d28ef%22%3E%3Crect%20width%3D%22318%22%20height%3D%22180%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22129.359375%22%20y%3D%2297.35%22%3EImage%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E"
								</c:if>
								<c:if test="${not empty article.imgLink}">
							    	src="${article.imgLink}"
								</c:if>
								alt="Card image">
							<div class="card-body">
								<p class="card-text">${article.shortContent}</p>
							</div>
							<div class="card-body">
								<a href="${article.link}" class="card-link" target="_blank">Card link</a> <a
									href="#" class="card-link">Another link</a>
							</div>
							<div class="card-footer text-muted">${article.pubDate}</div>
						</div>
					</c:forEach>
				</div>
			</div>

			<div class="col-lg-4">
				<div class="bs-component">

					<c:forEach var="article" items="${articleList3}">

						<div class="card mb-3">
							<h3 class="card-header">A3</h3>
							<div class="card-body">
								<h5 class="card-title">${article.title}</h5>
								<h6 class="card-subtitle text-muted">Support card subtitle</h6>
							</div>
							<img class="article-img"
								<c:if test="${empty article.imgLink}">
									src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22318%22%20height%3D%22180%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20318%20180%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_158bd1d28ef%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A16pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_158bd1d28ef%22%3E%3Crect%20width%3D%22318%22%20height%3D%22180%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22129.359375%22%20y%3D%2297.35%22%3EImage%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E"
								</c:if>
								<c:if test="${not empty article.imgLink}">
							    	src="${article.imgLink}"
								</c:if>
								alt="Card image">
							<div class="card-body">
								<p class="card-text">${article.shortContent}</p>
							</div>
							<div class="card-body">
								<a href="${article.link}" class="card-link" target="_blank">Card link</a> <a
									href="#" class="card-link">Another link</a>
							</div>
							<div class="card-footer text-muted">${article.pubDate}</div>
						</div>
					</c:forEach>
				</div>
			</div>

		</div>

	</div>



	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>