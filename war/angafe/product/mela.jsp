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
			<img src="/resources/products/mela.png"/ align="center">
			<h1>LA MELA ROSSA "RED LOVE"</h1>
			<p>DESCRIZIONE DEL PRODOTTO</p>
			<p>Red Love, la mela rossa di Markus Kobertis avrebbe fatto invidia sia a Eva che al serpente, e di certo avrebbe conquistato Biancaneve. Red Love è una mela completamente rossa, sono rosse la buccia e la polpa.
</p><p>
			La produzione del frutto è inglese (l'azienda Suttons ha acquistato il brevetto) ma l'agronomo che ha lavorato alla nascita di Red Love, incrociando per vent'anni specie diverse, è lo svizzero Markus Kubertis. Red Love è un frutto biologico, la sua produzione è al 100% naturale, per la sua creazione non si è fatto ricorso ad alcun Ogm.
			Per evitare l'impollinazione casuale da parte delle api, gli alberi di Red Love sono stati tenuti in gallerie apposite invece che all'aria aperta.
		</p><p>
			Red Love, non solo è bella a vedersi, è anche buona. Il frutto è ricco di proprietà antiossidanti ed ha una caratteristica molto particolare: Red Love tagliata a pezzetti per la macedonia o a fette per essere servita a fine pasto, non annerisce.</p>
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
