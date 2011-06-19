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
			<h1>BIOFRUTTA di Giovanni Mucciaccia</h1>
			<img src="/resources/producers/biofrutta.png"/ align="center">
			<p>INFO</p>
			<p>Biofrutta è attiva da anni nel campo della produzione di alimenti biologici.
			Fondata nel 1998 da Giovanni Mucciaccia è una delle aziende più in vista nel panorama calabrese.
			È particolarmente rinomata la sua Red Love, la mela rossa che ha riscosso immediato successo fin dal suo lancio sul mercato, avvenuto nel 2002.</p>
			<p>Particolarmente attenta alle esigenze dei neonati, ha lanciato da poco anche una linea di omogeneizzati.</p>
			<br />
			<p>
				<a href="/angafe/product"><h2>Prodotti</h2></a>
			</p>
			<h2>Contatti</h2>
			<p>
				email: info@biofrutta.cb<br />
				tel: 0961/735239
				fax: 0961/735236
				sito: <a href="#">www.biofrutta.cb</a>
			</p>
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