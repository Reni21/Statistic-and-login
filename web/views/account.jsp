
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>My account</title>
    </head>
    <body>
        <div>
             <br>Click this link to <a href="/login?out=exit">logout</a>
        </div>

        <h3 style="color: red;">*All fields are required</h3>

        <form name = "form" method= "post" action="/statistic">
            <div>
                <h4 >Q1: Who will be the king of the Seven Kingdoms?</h4>
                a: Deni Mother of Dragons <input type="radio" name="q1" value="deni"><br> <!-- checked-->
                b: Jon Snow <input type="radio" name="q1" value="snow"><br>
                c: Darth Vader <input type="radio" name="q1" value="vader">
            </div>
            <div>
                <h4 >Q2: Are you angel or demon?</h4>
                a: Angel  <input type="radio" name="q2" value="angel"><br>
                b: Demon <input type="radio" name="q2" value="demon"><br>
                c: I'm a potato <input type="radio" name="q2" value="potato">
            </div>

            <!--send post request-->
            <div>
                <br><input style="margin-right:2em;" type=submit name="act2" value="My statistic"><input type=submit name="act2" value ="Submit">
            </div>

        </form>
    </body>
</html>
