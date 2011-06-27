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
				
				
	
			<a href="/angafe/producer?id=${producer.key.id}" class="${visibility} "><h3><-- ${f:h(backText)}</h3></a>
			<h1>${f:h(title)}</h1>
				<table class="service_table">
				<tbody>
				          <tr> 
           					<th>Immagine</th> 
            				<th>Nome</th> 
         				 </tr> 
			<c:forEach var="m" items="${methods}">
			<tr>
				<td class="photo">
					<img src="/angafe/image?imgId=${f:h(m.photo.key.id)}" />
				</td>
				<td>
					<a href="/angafe/method?id=${f:h(m.key.id)}&index=true">${f:h(m.name)}</a>
				</td>
			</tr>
			</c:forEach>
					</tbody>
		</table>





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

