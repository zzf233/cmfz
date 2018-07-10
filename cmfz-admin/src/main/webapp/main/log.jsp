<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
    <title>datagride_view</title>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript">
    $(function () {
        $('#logManager').datagrid({
            title:'日志管理页',
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            toolbar:"#logTb",
            pagination : true,
            pageList : [ 1, 3, 5, 7, 10 ],
            pageSize:5,
                url:'${pageContext.request.contextPath}/log/queryAll',
            columns:[[
                {field:'logId',title:'id',width:120,align:'center'},
                {field:'logUser',title:'用户',width:100,align:'center',sortable:true},
                {field:'logTime',title:'日志时间',width:80,align:'center',sortable:true},
                {field:'logResource',title:'日志来源',width:100,align:'center',sortable:true},
                {field:'logAction',title:'执行操作',width:60,align:'center'},
                {field:'logMessage',title:'日志详细信息',width:60,align:'center'},
                {field:'logResult',title:'执行结果',width:60,align:'center'},
            ]]
        });
    });
    </script>


    <table id="logManager"></table>


    <div id="logTb" style="display: none">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true"/>
    </div>



