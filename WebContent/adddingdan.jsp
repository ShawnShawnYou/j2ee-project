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
                            <li><a tabindex="-1" href="#">????????????</a></li>
                            <li class="divider"></li>
                          
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="login.jsp">??????</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="http://localhost:8080/Logistics-system/indexservlet"><span class="first">moonlight</span> <span class="second">??????</span></a>
        </div>
    </div>
    


    
    <div class="sidebar-nav">
        <form class="search form-inline">
            <input type="text" placeholder="Search...">
        </form>

        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>?????????</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
			<li><a href="http://localhost:8080/Logistics-system/Stuff.jsp">??????</a></li>
			<li><a href="http://localhost:8080/Logistics-system/allservlet">?????????</a></li>
			<li><a href="admin_user.jsp">????????????</a></li>
			<li><a href="http://localhost:8080/Logistics-system/admin_allgoods_servlet">????????????</a></li>
			<li><a href="http://localhost:8080/Logistics-system/lookdingdanservlet">????????????</a></li>
			<li><a href="http://localhost:8080/Logistics-system/all_stuff_servlet">????????????</a></li>
			<li><a href="http://localhost:8080/Logistics-system/vehicle_servlet">????????????</a></li>
            
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>??????</a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="sign-in.html">????????????</a></li>
            <li ><a href="sign-up.html">??????</a></li>
           
        </ul>       
    </div>
    

    
    <div class="content">
    
    	<div class="header">
    
    		<h1 class="page-title">????????????</h1>
    	</div>
    
    	
    
    	<div class="container-fluid">
    		<div class="row-fluid">
    		<form method="get" action="http://localhost:8080/Logistics-system/admin_submitservlet">
    			<div class="btn-toolbar" style="margin-left: 25px;">    
    				<a href="adddingdan.jsp" class="btn">??????</a>
    				<div class="btn-group"></div>
    			</div>
    			<div class="block span11">
    				<div class="block-heading">
    					<a href="#widget2container" data-toggle="collapse">????????????</a>
    				</div>
    				<div id="widget2container" class="block-body collapse in">
    					<table class="table list">
    						<tbody id="prolist">
    							<tr>
    								<th>
    									<p>????????????</p>
    								</th>
    								<th>
    									<p>??????</p>
    								</th>
    								<th>
    									<p>??????</p>
    								</th>
    								<th>
    									<p>??????(kg)</p>
    								</th>
    								<th>
    									<p>??????(m2)</p>
    								</th>
    								
    							</tr>
    							<tr>
    								<td>
    									<p>
    										<input type="text" placeholder="??????" class="input-small" name="goods_name">
    									</p>
    								</td>
    								<td>
    									<p>
    										<input type="number" placeholder="3???" class="input-small" name="goods_number">
    									</p>
    								</td>
    								<td>
    									<p>
    										<input type="text" placeholder="?????????" class="input-small" name="goods_baozhuang">
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
    										<input type="number" placeholder="5.5??????" class="input-small" name="goods_volume">
    									</p>
    								</td>
    								
    							</tr>
    						</tbody>
    					</table>
    					
    				</div>
    			</div>
    
    			
    
    			<div class="block span11">
    				<div class="block-heading">
    					<a href="#widget2" data-toggle="collapse">????????????</a>
    				</div>
    				<div id="widget2" class="block-body collapse in">
    					<table class="table list">
    						<thead>
    							<tr id="psxx">
    								<th>?????????:<input type="text"	placeholder="??????" class="input-medium" name="fahuo_person"/></th>
    								<th>?????????:<input type="text"	placeholder="??????" class="input-medium" name="shouhuo_person"/></th>
    								<th>????????????:<input type="date" placeholder="2019/7/19" class="input-medium" name="fahuo_date"/></th>
    								<th>?????????:<input type="text" class="input-small" placeholder="??????" name="fahuo_addr"/></th>
    								<th>?????????:<input type="text" class="input-small" placeholder="??????" name="shouhuo_addr"/></th>
    								
    							</tr>
    						</thead>
    						<tbody>
    							<tr>
    								<td colspan="6" style="text-align: center;"><strong>????????????</strong></td>
    							</tr>
    							<tr>
    								<td>
    									<p>?????????</p>
    								</td>
    								<td>
    									<p>?????????</p>
    								</td>
    								<td>
    									<p>?????????</p>
    								</td>
    								<td>
    									<p>?????????</p>
    								</td>
    								
    							</tr>
    							<tr id="ysfy">
    								<td>
    									<p>
    										<input type="number" value="0" placeholder="?????????"
    											class="input-small" name="tuoyun_money">
    									</p>
    								</td>
    								<td>
    									<p>
    										<input type="number" value="0" placeholder="?????????"
    											class="input-small" name="shonghuo_money">
    									</p>
    								</td>
    								<td>
    									<p>
    										<input type="number" value="0" placeholder="?????????"
    											class="input-small" name="baoxian_money">
    									</p>
    								</td>
    								<td>
    									<p>
    										<input type="number" value="0" placeholder="?????????"
    											class="input-small" name="jiehuo_money">
    									</p>
    								</td>
    								
    							</tr>
    							
    						</tbody>
    					</table>
    				</div>
    			</div>
    
    			<div class="block span11">
    				<a href="#widget3" class="block-heading" data-toggle="collapse">????????????</a>
    				<div id="widget3" class="block-body collapse in">
    					<table class="table list">
    						<thead>
    							<tr id="hwtq">
    								<th>????????????:<input type="text" placeholder="?????????"
    									class="input-medium" onfocus="converTo()" name="pay_money"></th>
    								<th>????????????:<input type="text" placeholder="??????"
    									class="input-medium" name="pick"></th>
    								
    								<th>??????:<input type="text" placeholder="??????"
    									class="input-medium" name="single"></th>
    							</tr>
    						</thead>
    					</table>
    				</div>
    			</div>
    			<input type="submit" class="btn btn-primary pull-right" value="????????????" >
				</form>
    		</div>
    		<footer>
    			<hr>
    			<p class="pull-right">
    				<a href="#" target="_blank">????????????</a>
    			</p>
    
    			<p>
    				&copy; 2020 <a href="#" target="_blank">????????????</a>
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