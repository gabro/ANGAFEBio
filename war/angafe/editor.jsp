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
			<div id="contentcolumn" class="editor">
				<h1> EDITOR </h1>
				<table>
					<th>
						PRODUCTS
					</th>
					<c:forEach var="p" items="${allProducts}">
					<tr>
						<td class="first">
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
				<tr>
					<td class="first">
						<a href="/angafe/product/add">Add</a>
					</td>
				</tr>
			</table>
			<br />
			<table>
				<th>
					PRODUCERS
				</th>
				<c:forEach var="p" items="${allProducers}">
				<tr>
					<td class="first">
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
			<tr>
				<td class="first">
					<a href="/angafe/producer/add">Add</a>
				</td>
			</tr>
		</table>
		<br />
		<table>
			<th>
				RECIPES
			</th>
			<c:forEach var="r" items="${allRecipes}">
			<tr>
				<td class="first">
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
		<tr>
			<td class="first">
				<a href="/angafe/recipe/add">Add</a>
			</td>
		</tr>
	</table>
	<br />
	<table>
		<th>
			OFFERS
		</th>
		<c:forEach var="o" items="${allOffers}">
		<tr>
			<td class="first">
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
	<tr>
		<td class="first">
			<a href="/angafe/offer/add">Add</a>
		</td>
	</tr>
</table>
<br />
<table>
	<th>
		METHODS
	</th>
	<c:forEach var="m" items="${allMethods}">
	<tr>
		<td class="first">
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
<tr>
	<td class="first">
		<a href="/angafe/method/add">Add</a>
	</td>
</tr>
</table>
<br />
<table>
	<th>
		SPECIAL NEEDS
	</th>
	<c:forEach var="n" items="${allNeeds}">
	<tr>
		<td class="first">
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
<tr>
	<td class="first">
		<a href="/angafe/need/add">Add</a>
	</td>
</tr>
</table>
</div>
</div>

<div id="rightcolumn">
	<jsp:include page="/includes/sidemenu.jsp" flush="true" />
</div>

<div id="footer">Realizzazione a cura di <b>Andrea Villa</b>, <b>Federico Pellegatta</b> e <b>Gabriele Petronella</b></a></div>

</div>
</body>
</html>