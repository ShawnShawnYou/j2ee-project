<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <title>物流管理系统</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

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
                            <i class="icon-user"></i>
                             ${LFname}<!-- 将姓与名输出到jsp页面 -->
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="MyAccount.jsp">我的账户</a></li>
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

        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>仪表板</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li><a href="http://localhost:8080/Logistics-system/indexservlet">主页</a></li>
            <li ><a href="http://localhost:8080/Logistics-system/allservlet">账户表</a></li>
            <li ><a href="user.jsp">修改密码</a></li>
            <li><a href="http://localhost:8080/Logistics-system/allgoods_servlet">订单操作</a></li>
            <li><a href="http://localhost:8080/Logistics-system/lookdingdanservlet">订单统计</a></li>
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>账户</a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="login.jsp">重新登陆</a></li>
            <li ><a href="sign-up.jsp">注册</a></li>
           
        </ul>       
    </div>   
    <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">仪表板</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="index.html">主页</a> <span class="divider">/</span></li>
            <li class="active">仪表板</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    

<div class="row-fluid">

    <div class="alert alert-info">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <strong>友情提醒：</strong> 希望你喜欢这个网页!
    </div>

    <div class="block">
        <a href="#page-stats" class="block-heading" data-toggle="collapse">最新统计</a>
        <div id="page-stats" class="block-body collapse in">

            <div class="stat-widget-container">
                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title"> ${all_user} </p>
                        <p class="detail">总账户数</p>
                    </div>
                </div>

                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">${all_index}</p>
                        <p class="detail">订户（订单数）</p>
                    </div>
                </div>

                <div class="stat-widget">
                    <div class="stat-button">
                    <!-- 循环求和， -->
                        <c:set var="a" value="${0}" />
                        <c:forEach items="${list_index}" var="li_index">
                        <c:set var="a" value="${a + li_index.tuoyun_money+ li_index.shonghuo_money+ li_index.baoxian_money}" />                        
                        </c:forEach>
                       <p class="title">$ ${a}</p>
                        <p class="detail">已完成全部金额</p>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

</div>

<div class="row-fluid">
    <div class="block span6">
        <div class="block-heading">
            <span class="block-icon pull-right">
                <a href="#" class="demo-cancel-click" rel="tooltip" title="Click to refresh"><i class="icon-refresh"></i></a>
            </span>

            <a href="#widget2container" data-toggle="collapse">历史订单</a>
        </div>
        <div id="widget2container" class="block-body collapse in">
            <table class="table list">
              <tbody>
                 
                  
                  <tr>
                      <td>
                          <p><i class="icon-user"></i>姓名（收货人）</p>
                      </td>
                      <td>
                          <p>收货地址</p>
                      </td>
                      <td>
                          <p>日期: </p>
                         
                      </td>
                  </tr>
                   <c:forEach items="${list_index}" var="li_index">
										<tr>
											<td height="22" align="center" >${li_index.shouhuo_person}</td>
										
											<td height="22" align="center">${li_index.shouhuo_addr}</td>
											<td height="22" align="center"> ${li_index.fahuo_date} </td>
										</tr>
									</c:forEach>
              </tbody>
            </table>
        </div>
    </div>
    <div class="block span6">
        <p class="block-heading">不可折叠</p>
        <div class="block-body">
            <h2>每日提示</h2>
            <p>暂无.</p>
           
        </div>
    </div>
</div>             
                    <footer>
                        <hr>
                        <!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
                        <p class="pull-right">A <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free Bootstrap Theme</a> by <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
                        

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


