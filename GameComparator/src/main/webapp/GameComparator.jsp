<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="comparator.GameComparator"%>

<html>
	<head>
		<title>Blungogo, tu comparador de juegos de ordenador</title>
		<link rel="stylesheet" type="text/css" media="screen" href="style.css" />	
	</head>


	<body>
		<main>
	<% 
	if(request.getAttribute("juego") != null){
		GameComparator modelo=(GameComparator)request.getAttribute("juego");
		int cont=0;
                // cuando se añada amazon cambiar al final contador==3
		if(modelo.getUrlImagenIG() != null){%>
			<div id="preamble">
					<h3>InstantGaming</h3>
					<p class="p1"><a href="<%out.print(modelo.getUrlIG()); %>"> 
						<img src="<%out.print(modelo.getUrlImagenIG()); %>" width="179" height="250" 
						style="float:left; padding-right:20px; " /> </a> 
						 <%out.print(modelo.getPrecioIG()); %></p>
				  </div>
		<%}/*
		else{
			cont++;
		}
		/*if(modelo.getUrlImagenKinguin() != null){*/%>
			<div id="preamble">
					<h3>Kinguin</h3>
					<p class="p1"><a href="<%out.print(modelo.getUrlKinguin()); %>"> 
						<img src="<%out.print(modelo.getUrlImagenKinguin()); %>" width="179" height="250" 
						style="float:left; padding-right:20px; " /> </a>  
						<%out.print(modelo.getPrecioKinguin()); %></p>
					  </div>
		<%/*}
		else{
			cont++;
		}*/
		/*if(modelo.getUrlImagenAmazon() != null){*/%>
		<div id="preamble">
				<h3>Amazon</h3>
				<p class="p1"><a href="<%out.print(modelo.getUrlAmazon()); %>"> 
					<img src="<%out.print(modelo.getUrlImagenAmazon()); %>" width="179" height="250" 
					style="float:left; padding-right:20px; " /> </a>  
					<%out.print(modelo.getPrecioAmazon()); %></p>
				  </div>
		<%/*}
		else{
			cont++;
		}*/
		if(cont==3){
			%><p id="fail">No hemos encontrado ninguna oferta :(</p><%
		}
	}%>

</main>
	<footer>
			<a href="">About Us</a>
			<a href="mailto:davidpeinado@correo.ugr.es">Contact</a>
</footer>	
</body>
</html>