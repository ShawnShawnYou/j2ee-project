<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>物流管理</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}
</style>

<link rel="shortcut icon" href="../assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
</head>

<body class="">


	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav pull-right">

				<li id="fat-menu" class="dropdown"><a href="#" role="button"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-user"></i> ${LFname}<i class="icon-caret-down"></i>
				</a>

					<ul class="dropdown-menu">
						<li><a tabindex="-1" href="MyAccount.jsp">我的账户</a></li>
						<li class="divider"></li>

						<li class="divider visible-phone"></li>
						<li><a tabindex="-1" href="login.jsp">退出</a></li>
					</ul></li>

			</ul>
			<a class="brand" href="http://localhost:8080/Logistics-system/indexservlet"><span class="first">moonlight</span>
				<span class="second">物流</span></a>
		</div>
	</div>

	<div class="sidebar-nav">
		<form class="search form-inline">
			<input type="text" placeholder="Search...">
		</form>

		<a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-dashboard"></i>仪表板</a>
		<ul id="dashboard-menu" class="nav nav-list collapse in">
			<li><a href="http://localhost:8080/Logistics-system/indexservlet">主页</a></li>
<%--			<li ><a href="http://localhost:8080/Logistics-system/allservlet">账户表</a></li>--%>
			<li ><a href="user.jsp">修改密码</a></li>
			<li><a href="http://localhost:8080/Logistics-system/allgoods_servlet">订单操作</a></li>
		</ul>

		<a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-briefcase"></i>账户</a>
		<ul id="accounts-menu" class="nav nav-list collapse">
			<li><a href="login.jsp">重新登陆</a></li>
			<li><a href="sign-up.jsp">注册</a></li>
		</ul>
	</div>
	<div class="content">
		<div class="header">
			<h1 class="page-title">修改密码</h1>
		</div>
		<ul class="breadcrumb">
			<li><a href="index.jsp">主页</a> <span class="divider">/</span></li>
			<li><a href="users.jsp">用户表</a> <span class="divider">/</span></li>
			<li class="active">用户</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">


				<div class="well">
					<ul class="nav nav-tabs">

						<li><a href="#profile" data-toggle="tab">密码</a></li>
					</ul>
					<div id="myTabContent" class="tab-content">

						<div class="tab-pane fade" id="profile">
							<form id="tab2" method="get"
								action="http://localhost:8080/Logistics-system/repassservlet">
								<label>新密码</label> <input type="password" class="input-xlarge"
									name="rpass">
								<div>
									<input type="submit" class="btn btn-primary " value="确认修改">

								</div>
							</form>
						</div>
					</div>

				</div>

				<div class="modal small hide fade" id="myModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

					<div class="modal-body">

						<p class="error-text">
							<i class="icon-warning-sign modal-icon"></i>Are you sure you want
							to delete the user?
						</p>
					</div>
				</div>



				<footer>
					<hr>
					<!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
					<p class="pull-right">
						A <a href="http://www.portnine.com/bootstrap-themes"
							target="_blank">Free Bootstrap Theme</a> by <a
							href="http://www.portnine.com" target="_blank">Portnine</a>
					</p>


					<p>
						&copy; 2020 <a href="http://www.portnine.com" target="_blank">Portnine</a>
					</p>
				</footer>

			</div>
		</div>
	</div>



	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
		});
	</script>

</body>
</html>


