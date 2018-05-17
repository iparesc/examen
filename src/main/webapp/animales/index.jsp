<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>


<h1>Animales</h1>



<table class="tabla table table-striped table-bordered" style="width:100%">
   <thead>
       <tr>
           <th>ID</th>
           <th>Nombre</th>                   
       </tr>
   </thead>
   <tbody>
            
	<c:forEach items="${animales}" var="animal">
		<tr>			
					
			<td>${animal.id}</td>			
			<td>${animal.nombre}</td>
		</tr>	
	</c:forEach>
	
	</tbody>
</table>

<jsp:include page="/templates/footer.jsp"></jsp:include>