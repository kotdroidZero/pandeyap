package com.example.pandyap.pandyap;

import io.reactivex.disposables.Disposable;

public class EmployeeInteractor extends BaseInteractor {
    public Disposable getAllList(NetworkRequestCallbacks networkRequestCallbacks) {
        return getDisposable(RestClient.get().getAllList(), networkRequestCallbacks);
    }
}
