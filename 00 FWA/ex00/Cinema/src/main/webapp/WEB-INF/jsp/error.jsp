<%
    String errorMsg = (String) session.getAttribute("error_msg");
    if (errorMsg == null) {
        errorMsg = "";
    }
    session.removeAttribute("error_msg");

    String errorCode = (String) session.getAttribute("error_code");
    if (errorCode == null) {
        errorCode = "";
    }
    session.removeAttribute("error_code");
%>

<div class="errorPage">
    <div class="errorMsg">
        <p> Oops!
        <p> <%= errorCode %>
        <p> <%= errorMsg %>
    </div>
    <div class="errorPhoto">
        <img src="https://pngimg.com/uploads/robot/robot_PNG8.png">
    </div>
</div>

