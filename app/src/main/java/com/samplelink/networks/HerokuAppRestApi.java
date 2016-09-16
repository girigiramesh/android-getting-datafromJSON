package com.samplelink.networks;

import com.samplelink.model.EmployeeDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ramesh on 9/15/16.
 */
public interface HerokuAppRestApi {
    @GET("/users.json")
    Call<List<EmployeeDetails>> readUser();
}
