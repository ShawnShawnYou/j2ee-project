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
                </ul>
                <a class="brand" href="index.jsp"><span class="first">moonlight</span><span class="second">物流</span></a>
        </div>
    </div>

        <div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">个人信息</p>
            <div class="block-body">
           
                <form>
                    <label>姓</label>
                    <input type="text" class="span12" value="${db_fristname}">
                    <label>名</label>
                    <input type="text" class="span12" value="${db_lastname}">
                    <label>地址</label>
                    <input type="text" class="span12" value="${db_addr}">
                    <label>账户名</label>
                    <input type="text" class="span12" value="${use}">
                    <label>密码</label>
                    <input type="text" class="span12" value="${db_pass}">
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
        
    </div>
</div>
    <script src="lib/bootstrap/js/bootstrap.js"></script> 
  </body>
</html>


