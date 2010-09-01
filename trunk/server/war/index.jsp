<%@ page language="java" pageEncoding="UTF-8"%>

<b>使用者的名称及其大中小三种头像：</b>
<div style="text-align: center;">
	图片：
		<xn:profile-pic uid="loggedinuser" linked="true" size="tiny"/>
		<xn:profile-pic uid="loggedinuser" linked="true" size="normal"/>
		<xn:profile-pic uid="loggedinuser" linked="true" size="main"/>
	<br />
	姓名：
		<xn:name uid="loggedinuser" linked="true" shownetwork="true" />
</div>

<div align="center">
          <b style="color:red;">选择好友，然后提交，可以看到好友的ID号:</b>
          <form action="demo3.jsp">
          <xn:multi-friend-selector max="5"/>
          <input type="submit" name="submit">

          </form>
        <%
          if (request.getParameter("ids[]") != null){
	          String[] ids = request.getParameterValues("ids[]");
	          for (String id:ids){
	          out.print(id + "<br>");
	          }
          }
		%>
</div>


<xn:swf swfsrc="http://doodle-jump.appspot.com/DJ/doodleJump1.swf" height="480" width="320"
align="center"  waitforclick="false"/>