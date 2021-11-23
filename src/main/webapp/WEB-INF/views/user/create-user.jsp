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
							<li class="breadcrumb-item active" aria-current="page">
								Create User</li>
						</ol>
					</nav>
					<h1 class="m-0">Create User</h1>
				</div>
				<div class="ml-auto">
					<a href="" class="btn btn-light"><i
						class="material-icons icon-16pt text-muted mr-1">settings</i>
						Settings</a>
				</div>
			</div>
		</div>
	</div>

	<div class="container page__container">
		<form action="/action_page.php">
			<label for="fname">Email:</label> 
			<input type="text" id="email" name="email"><br> 
			<label for="pwd">Password:</label>
			<input type="password" id="pwd" name="pwd"><br> 
			<label for="fname">Full Name:</label>
			<input type="text" id="fname" name="fname"><br> 
			<label for="avatar">Avatar:</label> 
			<input type="text" id="avatar" name="avatar"><br> 
			<label for="roleId">Role Id:</label>
			<input type="text" id="roleId" name="roleId"><br> 
			<input type="submit" value="Submit">
		</form>	
	</div>

	<content tag="scripts"> <!-- Chart.js --> <script
		src='<c:url value="assets/vendor/Chart.min.js" />'></script> <!-- App Charts JS -->
	<script src='<c:url value="assets/js/chartjs-rounded-bar.js" />'></script>
	<script src='<c:url value="assets/js/charts.js" />'></script> <!-- Chart Samples -->
	<script src='<c:url value="assets/js/page.dashboard.js" />'></script> </content>
</body>