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
		<div class="list">
			<a href="/angafe/producer?id=${producer.key.id}" class="${visibility}"><-- ${f:h(backText)}</a>
			<h1>${f:h(title)}</h1>
		<table>
			<c:forEach var="m" items="${methods}">
			<tr>
				<td class="photo">
					<img src="/angafe/image?imgId=${f:h(m.photo.key.id)}" />
				</td>
				<td>
					<a href="/angafe/method?id=${f:h(m.key.id)}">${f:h(m.name)}</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		</div>
	</div>
</div>

<div id="rightcolumn">
	<div class="innertube">
		<jsp:include page="/includes/sidemenu.jsp" flush="true" />
	</div>
</div>

<div id="footer">Realizzazione a cura di <b>Andrea Villa</b>, <b>Federico Pellegatta</b> e <b>Gabriele Petronella</b></a></div>

</div>
</body>
</html>
