
<%@ page import="java.util.Map" %>
<%@ page import="entities.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <style>
            html {
                font-family: sans-serif;
            }

            table {
                border-collapse: collapse;
                border: 2px solid rgb(200,200,200);
                letter-spacing: 1px;
                font-size: 0.8rem;
            }
            strong {
                font-size: 1.5rem;
            }

            td, th {
                border: 1px solid rgb(190,190,190);
                padding: 10px 20px;
            }

            td {
                text-align: center;
            }

            caption {
                padding: 10px;
            }
        </style>
        <meta charset="utf-8">
        <title>Answers</title>
    </head>
    <body>
        <div>
            <br>Click this link to <a href="/login?a=exit">logout</a>
        </div>
        <%
            User user = (User) request.getSession().getAttribute("user");
            Map<String, Integer> voices = user.getVoices();

        %>
        <h1>Your answers</h1>
        <table>
            <colgroup>
                <col>
                <col width="150">
                <col width="150">
            </colgroup>
            <tr>
                <td></td><!--first line of cells / in horizontally-->
                <th>Q1</th>
                <th>Q2</th>
            </tr>
            <tr>
                <th>a</th><!--second line of cells / in horizontally-->
                <td><%="Deni" + "<br>" + "<strong>" +  voices.get("deni") + "</strong>"%></td>
                <td><%="angel" + "<br>" + "<strong>" + voices.get("angel") + "</strong>"%></td>
            </tr>

            <tr>
                <th>b</th><!--third line of cells / in horizontally-->
                <td><%="Jon Snow" + "<br>" + "<strong>" + voices.get("snow") + "</strong>"%></td>
                <td><%="demon" + "<br>" + "<strong>" + voices.get("demon") + "</strong>"%></td>
            </tr>

            <tr>
                <th>c</th><!--fourth line of cells / in horizontally-->
                <td><%="D. Vader" + "<br>" + "<strong>" + voices.get("vader") + "</strong>"%></td>
                <td><%="potato" + "<br>" + "<strong>" + voices.get("potato") + "</strong>"%></td>

            </tr>
        </table>
        <div>
            <br>
            <button onclick="location.href='views/account.jsp' ">Pass this test one more</button>
        </div>

    </body>
</html>