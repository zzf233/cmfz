<%--
  Created by IntelliJ IDEA.
  User: zzf_PC
  Date: 2018/7/6
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<script type="text/javascript" >
    $(function(){

        $("#modifyPicture").form("load","${pageContext.request.contextPath}/picture/queryById?pictureId=${param.pictureId}");


        $("#modifyPicOk").linkbutton({
            iconCls:"icon-add",
            onClick:function(){
                $("#modifyPicture").form("submit",{
                    url:"${pageContext.request.contextPath}/picture/modifyPicture",
                    success:function(res){
                        $.messager.show({
                            title:"修改成功！",
                            msg:"2秒后关闭",
                            timeout:2000,
                            showType:"slider",
                        });
                        $("#picManager").datagrid("load");
                        $("#modifyPic").dialog("close");
                    },

                })
            },
        })
    })
</script>



<form id="modifyPicture" action="" method="post" style="text-align: center" enctype="multipart/form-data">
    <br><br>
    <div style="margin: auto">
        文件编号 ：<input name="pictureId" class="easyui-textbox" data-options="readonly:true" > <br>
    </div><br>
    <div style="margin: auto">
        描述信息 ：<input name="pictureDescription" class="easyui-textbox" data-options="required:true"><br>
    </div><br>
    <div style="margin: auto">
        轮播状态 ：<input name="pictureStatus" class="easyui-textbox" data-options="required:true"><br>
    </div><br>
    <div style="margin: auto">
        文件 ：<input name="multipartFile" class="easyui-filebox" ><br>
    </div><br>


</form>

<p style="text-align: center"><a id="modifyPicOk">确认修改</a></p>
