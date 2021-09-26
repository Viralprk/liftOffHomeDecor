package com.liftoffproject.premiumdecorsite.config;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();

        String redirectURL = request.getContextPath();

        if (userDetails.hasRole("NORMAL_USER")) {
            redirectURL = "nindex";
        }  else if (userDetails.hasRole("ADMIN")) {
            redirectURL = "aindex";
        }

        response.sendRedirect(redirectURL);

    }

}
