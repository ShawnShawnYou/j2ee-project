<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>员工管理</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

<!-- Demo page code -->

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


<!-- Le fav and touch icons -->
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
						class="icon-user"></i>${LFname} <i class="icon-caret-down"></i>
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
			<li><a href="http://localhost:8080/Logistics-system/Stuff.jsp">主页</a></li>
			<li><a href="http://localhost:8080/Logistics-system/allservlet">用户表</a></li>
			<li><a href="user.jsp">修改密码</a></li>
			<li><a href="http://localhost:8080/Logistics-system/admin_allgoods_servlet">订单操作</a></li>
			<li><a href="http://localhost:8080/Logistics-system/lookdingdanservlet">订单统计</a></li>
			<li><a href="http://localhost:8080/Logistics-system/vehicle_servlet">车辆管理</a></li>
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
			

			
		</div>


		<div class="container-fluid">
			<div class="row-fluid">


				<div class="row-fluid">

					<div class="header">

						<h1 class="page-title">员工管理</h1>
					</div>

					

					<div class="container-fluid">
						<div class="row-fluid">

							<div class="btn-toolbar">
								<a href="add_stuff.jsp" class="btn btn-primary"><i
									class="icon-plus"></i> 添加员工</a>
								<a href="update_stuff.jsp" class="btn btn-primary"> 更新员工</a>
							</div>
							<div class="btn-group" id="srh-btn" style="display: none;">
								<form class="search form-inline">
									起止时间:<input type="date" id="id_start" name="start_time"
										placeholder="开始时间..."> -- <input type="date"
										id="id_end" name="end_time" placeholder="结束时间..."> <input
										type="button" class="btn btn-info" value="查 询"
										onclick="getPageByDate()" />
								</form>
							</div>
							<div class="well">
								<table class="table" id="table1">
									<thead>
										<tr>
											<th class="col-md-2">员工姓名</th>
											<th class="col-md-2">员工号</th>
											<th class="col-md-2"></th>
										</tr>
									</thead>

									<tbody>
									<c:forEach items="${list1}" var="li1">
										<tr>
											<td height="22" align="center" >${li1.stuff_name}</td>
											<td height="22" align="center"> ${li1.stuff_number} </td>
											<td><input name="update_button" type="button" value="编辑" onclick="update_stuff(${li1.id})"/>
												<input name="delete_button" type="button" value="删除" onclick="delete_stuff(${li1.id})"/></td>
										</tr>
									</c:forEach>
									
									</tbody>
								</table>
							</div>
							<div class="pagination">
								<ul>
									<li><a>&nbsp;&nbsp;共有  ${all1} 条记录，当前${now_page} / ${pages_dingdan}页</a></li>
									<td width="150">
										<div align="center" style="float: left; margin-left: 800px; margin-top: -40px;">
											<span class="STYLE1">
												转到第
												<input name="pageSize" id="pageSize" type="text" value="${now_page}" size="4" style="height:12px; width:20px; border:1px solid #999999;" />
												页  <input name="transfer" type="button" value="跳转" onclick="transfer()"/>
											</span>
										</div>
									</td>
								</ul>
							</div>
						</div>
					</div>
					<footer>
						<hr>
						<p class="pull-right">
							<a href="#" target="_blank">员工管理</a>
						</p>

						<p>
							&copy; 2020 <a href="#" target="_blank">员工管理</a>
						</p>
					</footer>
				</div>
			</div>
		</div>
		<script src="lib/bootstrap/js/bootstrap.js"></script>
		<script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });

        function transfer() {
    		var pageSize = document.getElementById("pageSize" ).value;
    		if(pageSize!=null||pageSize!="")
    		   window.location.href="http://localhost:8080/Logistics-system/StuffServlet?pageNo=" + pageSize;
    	}

		function update_stuff(stuff_number) {
			var pageSize = document.getElementById("pageSize" ).value;
			window.location.href = "http://localhost:8080/Logistics-system/update_stuff.jsp?stuff_number="
					+ stuff_number + "&pageNo=" + pageSize;
		}

		function delete_stuff(stuff_number) {
			var pageSize = document.getElementById("pageSize" ).value;
			window.location.href = "http://localhost:8080/Logistics-system/delete_stuff_servlet?stuff_number="
					+ stuff_number + "&pageNo=" + pageSize;
			// $('#table1 tbody').find("tr").eq(tr_id).hide();
		}


    </script>
</body>
</html>


