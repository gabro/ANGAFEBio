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
				
				
				
				<h1>Editor</h1>
				<table class="service_table edit_table">
					<th>Products</th>
					<th>Edit</th>
					<th>Delete</th>
					<c:forEach var="p" items="${allProducts}">
					<tr>
						<td>
							${f:h(p.name)}
						</td>
						<td>
							<a href="/angafe/product/edit?id=${f:h(p.key.id)}">Edit</a>
						</td>
						<td>
							<a href="/angafe/product/delete?id=${f:h(p.key.id)}">Delete</a>
						</td>	
					</tr>
				</c:forEach>
			</table>
									<a href="/angafe/product/add">Add</a>
			<br /><br />
			<table class="service_table edit_table">
					<th>Producers</th>
					<th>Edit</th>
					<th>Delete</th>
				<c:forEach var="p" items="${allProducers}">
				<tr>
					<td>
						${f:h(p.name)}
					</td>
					<td>
						<a href="/angafe/producer/edit?id=${f:h(p.key.id)}">Edit</a>
					</td>
					<td>
						<a href="/angafe/producer/delete?id=${f:h(p.key.id)}">Delete</a>
					</td>	
				</tr>
			</c:forEach>
		</table>
							<a href="/angafe/producer/add">Add</a>
			<br /><br />
		<table class="service_table edit_table">
				<th>Recipes</th>
					<th>Edit</th>
					<th>Delete</th>
			<c:forEach var="r" items="${allRecipes}">
			<tr>
				<td>
					${f:h(r.name)}
				</td>
				<td>
					<a href="/angafe/recipe/edit?id=${f:h(r.key.id)}">Edit</a>
				</td>
				<td>
					<a href="/angafe/recipe/delete?id=${f:h(r.key.id)}">Delete</a>
				</td>	
			</tr>
		</c:forEach>
	</table>
	<a href="/angafe/recipe/add">Add</a>
		<br /><br />
	<table class="service_table edit_table">
				<th>Offers</th>
					<th>Edit</th>
					<th>Delete</th>
		<c:forEach var="o" items="${allOffers}">
		<tr>
			<td>
				${f:h(o.name)}
			</td>
			<td>
				<a href="/angafe/offer/edit?id=${f:h(o.key.id)}">Edit</a>
			</td>
			<td>
				<a href="/angafe/offer/delete?id=${f:h(o.key.id)}">Delete</a>
			</td>	
		</tr>
	</c:forEach>
</table>
<a href="/angafe/offer/add">Add</a>
	<br /><br />
<table class="service_table edit_table">
				<th>Methods</th>
					<th>Edit</th>
					<th>Delete</th>
	<c:forEach var="m" items="${allMethods}">
	<tr>
		<td>
			${f:h(m.name)}
		</td>
		<td>
			<a href="/angafe/method/edit?id=${f:h(m.key.id)}">Edit</a>
		</td>
		<td>
			<a href="/angafe/method/delete?id=${f:h(m.key.id)}">Delete</a>
		</td>	
	</tr>
</c:forEach>
</table>
		<a href="/angafe/method/add">Add</a>
	<br /><br />
<table class="service_table edit_table">
				<th>Special Needs</th>
					<th>Edit</th>
					<th>Delete</th>
	<c:forEach var="n" items="${allNeeds}">
	<tr>
		<td>
			${f:h(n.name)}
		</td>
		<td>
			<a href="/angafe/need/edit?id=${f:h(n.key.id)}">Edit</a>
		</td>
		<td>
			<a href="/angafe/need/delete?id=${f:h(n.key.id)}">Delete</a>
		</td>	
	</tr>
</c:forEach>
</table>
		<a href="/angafe/need/add">Add</a>
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
