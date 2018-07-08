<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
    <title>datagride_view</title>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript">
    $(function () {
        $('#masterManager').datagrid({
            title:'上师管理页',
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            toolbar:"#MasterTb",
            pagination : true,
            pageList : [ 1, 3, 5, 7, 10 ],
            pageSize:5,
                url:'${pageContext.request.contextPath}/master/queryAll',
            columns:[[
                {field:'masterId',title:'id',width:120,align:'center'},
                {field:'masterName',title:'上师法名',width:100,align:'center',sortable:true},
                {field:'masterPhoto',title:'照片',width:80,align:'center',sortable:true},
                {field:'masterSummar',title:'简介',width:100,align:'center',sortable:true},
                {field:"operation",title:"操作",formatter:function(value,row,index){ // 格式化展示数据到对应的列
                    return "<a href='${pageContext.request.contextPath}/master/toModify?masterId="  + "row.masterId" + "'>修改</a>";
                }},
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return "<table><tr><td rowspan=2 style='border:0'><img style='height:400px; width:1200px;' src='/upload/"+ rowData.masterPhoto +"' /></tr></td></table>";
            }
        });

        $("#addMaster").linkbutton({
            onClick:function(){
                $("#masterAdd").dialog({
                    width:300,
                    height:251,
                    href:"${pageContext.request.contextPath}/main/addMaster.jsp", //包含子页面
                });
            }
        });

        $("#master_batch").linkbutton({
            onClick:function(){
                $("#master_dd").dialog({
                    width:300,
                    height:251,
                    href:"${pageContext.request.contextPath}/main/addBatch.jsp", //包含子页面
                });
            }
        });
    });

    function qq(value, name) {
        console.log(name + ":" + value)
        //加载第一页数据，并携带额外请求数据
        $('#masterManager').datagrid('load',{
            value:value,
            condition:name,
        });
    }

    </script>


    <table id="masterManager"></table>
    <div id="masterAdd"></div>
    <div id="master_dd"></div>


    <div id="MasterTb" style="display: none">
        <a id="addMaster" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增上师'"></a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true"/>
        <input id="ss" class="easyui-searchbox" style="width:300px" data-options="searcher:qq,prompt:'请您输入需要模糊查询的内容',menu:'#mm'"></input>
        <a id="master_batch" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'批量插入'"></a>
        <div id="mm" style="width:120px">
            <div data-options="name:'master_name',iconCls:'icon-ok'">法名</div>
            <div data-options="name:'master_summar',iconCls:'icon-ok'">描述</div>
        </div>
        <a id="master_export" href="${pageContext.request.contextPath}/master/export" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'批量导出'"></a>
    </div>





