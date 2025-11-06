package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebFilter(
        filterName = "auth-filter",
        urlPatterns = {"/dish", "/chefDetails"},
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD},
        initParams = @WebInitParam(name = "ignore-path", value = "/dish")
)
public class LoginFilter implements Filter {
    private String ignorePath;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        this.ignorePath = filterConfig.getInitParameter("ignore-path");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;


        String path = req.getServletPath();

        if ("/dish".equals(path)) {
            String chefId = req.getParameter("chefid");
            if (chefId == null || chefId.isEmpty()) {
                resp.sendRedirect("/listChefs");
                return;
            }
        } else if ("/chefDetails".equals(path)) {
            String chefId = req.getParameter("chefid");
            String dishId = req.getParameter("dishid");
            if (chefId == null || chefId.isEmpty() || dishId == null || dishId.isEmpty()) {
                resp.sendRedirect("/listChefs");
                return;
            }
        }

        filterChain.doFilter(req, resp);
    }
}


