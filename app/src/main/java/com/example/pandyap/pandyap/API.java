package com.example.pandyap.pandyap;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/**
 */
public interface API {

    @FormUrlEncoded
    @POST("endpoint of your url")
    Observable<Response<List<PojoDataModel>>> getAllList(/**enter the required feild here*/);


}
