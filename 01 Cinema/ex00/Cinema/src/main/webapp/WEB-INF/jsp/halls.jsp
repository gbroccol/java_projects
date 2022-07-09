<%--<%@ page import="edu.school21.cinema.models.User" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="edu.school21.cinema.services.AvatarService" %>--%>
<%--<%@ page import="edu.school21.cinema.models.Avatar" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>


<div class="title">
    <h1>All Halls</h1>
</div>

<div class="section">

    <div class="preview">
        <div class="preview_img">
            <img src="https://p.turbosquid.com/ts-thumb/9m/KhMVkp/3x/cinemahall08a/jpg/1625753266/600x600/fit_q87/1f74cc6de679212b6d3f0bd2b9d644976155b60b/cinemahall08a.jpg" class="center_img">
        </div>
        <div class="photoCardText">
            <p> <b> Serial number: </b> text
            <p> <b> Hall title: </b> text
            <p> <b> Number of seats: </b> text
        </div>
    </div>

    <div class="preview">
        <div class="preview_img">
            <img src="https://p.turbosquid.com/ts-thumb/9m/KhMVkp/3x/cinemahall08a/jpg/1625753266/600x600/fit_q87/1f74cc6de679212b6d3f0bd2b9d644976155b60b/cinemahall08a.jpg" class="center_img">
        </div>
        <div class="photoCardText">
            <p> <b> Serial number: </b> text
            <p> <b> Hall title: </b> text
            <p> <b> Number of seats: </b> text
        </div>
    </div>

    <div class="preview">
        <div class="preview_img">
            <img src="https://p.turbosquid.com/ts-thumb/9m/KhMVkp/3x/cinemahall08a/jpg/1625753266/600x600/fit_q87/1f74cc6de679212b6d3f0bd2b9d644976155b60b/cinemahall08a.jpg" class="center_img">
        </div>
        <div class="photoCardText">
            <p> <b> Serial number: </b> text
            <p> <b> Hall title: </b> text
            <p> <b> Number of seats: </b> text
        </div>
    </div>

    <div class="preview">
        <div class="preview_img">
            <img src="https://p.turbosquid.com/ts-thumb/9m/KhMVkp/3x/cinemahall08a/jpg/1625753266/600x600/fit_q87/1f74cc6de679212b6d3f0bd2b9d644976155b60b/cinemahall08a.jpg" class="center_img">
        </div>
        <div class="photoCardText">
            <p> <b> Serial number: </b> text
            <p> <b> Hall title: </b> text
            <p> <b> Number of seats: </b> text
        </div>
    </div>

    <div class="preview">
        <div class="preview_img">
            <img src="https://p.turbosquid.com/ts-thumb/9m/KhMVkp/3x/cinemahall08a/jpg/1625753266/600x600/fit_q87/1f74cc6de679212b6d3f0bd2b9d644976155b60b/cinemahall08a.jpg" class="center_img">
        </div>
        <div class="photoCardText">
            <p> <b> Serial number: </b> text
            <p> <b> Hall title: </b> text
            <p> <b> Number of seats: </b> text
        </div>
    </div>

    <div class="preview">
        <div class="preview_img">
            <img src="https://p.turbosquid.com/ts-thumb/9m/KhMVkp/3x/cinemahall08a/jpg/1625753266/600x600/fit_q87/1f74cc6de679212b6d3f0bd2b9d644976155b60b/cinemahall08a.jpg" class="center_img">
        </div>
        <div class="photoCardText">
            <p> <b> Serial number: </b> text
            <p> <b> Hall title: </b> text
            <p> <b> Number of seats: </b> text
        </div>
    </div>

    <div class="preview">
        <div class="preview_img">
            <img src="https://p.turbosquid.com/ts-thumb/9m/KhMVkp/3x/cinemahall08a/jpg/1625753266/600x600/fit_q87/1f74cc6de679212b6d3f0bd2b9d644976155b60b/cinemahall08a.jpg" class="center_img">
        </div>
        <div class="photoCardText">
            <p> <b> Serial number: </b> text
            <p> <b> Hall title: </b> text
            <p> <b> Number of seats: </b> text
        </div>
    </div>

    <div class="preview">
        <div class="preview_img">
            <img src="https://p.turbosquid.com/ts-thumb/9m/KhMVkp/3x/cinemahall08a/jpg/1625753266/600x600/fit_q87/1f74cc6de679212b6d3f0bd2b9d644976155b60b/cinemahall08a.jpg" class="center_img">
        </div>
        <div class="photoCardText">
            <p> <b> Serial number: </b> text
            <p> <b> Hall title: </b> text
            <p> <b> Number of seats: </b> text
        </div>
    </div>


</div>


<div class="title">
    <h1> Add New Hall </h1>
</div>

<div class="section_application">

    <form action="<%= request.getContextPath() %>/halls" method="post">
        <p><input type="text" placeholder="Hall title" name="hall title" required></p>
        <p><input type="text" placeholder="Number of seats" name="number of seats" required></p>
        <p><input type="submit" value="Add new hall"></p>
    </form>

</div>