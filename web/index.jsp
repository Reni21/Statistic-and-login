<%--
  Created by IntelliJ IDEA.
  User: reni
  Date: 5/20/19
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Login page</title>
  </head>
  <body>
    <%
      Boolean isExists = (Boolean) request.getSession().getAttribute("isExists");
      Boolean isValidData = (Boolean) request.getSession().getAttribute("isValidData");
      if(isExists != null && !isExists) {
        out.println("<h2 style=\"color: red;\">Incorrect login or password</h2>");
      } else if(isValidData != null && !isValidData){
        out.println("<h2 style=\"color: red;\">This login is already taken</h2>");
      }
    %>
    <form name = "form" method= "post" action="/login">
      <input type=textbox name ="log" size="25" maxlength="16" placeholder="Login"><br><br>
      <input type=password name ="pas" size= "25" maxlength="8" placeholder="Password">

      <!--send post request-->
      <div>
        <br><input style="margin-right:2em;" type=submit name="act" value="Sign in"><input type=submit name="act" value="Sign up">
      </div>
    </form>
  </body>
</html>