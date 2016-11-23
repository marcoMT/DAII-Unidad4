<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>Bootstrap sample| Home</title>
	<link href="/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="/static/css/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="nav navbar-nav">
				<ul class="nav navbar-nav">
					<li><a href="/seller">Seller</a></li>
					<li><a href="new-seller">Manage Seller</a></li>
					<li><a href="all-sellers">All sellers</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
	<c:when test="${mode== 'MODE_SELLER'}">
	<div class="container">
		<div class="jumbotron text-center" id="homeDiv">
			<h1>Welcome to Seller Manager</h1>
		</div>
	</div>
	</c:when>

	<c:when test="${mode== 'MODE_SPORTS'}">
	<div class="container text-center" id="sportsDiv">
		<h3>My Sports</h3>
		<hr/>
		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Sport team</th>
						<th>Date register</th>
						<th>World cup</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="sport" items="${sports}">
						<tr>
							<td>${sport.sportId}</td>
							<td>${sport.sportName}</td>
							<td>${sport.sportTeam}</td>
							<td><fmt:formatDate pattern="dd-MM-yyyy" value="${sport.dateRegister}"/> </td>
							<td>${sport.worldCup==true?'Yes':'No'}</td>
							<td><a href="update-sport?id=${sport.sportId }">
							<span class="glyphicon glyphicon-pencil"></span>
							</a></td>
							<td><a href="delete-sport?id=${sport.sportId }">
							<span class="glyphicon glyphicon-trash"></span>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
				
			</table>
		</div>
	</div>
	</c:when>
	<c:when test="${mode=='MODE_NEW_SPORT' || mode=='MODE_UPDATE_SPORT'}">
		<div class="container text-center">
			<h3>Manager Sport</h3>
			<hr />
			<form class="form-horizontal" method="POST" action="save-sport">
				<input type="hidden" name="sportId" value="${sport.sportId}" />
				<div class="form-group">
					<label class="control-label col-md-3">Name</label>
					<div class="col-md-7">
						<input type="text" class="form-control"
						 value="${sport.sportName}" name="sportName"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">Sport Team</label>
					<div class="col-md-7">
						<input type="text" class="form-control"
						 value="${sport.sportTeam}" name="sportTeam"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">World Cup</label>
					<div class="col-md-7">
						<input type="radio" class="col-sm-1"
						 name="worldCup" value="true"/>
						 <div class="col-sm-1">Yes</div>
						 <input type="radio" class="col-sm-1"
						 name="worldCups" value="false" checked="checked"/>
						 <div class="col-sm-1">No</div>
					</div>
				</div>
				
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="Save"/>
				</div>
				
			</form>
			
		</div>
	
	</c:when>
	
	
	<c:when test="${mode== 'MODE_SELLERS'}">
	<div class="container text-center" id="sellersDiv">
		<h3>My Sellers</h3>
		<hr/>
		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Last Name</th>
						<th>Telephone</th>
						<th>Address</th>
						<th>Email</th>
						<th>Turn</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="seller" items="${sellers}">
						<tr>
							<td>${seller.id}</td>
							<td>${seller.name}</td>
							<td>${seller.lastName}</td>
							<td>${seller.telephone}</td>
							<td>${seller.address}</td>
							<td>${seller.email}</td>
							<td>${seller.turn}</td>
							<td><a href="update-seller?id=${seller.id }">
							<span class="glyphicon glyphicon-pencil"></span>
							</a></td>
							<td><a href="delete-seller?id=${seller.id }">
							<span class="glyphicon glyphicon-trash"></span>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
				
			</table>
		</div>
	</div>
	</c:when>
	<c:when test="${mode=='MODE_NEW_SELLER' || mode=='MODE_UPDATE_SELLER'}">
		<div class="container text-center">
			<h3>Manager Seller</h3>
			<hr />
			<form class="form-horizontal" method="POST" action="save-seller">
				<input type="hidden" name="id" value="${seller.id}" />
				<div class="form-group">
					<label class="control-label col-md-3">Name</label>
					<div class="col-md-7">
						<input type="text" class="form-control"
						 value="${seller.name}" name="name"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">Last Name</label>
					<div class="col-md-7">
						<input type="text" class="form-control"
						 value="${seller.lastName}" name="lastName"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">Telephone</label>
					<div class="col-md-7">
						<input type="text" class="form-control"
						 value="${seller.telephone}" name="telephone"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">Address</label>
					<div class="col-md-7">
						<input type="text" class="form-control"
						 value="${seller.address}" name="address"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">Email</label>
					<div class="col-md-7">
						<input type="text" class="form-control"
						 value="${seller.email}" name="email"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">Turn</label>
					<div class="col-md-7">
						<input type="text" class="form-control"
						 value="${seller.turn}" name="turn"/>
					</div>
				</div>
				
				
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="Save"/>
				</div>
				
			</form>
			
		</div>
	
	</c:when>
	</c:choose>
	
	
	
	
	

	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js">
	</script>
	<script type="text/javascript" src="/static/js/bootstrap.min.js">
	</script>
	
	
</body>
</html>
