<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
         
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <title>物流管理</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
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
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>


  <body class=""> 

    
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> ${LFname} 
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="#">我的账户</a></li>
                            <li class="divider"></li>
                          
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="login.jsp">退出</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="http://localhost:8080/Logistics-system/indexservlet"><span class="first">moonlight</span><span class="second">物流</span></a>
        </div>
    </div>
    


    <div class="sidebar-nav">
			<form class="search form-inline">
				<input type="text" placeholder="Search...">
			</form>

			<a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>订单管理 </a>
			<ul id="dashboard-menu" class="nav nav-list collapse in">
				 <li><a href="http://localhost:8080/Logistics-system/indexservlet">主页</a></li>
				<li ><a href="http://localhost:8080/Logistics-system/allservlet">用户表</a></li>
				<li ><a href="user.jsp">修改密码</a></li>
				<li><a href="http://localhost:8080/Logistics-system/allgoods_servlet">订单操作</a></li>
				<li><a href="http://localhost:8080/Logistics-system/lookdingdanservlet">订单统计</a></li>
				<li><a href="http://localhost:8080/Logistics-system/vehicle_servlet">车辆管理</a></li>
			</ul>

			<a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>账户管理</a>
			<ul id="accounts-menu" class="nav nav-list collapse">
				 <li ><a href="login.jsp">重新登陆</a></li>
				<li ><a href="sign-up.jsp">注册</a></li>
			</ul>
		</div>

		<div class="content">

			<div class="header">

				<h1 class="page-title">订单统计</h1>
			</div>

			

			<div class="container-fluid">
				<div class="row-fluid">
									 
					<div class="block span11">
						<div class="block-heading">
							<a href="#widget2container" data-toggle="collapse">订单统计</a>
						</div>
						<div id="widget2container" class="block-body collapse in">
							<table class="table list">
								<tbody>
									<tr>
										<th class="col-md-1">
											<p>订单总数</p>
											<p> ${dingdan}</p>
										</th>
										
										<th class="col-md-2">
											<p>托运费用</p>
											<c:set var="c" value="${0}" />
                        							<c:forEach items="${dingdan_alllist}" var="lilook_index">
                        							
                        							<c:set var="c" value="${c + lilook_index.tuoyun_money}" />
                        						</c:forEach>
											<p> $ <fmt:formatNumber type="number" value="${c}" pattern="0.00" maxFractionDigits="2"/></p>
											
										</th>
										<th class="col-md-2">
											<p>订单总金额</p> 
									
												 <c:set var="b" value="${0}" />
                        							<c:forEach items="${dingdan_alllist}" var="lilook_index">
                        							
                        							<c:set var="b" value="${b + lilook_index.tuoyun_money+ lilook_index.shonghuo_money+ lilook_index.baoxian_money}" />
                        						</c:forEach>
											<p> $ ${b}</p>
											
					
										</th>
									</tr>									
									<tr>
										
									</tr>                           
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<footer>
					<hr>
					<p class="pull-right"><a href="#" target="_blank">物流管理</a></p>
					<p>&copy; 2020 <a href="#" target="_blank">物流管理</a></p>
				</footer>
			</div>
		</div>                    
                    <footer>
                        <hr>
                        <!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
                        <p class="pull-right">A <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free Bootstrap Theme</a> by 
                        <a href="http://www.portnine.com" target="_blank">Portnine</a></p>

                        <p>&copy; 2020 <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
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
    </script>
    
  </body>
</html>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
	</body>
</html>
