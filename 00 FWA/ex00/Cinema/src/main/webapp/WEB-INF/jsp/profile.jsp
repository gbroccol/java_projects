<%@ page import="edu.school21.cinema.models.User" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.school21.cinema.models.UserAuthentication" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    User user = (User) session.getAttribute("user");
    String avatarPath;
    if (user.getAvatar() == null) {
        avatarPath = "https://t3.ftcdn.net/jpg/03/46/83/96/360_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg";
    } else {
        avatarPath = "images/users/" + user.getLogin() + "/" + user.getAvatar().getFileName();
    }
%>

<div class="profile">

    <div class="sidebar">
        <div class="block">
            <h3> Photo </h3>

            <img class="circle" src="<%= avatarPath %>">

<%--            <img class="circle" src="/home/anastasiya/Desktop/img_test_folder/06.jpg">--%>


            <form method="post" action="<%= request.getContextPath() %>/images" enctype="multipart/form-data">
                Choose a file: <input type="file" name="multiPartServlet" />
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

<%--            <table>--%>
<%--                <tr>--%>
<%--                    <th>Date</th>--%>
<%--                    <th>Time</th>--%>
<%--                    <th>IP</th>--%>
<%--                </tr>--%>

<%--                <%--%>
<%--                    List<UserAuthentication> authList = (List<UserAuthentication>) request.getAttribute("auth_list");--%>
<%--                    if (authList != null) {--%>
<%--                        for (UserAuthentication auth : authList) {--%>
<%--                %>--%>

<%--                <tr>--%>
<%--                    <td> <%= auth.getDate() == null ? "Date is null :(" : auth.getDate() %> </td>--%>
<%--                    <td> <%= auth.getTime() == null ? "Time is null :(" : auth.getTime() %> </td>--%>
<%--                    <td> <%= auth.getIp() == null ? "IP is null :(" : auth.getIp() %> </td>--%>
<%--                </tr>--%>

<%--                <%--%>
<%--                        }--%>
<%--                    }--%>
<%--                %>--%>

<%--            </table>--%>


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
                    List<String> photoList = new ArrayList<>();

                    File folder = new File(request.getServletContext().getRealPath("") + "images/users/" + user.getLogin());
                    File[] listOfFiles = folder.listFiles();

                    if (folder.exists()) {
                        for (int i = 0; i < listOfFiles.length; i++) {
                            if (listOfFiles[i].isFile()) {
                                photoList.add(listOfFiles[i].getName());
                            }
                        }

                        if (photoList != null) {
                            for (String fileName : photoList) {
                %>


                <div class="photoCard">
                    <img src="images/users/<%= user.getLogin() %>/<%= fileName %>">
                    <p> <b> File name: </b> 00.jpg
                    <p> <b> Size: </b> 1MB
                    <p> <b> MIME: </b> image/jpg
                </div>

                <%
                            }
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
        width: 100%;
    }

    .allPhotos {
        display: grid;
        gap: 14px;
        grid-template-columns: repeat(4, 1fr);
    }

</style>