<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>Bootstrap sample| Task</title>
	<link href="/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="/static/css/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="nav navbar-nav">
				<ul class="nav navbar-nav">
					<li><a href="task">Task</a></li>
					<li><a href="new-task">Manage Task</a></li>
					<li><a href="all-tasks">All tasks</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
	<c:when test="${mode== 'MODE_TASK'}">
	<div class="container">
		<div class="jumbotron text-center" id="homeDiv">
			<h1>Welcome to Task Manager</h1>
		</div>
	</div>
	</c:when>
	<c:when test="${mode== 'MODE_TASKS'}">
	<div class="container text-center" id="tasksDiv">
		<h3>My Tasks</h3>
		<hr/>
		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Description</th>
						<th>Date created</th>
						<th>Finished</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="task" items="${tasks}">
						<tr>
							<td>${task.id}</td>
							<td>${task.name}</td>
							<td>${task.description}</td>
							<td><fmt:formatDate pattern="dd-MM-yyyy" value="${task.dateCreated}"/> </td>
							<td>${task.finished==true?'Yes':'No'}</td>
							<td><a href="update-task?id=${task.id }">
							<span class="glyphicon glyphicon-pencil"></span>
							</a></td>
							<td><a href="delete-task?id=${task.id }">
							<span class="glyphicon glyphicon-trash"></span>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
				
			</table>
		</div>
	</div>
	</c:when>
	<c:when test="${mode=='MODE_NEW' || mode=='MODE_UPDATE'}">
		<div class="container text-center">
			<h3>Manager Task</h3>
			<hr />
			<form class="form-horizontal" method="POST" action="save-task">
				<input type="hidden" name="id" value="${task.id}" />
				<div class="form-group">
					<label class="control-label col-md-3">Name</label>
					<div class="col-md-7">
						<input type="text" class="form-control"
						 value="${task.name}" name="name"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">Description</label>
					<div class="col-md-7">
						<input type="text" class="form-control"
						 value="${task.description}" name="description"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">Finished</label>
					<div class="col-md-7">
						<input type="radio" class="col-sm-1"
						 name="finished" value="true"/>
						 <div class="col-sm-1">Yes</div>
						 <input type="radio" class="col-sm-1"
						 name="finished" value="false" checked="checked"/>
						 <div class="col-sm-1">No</div>
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
