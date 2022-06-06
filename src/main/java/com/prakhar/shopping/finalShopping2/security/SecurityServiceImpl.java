package com.prakhar.shopping.finalShopping2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService{
    @Autowired
    UserDetailsSecurityimpl userDetailsSecurityimpl;
    @Autowired
    AuthenticationManager authenticationManager;


    @Override
    public boolean login(String userName, String password) {
        UserDetails userDetails = userDetailsSecurityimpl.loadUserByUsername(userName);
        UsernamePasswordAuthenticationToken token =  new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
        authenticationManager.authenticate(token);
        boolean result = token.isAuthenticated();

        if(result){
            SecurityContextHolder.getContext().setAuthentication(token);
        }

        return result;
    }
}
