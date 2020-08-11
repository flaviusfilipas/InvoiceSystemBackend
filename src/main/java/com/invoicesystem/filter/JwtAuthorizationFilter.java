package com.invoicesystem.filter;

import com.invoicesystem.jwt.JwtService;
import com.invoicesystem.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserService userService;

    public JwtAuthorizationFilter(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        String token = null;

        if (authorizationHeader != null && !authorizationHeader.isEmpty()){
            //split the authorizationHeader header in order to get the jwt token
            String[] splitString = authorizationHeader.split(" ");
            token = splitString[1];
        }

        Authentication userAuthentication = getUserAuthentication(token);
        //TODO check if jwt is expired
        if(userAuthentication != null){
            SecurityContextHolder.getContext().setAuthentication(userAuthentication);
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }


    private Authentication getUserAuthentication(String token){
        Claims claims = jwtService.getClaims(token);

        String subject = claims.getSubject();

        UserDetails userDetails = userService.loadUserByUsername(subject);

        if(userDetails != null){
            return new UsernamePasswordAuthenticationToken(userDetails.getUsername(),null,
                    userDetails.getAuthorities());
        }

        return null;
    }
}
