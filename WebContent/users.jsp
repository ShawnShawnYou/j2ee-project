<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                          <i class="icon-user"></i>${LFname}
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
              <a class="brand" href="http://localhost:8080/Logistics-system/indexservlet"><span class="first">moonlight</span> <span class="second">物流</span></a>
      </div>
  </div>

  <div class="sidebar-nav">
      <form class="search form-inline">
          <input type="text" placeholder="Search...">
      </form>
  
      <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>仪表板</a>
      <ul id="dashboard-menu" class="nav nav-list collapse in">
          <li><a href="http://localhost:8080/Logistics_system/indexservlet">主页</a></li>
          <li ><a href="http://localhost:8080/Logistics_system/allservlet">账户表</a></li>
          <li ><a href="user.jsp">修改密码</a></li>
          <li><a href="http://localhost:8080/Logistics_system/allgoods_servlet">订单操作</a></li>
          <li><a href="http://localhost:8080/Logistics_system/lookdingdanservlet">订单统计</a></li>
      </ul>
  
      <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>账户</a>
      <ul id="accounts-menu" class="nav nav-list collapse">
          <li ><a href="login.jsp">重新登陆</a></li>
          <li ><a href="sign-up.jsp">注册</a></li>
         
      </ul>       
  </div>
    <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">账户表</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="index.jsp">主页</a> <span class="divider">/</span></li>
            <li class="active">账户表</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    

  </div>
</div>
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>账户名</th>
          <th>名</th>
          <th>姓</th>
          <th>地址</th>
          <th style="width: 26px;"></th>
        </tr>
      </thead>
      <tbody>
       
 <c:forEach items="${list}" var="li">
  <tr>
 <td height="22" align="center" >${li.zhanghao}</td>
 <td height="22" align="center">${li.firstname}</td>
 <td height="22" align="center">${li.lastname}</td>
 <td height="22" align="center">${li.addr}</td> 
 <td height="22" align="center" width="100px"><a href="user.jsp"><div width="100px">修改密码</div></a></td>
 <td> <a href ="http://localhost:8080/Logistics-system/deleteservlet?user_name=${li.zhanghao}">删除</a></td>

    </tr>
  </c:forEach>
      </tbody>
    </table>
   
</div>
<div class="pagination">
    <ul>
        <li><a href="#">共有 ${all} 行,共 ${pages} 页</a></li>
    </ul>  
</div>
<!-- <div style ="float: left; width: 100px; height: 100px;margin-left: 800px; margin-top: -50px;">当前为第  ${pages} 页</div>
 -->
  <tr>
                 
        <td width="150"><div align="center" style="float: left; margin-left: 800px; margin-top: -60px;"><span class="STYLE1">转到第
         <input name="pageSize" id="pageSize" type="text" value="${param.pageNo}" size="4" style="height:12px; width:20px; border:1px solid #999999;" /> 
                      页  <input name="transfer" type="button" value="跳转" onclick="transfer()"/></span></div></td>                 
                </tr>
               
                
 <div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Delete Confirmation</h3>
    </div>
    <div class="modal-body">
        <p class="error-text"><i class="icon-warning-sign modal-icon"></i>Are you sure you want to delete the user?</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
        <button class="btn btn-danger" data-dismiss="modal">Delete</button>
    </div>
</div>
               
                    <footer>
                        <hr>
                     
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
        function transfer() {
    		var pageSize = document.getElementById("pageSize" ).value;
    		if(pageSize!=null||pageSize!="")
    		   window.location.href="http://localhost:8080/Logistics_system/allservlet?pageNo="+pageSize;
    		alert("即将跳转")//可以获取到该值
    	}
    </script>
     
  </body>
</html>
