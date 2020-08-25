<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>3Rr0r!</title>
<style type="text/css">
body {
	background-color: black;
}
img {
	position: fixed;
    z-index: 10;
  	display: block;
	right: 100px;
	top: 180px;
	float: right;
	width: 25%;
	height: 50%;
} 
#ghost {
	top: 0;
	left: 100px;
	z-index: 0;
	position: absolute;
}
h1 {
	color: white;
	left: 100px;
	position: fixed;
    z-index: 10;
	display: block;	
	top: 0;
	font-family: Impact;
	font-size: 250px;
}
p {
	color: white;
	left: 118px;
	position: fixed;
    z-index: 10;
  	display: block;
  	top: 420px;
	font-family: Impact;
	font-size: 35px;
}
a {
	color: #999999;	
}
</style>
</head>
<body>
<p id="ghost"> </p>
<div>
<h1>Oops!</h1>
<p>Something went wrong, please <a href="index.html">try again </a>.</p>
<img alt="broken" src="resources/FilmAISSbroken.png">
</div>
</body>
</html>