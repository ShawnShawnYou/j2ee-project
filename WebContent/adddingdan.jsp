<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <title>Bootstrap Admin</title>
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
                            <i class="icon-user"> ${LFname}</i>
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
                <a class="brand" href="http://localhost:8080/Logistics-system/indexservlet"><span class="first">moonlight</span> <span class="second">物流</span></a>
        </div>
    </div>
    


    
    <div class="sidebar-nav">
        <form class="search form-inline">
            <input type="text" placeholder="Search...">
        </form>

        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>仪表板</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li><a href="http://localhost:8080/Logistics-system/indexservlet">主页</a></li>
            <li ><a href="http://localhost:8080/Logistics-system/allservlet">用户表</a></li>
            <li ><a href="user.jsp">修改密码</a></li>
          <li><a href="dingdan.jsp">订单操作</a></li>
          <li><a href="lookdingdan.jsp">订单统计</a> <span class="divider">/</span></li>
			<li><a href="http://localhost:8080/Logistics-system/vehicle_servlet">车辆管理</a></li>
            
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>账户</a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="sign-in.html">重新登陆</a></li>
            <li ><a href="sign-up.html">注册</a></li>
           
        </ul>       
    </div>
    

    
    <div class="content">
    
    	<div class="header">
    
    		<h1 class="page-title">添加订单</h1>
    	</div>
    
    	
    
    	<div class="container-fluid">
    		<div class="row-fluid">
    		<form method="get" action="http://localhost:8080/Logistics-system/submitservlet">
    			<div class="btn-toolbar" style="margin-left: 25px;">    
    				<a href="adddingdan.jsp" class="btn">重置</a>
    				<div class="btn-group"></div>
    			</div>
    			<div class="block span11">
    				<div class="block-heading">
    					<a href="#widget2container" data-toggle="collapse">商品清单</a>
    				</div>
    				<div id="widget2container" class="block-body collapse in">
    					<table class="table list">
    						<tbody id="prolist">
    							<tr>
    								<th>
    									<p>货物名称</p>
    								</th>
    								<th>
    									<p>数量</p>
    								</th>
    								<th>
    									<p>包装</p>
    								</th>
    								<th>
    									<p>重量(kg)</p>
    								</th>
    								<th>
    									<p>体积(m2)</p>
    								</th>
    								
    							</tr>
    							<tr>
    								<td>
    									<p>
    										<input type="text" placeholder="香干" class="input-small" name="goods_name">
    									</p>
    								</td>
    								<td>
    									<p>
    										<input type="number" placeholder="3包" class="input-small" name="goods_number">
    									</p>
    								</td>
    								<td>
    									<p>
    										<input type="text" placeholder="塑料盒" class="input-small" name="goods_baozhuang">
    									</p>
    								</td>
    								<td>
    									<p>
    										<input type="number" placeholder="123.9kg"
    											class="input-small" name="goods_weight">
    									</p>
    								</td>
    								<td>
    									<p>
    										<input type="number" placeholder="5.5平米" class="input-small" name="goods_volume">
    									</p>
    								</td>
    								
    							</tr>
    						</tbody>
    					</table>
    					
    				</div>
    			</div>
    
    			
    
    			<div class="block span11">
    				<div class="block-heading">
    					<a href="#widget2" data-toggle="collapse">配送信息</a>
    				</div>
    				<div id="widget2" class="block-body collapse in">
    					<table class="table list">
    						<thead>
    							<tr id="psxx">
    								<th>发货人:<input type="text"	placeholder="张三" class="input-medium" name="fahuo_person"/></th>
    								<th>接货人:<input type="text"	placeholder="李四" class="input-medium" name="shouhuo_person"/></th>
    								<th>发货日期:<input type="date" placeholder="2019/7/19" class="input-medium" name="fahuo_date"/></th>
    								<th>始发地:<input type="text" class="input-small" placeholder="长沙" name="fahuo_addr"/></th>
    								<th>目的地:<input type="text" class="input-small" placeholder="北京" name="shouhuo_addr"/></th>
    								
    							</tr>
    						</thead>
    						<tbody>
    							<tr>
    								<td colspan="6" style="text-align: center;"><strong>运输费用</strong></td>
    							</tr>
    							<tr>
    								<td>
    									<p>托运费</p>
    								</td>
    								<td>
    									<p>送货费</p>
    								</td>
    								<td>
    									<p>保险费</p>
    								</td>
    								<td>
    									<p>接货费</p>
    								</td>
    								
    							</tr>
    							<tr id="ysfy">
    								<td>
    									<p>
    										<input type="number" value="0" placeholder="托运费"
    											class="input-small" name="tuoyun_money">
    									</p>
    								</td>
    								<td>
    									<p>
    										<input type="number" value="0" placeholder="送货费"
    											class="input-small" name="shonghuo_money">
    									</p>
    								</td>
    								<td>
    									<p>
    										<input type="number" value="0" placeholder="保险费"
    											class="input-small" name="baoxian_money">
    									</p>
    								</td>
    								<td>
    									<p>
    										<input type="number" value="0" placeholder="接货费"
    											class="input-small" name="jiehuo_money">
    									</p>
    								</td>
    								
    							</tr>
    							
    						</tbody>
    					</table>
    				</div>
    			</div>
    
    			<div class="block span11">
    				<a href="#widget3" class="block-heading" data-toggle="collapse">货物提取</a>
    				<div id="widget3" class="block-body collapse in">
    					<table class="table list">
    						<thead>
    							<tr id="hwtq">
    								<th>付款方式:<input type="text" placeholder="支付宝"
    									class="input-medium" onfocus="converTo()" name="pay_money"></th>
    								<th>取货方式:<input type="text" placeholder="自提"
    									class="input-medium" name="pick"></th>
    								
    								<th>制单:<input type="text" placeholder="张三"
    									class="input-medium" name="single"></th>
    							</tr>
    						</thead>
    					</table>
    				</div>
    			</div>
    			<input type="submit" class="btn btn-primary pull-right" value="保存订单" >
				</form>
    		</div>
    		<footer>
    			<hr>
    			<p class="pull-right">
    				<a href="#" target="_blank">物流管理</a>
    			</p>
    
    			<p>
    				&copy; 2020 <a href="#" target="_blank">物流管理</a>
    			</p>
    		</footer>
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