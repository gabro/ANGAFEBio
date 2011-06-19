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
				<!-- <br />
							<br />
							<table>
								<tr>
									<td class="photo">
										<a href="/angafe/product/mela"><img src="/resources/products/mela.png"></a>
									</td>
									<td>
										Red Love - Mela
									</td>
								</tr>
								<tr>
									<td class="photo">
										<a href="#"><img src="/resources/product/fragola.png"></a>
									</td>
									<td>
										Fragola
									</td>
								</tr>
								<tr>
									<td class="photo">
										<a href="#"><img src="/resources/product/pera.png"></a>
									</td>
									<td>
										Pera
									</td>
								</tr>
								<tr>
									<td class="photo">
										<a href="#"><img src="/resources/product/carciofo.png"></a>
									</td>
									<td>
										Carciofo
									</td>
								</tr> -->
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