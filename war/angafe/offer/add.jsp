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
				
				
				<table>
					<form method="post" action="load?action=add">
						<tr>
							<td>Name</td>
							<td><input type="text" name="name"/></td>
						</tr>
						<tr>
							<td>Informations</td>
							<td><textarea name="info"></textarea></td>
						</tr>
						<tr>
							<td valign="top">Products Featured</td>
							<td>
								<c:forEach var="p" items="${allProducts}">		            
								<input type=checkbox name="product" value="${f:h(p.key.id)}">${f:h(p.name)}</input>
								<br />
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td>
							Data inizio
						</td>
						<td>
							<input type="text" name="dataInizio" />
						</td>
					</tr>
					<tr>
						<td>
							Data fine
						</td>
						<td>
							<input type="text" name="dataFine" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Invia"></td>
					</tr>
				</form>
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
