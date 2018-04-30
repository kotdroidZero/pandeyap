package com.example.pandyap.pandyap;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    Button btnGetList, btnQr;

    RecyclerView recyclerView;

    TextView tvNodataText;

    ProgressBar progressBar;

    RecyclerAdapter adapter;

    EmployeePresenter employeePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetList = findViewById(R.id.btnGetList);
        btnQr = findViewById(R.id.btnFetchViaQr);
        recyclerView = findViewById(R.id.recyclerView);
        tvNodataText = findViewById(R.id.tvNoDataText);
        progressBar = findViewById(R.id.progressBar);

        //onclick
        btnQr.setOnClickListener(this);
        btnGetList.setOnClickListener(this);

        //setting adapter
        adapter = new RecyclerAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false));
        recyclerView.setAdapter(adapter);


        employeePresenter = new EmployeePresenter();
        employeePresenter.attachView(this);


    }

    @Override
    public void updateListData(List<PojoDataModel> pojoDataModels) {
        adapter.updateProduct(pojoDataModels);
    }

    @Override
    public void setNoDataText() {
        tvNodataText.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNoDataText() {
        tvNodataText.setVisibility(View.GONE);
    }

    @Override
    public void showProgressLoader() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressLoader() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFetchViaQr:
                employeePresenter.getEmployeeList();
                break;
            case R.id.btnGetList:

                break;
        }
    }
}
