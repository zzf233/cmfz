<%--
  Created by IntelliJ IDEA.
  User: zzf_PC
  Date: 2018/7/5
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<script type="text/javascript" >



    $(function(){

        $('#dg').datagrid({
            url:"${pageContext.request.contextPath}/picture/queryAll",
            columns:[[
                {field:'pictureId',title:'标识编号',width:300,sortable:true},//列属性设置
                {field:'picturePath',title:'文件名',width:100},
                {field:'pictureDate',title:'轮播图创建时间',width:200},
                {field:'pictureDescription',title:'描述信息',width:100},
                {field:'pictureStatus',title:'轮播图状态',width:100},
            ]],

            toolbar:"#tb",
            striped:true,
            nowrap:true,
            pagination:true,//显示分页工具栏
            pageList:[2,4,6,8],
            pageSize : 4,
            singleSelect:true,
        });


    })
</script>
    <table id="dg"></table>

<%--    <div id="dd"></div>

    <div id="ad"></div>--%>

<div id="tb" style="display: none">
    <a id="adda" href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-add',plain:true,text:'新增轮播图'"></a>
</div>
<%--
<a id="mod" href="#" class="easyui-linkbutton"
   data-options="iconCls:'icon-edit',plain:true,text:'修改'"></a>

<a id="dele" href="#" class="easyui-linkbutton"
   data-options="iconCls:'icon-cancel',plain:true,text:'删除'"></a>--%>
