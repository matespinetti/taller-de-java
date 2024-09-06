package com.example.practicafiltros;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

@WebFilter(
        filterName = "FilterStats",
        urlPatterns = {"/*"}
)
public class FilterStats implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       String ip = servletRequest.getRemoteAddr();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Date requestDate = new Date();
        String requestLine = "Request Line: " + request.getMethod() + " " + request.getRequestURI() + " " + request.getProtocol();
        String userAgent = request.getHeader("User-Agent");
        System.out.println("IP: " + ip + "Request Date: " + requestDate + " " + requestLine + " User-Agent: " + userAgent);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
