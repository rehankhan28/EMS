<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<center>
<c:if test="${message ne null}">
  <c:out value="${message}"/>
</c:if>
<hr>
<a  href="addEmployee"> add employee </a> <br> <br>
<a  href="listEmployees"> list employees </a>
</center>
<br>
<br>
<!-- <a href="logoutMe">SignOut</a>-->
