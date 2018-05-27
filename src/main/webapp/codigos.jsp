<%@include file="/templates/head.jsp"%>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp"%>

<div id="codigo">

  <form class="form-signin" action="codigo" method="post">     

      <div class="form-label-group">
        <input type="text" class="form-control"
               name="code" 
               placeholder="Nombre Usuario" 
               required autofocus>
               
        <label for="code">Inserta Codigo</label>
      </div>

  
      <button class="btn btn-lg btn-primary btn-block" type="submit">Buscar</button>
      
    </form>

</div>
<jsp:include page="templates/footer.jsp"></jsp:include>
