<%@ page import="java.net.URLDecoder" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<head>
	<title>持明法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="/admin/login/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="/admin/login/css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="/admin/login/css/login.css" type="text/css"></link>
	<script type="text/javascript" src="/admin/login/script/jquery.js"></script>
	<script type="text/javascript" src="/admin/login/script/common.js"></script>
	<script type="text/javascript">
	
		$(function(){
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码
                $("#captchaImage").attr("src" , "/admin/manager/getCode?rnd="+Math.random());
			});

			
			//  form 表单提交
			$("#loginForm").bind("submit",function(){
				/*alert("自己做");*/
                return $("#loginForm").submit;
            });

			//点击勾选记住密码
            $("#isRememberUsername").click(function(){
                $("#isRememberUsername").prop("value","true");
            });
		});
       /* window.onload=function(){
            var remeger = document.getElementById("managerName");//获取对象
            var username = decodeURIComponent("${cookie.managerName.value}");//如果为空,使用解码后为空字符串
            if(!remeger.length==0){
                remeger.value=username;
            }
        };*/
	</script>
</head>
<body>
	
		<div class="login">
			<form id="loginForm" action="/admin/manager/login" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="/admin/login/img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<%
									Cookie[] cookies = request.getCookies();
									String name = "";
									for (Cookie cookie : cookies) {
										if (cookie.getName().equals("managerName")) {
										    name = URLDecoder.decode(cookie.getValue(),"utf-8");
										}
									}
								%>
								<input type="text" id="managerName"  name="managerName" class="text" value="<%=name%>" maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" name="managerPassword" class="text" value="${cookie.managerPassword.value}" maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="/admin/manager/getCode" title="点击更换验证码"/>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
						<td>
							<label>
								<input type="checkbox" id="isRememberUsername" name="rememberPassword" value=""/> 记住密码
							</label>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>