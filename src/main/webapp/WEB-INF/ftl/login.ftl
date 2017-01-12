<!DOCTYPE html>
<html lang="en-us" id="extr-page">
	<head>
		<meta charset="utf-8">
		<title> SmartAdmin</title>
		<meta name="description" content="">
		<meta name="author" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		
		<!-- #CSS Links -->
		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="${APP_PATH}/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="${APP_PATH}/css/font-awesome.min.css">

		<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
		<link rel="stylesheet" type="text/css" media="screen" href="${APP_PATH}/css/smartadmin-production-plugins.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="${APP_PATH}/css/smartadmin-production.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="${APP_PATH}/css/smartadmin-skins.min.css">

		<!-- SmartAdmin RTL Support -->
		<link rel="stylesheet" type="text/css" media="screen" href="${APP_PATH}/css/smartadmin-rtl.min.css"> 

		<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="${APP_PATH}/css/your_style.css"> -->

		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<link rel="stylesheet" type="text/css" media="screen" href="${APP_PATH}/css/demo.min.css">

		<!-- #FAVICONS -->
		<link rel="shortcut icon" href="${APP_PATH}/img/favicon/favicon.ico" type="image/x-icon">
		<link rel="icon" href="${APP_PATH}/img/favicon/favicon.ico" type="image/x-icon">
		<!-- #APP SCREEN / ICONS -->
		<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
		<link rel="apple-touch-icon" href="${APP_PATH}/img/splash/sptouch-icon-iphone.png">
		<link rel="apple-touch-icon" sizes="76x76" href="${APP_PATH}/img/splash/touch-icon-ipad.png">
		<link rel="apple-touch-icon" sizes="120x120" href="${APP_PATH}/img/splash/touch-icon-iphone-retina.png">
		<link rel="apple-touch-icon" sizes="152x152" href="${APP_PATH}/img/splash/touch-icon-ipad-retina.png">
		
		<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		
		<!-- Startup image for web apps -->
		<link rel="apple-touch-startup-image" href="${APP_PATH}/img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
		<link rel="apple-touch-startup-image" href="${APP_PATH}/img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
		<link rel="apple-touch-startup-image" href="${APP_PATH}/img/splash/iphone.png" media="screen and (max-device-width: 320px)">

	</head>
	
	<body class="animated fadeInDown">

		<header id="header">

			<div id="logo-group">
				<span id="logo"> <img src="${APP_PATH}/img/logo.png" alt="SmartAdmin"> </span>
			</div>

			<span id="extr-page-header-space"> <span class="hidden-mobile hidden-xs">Need an account?</span> <a href="register.html" class="btn btn-danger">Create account</a> </span>

		</header>

		<div id="main" role="main">

			<!-- MAIN CONTENT -->
			<div id="content" class="container">

				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-7 col-lg-8 hidden-xs hidden-sm">
						<h1 class="txt-color-red login-header-big">SmartAdmin</h1>
						<div class="hero">

							<div class="pull-left login-desc-box-l">
								<h4 class="paragraph-header">It's Okay to be Smart. Experience the simplicity of SmartAdmin, everywhere you go!</h4>
								<div class="login-app-icons">
									<a href="javascript:void(0);" class="btn btn-danger btn-sm">Frontend Template</a>
									<a href="javascript:void(0);" class="btn btn-danger btn-sm">Find out more</a>
								</div>
							</div>
							
							<img src="${APP_PATH}/img/demo/iphoneview.png" class="pull-right display-image" alt="" style="width:210px">

						</div>

						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<h5 class="about-heading">About SmartAdmin - Are you up to date?</h5>
								<p>
									Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa.
								</p>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<h5 class="about-heading">Not just your average template!</h5>
								<p>
									Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi voluptatem accusantium!
								</p>
							</div>
						</div>

					</div>
					<div class="col-xs-12 col-sm-12 col-md-5 col-lg-4">
						<div class="well no-padding">
							<form action="index.html" id="login-form" class="smart-form client-form">
								<header>用户登录</header>

								<fieldset>
									
									<section>
										<label class="label">登录账号</label>
										<label class="input"> <i class="icon-append fa fa-user"></i>
											<input type="text" id="loginacct" name="loginacct">
											<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i> 请输入登录账号</b></label>
									</section>

									<section>
										<label class="label">登录密码</label>
										<label class="input"> <i class="icon-append fa fa-lock"></i>
											<input type="password" id="userpswd" name="userpswd">
											<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i> 请输入密码</b> </label>
									</section>

									<section>
									    <label class="label">验证码</label>
										<label class="input"> <i class="icon-append fa fa-user"></i>
											<input type="text" id="authcode" name="authcode">
											</label>
										<img id="autgImg" src="${APP_PATH}/system/user/verify.do?r1=1">
									    <!--
										<label class="checkbox">
											<input type="checkbox" name="remember" checked="">
											<i></i>保存登录</label>
									    -->
									</section>
								</fieldset>
								<footer>
									<a class="btn btn-primary" id="submitBtn">
										<i class="fa fa-sign-in"></i> 登录
									</a>
								</footer>
							</form>

						</div>
						
						<h5 class="text-center"> - Or sign in using -</h5>
															
							<ul class="list-inline text-center">
								<li>
									<a href="javascript:void(0);" class="btn btn-primary btn-circle"><i class="fa fa-facebook"></i></a>
								</li>
								<li>
									<a href="javascript:void(0);" class="btn btn-info btn-circle"><i class="fa fa-twitter"></i></a>
								</li>
								<li>
									<a href="javascript:void(0);" class="btn btn-warning btn-circle"><i class="fa fa-linkedin"></i></a>
								</li>
							</ul>
						
					</div>
				</div>
			</div>

		</div>

		<!--================================================== -->	

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
		<script src="${APP_PATH}/js/plugin/pace/pace.min.js"></script>
        <script src="${APP_PATH}/js/libs/jquery-2.1.1.min.js"></script>
        <script src="${APP_PATH}/js/libs/jquery-form.min.js"></script>
	    <script src="${APP_PATH}/js/libs/jquery-ui-1.10.3.min.js"></script>

		<!-- IMPORTANT: APP CONFIG -->
		<script src="${APP_PATH}/js/app.config.js"></script>

		<!-- JS TOUCH : include this plugin for mobile drag / drop touch events 		
		<script src="${APP_PATH}/js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

		<!-- BOOTSTRAP JS -->		
		<script src="${APP_PATH}/js/bootstrap/bootstrap.min.js"></script>

		<!-- JQUERY VALIDATE -->
		<script src="${APP_PATH}/js/plugin/jquery-validate/jquery.validate.min.js"></script>
		
		<!-- JQUERY MASKED INPUT -->
		<script src="${APP_PATH}/js/plugin/masked-input/jquery.maskedinput.min.js"></script>
		
		<!--[if IE 8]>
			
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
			
		<![endif]-->

		<!-- MAIN APP JS FILE -->
		<script src="${APP_PATH}/js/app.min.js"></script>
		
		<script src="${APP_PATH}/js/plugin/layer/layer.js"></script>

		<script type="text/javascript">
			$(function() {
			    $("#autgImg").click(function(){
			     
			        // JQuery对象[0] ==> DOM对象
			        // $(DOM对象) ==> JQuery对象
			        $(this).attr("src", "${APP_PATH}/system/user/verify.do?r1=2&_="+new Date().getTime());
			    });
			    $("#submitBtn").click(function(){
			         
			         var loginacct = $("#loginacct").val();
			         if ( loginacct == "" ) {
			             //alert("登录账号不能为空，请输入");
			             layer.msg("登录账号不能为空，请输入", {time:2000, icon:5, shift:6}, function(){
			                  $("#loginacct").focus();
			             });
			             return;
			         }
			         
			         var userpswd = $("#userpswd").val();
			         if ( userpswd == "" ) {
			             //alert("登录密码不能为空，请输入");
			             layer.msg("登录密码不能为空，请输入", {time:2000, icon:5, shift:6}, function(){
			                  $("#userpswd").focus();
			             });
			             return;
			         }
			         
			         var authcode = $("#authcode").val();
			         if ( authcode == "" ) {
			             //alert("登录密码不能为空，请输入");
			             layer.msg("验证码不能为空，请输入", {time:2000, icon:5, shift:6}, function(){
			                  $("#authcode").focus();
			             });
			             return;
			         }
			         
			         /*
			         var opt = {
			             type : "POST",
			             url  : "${APP_PATH}/system/user/login.do",
			             data : {
			                 "loginacct" : loginacct,
			                 "userpswd"  : userpswd
			             },
			             beforeSend : function() {
			                 return true;
			             },
			             success : function(r) {
			                 if ( r.success ) {
			                     window.location.href = "${APP_PATH}/system/main.htm";
			                 } else {
			                     alert(r.error);
			                 }
			             },
			             error : function(r){
			                 alert(r);
			             }
			         };
			         $.ajax(opt);
			         */
			         
			         // 使用jQuery的form插件提交数据
			         var loadingIndex = -1;
			         $("#login-form").ajaxSubmit({
			             type : "POST",
			             url  : "${APP_PATH}/system/user/login.do",
			             beforeSubmit : function() {
			                 loadingIndex = layer.msg('处理中', {icon: 16});
			                 return true;
			             },
			             success : function(r){
			                 layer.close(loadingIndex);
			                 if ( r.success ) {
			                     window.location.href = "${APP_PATH}/system/main.htm";
			                 } else {
					             layer.msg(r.error, {time:2000, icon:5, shift:6}, function(){
					                  $("#autgImg").attr("src", "${APP_PATH}/system/user/verify.do?r1=2&_="+new Date().getTime());
					             });
			                 }
			             }
			         });
			    });
			    
			});
		</script>
	</body>
</html>