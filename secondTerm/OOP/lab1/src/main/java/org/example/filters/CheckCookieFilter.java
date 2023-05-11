package org.example.filters;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.controllers.LoginServlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Logger;

public class CheckCookieFilter implements HttpFilter {
    private static final Logger log = Logger.getLogger(String.valueOf(LoginServlet.class));
    @Override
    public void doHttpFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        Cookie[] cookies = request.getCookies();
        Optional<Cookie> cookieId = Optional.ofNullable(cookies)
                .flatMap(cookies1 ->
                        Arrays.stream(cookies1).filter(cookie ->
                                cookie.getName().equals("id")).findFirst());
        if (cookieId.isPresent())
            filterChain.doFilter(request, response);
        else
            log.info("Coockie is empty");
            response.sendRedirect("/login");
    }
}