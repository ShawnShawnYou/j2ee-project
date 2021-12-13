<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
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
              <!-- 在这个Your company中不能直接实现跳转到主界面，可加上一个判断， -->
              <span class="first">moonlight</span><span class="second">物流</span>
        </div>
    </div>
    
    
        <div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">Login</p>
            <div class="block-body">
          
          <!--使用表单提交后，在Loginservlet中可获取输入的值，
          	在使用表单提交的时候要运用隐藏技术，不然在登录后的网址上会有账号密码输出，不安全  -->
                <form method="get" action="http://localhost:8080/Logistics-system/loginservlet" >
                   <label>Username</label>
                    <input type="text" class="span12" name="username" >
                    <label>Password</label>
                    <input type="password" class="span12" name="password">
                    <input type="submit" class="btn btn-primary pull-right" value="Login in">
                    <label class="remember-me"><input type="checkbox" > Remember me</label>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
        <p class="pull-right" style=""><a href="http://www.portnine.com" target="blank">Theme by Portnine</a></p>
        <p><a href="reset-password.html">忘记密码?</a></p>
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


