package com.cybersoft.cozastoreJava21.Filter;


import com.cybersoft.cozastoreJava21.Utils.JwtHelper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

// tat ca request deu phai chay vao filter
@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtHelper jwtHelper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    try {
        String header=request.getHeader("Authorization");
        if(header.startsWith("Bearer ")){
            // cat bo chu bearer va lay ra token
            String token=header.substring(7);
            // giai ma token
            Claims claims= jwtHelper.decodeToken(token);
            if(claims!=null){
                // tao chung thuc cho Security
                SecurityContext context= SecurityContextHolder.getContext();
                UsernamePasswordAuthenticationToken user= new UsernamePasswordAuthenticationToken("","",new ArrayList<>());
                context.setAuthentication(user);
            }
        }
    } catch (Exception e) {

    }

    filterChain.doFilter(request,response);
    }
}
