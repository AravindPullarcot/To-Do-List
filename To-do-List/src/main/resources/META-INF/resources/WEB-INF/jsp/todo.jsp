<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
        
    <title>ToDo Details Page</title>
    <style>
      .error {
        color: red;
        myreee
      }
    </style>
  </head>
  <body>
       <%@ include file="common/navigation.jspf" %>
	  
  
	  <div class ="container">
	  	<h1>Enter ToDo Details</h1>
		  	<form:form method="post" modelAttribute="todo"><!-- binding todo with the bean -->
		    <fieldset class="mb-3">
			  	<form:label path="description">Description</form:label>
			  	<form:input type="text" path="description" required="required"/> <!-- name="description" --> <!-- front end validation using required server side validation is recommedned as front  -->
			  	<form:errors path="description" cssClass="text-warning"/>
		  	</fieldset>	
		  	
		  	<fieldset class="mb-3">
			  	<form:label path="targetdate">Target-Date</form:label>
			  	<form:input type="text" path="targetdate" required="required"/> <!-- name="description" --> <!-- front end validation using required server side validation is recommedned as front  -->
			  	<form:errors path="targetdate" cssClass="text-warning"/>
		  	</fieldset>	
		  		  	
		  	<form:input type="hidden" path="id" /><!-- instead of type=hidden write text then you will see the dialogue box, which is not what we want  -->
		  	<form:input type="hidden" path="done" />
		  	<input type="submit" class="btn btn-success"/>
		  	</form:form>	    
	  </div>
     <script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
     <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
      <script src="/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
      <script type="text/javascript">$('#targetdate').datepicker({
    	    format: 'yyyy-mm-dd',
    	});
      </script>
     
    
  </body>
</html>
