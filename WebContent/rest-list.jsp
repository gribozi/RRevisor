<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="js/fancybox/jquery.fancybox.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/fancybox/jquery.fancybox.pack.js" type="text/javascript"></script>
<script src="js/functions.js" type="text/javascript"></script>
<script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript"></script>

<title>Рестораны</title>
</head>
<body>
	<div class="wrapper">
		<h1>Рестораны</h1>
		<ul class="rests-list">
			<c:forEach var="rest" items="${restList}">
			<li>
				<div><a href="RestOne?rest=${rest.id}">${rest.name}</a></div>
				<div><span class="rate"><span style="width: ${rest.raitTotal * 100 / 5}%;"></span></span></div>
			</li>
			</c:forEach>
		</ul>
	</div>

    <div class="map">
		<div class="map-container"></div>
    </div>

</body>
</html>