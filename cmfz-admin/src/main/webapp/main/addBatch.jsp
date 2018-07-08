<%--
  Created by IntelliJ IDEA.
  User: zzf_PC
  Date: 2018/7/8
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<script type="text/javascript">
    $("#master_btn").linkbutton({
        onClick:function () {
            $("#master_form").form("submit" , {
                url:"${pageContext.request.contextPath}/master/addBatch",
                onSubmit:function () {
                    return true;
                },
                success:function () {
                    $.messager.show({
                        title:"插入成功！",
                        msg:"2秒后关闭",
                        timeout:2000,
                        showType:"slider",
                    });
                    $("#masterManager").datagrid("load");
                    $("#master_dd").dialog("close");
                }
            })
        }
    })
</script>
<form id="master_form" method="post" enctype="multipart/form-data" style="text-align: center">
    <br /><br /><br />
    <div>
        请选择Excel文件：<input class="easyui-filebox" name="file" />
    </div>
    <br /><br />
</form>
<p style="text-align: center"><a style="text-align: center" class="easyui-linkbutton" id="master_btn">提交</a></p>