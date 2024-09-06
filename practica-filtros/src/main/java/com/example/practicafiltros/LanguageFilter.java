package com.example.practicafiltros;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebFilter(
        filterName = "LanguageFilter",
        urlPatterns = {"/*"}
)
public class LanguageFilter implements Filter {
    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String language = request.getHeader("Accept-Language");
        System.out.println("Language: " + language);

        Locale locale = language != null && language.startsWith("es") ? Locale.of("es") : Locale.of("en");

        ResourceBundle texts = ResourceBundle.getBundle("textos", locale);
        request.setAttribute("textos", texts);
        filterChain.doFilter(request, servletResponse);

    }
}
