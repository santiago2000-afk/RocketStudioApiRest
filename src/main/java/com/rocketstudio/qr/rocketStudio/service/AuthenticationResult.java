package com.rocketstudio.qr.rocketStudio.service;

public class AuthenticationResult {
    private boolean authenticated;

    AuthenticationResult(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public static AuthenticationResult successful() {
        return new AuthenticationResult(true);
    }

    public static AuthenticationResult failed() {
        return new AuthenticationResult(false);
    }

    public boolean isAuthenticated() {
        return authenticated;
    }
}