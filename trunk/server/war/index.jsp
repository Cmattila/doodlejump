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