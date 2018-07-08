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
        $("#addMa").linkbutton({
            iconCls:"icon-add",
            onClick:function(){
                $("#addM").form("submit",{
                    url:"${pageContext.request.contextPath}/master/addMaster",
                    success:function(res){
                        $.messager.show({
                            title:"添加成功！",
                            msg:"2秒后关闭",
                            timeout:2000,
                            showType:"slider",
                        });
                        $("#masterManager").datagrid("load");
                        $("#masterAdd").dialog("close");
                    },

                })
            },
        })
    })
</script>



<form id="addM" action="" method="post" style="text-align: center" enctype="multipart/form-data">
    <br/><br/>
    上师法名：<input id="name" class="easyui-textbox" name="masterName" /><br/><br/>
    简介：<input class="easyui-textbox" name="masterSummar" /><br/><br/>
    上传上师照片：<input class="easyui-filebox" name="multipartFile" /><br/><br/>


</form>

<p style="text-align: center"><a id="addMa">添加上师</a></p>
