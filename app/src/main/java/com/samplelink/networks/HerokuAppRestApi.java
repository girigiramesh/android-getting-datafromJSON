package com.samplelink.networks;

import com.samplelink.model.EmployeeDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ramesh on 9/15/16.
 */
public interface HerokuAppRestApi {
    @GET("/users.json")
    Call<List<EmployeeDetails>> readUser();
//    Call<String> readUser(@Query("id")  int id,
//                          @Query("first_name") String first_name,
//                          @Query("last_name") String last_name,
//                          @Query("email") String email,
//                          @Query("mobile") String mobile,
//                          @Query("password") String password,
//                          @Query("created_at") String created_at,
//                          @Query("updated_at") String updated_at,
//                          @Query("url") String url);

}
