<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-8">
		<h1 class="page-title txt-color-blueDark"> 分配角色</h1>
	</div>
    <div class="col-xs-12 col-sm-5 col-md-5 col-lg-4">
        <ul id="sparks" class="">
            <li class="sparks-info">
                <a style="margin-left: 10px;" class="btn btn-primary" href="#user/index.htm">返回用户一览页面</a>
            </li>
        </ul>
    </div>
</div>
<section id="widget-grid" class="">
	<div class="row">
		<article class="col-sm-12 col-md-12 col-lg-12">
			<div class="jarviswidget jarviswidget-color-darken" id="wid-id-2" data-widget-colorbutton="false" data-widget-togglebutton="false" data-widget-deletebutton="false" data-widget-editbutton="false">
				<!-- widget options:
				usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">
				data-widget-colorbutton="false"
				data-widget-editbutton="false"
				data-widget-togglebutton="false"
				data-widget-deletebutton="false"
				data-widget-fullscreenbutton="false"
				data-widget-custombutton="false"
				data-widget-collapsed="true"
				data-widget-sortable="false"
				-->
				<header>
					<h2>角色分配 </h2>
				</header>
				<div>
					<div class="widget-body">
						<select multiple="multiple" size="10" name="duallistbox" id="initializeDuallistbox">
						    <#list rs as role>
						        <#if ars?seq_contains(role.id)>
						            <option value="${role.id}" selected="selected" >${role.name}</option>
						        <#else>
						            <option value="${role.id}">${role.name}</option>
						        </#if>
						    </#list>
						</select>
					</div>
				</div>
			</div>
		</article>
	</div>
</section>
<script type="text/javascript">

	pageSetUp();
	
	var selectedIds = [];
	
	function isInArray( as, val ) {
		for ( var j = 0; j < as.length; j++ ) {
			if ( a == selectedIds[j] )  {
				return true;
			}
		}
		return false;
	}
	// 左边列表元素向右边列表中增加
	function moveItem() {
		var val = $("#bootstrap-duallistbox-nonselected-list_duallistbox").val();
		if ( val ) {
			var p = {"id" : "${user.id}"};
			$.each(val, function(i, n){
				p["ids["+i+"]"] = n;
			});
			
			$.ajax({
				type : "post",
				url  : "${APP_PATH}/system/user/assignRole.do",
				data : p,
				async : false,
				success : function(r) {
		            if ( r.success ) {
		                layer.msg("角色分配成功", {time:1500, icon:6});
		            } else {
		                if ( r.error ) {
		                    layer.msg(r.error, {time: 1500, icon:5, shift:6});
		                } else {
		                    layer.msg("角色分配失败", {time: 1500, icon:5, shift:6});
		                }
		            }
				},
		        error : function() {
		            layer.msg("角色分配失败", {time: 1500, icon:5, shift:6});
		        }
			});
		} else {
		    layer.msg("没有选择角色进行分配", {time: 1500, icon:7, shift:6});
		}
	}
	// 左边所有的元素移动到右边列表中
	function moveAllItems() {
		var html = $("#bootstrap-duallistbox-nonselected-list_duallistbox").html();
		if ( !html ) {
			$.ajax({
				type : "post",
				url  : "${APP_PATH}/system/user/assignAll.do",
				data : {
					"id" : "${user.id}"
				},
				async : false,
				success : function(r){
		            if ( r.success ) {
		                layer.msg("角色分配成功", {time:1500, icon:6});
		            } else {
		                if ( r.error ) {
		                    layer.msg(r.error, {time:1500, icon:5, shift:6});
		                } else {
		                    layer.msg("角色分配失败", {time:1500, icon:5, shift:6});
		                }
		            }
				},
		        error : function() {
		            layer.msg("角色分配失败", {time: 1500, icon:5, shift:6});
		        }
			});
		} else {
			layer.msg("没有角色可以分配", {time: 1500, icon:4, shift:6});
		}
	}
	// 将右边列表的数据移动到左边
	function removeItem() {
		var val = $("#bootstrap-duallistbox-selected-list_duallistbox").val();
		if ( val ) {
			var p = {"id" : "${user.id}"};
			$.each(val, function(i, n){
				p["ids["+i+"]"] = n;
			});
			
			$.ajax({
				type : "post",
				url  : "${APP_PATH}/system/user/unAssignRole.do",
				data : p,
				async : false,
		        success : function(r){
		            if ( r.success ) {
		                layer.msg("角色取消分配成功", {time:1500, icon:6});
		            } else {
		                if ( r.error ) {
		                    layer.msg(r.error, {time: 1500, icon:5, shift:6});
		                } else {
		                    layer.msg("角色取消分配失败", {time: 1500, icon:5, shift:6});
		                }
		            }
		        },
		        error : function() {
		            layer.msg("角色取消分配失败", {time: 1500, icon:5, shift:6});
		        }
			});
		} else {
			layer.msg("没有选择角色取消分配", {time: 1500, icon:3, shift:6});
		}
	}
	// 将右边列表的数据全部移动到左边
	function removeAllItems() {
		
		var html = $("#bootstrap-duallistbox-selected-list_duallistbox").html();
		if ( !html ) {
			$.ajax({
				type : "post",
				url  : "${APP_PATH}/system/user/unAssignAll.do",
				data : {
					"id" : "${user.id}"
				},
				async : false,
				success : function(r){
		            if ( r.success ) {
		                layer.msg("角色取消分配成功", {time:1500, icon:6});
		            } else {
		                if ( r.error ) {
		                    layer.msg(r.error, {time: 1500, icon:5, shift:6});
		                } else {
		                    layer.msg("角色取消分配失败", {time: 1500, icon:5, shift:6});
		                }
		            }
				}
			});
		} else {
			layer.msg("没有角色需要取消分配", {time: 1500, icon:4, shift:6});
		}
	}
	
	var pagedestroy = function(){
		$('#initializeDuallistbox').bootstrapDualListbox('destroy');
	}
	
	loadScript("${APP_PATH}/js/plugin/bootstrap-duallistbox/jquery.bootstrap-duallistbox.min.js", duallistbox);
	
	function duallistbox(){
		var initializeDuallistbox = $('#initializeDuallistbox').bootstrapDualListbox({
          nonSelectedListLabel: '未分配角色',
          selectedListLabel: '已分配角色',
          preserveSelectionOnMove: '移动',
          filterTextClear:"展示全部",
          filterPlaceHolder:"过滤",
          moveAllLabel:"分配所有角色",
          moveSelectedLabel:"分配选中角色",
          removeSelectedLabel:"取消分配选中角色",
          removeAllLabel:"取消全部角色",
          infoTextEmpty:"空数据", 
          infoText:"展示全部：{0}",
          infoTextFiltered:'<span class="label label-warning">过滤</span>',
          moveOnSelect: false
          //nonSelectedFilter: 'ion ([7-9]|[1][0-2])'
        });
	}
	
	

	var pagefunction = function() {
		drawBreadCrumb( ["权限管理", "<a href='#user/index.htm'>用户管理</a>", "角色分配"] );
	};
	pagefunction();
</script>
