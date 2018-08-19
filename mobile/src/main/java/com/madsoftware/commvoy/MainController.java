package com.madsoftware.commvoy;

import com.madsoftware.commvoy.authentication.LoginService;

public class MainController {

    private LoginService lService = new LoginService();

    /**
     * Constructor
     */
    public MainController() {

    }

    public boolean isUserLoggedIn() {
        return lService.isUserAuthenticated();
    }
}
