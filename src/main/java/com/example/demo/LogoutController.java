package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Needed to perform proper logout with Auth0
 */
@Controller
public class LogoutController extends SecurityContextLogoutHandler {

    private final ClientRegistrationRepository clientRegistrationRepository;

    private Logger logger = LoggerFactory.getLogger(LogoutController.class);

    @Value("${spring.security.oauth2.client.registration.auth0.logout-uri}")
    private String logoutUrl;

    public LogoutController(ClientRegistrationRepository clientRegistrationRepository) {
        this.clientRegistrationRepository = clientRegistrationRepository;
    }

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                       Authentication authentication) {

        super.logout(httpServletRequest, httpServletResponse, authentication);

        try {
            httpServletResponse.sendRedirect(logoutUrl);
        } catch (IOException ioe) {
            logger.error("Error logging out.", ioe);
        }

    }

}
