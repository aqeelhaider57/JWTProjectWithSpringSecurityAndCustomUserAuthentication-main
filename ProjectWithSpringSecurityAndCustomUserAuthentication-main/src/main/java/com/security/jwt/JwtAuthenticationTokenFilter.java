package com.security.jwt;

import com.config.UserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

            final String tokenHeader = request.getHeader("authorization");

            String userName = null;
            String jwtToken = null;

            if(tokenHeader != null){
                jwtToken = tokenHeader.substring(7);
                try{
                        userName = this.jwtUtils.extractUsername(jwtToken);
                }
                catch(ExpiredJwtException e){
                    e.printStackTrace();
                    System.out.println("JWT Token is expired.");
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Error");
                }
            }else {
                System.out.println("Invalid token, not start with.....");
            }

            if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
                final UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

                if(this.jwtUtils.validateToken(jwtToken, userDetails)){
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
                else {
                    System.out.println("Toke is not valid");
                }
            }

        filterChain.doFilter(request, response);
    }

}
