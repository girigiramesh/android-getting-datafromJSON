package com.samplelink.networks;

import com.samplelink.util.StringConverterFactory;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ramesh on 9/15/16.
 */
public class RetrofitHandler {
    private static RetrofitHandler OurInstance = new RetrofitHandler();
    public static RetrofitHandler getInstance() {
        return OurInstance;
    }

//    public Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("https://new-linky.herokuapp.com")
//            .addConverterFactory(StringConverterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
//    public HerokuAppRestApi service = retrofit.create(HerokuAppRestApi.class);
//
//    private RetrofitHandler() {
//    }
//
//    public Call<String> readUser(int id,String first_name,String last_name,String email,String mobile,String password,String created_at,String updated_at,String url) {
//        return service.readUser(id,first_name,last_name,email,mobile,password,created_at,updated_at,url);
//    }

}
