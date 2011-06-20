<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<link rel="stylesheet" href="/css/global.css" type="text/css" media="screen" title="no title" charset="utf-8">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ANGAFE Index</title>
</head>
<body>	

<div id="maincontainer">

<div id="header">
	<jsp:include page="/includes/header.jsp" flush="true" />
</div>

<div id="contentwrapper">
	<div id="contentcolumn">
		<table>
			<form enctype="multipart/form-data" method="post" action="load?action=edit&id=${producer.key.id}">
				<tr>
					<td>Name</td>
					<td><input type="text" name="name"/ value="${producer.name}"></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><textarea name="description">${producer.description}</textarea></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="text" name="phone"/ value="${producer.phone}"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email"/ value="${producer.email}"></td>
				</tr>
				<tr>
					<td>Photo</td>
					<td><img src="/angafe/image?imgId=${f:h(producer.photo.key.id)}" /></td>
				</tr>
				<tr>
					<td>Load a photo</td>
					<td><input type="file" name="img"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Send"></td>
				</tr>
			</form>
		</table>	
	</div>
</div>

<div id="rightcolumn">
		<jsp:include page="/includes/sidemenu.jsp" flush="true" />
</div>

<div id="footer">Realizzazione a cura di <b>Andrea Villa</b>, <b>Federico Pellegatta</b> e <b>Gabriele Petronella</b></a></div>

</div>
</body>
</html>
