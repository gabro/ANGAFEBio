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
		<div class="producer">
			<a href="${backLink}" class="${backLinkVisibility}"><-- ${backLinkTitle}</a>
			<h1>${f:h(producer.name)}</h1>
			<img src="/angafe/image?imgId=${f:h(producer.photo.key.id)}" />
			<p>INFO</p>
			<p>${f:h(producer.description)}</p>
			<br />
			<p>
			<a href="/angafe/products?filter=producer&id=${f:h(producer.key.id)}"><h2>Prodotti</h2></a>
			</p>
			<p>METODI DI PRODUZIONE ADOTTATI
				<ul>
				<c:forEach var="m" items="${methods}">
					<li><a href="/angafe/method?id=${m.key.id}&tour=producer&producerId=${f:h(producer.key.id)}">${m.name}</a></li>
				</c:forEach>
				</ul>
			</p>
			<h2>Contatti</h2>
			<p>
				email: ${f:h(producer.email)}<br />
				tel: ${f:h(producer.phone)}<br />
				fax: ${f:h(producer.fax)}
			</p>
			<a href="${groupLinkBack}" class="${groupLinkBackVisibility}"><-- ${groupLinkBackTitle}</a>
			<a href="${groupLinkForward}" class="${groupLinkForwardVisibility}">${groupLinkForwardTitle} --></a>
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