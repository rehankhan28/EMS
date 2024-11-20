<%@taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>

<center>
<form:form  action="saveEmployee"  method="post"  modelAttribute="empModel">
 <table>
   <tr>
     <td> Emp No </td> <td> <form:input path="empno"/> </td>
   </tr>
   <tr>
     <td> Emp Name </td> <td> <form:input path="ename"/> </td>
   </tr>
   <tr>
     <td> Salary </td> <td> <form:input path="sal"/> </td>
   </tr>
   <tr>
     <td> Dept No </td> <td> <form:input path="deptno"/> </td>
   </tr>     
   <tr>
      <td  colspan="2"> <input type="submit"  value="SUBMIT"> </td>
   </tr>
 </table>

</form:form>
</center>