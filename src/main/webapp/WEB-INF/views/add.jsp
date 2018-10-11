<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<jsp:include page="header.jsp"></jsp:include>

<div role="main" class="container">

	<div class="col-lg-8">
		<form:form method="POST" action="/addRss" modelAttribute="rss">
			<fieldset>
				<legend>Discover the best sources for any topic</legend>
				<div class="form-group">
					<label class="col-form-label">e.g., <c:forEach
							items="${list}" var="rssItem">
							<a class="itemRss-${rssItem.id}" href="/getFeed?url=${rssItem.linkRss}"> <c:if
									test="${not empty rssItem.nameRss}">
									${rssItem.nameRss} 
								</c:if> <c:if test="${empty rssItem.nameRss}">
									${rssItem.linkRss} 
								</c:if>
							</a>

							<button class="itemRss-${rssItem.id} close" data-toggle="modal"
								data-target="#myModal${rssItem.id}" style="float: none"
								type="button">&times;,</button>
							
							<div class="modal itemRss-${rssItem.id}"
								id="myModal${rssItem.id}">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title">Confirm box</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											<p>Are you sure to delete ${rssItem.nameRss}?</p>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-danger"
												onclick="removeRss(${rssItem.id})">Yes</button>
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">No</button>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</label>

					<form:input path="linkRss" type="text" class="form-control"
						placeholder="Search by topic, website or RSS link"
						id="inputDefault" />
				</div>
				<input type="submit" class="btn btn-primary" value="Submit" />
			</fieldset>
		</form:form>

		<c:if test="${not empty articleList}">
			<div class="bs-component">
				<c:forEach var="article" items="${articleList}">
					<div class="card mb-3">
						<!--<h3 class="card-header">A1</h3>-->
						<div class="card-body">
							<h5 class="card-title">${article.title}</h5>
							<h6 class="card-subtitle text-muted">${article.pubDate}</h6>
						</div>
						<div>
							<c:if test="${empty article.mediaLink}">
								<img class="article-img"
									src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22318%22%20height%3D%22180%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20318%20180%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_158bd1d28ef%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A16pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_158bd1d28ef%22%3E%3Crect%20width%3D%22318%22%20height%3D%22180%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22129.359375%22%20y%3D%2297.35%22%3EImage%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E"
									alt="Card image">
							</c:if>

							<c:if test="${not empty article.mediaLink}">
								<c:if test="${not article.videoFlag}">
									<img class="article-img" src="${article.mediaLink}"
										alt="Card image">
								</c:if>
								<c:if test="${article.videoFlag}">
									<iframe class="article-img" width="560" height="315"
										src="${article.mediaLink}" frameborder="0"
										allow="autoplay; encrypted-media" allowfullscreen></iframe>
								</c:if>
							</c:if>
						</div>
						<div class="card-body">
							<p class="card-text">${article.shortContent}</p>
						</div>
						<div class="card-body">
							<a href="${article.link}" class="card-link" target="_blank">Card
								link</a> <a href="#" class="card-link">Another link</a>
						</div>
						<!--<div class="card-footer text-muted"></div>-->
					</div>
				</c:forEach>
			</div>
		</c:if>
		<c:if test="${empty getFlag}">
			<c:if test="${empty articleList}">
			Not found, please try again!
		</c:if>

		</c:if>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript">
	var itemId;
	
	function removeRss(id) {
		$("#myModal"+id+" .btn-danger").addClass("disabled");
			
		itemId = id;
		var request = $.ajax({
		  method: "POST",
		  url: "/remove",
		  data: { id: id}
		});
	
		request.done(function(msg){
			if(msg == "OK") {
				$("#myModal"+itemId).modal("hide");
				$(".itemRss-"+itemId).remove();
			} else  if (msg == "NG") {
				$("#myModal"+id+" .modal-body p").text("Error, please try again!");
				$("#myModal"+id+" .btn-danger").removeClass("disabled");
			}	
		});
	
		request.fail(function( jqXHR, textStatus ) {
			$("#myModal"+id+" .modal-body p").text("Error, please try again!");
			$("#myModal"+id+" .btn-danger").removeClass("disabled");
		});
	}
</script>
</body>
</html>