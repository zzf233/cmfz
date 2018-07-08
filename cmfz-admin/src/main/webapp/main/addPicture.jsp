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
        $("#addPicOk").linkbutton({
            iconCls:"icon-add",
            onClick:function(){
                $("#addPicture").form("submit",{
                    url:"${pageContext.request.contextPath}/picture/addPicture",
                    success:function(res){
                        $.messager.show({
                            title:"添加成功！",
                            msg:"2秒后关闭",
                            timeout:2000,
                            showType:"slider",
                        });
                        $("#picManager").datagrid("load");
                        $("#adPic").dialog("close");
                    },

                })
            },
        })
    })
</script>



<form id="addPicture" action="" method="post" style="text-align: center" enctype="multipart/form-data">
    <br/><br/>
    轮播图描述：<input id="name" class="easyui-textbox" name="pictureDescription" /><br/><br/>
    轮播图状态：<input class="easyui-textbox" name="pictureStatus" /><br/><br/>
    上传轮播图：<input class="easyui-filebox" name="multipartFile" /><br/><br/>


</form>

<p style="text-align: center"><a id="addPicOk">添加用户</a></p>
