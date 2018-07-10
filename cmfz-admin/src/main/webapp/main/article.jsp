<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/8 0008
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8" isELIgnored="false"  %>

    <script type="text/javascript">
        function test() {
            alert(editor.txt.html());
        }

        $(function(){

            $("#save_article").linkbutton({

                iconCls:"icon-edit",
                onClick:function(){
                    //点击按钮提交表单
                    $("#article_form").form("submit",{
                        url:"${pageContext.request.contextPath}/article/addArticle",
                        onSubmit:function(article){
                        article.articleContent= editor.txt.html();

                        },
                        success:function(res){

                            $.messager.show({
                                title:"添加成功！",
                                msg:"2秒后关闭",
                                timeout:2000,
                                showType:"slider",
                            })

                            //成功重新加载页面
                           /* $('#masterdg').datagrid('load',{
                            });*/
                            //关闭对话框
                            //$("#dialog").dialog("close")

                        },
                    })

                },

            })



            //提交额外参数
        /*    $('#article_form').form('submit', {
                url:"/article/add",
                onSubmit: function(param){
                    introduction= 'aaa';
                }
            });
*/


            //取消按钮
            $("#cancel_article").linkbutton({

                iconCls:'icon-cancel',

                onClick:function(){

                    //$("#dialog").dialog("close")

                    $.messager.show({
                        title:"取消！",
                        msg:"2秒后关闭",
                        timeout:2000,
                        showType:"slider",
                    })

                }


            })


            //作者下拉框
            $("#masterName").combobox({
                valueField: 'masterId',
                textField: 'masterName',
                url:"${pageContext.request.contextPath}/master/showAllMaster",
            })


        })
    </script>




<form id="article_form" action="" method="post" style="text-align: center">
    <br/><br/><br/>
    &nbsp&nbsp文章标题：&nbsp<input id="name" class="easyui-textbox" name="articleName"/><br/><br/>
    &nbsp&nbsp文章作者：&nbsp<input  id="masterName" name="masterId" /><br/><br/>
    &nbsp&nbsp文章状态：&nbsp<input class="easyui-switchbutton" data-options="onText:'已上架',offText:'未上架'" name="articleStatus"/><br/><br/>

</form>



<p>文章内容：</p>
<div id="editor"></div>

<button id="btn" onclick="test()">点击获取富文本编辑器中的内容</button>

<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#editor');
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/upload';  // 上传图片到服务器
    editor.customConfig.uploadFileName = 'files'; //自定义上传图片的名称（input标签中的name）

    editor.create()
</script>




<p style="text-align: center">
    <a id="save_article">添加</a>
    <a id="cancel_article">取消</a>
</p>
