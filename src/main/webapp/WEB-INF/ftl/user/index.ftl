<style>
<!--
div.ColVis {
    float: left;
}
.text-center {
    text-align: center;
}
.dt-toolbar {
    padding-bottom: 6px;
}
input[type="checkbox"] {
  -webkit-appearance: none;
  -webkit-appearance: none;
  background: #fff url(${APP_PATH}/img/checkbox.png);
  background-repeat:no-repeat;
  background: none\0;
  *background: none;
  height: 22px;
  vertical-align: middle;
  width: 22px;
}

input[type="checkbox"]:focus,
input[type="checkbox"]:hover {
  background-position: -24px 0;
  outline: none;
}

input[type="checkbox"]:checked {
  background-position: -48px 0;
}

input[type="checkbox"][disabled] {
  background-position: -72px 0;
}

input[type="checkbox"][disabled]:checked {
  background-position: -96px 0;
}
table.dataTable thead>tr>th input {
    width:100%;
}
#userTable tbody td {
    line-height: 30px;
    font-size: 14px;
}
.qsi {
  -webkit-appearance: none;
  -webkit-appearance: none;
  background: #fff url(${APP_PATH}/img/spotlight.png) 3px 5px;
  background-repeat:no-repeat;
  background: none\0;
  *background: none;
  vertical-align: middle;
  padding-left: 24px;
}
-->
</style>
<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
        <h1 class="page-title txt-color-blueDark"> 用户信息一览
        </h1>
    </div>
</div>

<!-- widget grid -->
<section id="widget-grid" class="">

    <!-- row -->
    <div class="row">

        <!-- NEW WIDGET START -->
        <article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <div class="jarviswidget jarviswidget-color-darken" id="wid-id-1" data-widget-togglebutton="false" data-widget-deletebutton="false" data-widget-editbutton="false">
                <header>
                    <span class="widget-icon"> <i class="fa fa-table"></i> </span>
                    <h2>查询列表</h2>
                </header>
                <div>
                    <div class="widget-body no-padding">
                        <table id="userTable" class="table table-striped table-bordered" width="100%">
                            <thead>
                                <tr>
                                    <td style="width:44px">
                                        <input type="checkbox" id="checkall" />
                                    </td>
                                    <th style="width:36px">No</th>
                                    <th style="width:150px">登录账号</th>
                                    <th style="width:150px">用户名称</th>
                                    <th >邮箱</th>
                                    <th style="width:120px">是否授权</th>
                                    <th style="width:120px">操作</th>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </article>
    </div>
</section>
<script type="text/javascript">
    var otable = null;

    pageSetUp();
    var pagefunction = function() {
    
        var responsiveHelper_datatable_fixed_column = undefined;
        
        var breakpointDefinition = {
            tablet : 1024,
            phone : 480
        };

    	var pageinitcfg = { ilength : 25, istart : 0 };
        if ( window.sessionStorage ) {
        	var json = window.sessionStorage.getItem("user/pagecfg");
        	var cfg = JSON.parse(json);
        	if ( cfg != null ) {
        		pageinitcfg = cfg;
        	}
        }
        
        otable = $('#userTable').DataTable({
            "bFilter": false,
            "bPaginate": true,
            "iDisplayLength":pageinitcfg.ilength,
            "iDisplayStart":pageinitcfg.istart,
            "sDom": "<'dt-toolbar'<'col-xs-12 col-sm-6 hidden-xs'l><'col-sm-6 col-xs-12 hidden-xs'T>r>"+
                "t"+
                "<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'i><'col-sm-6 col-xs-12 'p>>",
            "autoWidth" : true,
            "preDrawCallback" : function(settings) {
                if (!responsiveHelper_datatable_fixed_column) {
                    responsiveHelper_datatable_fixed_column = new ResponsiveDatatablesHelper($('#userTable'), breakpointDefinition);
                }
                
                var qurl = "${APP_PATH}/system/user/datas.do";
                var p = "";
                settings.ajax = qurl + (p);
                return true;
            },
            "rowCallback" : function(nRow) {
                responsiveHelper_datatable_fixed_column.createExpandIcon(nRow);
            },
            "drawCallback" : function(oSettings) {
                responsiveHelper_datatable_fixed_column.respond();
                $("#userTable #checkall").click(function(){
                	var flg = this.checked;
                	$.each($("#userTable .data-check"), function(){                	
                		this.checked = flg;
                	});
                });
                
                $(".sorting_asc").removeClass("sorting_asc");
            },
            "oLanguage": {
                "sLengthMenu": "每页显示 _MENU_ 条记录",
                "sZeroRecords": "抱歉， 没有找到",
                "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
                "sInfoEmpty": "没有数据",
                "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
                "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "前一页",
                "sNext": "后一页",
                "sLast": "尾页"
                },
                "sZeroRecords": "没有检索到数据",
                "sProcessing": "数据加载中......"
            },
            "columns":[
                {"data":"id"},
                {"data":"index"},
                {"data":"loginacct"},
                {"data":"name"},
                {"data":"email"},
                {"data":"count"},
                null
            ],
            "aoColumnDefs":[
	             {
	                 "sClass": "text-center",
	                 "bSortable": false,
	                 "bSearchable": false,
	                 "mRender": function(data, type, full) {
	                	 return '<input type="checkbox" class="data-check" value="' + data + '" />';
	                 },
	                 "aTargets": [0]
	             },
                 {
                     "sClass": "text-center",
                     "bSortable": false,
                     "bSearchable": false,
                     "mRender": function(data, type, full) {
                         return data;
                     },
                     "aTargets": [1]
                 },
                 {
                     "sClass": "text-center",
                     "bSortable": false,
                     "bSearchable": false,
                     "mRender": function(data, type, full) {
                         return data;
                     },
                     "aTargets": [2]
                 },
                 {
                     "sClass": "text-center",
                     "bSortable": false,
                     "bSearchable": false,
                     "mRender": function(data, type, full) {
                         return data;
                     },
                     "aTargets": [3]
                 },
                 {
                     "sClass": "text-center",
                     "bSortable": false,
                     "bSearchable": false,
                     "mRender": function(data, type, full) {
                         return data;
                     },
                     "aTargets": [4]
                 },
                 {
                     "sClass": "text-center",
                     "bSortable": false,
                     "bSearchable": false,
                     "mRender": function(data, type, full) {
                         return data?"是":"否";
                     },
                     "aTargets": [5]
                 },
                 {
                     "sClass": "text-center",
                     "bSortable": false,
                     "bSearchable": false,
                     "mRender": function(data, type, full) {
                         return "<a class='btn btn-primary' href='#user/role/"+full.id+".htm'>分配权限</a>";
                     },
                     "aTargets": [6]
                 }
            ],
            "serverSide":true,
            "oTableTools": {
                "aButtons": [
                    {
                         "sExtends": "text",
                         "sButtonText": "<i class='fa fa-plus fa-fw'></i>新增",
                         "fnClick": function ( nButton, oConfig, oFlash ) {
                             window.location.href = "#user/add.htm";
                         },
                         "fnComplete": function ( nButton, oConfig, oFlash, sFlash ) {
                         },
                         "fnSelect": function ( nButton, oConfig, nRow ) {
                         }
                    },
                    {
                        "sExtends": "text",
                        "sButtonText": "<i class='fa fa-edit fa-fw'></i>修改",
                        "fnClick": function ( nButton, oConfig, oFlash ) {
                        	var users = $("#userTable .data-check:checked");
                        	if ( users.length == 0 ) {
					            layer.msg("请选择需要修改的用户信息", {time:2000, icon:5, shift:6});
                        	} else if ( users.length > 1 ) {
                        		layer.msg("只能选择一条用户信息进行修改", {time:2000, icon:5, shift:6});
                        	} else {
                                var s = users[0];
                                window.location.href = "#user/edit/"+s.value+".htm";
                        	}
                        },
                        "fnComplete": function ( nButton, oConfig, oFlash, sFlash ) {
                        },
                        "fnSelect": function ( nButton, oConfig, nRow ) {
                        }
                   }
                   ,{
                       "sExtends": "text",
                       "sButtonText": "<i class='fa fa-minus fa-fw'></i>删除",
                       "fnClick": function ( nButton, oConfig, oFlash ) {
                           var users = $("#userTable .data-check:checked");
                           if ( users.length == 0 ) {
                               layer.msg("请选择需要删除的用户用户信息", {time:1000, icon:5, shift:6});
                           } else {
                                var param = {};
                                $.each(users, function(i, n){
                                   //param["ids["+i+"]"] = n.value;
                                   param["users["+i+"].id"] = n.value;
                                });
                                
								layer.confirm('删除选择的用户信息, 是否继续?', {icon: 3, title:'提示'}, function(index){
									$.ajax({
										type : "POST",
										url  : "${APP_PATH}/system/user/deletes.do",
										data : param,
										success : function(r) {
											if ( r.success ) {
												layer.msg("用户信息删除成功", {time: 1500, icon:1}, function(){
                                                    otable.draw();
                                                    $("#userTable #checkall")[0].checked = false;
												});
											} else {
												layer.msg("用户信息删除失败", {time: 1500, icon:2, shift: 6});
											}
										},
										error : function() {
											layer.msg("用户信息删除失败", {time: 1500, icon:2, shift: 6});
										}
									});
								});
                           }
                       },
                       "fnComplete": function ( nButton, oConfig, oFlash, sFlash ) {
                       },
                       "fnSelect": function ( nButton, oConfig, nRow ) {
                       }
                  }
               ],
               "sSwfPath": "${APP_PATH}/js/plugin/datatables/swf/copy_csv_xls_pdf.swf"
            }
        });
    };
    
    loadScript("${APP_PATH}/js/plugin/datatables/jquery.dataTables.min.js", function(){
        loadScript("${APP_PATH}/js/plugin/datatables/dataTables.colVis.min.js", function(){
            loadScript("${APP_PATH}/js/plugin/datatables/dataTables.tableTools.min.js", function(){
                loadScript("${APP_PATH}/js/plugin/datatables/dataTables.bootstrap.min.js", function(){
                    loadScript("${APP_PATH}/js/plugin/datatable-responsive/datatables.responsive.min.js", pagefunction)
                });
            });
        });
    });
</script>
