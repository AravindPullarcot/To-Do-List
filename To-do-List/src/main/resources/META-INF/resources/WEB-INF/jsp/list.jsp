<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">   
    <title>ToDOList Page</title>
  </head>
  <body>
	  <%@ include file="common/navigation.jspf" %>
	  <div class ="container">
		     <h1>HELLO ${name} YOUR TODO'S</h1>
		     <!-- <div>Your todos are ${todos}</div>-->
		     <table class="table">
		       <thead>
		        <tr>
		           <!-- <th>id</th>-->
		           <th>Description</th>
		           <th> Target Date</th>
		           <th>Is Done?</th>
		           <th></th>
		           <th></th>
		        </tr>
		       </thead>
		       <tbody>
		         <c:forEach items="${todos}" var="todo">
		            <tr>
		               <!-- <td>${todo.id}</td>-->
		               <td>${todo.description}</td>
		               <td>${todo.targetdate}</td>
		               <td>${todo.done}</td>
		               <td><a href="deletetodo?id=${todo.id}" class="btn btn-warning">DELETE <!-- ${todo.id}--></a> <!-- id is being passed to the function-->
		               <td><a href="updatetodo?id=${todo.id}" class="btn btn-success">UPDATE </a> <!-- id is being passed to the function-->
		            </tr>
		         </c:forEach>
		       </tbody>
		     </table>
		     <a href="addtodo" class="btn btn-success">ADD TODO</a>
	     </div>
	     <script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	     <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
