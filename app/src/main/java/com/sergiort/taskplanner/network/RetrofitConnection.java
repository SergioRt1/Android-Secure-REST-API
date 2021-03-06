package com.sergiort.taskplanner.network;

import com.sergiort.taskplanner.network.service.AuthService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnection {

    private static AuthService authService = null;

    private static void createRetrofitConnection() {
        if(authService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api-task-planner.herokuapp.com") //localhost for emulator
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            authService = retrofit.create(AuthService.class);
        }
    }

    public static AuthService getAuthService() {
        if(authService == null){
            createRetrofitConnection();
        }
        return authService;
    }


}
