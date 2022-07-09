<%--<%@ page import="edu.school21.cinema.models.User" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="edu.school21.cinema.services.AvatarService" %>--%>
<%--<%@ page import="edu.school21.cinema.models.Avatar" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>


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

    <form action="<%= request.getContextPath() %>/films" method="post">
        <p><input type="text" placeholder="Film title" name="film title" required></p>
        <p><input type="text" placeholder="Year of release" name="year of release" required></p>
        <p><input type="text" placeholder="Age restrictions" name="age restrictions" required></p>
        <p><input type="text" placeholder="Description" name="description" required></p>

        <p><input type="submit" value="Add new film"></p>
    </form>

</div>