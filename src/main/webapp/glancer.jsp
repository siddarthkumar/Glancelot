<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<%  session.setAttribute("user", request.getAttribute("user")); %>
<title>Glancelot - Dashboard</title>
<!-- Required meta tags always come first -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Sign In</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<link
	href="https://mdbootstrap.com/previews/docs/latest/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://mdbootstrap.com/previews/docs/latest/css/mdb.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="home.css">
<style type="text/css">
.double-nav .breadcrumb-dn {
	color: #fff;
}

.side-nav.wide.slim .sn-ad-avatar-wrapper a span {
	display: none;
}

header {
	height: auto;
	background: red;
}

.top-nav-collapse {
	background: #000000 !important;
}

.navbar:not (.top-nav-collapse ){
	background: #000000 !important;
}

.imageCenter {
	width: 200px;
	height: 200px;
	background: yellow;
	border-radius: 200px;
	border: 2px solid var(- -theme-color);
	margin: auto;
}

.imageCenter img {
	border-radius: 200px;
	width: 100%;
	height: 100%;
}

.prsnl-info {
	width: 25%;
	min-height: 230px;
	margin: auto;
}

.info-background {
	background: linear-gradient(45deg, #3c3b3b, #101010, #3c3b3b);
	color: #fff;
}

.show-table {
	width: 50%;
	margin: auto;
}

.show-table a {
	color: var(- -theme-color)
}

@media ( max-width : 600px) {
	.prsnl-info {
		width: 100%;
	}
}
</style>
</head>
<body>

	<section class="mdb-skin bg-danger">
		<!--Double navigation-->
		<header>

			<!-- Navbar -->
			<nav
				class="navbar navbar-toggleable-md navbar-expand-lg scrolling-navbar double-nav">
				<!-- SideNav slide-out button -->
				<!-- <div class="float-left">
		        <a href="#" data-activates="slide-out" class="button-collapse"><i class="fas fa-bars"></i></a>
		      </div> -->
				<!-- Breadcrumb-->
				<div class="breadcrumb-dn mr-auto">
					<p>Glancelot</p>
				</div>
				<ul class="nav navbar-nav nav-flex-icons ml-auto">
					<li class="nav-item"><a class="nav-link"><i
							class="fas fa-envelope"></i> <span
							class="clearfix d-none d-sm-inline-block">Contact</span></a></li>
					<li class="nav-item"><a href="/logout" class="nav-link"><i
							class="fas fa-comments"></i> <span
							class="clearfix d-none d-sm-inline-block">Logout</span></a></li>
					<li class="nav-item"><a class="nav-link"><i
							class="fas fa-user"></i> <span
							class="clearfix d-none d-sm-inline-block">Account</span></a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Dropdown </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a> <a
								class="dropdown-item" href="#">Something else here</a>
						</div></li>
				</ul>
			</nav>
			<!-- /.Navbar -->
		</header>
		<!--/.Double navigation-->
	</section>

	<section>
		<div class="container-fluid">
			<div class="row pb-4 info-background border-bottom-thick">
				<div class="col-12 p-3">
					<div class="imageCenter">
						<img
							src="https://appamatix.com/wp-content/uploads/2016/05/Anonymous-FeatPic.jpg">
					</div>
				</div>
				<div class="col">
					<div class="row ">
						<div class="col">
							<div class="prsnl-info p-2 text-center">
								<div class="row">
									<div class="col text-center">
										<h4 class="h4">${user.name}</h4>
									</div>
								</div>
								<div class="row pt-2">
									<div class="col-2">Email:</div>
									<div class="col">${user.email}</div>
								</div>

								<div class="row pt-2">
									<div class="col-2">Mobile:</div>
									<div class="col">${user.mobile}</div>
								</div>

								<div class="row pt-2">
									<div class="col-2">Age:</div>
									<div class="col">${user.age}</div>
								</div>

								<div class="row pt-2">
									<div class="col-2">Gender:</div>
									<div class="col">${user.gender}</div>
								</div>

								<div class="row pt-2 mt-4">
									<button type="button" class="btn btn-lg themeBackground"
										data-toggle="modal" data-target="#edit-info"
										style="margin: auto;">Edit Info</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</section>

	<section class="bg-black pb-3">
		<div class="container text-white">
			<div class="row pt-5">

				<div class="row text-center mb-3">
					<div class="col">
						<button type="button" class="btn btn-lg themeBackground"
							data-toggle="modal" data-target="#create-new-link">Crete
							New Link</button>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="bg-black pb-3">
		<div class="container text-white">
			<div class="row pt-5">
				<div class="row text-center mb-3">
					<div class="col">
						<button type="button" class="btn btn-lg themeBackground"
							data-toggle="modal" data-target="#schedule-meeting">Schedule
							Meeting</button>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- Modes ka section h  yellowe -->
	<section class="models-h-iss-mai">
		<!-- Button trigger modal -->
		<!-- Modal -->
		<div class="modal fade" id="create-new-link" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">

			<!-- Add .modal-dialog-centered to .modal-dialog to vertically center the modal -->
			<div class="modal-dialog modal-dialog-centered" role="document">


				<div class="modal-content">
					<form action="call" method="get">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle">Title for
								this Pop Up</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">

							<div class="md-form">
								<i class="fa fa-video prefix"></i> <input name="roomname"
									type="text" id="form2" class="form-control"> <label
									for="form2">create new room</label>
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Create</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- Edit info Model -->
		<div class="modal fade" id="edit-info" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">

			<!-- Add .modal-dialog-centered to .modal-dialog to vertically center the modal -->
			<div class="modal-dialog modal-dialog-centered" role="document">


				<div class="modal-content">
					<form action="" method="">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle">Test
								Meeting</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">

							<div class="md-form">
								<i class="fa fa-user prefix"></i> <input type="text" id="name"
									class="form-control"> <label for="name">Name</label>
							</div>
							<div class="md-form">
								<i class="fa fa-envelope prefix"></i> <input type="text"
									id="email" class="form-control"> <label for="email">Email</label>
							</div>
							<div class="md-form">
								<i class="fa fa-time prefix"></i> <input type="text" id="age"
									class="form-control"> <label for="age">Age</label>
							</div>
							<div class="md-form">
								<i class="fa fa-mars prefix"></i> <input type="text" id="gender"
									class="form-control"> <label for="gender">Gender</label>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary">Create</button>
						</div>
					</form>
				</div>
			</div>
		</div>


	</section>

	<section class="models-h-iss-mai">
		<!-- Button trigger modal -->
		<!-- Modal -->
		<div class="modal fade" id="schedule-meeting" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">

			<!-- Add .modal-dialog-centered to .modal-dialog to vertically center the modal -->
			<div class="modal-dialog modal-dialog-centered" role="document">


				<div class="modal-content">
					<form action="schedularMeeting" method="post">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle">schedule
								a Meeting</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">

							<div class="md-form">
								<i class="fa fa-video prefix"></i> <input name="createNewRoom"
									type="text" class="form-control"> <label for="form2">create
									new room</label>
							</div>
							<div class="md-form">
								<!-- <i class="fa fa-calendar"></i> -->
								<input name="setDate" type="date" class="form-control">
								<label for="form2">Set Date</label>
							</div>
							<div class="md-form">
								<!-- <i class="fa fa-clock-o"></i> -->
								<input name="setTime" type="time" class="form-control">
								<label for="form2">Set Time</label>
							</div>
							<div class="md-form">
								<!-- <i class="fa fa-envelope"></i> -->
								<input name="addMails" type="text" class="form-control">
								<label for="form2">Add Mails</label>
							</div>
							
							<div class="md-form">
								<!-- <i class="fa fa-envelope"></i> -->
								<input name="admins" type="text" class="form-control">
								<label for="form2">Add Mails</label>
							</div>
							
							
							<div class="md-form">
								<!-- <i class="fa fa-envelope"></i> -->
								<input name="mailPassword" type="password" class="form-control"
									required="required"> <label for="form2">Mail
									Password</label>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Send</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- Edit info Model -->
	</section>

	<!-- SCRIPTS -->
	<script type="text/javascript"
		src="https://mdbootstrap.com/previews/docs/latest/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="https://mdbootstrap.com/previews/docs/latest/js/popper.min.js"></script>
	<script type="text/javascript"
		src="https://mdbootstrap.com/previews/docs/latest/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="https://mdbootstrap.com/previews/docs/latest/js/mdb.min.js"></script>
	<script>
        // Material Select Initialization
      $(document).ready(function() {
        $('.mdb-select').materialSelect();
		    // SideNav Initialization
		$(".button-collapse").sideNav();
      });
    </script>
</body>
</html>