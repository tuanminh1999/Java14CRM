<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<meta charset="UTF-8">
<title>Create User</title>
<!-- Validate User -->
<script src='<c:url value="assets/validate/validate-create-user.js" />'></script>
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
		<div class="col-sm-12">
			<c:if test="${not empty message}">
				<div class="alert alert-block alert-${alert}">
					<button type="button" class="close" data-dismiss="alert">
						<i class="ace-icon fa fa-times"></i>
					</button>
					${message}
				</div>
			</c:if>
		</div>
		<form method="post" action="<c:url value="/create-user"/>" id="userForm" onsubmit="return validateUserForm()">
			<div class="form-group">
				<label class="col-sm-5 control-label no-padding-right">Name</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" name="name" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-5 control-label no-padding-right">Email</label>
				<div class="col-sm-7">
					<input type="email" class="form-control" name="email" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-5 control-label no-padding-right">Password</label>
				<div class="col-sm-7">
					<input type="password" class="form-control" name="password" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-5 control-label no-padding-right">Phone</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" name="phone" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-5 control-label no-padding-right">Address</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" name="address" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-8 control-label no-padding-right">Role</label>
				<div class="col-sm-4">
					<select class="form-control" name="roleId">
						<c:forEach var="item" items="${roles }">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="col-sm-12">
				<input type="submit" class="btn btn-primary" value="Create User">
			</div>
		</form>
	</div>
</body>