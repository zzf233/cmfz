<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
    <title>datagride_view</title>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript">
    $(function () {
        $('#picManager').datagrid({
            title:'轮播图管理页',
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            toolbar:"#picTb",
            pagination : true,
            pageList : [ 1, 3, 5, 7, 10 ],
            pageSize:5,
                url:'${pageContext.request.contextPath}/picture/queryAll',
            columns:[[
                {field:'pictureId',title:'id-图片编号',width:120,align:'center'},
                {field:'picturePath',title:'address-存储地址',width:50,align:'center',sortable:true},
                {field:'pictureDate',title:'date-存储日期',width:80,align:'center',sortable:true},
                {field:'pictureDescription',title:'describe-详细描述',width:100,align:'center',sortable:true},
                {field:'pictureStatus',title:'Status-上线状态',width:60,align:'center'},
                {field:"operation",title:"操作",width:50,align:'center',sortable:true,formatter:function(value,row,index){ // 格式化展示数据到对应的列
                    return "<a class=\"modifyPic\" href=\"#\" onclick=\"modifyPic('" + row.pictureId + "')\">修改</a>";
                }},
            ]],
            onLoadSuccess:function(data){
                $(".modifyPic").linkbutton({
                    plain:true,
                    iconCls:'icon-edit',
                });
            },
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return "<table><tr><td rowspan=2 style='border:0'><img style='height:400px; width:1200px;' src='/upload/"+ rowData.picturePath +"' /></tr></td></table>";
            }
        });

        $("#addPic").linkbutton({
            onClick:function(){
                $("#adPic").dialog({
                    width:300,
                    height:251,
                    href:"${pageContext.request.contextPath}/main/addPicture.jsp", //包含子页面
                });
            }
        });
    });
    
    function modifyPic(pictureId) {
        $("#modifyPic").dialog({
            width:400,
            height:400,
            href:"${pageContext.request.contextPath}/main/modifyPicture.jsp?pictureId=" + pictureId
        });
    }
    </script>


    <table id="picManager"></table>
    <div id="adPic"></div>
    <div id="modifyPic"></div>


    <div id="picTb" style="display: none">
        <a id="addPic" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增轮播图'"></a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true"/>
    </div>



