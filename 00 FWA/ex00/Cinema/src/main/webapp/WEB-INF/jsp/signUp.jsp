<div class="login">

    <h2 class="login-header"> Sign Up </h2>

    <form class="login-container" action="<%= request.getContextPath() %>/signUp" method="post">

        <p><input type="text" placeholder="Login" name="login" required></p>
        <p><input type="text" placeholder="First name" name="first_name" ></p>
        <p><input type="text" placeholder="Last name" name="last_name" ></p>
        <p><input type="text" placeholder="Phone number" name="phone_number" ></p>
        <p><input type="email" placeholder="Email" name="email" ></p>
        <p><input type="password" placeholder="Password" name="password" required></p>
        <p><input type="submit" value="Sign up"></p>
    </form>
</div>
