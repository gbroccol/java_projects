package edu.school21.cinema.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/profile")
public class ProfileFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (request.getSession(false) != null && request.getSession().getAttribute("user") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            request.getSession().setAttribute("error_code", "403");
            request.getSession().setAttribute("error_msg", "Forbidden. No access");
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendError(403);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
