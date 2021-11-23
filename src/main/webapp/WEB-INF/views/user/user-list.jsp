<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<meta charset="UTF-8">
<title>Homepage</title>
</head>

<body>
	<div class="container page__heading-container">
		<div class="page__heading">
			<div class="d-flex align-items-center">
				<div>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb mb-0">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">User
							</li>
							<li class="breadcrumb-item active" aria-current="page">User
								List</li>
						</ol>
					</nav>
					<h1 class="m-0">User List</h1>
				</div>
				<div class="ml-auto">
					<a href="" class="btn btn-light"><i
						class="material-icons icon-16pt text-muted mr-1">settings</i>
						Settings</a>
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<table class="table mt-5">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Password</th>
						<th>Phone</th>
						<th>Address</th>
						<th>Role Id</th>
						<th>#</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${users}">
						<tr>
							<td>${user.id}</td>
							<td>${user.name}</td>
							<td>${user.email}</td>
							<td>${user.password}</td>
							<td>${user.phone}</td>
							<td>${user.address}</td>
							<td>${user.roleId}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>






	<content tag="scripts"> <!-- Chart.js --> <script
		src='<c:url value="assets/vendor/Chart.min.js" />'></script> <!-- App Charts JS -->
	<script src='<c:url value="assets/js/chartjs-rounded-bar.js" />'></script>
	<script src='<c:url value="assets/js/charts.js" />'></script> <!-- Chart Samples -->
	<script src='<c:url value="assets/js/page.dashboard.js" />'></script> </content>
</body>