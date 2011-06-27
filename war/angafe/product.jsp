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
<div id="background_texture">
	<div id="leaf">
		<div id="wrapper">
			<jsp:include page="/includes/header.jsp" flush="true" />
			<div class="top"><img src="/resources/layout/content_box_top.png" width="940" height="10" alt="top" /></div>
			<div id="content_bg">
				<div id="left_column">
				
				
		<div class="product">
			<a href="${backLink}" class="${backLinkVisibility} "><h3><-- ${backLinkTitle}</h3></a>
			<h1>${f:h(product.name)}</h1>
			<img src="/angafe/image?imgId=${f:h(product.photo.key.id)}" class="image_border"/>

			<p><h2>Descrizione del Prodotto:</h2>
			${f:h(product.description)}</p>
			<p>
			<table class=service_table detail_table">
				<tbody>
				          <tr> 
           					<th>Producer</th> 
            				<th>Production Method</th> 
         				 </tr> 
							<tr>
							<td>
<a href="/angafe/producer?id=${f:h(product.producerRef.model.key.id)}">${f:h(product.producerRef.model.name)}</a>
							</td>
							<td>
<a href="/angafe/method?id=${f:h(product.productionMethodRef.model.key.id)}">${f:h(product.productionMethodRef.model.name)}</a>	
							</td>
						</tr>
			</tbody>
				</table>
			</p>	
			<c:if test='${fn:length(needs) > 0}'>
				<p><h2>Indicated for these special needs:</h2>
					<ul class="ticklist">
					<c:forEach var="n" items="${needs}">
						<li>${f:h(n.name)}</li>
					</c:forEach>
					</ul>
				</p>
			</c:if>
			<a href="/angafe/recipes?filter=product&id=${f:h(product.key.id)}"><h2>Ricette</h2></a>
			<h3>
			<a href="${groupLinkBack}" class="${groupLinkBackVisibility}"><-- ${groupLinkBackTitle}</a>
			<a href="${groupLinkForward}" class="${groupLinkForwardVisibility}">${groupLinkForwardTitle} --></a>
			</h3>
		</div>
				</div>
        	<div id="right_column">
           		<jsp:include page="/includes/sidemenu.jsp" flush="true" />     	
        	</div>
        	<hr class="clear" />
      </div>
      <div class="bottom"><img src="/resources/layout/content_box_bottom.png" width="940" height="21" alt="bottom" /></div>
    </div>
    <div id="footer">
      <div class="left">Realizzazione a cura di <b>Andrea Villa</b>, <b>Federico Pellegatta</b> e <b>Gabriele Petronella</b></div>
    </div>
  </div>
</div>
</body>
</html>

