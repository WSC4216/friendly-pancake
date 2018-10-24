<%@page import="java.util.List"%>
<%@page import="album.domain.Album"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Album> albums=(ArrayList<Album>)session.getAttribute("albums");
	
	%>
	<s:form action="uploadAction" method="post"
		enctype="multipart/form-data">
		<s:file name="upload"></s:file>
		<s:submit value="上传"></s:submit>
		<select name="album_id">
			<%
				for (int i = 0; i < albums.size(); i++) {
			%>
			<option value=<%=albums.get(i).getId()%>>
					<%=albums.get(i).getAlbum_name()%>
				</option>
			<%
				}
			%>
		</select>
	</s:form>
	<s:form action="viewPhotos" method="post">
		<select name="album_id">
			<%
				for (int i = 0; i < albums.size(); i++) {
			%>
			<option value=<%=albums.get(i).getId()%>>
					<%=albums.get(i).getAlbum_name()%>
				</option>
			<%
				}
			%>
		</select>
		<s:submit>查看相册</s:submit>
	</s:form>
</body>
</html>