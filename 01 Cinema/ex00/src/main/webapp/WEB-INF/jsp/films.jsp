<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>

<header>
    <nav>
        <li> <a href="http://localhost:8080/Cinema/signIn">Вход</a> </li>
        <li> <a href="http://localhost:8080/Cinema/signUp">Регистрация</a> </li>
        <li> <a href="http://localhost:8080/Cinema/logout">Выход</a> </li>
        <li> <a href="http://localhost:8080/Cinema/profile">Профиль</a> </li>
        <li> <a href="http://localhost:8080/Cinema/films">Фильмы</a> </li>
        <li> <a href="http://localhost:8080/Cinema/halls">Залы</a> </li>
        <li> <a href="http://localhost:8080/Cinema/sessions">Сессии</a> </li>
    </nav>
</header>

<body>
<div class="container">



<div class="title">
    <h1>All Films</h1>
</div>

<div class="section">

    <div class="preview">
        <div class="preview_img">
            <img src="https://www.alexcouncil.com/wp-content/uploads/2016/10/film-1155439_960_720.jpg" class="center_img">
        </div>
        <div class="photoCardText">
            <p> <b> Film title: </b> text
            <p> <b> Year of release: </b> text
            <p> <b> Age restrictions: </b> text
            <p> <b> Description: </b> text
        </div>
    </div>

    <div class="preview">
        <div class="preview_img">
            <img src="https://www.alexcouncil.com/wp-content/uploads/2016/10/film-1155439_960_720.jpg" class="center_img">
        </div>
        <div class="photoCardText">
            <p> <b> Film title: </b> text
            <p> <b> Year of release: </b> text
            <p> <b> Age restrictions: </b> text
            <p> <b> Description: </b> text
        </div>
    </div>

    <div class="preview">
        <div class="preview_img">
            <img src="https://www.alexcouncil.com/wp-content/uploads/2016/10/film-1155439_960_720.jpg" class="center_img">
        </div>
        <div class="photoCardText">
            <p> <b> Film title: </b> text
            <p> <b> Year of release: </b> text
            <p> <b> Age restrictions: </b> text
            <p> <b> Description: </b> text
        </div>
    </div>

    <div class="preview">
        <div class="preview_img">
            <img src="https://www.alexcouncil.com/wp-content/uploads/2016/10/film-1155439_960_720.jpg" class="center_img">
        </div>
        <div class="photoCardText">
            <p> <b> Film title: </b> text
            <p> <b> Year of release: </b> text
            <p> <b> Age restrictions: </b> text
            <p> <b> Description: </b> text
        </div>
    </div>


    <div class="preview">
        <div class="preview_img">
            <img src="https://www.alexcouncil.com/wp-content/uploads/2016/10/film-1155439_960_720.jpg" class="center_img">
        </div>
        <div class="photoCardText">
            <p> <b> Film title: </b> text
            <p> <b> Year of release: </b> text
            <p> <b> Age restrictions: </b> text
            <p> <b> Description: </b> text
        </div>
    </div>


    <div class="preview">
        <div class="preview_img">
            <img src="https://www.alexcouncil.com/wp-content/uploads/2016/10/film-1155439_960_720.jpg" class="center_img">
        </div>
        <div class="photoCardText">
            <p> <b> Film title: </b> text
            <p> <b> Year of release: </b> text
            <p> <b> Age restrictions: </b> text
            <p> <b> Description: </b> text
        </div>
    </div>


    <div class="preview">
        <div class="preview_img">
            <img src="https://www.alexcouncil.com/wp-content/uploads/2016/10/film-1155439_960_720.jpg" class="center_img">
        </div>
        <div class="photoCardText">
            <p> <b> Film title: </b> text
            <p> <b> Year of release: </b> text
            <p> <b> Age restrictions: </b> text
            <p> <b> Description: </b> text
        </div>
    </div>

</div>







<div class="title">
    <h1> Add New Film </h1>
</div>

<div class="section_application">

<%--    <form action="<%= request.getContextPath() %>/films" method="post">--%>
<%--        <p><input type="text" placeholder="Film title" name="film title" required></p>--%>
<%--        <p><input type="text" placeholder="Year of release" name="year of release" required></p>--%>
<%--        <p><input type="text" placeholder="Age restrictions" name="age restrictions" required></p>--%>
<%--        <p><input type="text" placeholder="Description" name="description" required></p>--%>

<%--        <p><input type="submit" value="Add new film"></p>--%>
<%--    </form>--%>

</div>


</div>
</body>
</html>


<style>

    /*@import url(https://fonts.googleapis.com/css?family=Open+Sans:400,700);*/

    * {
        margin: 0px;
        color: black;
        font-family: 'Roboto', sans-serif;
    }

    body {
        background: #bdbdbd70;
        font-family: 'Open Sans', sans-serif;
        margin: 0px;
        margin-top: 130px;
    }

    .container {
        max-width: 1200px;
        height: 100%;
        margin: auto;
    }

    .login {
        width: 400px;
        margin: 16px auto;
        font-size: 16px;
    }

    /* Reset top and bottom margins from certain elements */
    .login-header,
    .login p {
        margin-top: 0;
        margin-bottom: 0;
    }

    /* The triangle form is achieved by a CSS hack */
    .login-triangle {
        width: 0;
        margin-right: auto;
        margin-left: auto;
        border: 12px solid transparent;
        border-bottom-color: #28d;
    }

    .login-header {
        background: #28d;
        padding: 20px;
        font-size: 1.4em;
        font-weight: normal;
        text-align: center;
        text-transform: uppercase;
        color: #fff;
    }

    .login-container {
        background: #ebebeb;
        padding: 12px;
    }

    /* Every row inside .login-container is defined with p tags */
    .login p {
        padding: 12px;
    }

    .login input {
        box-sizing: border-box;
        display: block;
        width: 100%;
        border-width: 1px;
        border-style: solid;
        padding: 16px;
        outline: 0;
        font-family: inherit;
        font-size: 0.95em;
    }

    .login input[type="email"],
    .login input[type="password"] {
        background: #fff;
        border-color: #bbb;
        color: #555;
    }

    /* Text fields' focus effect */
    .login input[type="email"]:focus,
    .login input[type="password"]:focus {
        border-color: #888;
    }

    .login input[type="submit"] {
        background: #28d;
        border-color: transparent;
        color: #fff;
        cursor: pointer;
    }

    .login input[type="submit"]:hover {
        background: #17c;
    }

    /* Buttons' focus effect */
    .login input[type="submit"]:focus {
        border-color: #05a;
    }

    header {
        width: 100%;
        height: 90px;
        background-color: #020b44e8;
        /*rgb(0, 0, 0, 0.6);*/
        /*color: rgb(255, 255, 255);*/
        display: inline-flex;
        flex-direction: row;
        justify-content: end;
        align-items: center;
        position: fixed;
        z-index: 100;
        left: 0;
        top: 0;
    }

    header nav {
        display: flex;
        justify-content: space-between;
        font-size: 18px;
        list-style-type: none;
        margin-right: 30px;
    }

    header nav li {
        padding-left: 30px;
    }

    li {
        display: list-item;
        text-align: -webkit-match-parent;
    }

    a:link {
        color: rgb(255, 255, 255);
        /* background-color: transparent; */
        text-decoration: none;
    }

    .errorPage {
        display: flex;
        justify-content: center;
    }

    .errorMsg {
        width: 40%;
        padding-top: 200px;
    }

    .errorPhoto img {
        height: 700px;
    }


    .profile {
        display: flex;
    }

    .sidebar {
        width: 30%;
        /*background-color: #d1fdff;*/
    }

    .sections {
        width: 70%;
        /*background-color: #d1fdff;*/
    }

    .block {
        background-color: white;
        margin: 14px 7px 14px 7px;
        /*min-height: 250px;*/
        padding: 14px;
        border-radius: 7px;
    }

    .block hr {
        width: 100%;
        margin: 5px 0 15px 0;
        border: none;
        border-top: 1px solid #7e7e7e42;
    }

    .circle {
        border-radius: 50%;
        width: 50%;
    }

    a:link {
        color: #ebebeb;
    }
    a:visited {
        color: #ebebeb;
    }

    a:hover {
        color: #ebebeb;
    }

    a:active {
        color: #ebebeb;
    }





    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        text-align: left;
        padding: 8px;
    }

    tr:nth-child(even){background-color: #f2f2f2}

    th {
        background-color: #28d;
        color: white;
    }





    .allPhotos {
        display: grid;
        gap: 14px;
        grid-template-columns: repeat(4, 1fr);
    }

    .allPhotos img {
        height: 100%;
        position: absolute;
    }

    .photoCardImg {
        position: relative;
        overflow: hidden;
        height: 200px;
    }






    .title {
        padding: 50px 0px 30px 0px;
    }

    .title h1 {
        text-align: center
    }







    .section {
        display: grid;
        gap: 14px;
        grid-template-columns: repeat(5, 1fr);
    }

    .preview_img {
        position: relative;
        overflow: hidden;
        height: 130px;
    }

    .preview_img img {
        width: 100%;
        position: absolute;
    }


</style>