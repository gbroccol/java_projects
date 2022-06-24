<%@ page import="edu.school21.cinema.models.User" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.school21.cinema.services.AvatarService" %>
<%@ page import="edu.school21.cinema.models.Avatar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    User user = (User) session.getAttribute("user");
    String avatarPath;

    if (user.getAvatar() == null) {
        avatarPath = "https://t3.ftcdn.net/jpg/03/46/83/96/360_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg";
    } else {
        avatarPath = request.getContextPath() + "/images/" + user.getAvatar().getFileName();
    }

%>

<div class="profile">

    <div class="sidebar">
        <div class="block">
            <h3> Photo </h3>
            <img class="circle" src="<%= avatarPath %>" alt="User avatar">
            <form method="post" action="<%= request.getContextPath() %>/images" enctype="multipart/form-data">
                Choose a file: <input type="file" name="multiPartServlet" required />
                <input type="submit" value="Upload" />
            </form>

        </div>
        <div class="block">
            <h3> Friends </h3>
            <hr>

        </div>
    </div>

    <div class="sections">
        <div class="block">

            <h3> Contact Information </h3>
            <hr>

            <p> Login: <%= user.getLogin() %>
            <p> First name: <%= user.getFirstName() %>
            <p> Last name: <%= user.getLastName() %>
            <p> E-mail: <%= user.getEmail() %>
            <p> Phone number: <%= user.getPhoneNumber() %>
        </div>
        <div class="block">
            <h3> Authentications list </h3>
            <hr>
            <table>
                <th>Date</th>
                <th>Time</th>
                <th>Ip</th>

                <c:forEach items = "${auth_list}" var="authentication">
                    <tr>
                        <td>
                            <c:out value = "${authentication.date}" />
                        </td>
                        <td>
                                ${authentication.time}
                        </td>
                        <td>
                                ${authentication.ip}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div class="block">
            <h3> Photos </h3>
            <hr>
            <div class="allPhotos">

                <%
                    AvatarService avatarService = (AvatarService) request.getSession().getAttribute("avatarService");
                    List <Avatar> avatarList = avatarService.findAllByUserId(user.getUserId());

                    if (avatarList != null) {
                        for (Avatar avatar : avatarList) {
                %>

                <div class="photoCard">
                    <div class="photoCardImg">
                        <a href="images/<%= avatar.getFileName() %>" target="_blank">
                            <img src="images/<%= avatar.getFileName() %>" class="center_img">
                        </a>
                    </div>
                    <div class="photoCardText">
                        <p> <b> File name: </b> <%= avatar.getFileOriginalName() %>
                        <p> <b> Size: </b> <%= avatar.getSize() %>
                        <p> <b> MIME: </b> <%= avatar.getMime() %>
                    </div>
                </div>

                <%
                        }
                    }
                %>
            </div>
        </div>
    </div>
</div>

<style>
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

    .allPhotos img {
        height: 100%;
        position: absolute;
    }

    .photoCardImg {
        position: relative;
        overflow: hidden;
        height: 200px;
    }

    .allPhotos {
        display: grid;
        gap: 14px;
        grid-template-columns: repeat(4, 1fr);
    }

</style>