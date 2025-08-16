package com.vedalvi.jwt_auth.filter;

import com.vedalvi.jwt_auth.entity.UserPrincipal;
import com.vedalvi.jwt_auth.service.JWTService;
import com.vedalvi.jwt_auth.service.StudentUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;

    @Autowired
    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String userName = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")){
            token = authHeader.substring(7);
            System.out.println(getClass().getName()+" Token Details : "+token);
            userName = jwtService.extractUserName(token);
            System.out.println(getClass().getName()+" User Name : "+userName);
        }


        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = context.getBean(StudentUserDetailsService.class).loadUserByUsername(userName);
            if (jwtService.validateToken(token,userDetails)){
                UsernamePasswordAuthenticationToken token1 =
                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

                token1.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(token1);
            }
        }
        filterChain.doFilter(request,response);
    }
}
