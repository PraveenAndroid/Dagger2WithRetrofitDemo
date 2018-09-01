package com.example.pc.dagger2withretrofitdemo.network;
import com.example.pc.dagger2withretrofitdemo.model.Hero;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {

    @GET("marvel/")
    Call<ArrayList<Hero>> getHeroes();
}
