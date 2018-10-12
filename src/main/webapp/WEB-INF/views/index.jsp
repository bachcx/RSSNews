<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
	<!-- <div class="jumbotron">
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
		</div> -->


	<ul class="nav nav-tabs fixed-bottom bg-white">
		<c:forEach items="${list}" var="rssItem" varStatus="status">
			<li class="nav-item"><c:if
					test="${rssItem.linkRss eq urlSelected}">
					<a class="nav-link active" href="/getFeed2?url=${rssItem.linkRss}">
						<c:if test="${not empty rssItem.nameRss}">
									${rssItem.nameRss} 
								</c:if> <c:if test="${empty rssItem.nameRss}">
									${rssItem.linkRss} 
								</c:if>
					</a>
				</c:if> <c:if test="${rssItem.linkRss != urlSelected}">
					<a class="nav-link" href="/getFeed2?url=${rssItem.linkRss}"> <c:if
							test="${not empty rssItem.nameRss}">
									${rssItem.nameRss} 
								</c:if> <c:if test="${empty rssItem.nameRss}">
									${rssItem.linkRss} 
								</c:if>
					</a>
				</c:if></li>
		</c:forEach>
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade active show" id="">
			<p>
				<c:if test="${not empty articleList1}">
					<c:forEach var="article" items="${articleList1}">
						<div class="row article">
							<div class="article-img">
								<a href="${article.link}" target="_blank"> <c:if
										test="${empty article.mediaLink}">
										<img class="article-img-url img-fluid rounded mb-3 mb-md-0"
											src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22318%22%20height%3D%22180%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20318%20180%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_158bd1d28ef%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A16pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_158bd1d28ef%22%3E%3Crect%20width%3D%22318%22%20height%3D%22180%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22129.359375%22%20y%3D%2297.35%22%3EImage%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E"
											alt="Card image">
									</c:if> <c:if test="${not empty article.mediaLink}">
										<c:if test="${not article.videoFlag}">
											<img class="article-img-url img-fluid rounded mb-3 mb-md-0"
												src="${article.mediaLink}" alt="Card image">
										</c:if>
										<c:if test="${article.videoFlag}">
											<iframe
												class="article-img-url img-fluid rounded mb-3 mb-md-0"
												width="560" height="315" src="${article.mediaLink}"
												frameborder="0" allow="autoplay; encrypted-media"
												allowfullscreen></iframe>
										</c:if>
									</c:if> <!-- <img
						style="height: 78px; width: 130px; display: block; border-radius: 0.2rem;"
						class="img-fluid rounded mb-3 mb-md-0"
						src="http://placehold.it/700x300" alt=""> -->
								</a>
							</div>
							<div class="col-md-6 article-content">
								<h6>${article.title}</h6>
								<p class="card-text">${article.shortContent}</p>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty articleList1}">
				Error, Please try again!
				</c:if>
			</p>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>