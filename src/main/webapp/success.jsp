<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>FilmAISS</title>
<meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no" />
<script src="https://unpkg.com/leaflet@1.0.3/dist/leaflet.js"></script>
<script src="https://tiles.locationiq.com/js/leaflet-unwired.js"></script>
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.0.3/dist/leaflet.css" />
<link rel="stylesheet" type="text/css" href="component.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="Inpo.css" />
<style>
	body { margin: 0; 
	padding: 0; 
	background-color: #333333;
	}
  #inp{
  border: 1px solid #FFFAAA;}
	#map {top: 0; bottom: 0; width: 100%; height:600px; color: white; z-index: 1; position: absolute;border-bottom: 10px solid #777;}
	#data{top-margin:100px; color: white;}
     #imageLogo {
	  position: fixed;
     z-index: 10;
	  display: block;
	right: 10px;
	top: 10px;
      width: 5%;
    }
    a {
    	color: #AAAAAA;	
    }
    
	
    h5 {
  		font-size: 20px;
  		color: white;
    }
    #bodyId {
    	padding-top: 625px;
    }
    #deezer {
	  display: block;
	  margin-left: auto;
	  margin-right: auto;
	  scrolling: no;
    }
    #formBusq {
    	z-index: 10;
	    max-width:275px; 
	    max-height: 75px;
	    left: 50%;
	    top: 10%;
	    opacity: 80%;
	    position: absolute;
	    -webkit-transform: translate3d(-50%, -50%, 0);
	    -moz-transform: translate3d(-50%, -50%, 0);
	    transform: translate3d(-50%, -50%, 0);
    }
    
    * {
  box-sizing: border-box;
}

/* Style the search field */
form.example input[type=text] {
  padding: 10px;
  font-size: 17px;
  border: 1px solid grey;
  float: left;
  width: 80%;
  background: #f1f1f1;
}

/* Style the submit button */
form.example button {
  float: left;
  width: 20%;
  padding: 10px;
  height: 42px;
  background: grey;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none; /* Prevent double borders */
  cursor: pointer;
}

form.example button:hover {
  background: #0b7dda;
}

/* Clear floats */
form.example::after {
  content: "";
  clear: both;
  display: table;
}
/* width */
::-webkit-scrollbar {
  width: 10px;
}

/* Track */
::-webkit-scrollbar-track {
  box-shadow: inset 0 0 5px grey; 
}
 
/* Handle */
::-webkit-scrollbar-thumb {
  background: #EEEEEE; 
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background: #AAAAAA; 
}
</style>

<script type="text/javascript">
//auto expand textarea
function adjust_textarea(h) {
    h.style.height = "20px";
    h.style.height = (h.scrollHeight)+"px";
}
</script>

</head>
<body>
<div>
	<form action="index.html">
		<input type="image" id="imageLogo" alt="imageLogo" src="/resources/FilmAISS.png" href="index.html">
	</form>
	
	
<c:if test="${not empty requestScope.lcoordenadas}">
<div id="map" class="map"></div>
<script>
	// API token goes here
var key = '1048ac96715341';

// Add layers that we need to the map
var streets = L.tileLayer.Unwired({key: key, scheme: "streets"});

// Initialize the map
var map = L.map('map', {
        center: [0.0, 0.0], //map loads with this location as center
        zoom: 1.5,
        layers: [streets] // Show 'streets' by default

});

// Add the 'scale' control
L.control.scale().addTo(map);


</script>

	
	
<script>		
		<c:forEach items="${requestScope.lcoordenadas}" var="location">
				L.marker(["${location.latLng.lat}", "${location.latLng.lng}"]).addTo(map);//.bindPopup("<b>Scene Description</b><br>I am a popup.").addTo(map);
		</c:forEach>
</script>

</c:if>
		<form class="example" action="SearchController" method="post" id="formBusq">
		  <input id="barraBusq" name="searchQuery" type="text" placeholder="Search for your film...">
		  <button type="submit"><i class="fa fa-search"></i></button>
		</form>
</div>

<div id="bodyId">
	<h10 style="font-family: Impact; display: flex; align-items: left; justify-content: center; font-size: 3.0em; color: white; text-decoration: underline white;" name="tituloPelicula1">${requestScope.movie.title}</h10>
	<div id="data" style="margin-left:50px; margin-top: 60px;	">
	
	<div style="float: right; margin-right: 50px;">
	<div class="wrapper">
		<ul class="stage">

			<li class="scene">
				<div class="movie" onclick="return true">
					<div class="poster">
						<img alt="photo" width="100%" height="100%"
							src="${requestScope.movie.urlPoster}">
					</div>
					<div class="info">
						<header id="cabecerea">
							<h1 name="tituloPelicula">${requestScope.movie.title}</h1>
							<span class="year">${requestScope.movie.releaseDate}</span><br>
							<span class="rating">Rating: ${requestScope.movie.rating}</span><br>
							<span class="duration">${requestScope.movie.runtime}</span>
						</header>
						<p> ${requestScope.movie.simplePlot}</p>
					</div>
				</div>
			</li>
		</ul>
	</div>
	
	
	
	<c:if test="${not empty requestScope.datum.title}">
		<iframe id="deezer" frameborder="0" src="https://www.deezer.com/plugins/player?format=classic&autoplay=true&playlist=false&width=250&height=62&color=ff0000&layout=dark&size=medium&type=tracks&id=${requestScope.datum.id}&app_id=1" width="250" height="62" allow="autoplay"></iframe>
		<p style="text-align: center">To enjoy the full Soundtrack log in <a target="_blank" href="https://www.deezer.com/es/login">here</a></p>
	</c:if>
			
			<iframe style="margin-top: 100px;" width="560" height="315" src="https://www.youtube.com/embed/${requestScope.trailerYT.id.videoId}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			
			<br><br>
			
			<p style="font-size: 1.2em;"> Leave a comment </p>
			<!--  
			<form id="comments" action="RestdbController" method="post" target="_blank">
			<input type="text" name="nombreuser" id="inputComment" placeholder="Name" required />
		        <input type="text" name="comentario" id="inputComment" placeholder="Message"required /> <input
		            type="submit" name="SendBtn" title="send" value="Enviar">
			</form>
			-->
			
			
			
			<form class="form-style-4" id="comments" action="RestdbController" method="post" target="_blank">
			<label for="field1">
			<span>Enter Your Name</span><input type="text" name="nombreuser" id="inputComment" required />
			</label>
			<label for="field4">
			<span>Message to Us</span><textarea name="comentario" id="inputComment" onkeyup="adjust_textarea(this)" required></textarea>
			</label>
			<label>
			<span> </span><input type="submit" name="SendBtn" title="send" value="SEND">
			</label>
			</form>
			
			
			
			
			<br><br>
			
			<fieldset>
			 <legend>Comments:</legend>
				<br>
				<c:forEach items="${requestScope.comentariosList}" var="commentsVal">
				<div>
					<c:out value="Nombre: ${commentsVal.nombre}"></c:out>
					<br>
					<c:out value="Mensaje: ${commentsVal.mensaje}"></c:out>
					<br>
					<br>
				</div>
				</c:forEach>
			</fieldset>
			
			<c:set var="movie" scope="session" value="${requestScope.movie.title}"></c:set>
			<c:set var="aux" scope="session" value="1"></c:set>
	</div>
		<div id="imdb">
	
			<c:if test="${not empty requestScope.movie.directors}">
				<h1 style="font-size: 1.2em;">
					Directors
				</h1>
		
				<br>
				<c:forEach items="${requestScope.movie.directors}" var="director">
					Director Name: 
					<a href="${director.id}">${director.name}</a>
					<br>
				</c:forEach>
				<br><br><br>
			</c:if>
			
			<c:if test="${not empty requestScope.movie.writers}">
				<h2 style="font-size: 1.2em;">
					Writers
				</h2>
	
				<br>
				<c:forEach items="${requestScope.movie.writers}" var="writer">
					Writer Name: 
					<a href="${writer.id}">${writer.name}</a>
					<br	>
				</c:forEach>
				<br><br><br>
			</c:if>
			
			<c:if test="${not empty requestScope.movie.actors}">
				<h3 style="font-size: 1.2em;">
					Actors
				</h3>
				
				<br>
				<c:forEach items="${requestScope.movie.actors}" var="actor">
					<img alt="photoact" src="${actor.urlPhoto}">
					<div>
						<c:out value="Actor: ${actor.actorName}" />
						<br>
						<c:out value="Character: ${actor.character}" />
					</div>
					<br /><br>
				</c:forEach>
			</c:if>

		</div>
		
		

	</div>
	<script type="text/javascript">
		
	</script>
	
	
</div>

	
</body>
</html>