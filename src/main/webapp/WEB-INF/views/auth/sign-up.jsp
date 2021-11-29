<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>

<body>
	<h4 class="m-0">Sign up!</h4>
        <p class="mb-5">Create an account now!</p>
		<c:if test="${not empty message}">
				<div class="alert alert-dismissible bg-${alert } text-white border-0 fade show">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					${message}
				</div>
		</c:if>
        <form action="<c:url value='/sign-up'/>" method="post" novalidate>
            <div class="form-group">
                <label class="text-label" for="name_2">Name:</label>
                <div class="input-group input-group-merge">
                    <input id="name_2" type="text" required class="form-control form-control-prepended" placeholder="John" name="name">
                    <div class="input-group-prepend">
                        <div class="input-group-text">
                            <span class="far fa-user"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="text-label" for="email_2">Email Address:</label>
                <div class="input-group input-group-merge">
                    <input id="email_2" type="email" required class="form-control form-control-prepended" placeholder="john@doe.com" name="email">
                    <div class="input-group-prepend">
                        <div class="input-group-text">
                            <span class="far fa-envelope"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="text-label" for="password_2">Password:</label>
                <div class="input-group input-group-merge">
                    <input id="password_2" type="password" class="form-control form-control-prepended" placeholder="Enter your password" name="password">
                    <div class="input-group-prepend">
                        <div class="input-group-text">
                            <span class="fas fa-key"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="text-label" for="name_2">Phone:</label>
                <div class="input-group input-group-merge">
                    <input id="name_2" type="text" required class="form-control form-control-prepended" placeholder="0123456789" name="phone">
                    <div class="input-group-prepend">
                        <div class="input-group-text">
                            <span class="fas fa-phone-square-alt"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="text-label" for="name_2">Address:</label>
                <div class="input-group input-group-merge">
                    <input id="name_2" type="text" required class="form-control form-control-prepended" placeholder="123 Trần Hưng Đạo Quận 1 TP.HCM" name="address">
                    <div class="input-group-prepend">
                        <div class="input-group-text">
                            <span class="far fa-address-card"></span>
                        </div>
                    </div>
                </div>
            </div>
            <!-- <div class="form-group mb-5">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" checked class="custom-control-input" id="terms" />
                    <label class="custom-control-label" for="terms">I accept <a href="#">Terms and Conditions</a></label>
                </div>
            </div> -->
            <div class="form-group text-center">
                <button class="btn btn-primary mb-2" type="submit">Create Account</button><br>
                <a class="text-body text-underline" href="<c:url value='sign-in'/>">Have an account? Login</a>
            </div>
        </form>
        
	<content tag="scripts"> 
		<!-- jQuery -->
	    <script src="assets/vendor/jquery.min.js"></script>
	
	    <!-- Bootstrap -->
	    <script src="assets/vendor/popper.min.js"></script>
	    <script src="assets/vendor/bootstrap.min.js"></script>
	
	    <!-- Perfect Scrollbar -->
	    <script src="assets/vendor/perfect-scrollbar.min.js"></script>
	
	    <!-- DOM Factory -->
	    <script src="assets/vendor/dom-factory.js"></script>
	
	    <!-- MDK -->
	    <script src="assets/vendor/material-design-kit.js"></script>
	
	    <!-- App -->
	    <script src="assets/js/toggle-check-all.js"></script>
	    <script src="assets/js/check-selected-row.js"></script>
	    <script src="assets/js/dropdown.js"></script>
	    <script src="assets/js/sidebar-mini.js"></script>
	    <script src="assets/js/app.js"></script>
	
	    <!-- App Settings (safe to remove) -->
	    <script src="assets/js/app-settings.js"></script>   
     </content>
</body>