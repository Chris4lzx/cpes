<link rel="stylesheet" type="text/css" media="screen" href="${APP_PATH}/js/plugin/ztree/zTreeStyle.css">
<div class="modal fade" id="remoteModal" tabindex="-1" data-backdrop="false" role="dialog" aria-labelledby="remoteModalLabel" aria-hidden="true">  
    <div class="modal-dialog" style="width:930px;height:400px;">  
        <div class="modal-content" style="padding: 5px;">
        </div>
    </div>  
</div>
<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-8">
        <h1 class="page-title txt-color-blueDark"><!-- PAGE HEADER -->
            权限分配
        </h1>
    </div>
    <div class="col-xs-12 col-sm-5 col-md-5 col-lg-4">
        <ul id="sparks" class="">
            <li class="sparks-info">
                <a style="margin-left: 10px;" class="btn btn-primary" id="assignPermission">分配权限</a>
            </li>
            <li class="sparks-info">
                <a style="margin-left: 10px;" class="btn btn-primary" href="#role/index.htm">返回角色信息一览页面</a>
            </li>
        </ul>
    </div>
</div>
<!-- widget grid -->
<section id="widget-grid" class="">

    <!-- row -->
    <div class="row">

        <!-- NEW WIDGET START -->
        <article id="treeArt" class="col-sm-12 col-md-12 col-lg-12">
            <div class="jarviswidget jarviswidget-color-darken" data-widget-togglebutton="true" id="wid-id-1" data-widget-deletebutton="false" data-widget-editbutton="false">
                <header>
                    <h2><i class="fa fa-sitemap"></i> 系统菜单列表 </h2>
                </header>
                <div>
                    <div class="widget-body no-padding">
                        <ul id="treeDemo" class="ztree"></ul>
                    
                        <!--
                        <a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;" href="xxxxx.htm?level='+treeNode.level+'&id='+treeNode.id+'" data-toggle="modal" data-target="#remoteModal">
                        -->
                    </div>
                </div>
            </div>
        </article>
    </div>
</section>
<script>
    pageSetUp();
    
    $("#assignPermission").click(function(){
        // 获取树形结构中被选择的节点数据
        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
        var nodes = treeObj.getCheckedNodes(true);
        
        var param = {"roleid":"${role.id}"};
        $.each(nodes, function(i, n){
            param["ids["+i+"]"] = n.id;
        });
        
        $.ajax({
            type : "POST",
            url  : "${APP_PATH}/system/role/assign.do",
            data : param,
            success : function( r ){
                if ( r.success ) {
					layer.msg("角色授权成功", {time: 1500, icon:1}, function(){
					});
                }
            }
        
        });
    });

    loadScript("${APP_PATH}/js/plugin/ztree/jquery.ztree.all-3.5.min.js", function(){
        var setting = {
			check: {
				enable: true
			},
			view: {
				selectedMulti: false,
				addDiyDom: function(treeId, treeNode){
					var icoObj = $("#" + treeNode.tId + "_ico");
					if ( treeNode.icon ) {
						icoObj.removeClass("button ico_docu ico_open").addClass("fa fa-fw " + treeNode.icon).css("background","");
					}
				}
			},
			async: {
				enable: true,
				url:"${APP_PATH}/system/role/permissiontree.do?roleid=${role.id}",
				autoParam:["id", "name=n", "level=lv"]
			},
			callback: {
				onClick : function(event, treeId, json) {

				}
			}
        };
		
		$.fn.zTree.init($("#treeDemo"), setting);
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.setting.check.chkboxType =  { "Y" : "ps", "N" : "ps" };
    });
</script>