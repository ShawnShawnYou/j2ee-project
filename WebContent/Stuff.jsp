<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>员工管理系统</title>
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

        .search-box{

        }
        .search-bar{

        }
        .search-btn{

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
        <a class="brand" href="http://localhost:8080/Logistics-system/indexservlet"><span class="first">moonlight</span><span class="second">员工</span></a>
    </div>
</div>
<div class="sidebar-nav">
    <form class="search form-inline">
        <input type="text" placeholder="Search...">
    </form>

    <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>管理员权限</a>
    <ul id="dashboard-menu" class="nav nav-list collapse in">
        <li><a href="http://localhost:8080/Logistics-system/indexservlet">主页</a></li>
        <li ><a href="http://localhost:8080/Logistics-system/allservlet">账户表</a></li>
        <li ><a href="user.jsp">修改密码</a></li>
        <li><a href="http://localhost:8080/Logistics-system/allgoods_servlet">订单操作</a></li>
        <li><a href="http://localhost:8080/Logistics-system/lookdingdanservlet">订单统计</a></li>
        <li><a href="http://localhost:8080/Logistics_system/stuff_manage.jsp">员工管理</a></li>
    </ul>

    <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>账户</a>
    <ul id="accounts-menu" class="nav nav-list collapse">
        <li ><a href="login.jsp">重新登陆</a></li>
        <li ><a href="sign-up.jsp">注册</a></li>

    </ul>
</div>
<div class="content">

    <div class="header">

        <h1 class="page-title">员工展示</h1>
    </div>

    <ul class="breadcrumb">
        <li><a href="index.html">主页</a> <span class="divider">/</span></li>
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
                                    <p class="detail">总员工数</p>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        </div>

        <div class="row-fluid">
            <div>
                <input />
                <button id="search-btn">搜索</button>
            </div>
            <table border="1">
                <tr>
                    <th>员工号码</th>
                    <th>员工姓名</th>
                </tr>
                <tr id="stuff-items">
                    <td>001</td>
                    <td>FHy</td>
                </tr>
            </table>
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

    async function getStuffList(){
        document.getElementById('#stuff-items');
        await $('#search-btn').click(()=>{
            $.ajax({
                url: "http://localhost:8080/Logistics_system/stuffServlet",
                dataType: "json"
            }).done( res => {
                console.log(res);
                // $('#stuff-items').appendChild('')
            })
        })
    }
</script>

</body>
</html>


