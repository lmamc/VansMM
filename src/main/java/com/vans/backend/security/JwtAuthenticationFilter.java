package com.vans.backend.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtFilter jwtFilter;

    private static final List<String> EXCLUDED_URLS = Arrays.asList(
        "/auth/login",
        "/auth/register",
        "/conciertos"
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String path = request.getRequestURI();

        boolean isExcluded = EXCLUDED_URLS.stream().anyMatch(path::startsWith);

        if (isExcluded || request.getMethod().equalsIgnoreCase("OPTIONS")) {
            filterChain.doFilter(request, response);
        } else {
            jwtFilter.doFilter(request, response, filterChain);
        }
    }
}
