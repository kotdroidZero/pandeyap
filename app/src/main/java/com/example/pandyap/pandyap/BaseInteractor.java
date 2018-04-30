package com.example.pandyap.pandyap;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 */

public class BaseInteractor<T> {

    public Disposable getDisposable(Observable<Response<T>> observable,
                                    final NetworkRequestCallbacks networkRequestCallbacks) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Response<?>>() {
                    @Override
                    public void onNext(Response<?> response) {
                        networkRequestCallbacks.onSuccess(response);
                    }

                    @Override
                    public void onError(Throwable t) {
                        networkRequestCallbacks.onError(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
