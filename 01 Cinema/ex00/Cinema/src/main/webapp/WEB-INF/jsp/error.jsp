<%
    String errorMsg = (String) session.getAttribute("error_msg");
    if (errorMsg == null) {
        errorMsg = "";
    }
    session.removeAttribute("error_msg");
%>

<div class="errorPage">
    <div class="errorMsg">
        <p> Oops!
        <p> <%= response.getStatus() %>
        <p> <%=  errorMsg %>
    </div>
    <div class="errorPhoto">
        <img src="https://pngimg.com/uploads/robot/robot_PNG8.png">
    </div>
</div>

