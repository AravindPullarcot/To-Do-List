<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">   
  <body>
  <%@ include file="common/navigation.jspf" %>
  <div class="container">
      <div>Welcome to this application</div>
      <div>Welcome ${name}</div>
      <hr>
      <div><a href="listtodo">Manage your to-dos</a></div>
      
      <!-- Display error message if available -->
      <c:if test="${not empty error}">
          <div class="alert alert-danger" role="alert">
              Error: ${error}
          </div>
      </c:if>
  </div>
  <script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
  <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>


