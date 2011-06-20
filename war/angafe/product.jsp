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
		<div class="product">
			<img src="/angafe/image?imgId=${f:h(product.photo.key.id)}" />
			<h1>${f:h(product.name)}</h1>
			<p>Produttore: <a href="/angafe/producer?id=${f:h(product.producerRef.model.key.id)}">${f:h(product.producerRef.model.name)}</a></p>
			<p>DESCRIZIONE DEL PRODOTTO</p>
			<p>${f:h(product.description)}</p>
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
