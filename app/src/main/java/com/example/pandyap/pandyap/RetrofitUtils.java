package com.example.pandyap.pandyap;

import android.support.annotation.NonNull;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 */
public class RetrofitUtils {

    private static final String MULTIPART_FORM_DATA = "multipart/form-data";

    @NonNull
    public static RequestBody stringToRequestBody(String string) {
        return RequestBody.create(MediaType.parse(MULTIPART_FORM_DATA), string);
    }

    @NonNull
    public static RequestBody imageToRequestBody(File file) {
        return RequestBody.create(MediaType.parse(MULTIPART_FORM_DATA), file);
    }

    @NonNull
    public static MultipartBody.Part createPartFromFile(String partName, File file) {
        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(MediaType.parse(MULTIPART_FORM_DATA), file);

        // MultipartBody.Part is used to send also the actual file name
        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
    }

}
