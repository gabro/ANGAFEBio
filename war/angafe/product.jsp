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
			<a href="${backLink}" class="${backLinkVisibility}"><-- ${backLinkTitle}</a>
			<img src="/angafe/image?imgId=${f:h(product.photo.key.id)}" />
			<h1>${f:h(product.name)}</h1>
			<p>Producer: <a href="/angafe/producer?id=${f:h(product.producerRef.model.key.id)}">${f:h(product.producerRef.model.name)}</a></p>
			<p>Production Method: <a href="/angafe/method?id=${f:h(product.productionMethodRef.model.key.id)}">${f:h(product.productionMethodRef.model.name)}</a></p>
			<c:if test='${fn:length(needs) > 0}'>
				<p>Indicated for these special needs:
					<ul>
					<c:forEach var="n" items="${needs}">
						<li>${f:h(n.name)}</li>
					</c:forEach>
					</ul>
				</p>
			</c:if>
			<c:if test='${fn:length(recipes) > 0}'>
				<p>Featured in these recipes:
						<ul>
						<c:forEach var="r" items="${recipes}">
							<li><a href="/angafe/recipe?id=${f:h(r.key.id)}&tour=product&productId=${f:h(product.key.id)}">${f:h(r.name)}</a></li>
						</c:forEach>
						</ul>
				</p>
			</c:if>
			<p>DESCRIZIONE DEL PRODOTTO</p>
			<p>${f:h(product.description)}</p>
			
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
