<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-8">
		<h1 class="page-title txt-color-blueDark"> 新增用户信息</h1>
	</div>
    <div class="col-xs-12 col-sm-5 col-md-5 col-lg-4">
        <ul id="sparks" class="">
            <li class="sparks-info">
                <a style="margin-left: 10px;" class="btn btn-primary" href="#user/index.htm">返回用户信息一览页面</a>
            </li>
        </ul>
    </div>
</div>
<section id="widget-grid" class="">
	<div class="row">
		<article class="col-sm-12 col-md-12 col-lg-12">
			<div class="jarviswidget jarviswidget-color-darken" id="wid-id-2" data-widget-togglebutton="false" data-widget-editbutton="false" data-widget-deletebutton="false">
				<header>
					<h2>基本信息 （<i class="glyphicon glyphicon-star"></i>为必须输入项目）</h2>
				</header>
				<div>
					<div class="jarviswidget-editbox">
					</div>
					<div class="widget-body fuelux">
						<div class="step-content">
                                <style type="text/css">
                                    .jcrop-holder #preview-pane {
                                        display: block;
                                        position: absolute;
                                        z-index: 200;
                                        right: -80px;
                                        padding: 1px;
                                        border: 1px rgba(0,0,0,.4) solid;
                                        background-color: white;
                                        -webkit-box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.1);
                                        -moz-box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.1);
                                        box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.1);
                                    }
                                    #preview-pane .preview-container {
                                        width: 50px;
                                        height: 50px;
                                        overflow: hidden;
                                    }
                                    
                                    .complete .badge {
                                        background-color: #659265
                                    }
									textarea{  
										-moz-box-shadow:1px 1px 0 #E7E7E7;
										-moz-box-sizing:border-box;
										border-color:#CCCCCC #999999 #999999 #CCCCCC;
										border-style:solid;
										border-width:1px;
										font-size:13px;
										height:160px;
										margin:0px auto;
										outline-color:-moz-use-text-color;
										outline-style:none;
										outline-width:medium;
										padding:2px;
										width:100%;
									}
                                </style>
							<form class="form-horizontal" id="userForm" method="post" >
								<div class="step-pane active" id="step1">
									<fieldset>
										<div class="form-group">
											<label class="col-md-2 control-label">登录账号</label>
											<div class="col-md-10">
												<div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-list-alt fa-fw"></i></span>
                                                    <span class="input-group-addon" style="color:red"><i class="glyphicon glyphicon-star"></i></span>
                                                    <input class="form-control" type="text" id="floginacct" name="loginacct" style="border-left:none;" autocomplete="off">
												</div>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-2 control-label">用户名称</label>
											<div class="col-md-10">
												<div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-list-alt fa-fw"></i></span>
                                                    <span class="input-group-addon" style="color:red"><i class="glyphicon glyphicon-star"></i></span>
                                                    <input class="form-control" type="text" id="fname" name="name" style="border-left:none;" autocomplete="off">
												</div>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-2 control-label">邮箱</label>
											<div class="col-md-10">
												<div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-list-alt fa-fw"></i></span>
                                                    <span class="input-group-addon" style="color:red"><i class="glyphicon glyphicon-star"></i></span>
                                                    <input class="form-control" type="text" id="femail" name="email" style="border-left:none;" autocomplete="off">
												</div>
											</div>
										</div>
									</fieldset>
                                    <div class="form-actions">
                                        <div class="row">
                                            <div class="col-md-12" style="text-align:center;">
                                                <a href="javascript:;" class="btn btn-operation btn-success" onclick="submitForm()"><i class="fa fa-save"></i>&nbsp;保存</a>
                                                <a href="javascript:;" class="btn btn-operation btn-danger" onclick="clearForm()"><i class="fa fa-refresh"></i>&nbsp;重置</a>
                                            </div>
                                        </div>
                                    </div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</article>
	</div>
</section>
<script type="text/javascript">

	pageSetUp();
	
	function submitForm() {
	   var floginacct = $("#floginacct").val();
	   if ( floginacct == "" ) {
          layer.msg("登录账号不能为空，请输入", {time:2000, icon:5, shift:6}, function(){
              $("#floginacct").focus();
          });
	      return;
	   }
	   var fname = $("#fname").val();
	   if ( fname == "" ) {
          layer.msg("名称不能为空，请输入", {time:2000, icon:5, shift:6}, function(){
              $("#fname").focus();
          });
	      return;
	   }
	   var femail = $("#femail").val();
	   if ( femail == "" ) {
          layer.msg("邮箱不能为空，请输入", {time:2000, icon:5, shift:6}, function(){
              $("#femail").focus();
          });
	      return;
	   } else {
	      var reg = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
	      if ( !reg.test(femail) ) {
	          layer.msg("邮箱格式不正确，请重新输入", {time:2000, icon:5, shift:6}, function(){
	              $("#femail").focus();
	          });
		      return;
	      }
	   }
	   
         var loadingIndex = -1;
         $("#userForm").ajaxSubmit({
             type : "POST",
             url  : "${APP_PATH}/system/user/insert.do",
             beforeSubmit : function() {
                 loadingIndex = layer.msg('处理中', {icon: 16});
                 return true;
             },
             success : function(r){
                 layer.close(loadingIndex);
                 if ( r.success ) {
                     layer.msg("用户信息增加成功", {time:2000, icon:1});
                 } else {
		             layer.msg(r.error, {time:2000, icon:5, shift:6});
                 }
             }
         });
	}

	var pagefunction = function() {
		drawBreadCrumb( ["权限管理", "<a href='#user/index.htm'>用户管理</a>", "新增用户信息"] );
	};
	pagefunction();
</script>
