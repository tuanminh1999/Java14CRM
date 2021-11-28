<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

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
							<li class="breadcrumb-item active" aria-current="page">Dash
								Board</li>
						</ol>
					</nav>
					<h1 class="m-0">Dash Board</h1>
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
		<div class="row card-group-row">
			<div class="col-lg-3 col-md-4 card-group-row__col">
				<div class="card card-group-row__card card-shadow">
					<div class="p-2 d-flex flex-row align-items-center">
						
					</div>
				</div>
			</div>
	</div>
	</div>

	<content tag="scripts"> <!-- Chart.js --> <script
		src='<c:url value="assets/vendor/Chart.min.js" />'></script> <!-- App Charts JS -->
	<script src='<c:url value="assets/js/chartjs-rounded-bar.js" />'></script>
	<script src='<c:url value="assets/js/charts.js" />'></script> <!-- Chart Samples -->
	<script src='<c:url value="assets/js/page.dashboard.js" />'></script> </content>
</body>