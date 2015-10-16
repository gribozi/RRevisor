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

<title>${restOne.name}</title>
</head>
<body>
	<div class="wrapper">
		<h1>${restOne.name}</h1>
		<div class="allrates">
			<table class="rates-tabl">
				<tr>
					<td>Кухня:</td>
					<td><span class="rate"><span style="width: ${restOne.raitCuisine * 100 / 5}%;"></span></span></td>
				</tr>
				<tr>
					<td>Интерьер:</td>
					<td><span class="rate"><span style="width: ${restOne.raitInterior * 100 / 5}%;"></span></span></td>
				</tr>
				<tr>
					<td>Обслуживание:</td>
					<td><span class="rate"><span style="width: ${restOne.raitService * 100 / 5}%;"></span></span></td>
				</tr>
				<tr>
					<td class="total">Общий рейтинг:</td>
					<td><span class="rate"><span style="width: ${restOne.raitTotal * 100 / 5}%;"></span></span></td>
				</tr>
			</table>
	 	</div>
	 	<p class="review">${restOne.review}</p>
	 	<div class="gallery">
		 	<a class="fancy" rel="group" title="Это фото 1" href="img/gallery/${restOne.id}/010-b.jpg"><img src="img/gallery/${restOne.id}/010-s.jpg" /></a>
		 	<a class="fancy" rel="group" title="Это фото 2" href="img/gallery/${restOne.id}/020-b.jpg"><img src="img/gallery/${restOne.id}/020-s.jpg" /></a>
		 	<a class="fancy" rel="group" title="Это фото 3" href="img/gallery/${restOne.id}/030-b.jpg"><img src="img/gallery/${restOne.id}/030-s.jpg" /></a>
		 	<a class="fancy" rel="group" title="Это фото 4" href="img/gallery/${restOne.id}/040-b.jpg"><img src="img/gallery/${restOne.id}/040-s.jpg" /></a>
		 	<a class="fancy" rel="group" title="Это фото 5" href="img/gallery/${restOne.id}/050-b.jpg"><img src="img/gallery/${restOne.id}/050-s.jpg" /></a>
		 	<a class="fancy" rel="group" title="Это фото 6" href="img/gallery/${restOne.id}/060-b.jpg"><img src="img/gallery/${restOne.id}/060-s.jpg" /></a>
		</div>
	 	<a class="link" href="RestList">Список ресторанов</a>
	</div>	 	
</body>
</html>