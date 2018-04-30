package com.example.pandyap.pandyap;

import retrofit2.Response;

/**
 */

public interface NetworkRequestCallbacks {

    void onSuccess(Response<?> response);

    void onError(Throwable t);
}
