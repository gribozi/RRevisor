jQuery(document).ready(function(){
	//jQuery("body").css("background-color", "#111");
	jQuery("a.fancy").fancybox();
	initializeMap();
});

  //-------------------------------------------------
  //  Google map
  //-------------------------------------------------
function initializeMap() {
  var mapOptions = {
    zoom: 14,
    center: new google.maps.LatLng(46.505622, 30.631019),
    scrollwheel: false,
    // mapTypeId: google.maps.MapTypeId.HYBRID
  };
  var map = new google.maps.Map(document.getElementsByClassName('map-container')[0], mapOptions);

  new google.maps.Marker({
    position: new google.maps.LatLng(46.504387, 30.619852),
    map: map,
    title: 'Доминион Комплект',
    icon: 'img/map-pin.png'
  });
}