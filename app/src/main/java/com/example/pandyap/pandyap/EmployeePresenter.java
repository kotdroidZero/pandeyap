package com.example.pandyap.pandyap;

import android.widget.Toast;

import java.util.List;

import retrofit2.Response;

public class EmployeePresenter extends BasePresenter<MainView> {
    EmployeeInteractor employeeInteractor;

    @Override
    public void attachView(MainView view) {
        super.attachView(view);
        employeeInteractor = new EmployeeInteractor();
    }

    public void getEmployeeList() {
        getView().showProgressLoader();
        mCompositeDisposable.add(employeeInteractor.getAllList(new NetworkRequestCallbacks() {
            @Override
            public void onSuccess(Response<?> response) {
                if (null != getView()) {
                    getView().hideProgressLoader();
                    List<PojoDataModel> pojoDataModels = (List<PojoDataModel>) response.body();
                    if (pojoDataModels.size() > 0) {
                        getView().updateListData(pojoDataModels);
                        getView().hideNoDataText();
                    } else {
                        getView().setNoDataText();
                    }
                }
            }

            @Override
            public void onError(Throwable t) {
                getView().hideProgressLoader();
                Toast.makeText(getView().getActivityContext(), "Error in fetching data", Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public void detachView() {
        super.detachView();
        employeeInteractor = null;
    }
}

