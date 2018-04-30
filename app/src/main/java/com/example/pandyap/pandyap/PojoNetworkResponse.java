package com.example.pandyap.pandyap;

/**
 */

public class PojoNetworkResponse {

    private boolean isSuccess;
    private boolean isSessionExpired;

    public PojoNetworkResponse(boolean isSuccess, boolean isSessionExpired) {
        this.isSuccess = isSuccess;
        this.isSessionExpired = isSessionExpired;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public boolean isSessionExpired() {
        return isSessionExpired;
    }
}
