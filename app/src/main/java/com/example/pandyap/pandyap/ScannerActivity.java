package com.example.pandyap.pandyap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerActivity extends AppCompatActivity {


    private static final int REQUEST_CAMERA = 1;

    private ZXingScannerView mScannerView;

    ZXingScannerView.ResultHandler resultHandler;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        resultHandler = new ZXingScannerView.ResultHandler() {
            @Override
            public void handleResult(Result result) {

            }
        };
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mScannerView.stopCamera();
    }


    @Override
    public void onResume() {
        super.onResume();

        if (mScannerView == null) {
            mScannerView = new ZXingScannerView(this);
            setContentView(mScannerView);
        }
        mScannerView.setResultHandler(resultHandler);
        mScannerView.startCamera();
    }

}
