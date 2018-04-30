package com.example.pandyap.pandyap;

import android.content.Context;

import java.util.List;

interface MainView {
    void updateListData(List<PojoDataModel> pojoDataModels);

    void setNoDataText();

    void hideNoDataText();

    void showProgressLoader();

    void hideProgressLoader();

    Context getActivityContext();
}
