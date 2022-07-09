<%
    String errorMsg = (String) session.getAttribute("error_msg");
    if (errorMsg == null) {
        errorMsg = "";
    } else {
        errorMsg = "Opps! " + errorMsg;
    }
    session.removeAttribute("error_msg");
%>

<p>
    <%= errorMsg %>
</p>


<div class="login">
    <h2 class="login-header"> Sign In </h2>

    <form class="login-container" action="<%= request.getContextPath() %>/signIn" method="post">
        <p><input type="text" placeholder="Login" name="login" required></p>
        <p><input type="password" placeholder="Password" name="password" required></p>
        <p><input type="submit" value="Sign in"></p>
    </form>
</div>
