package com.example.pc.dagger2withretrofitdemo;
import android.app.Application;
import com.example.pc.dagger2withretrofitdemo.dagger.ApiComponent;
import com.example.pc.dagger2withretrofitdemo.dagger.ApiModule;
import com.example.pc.dagger2withretrofitdemo.dagger.AppModule;
import com.example.pc.dagger2withretrofitdemo.dagger.DaggerApiComponent;

/**
 * Created by pc on 9/1/2018.
 */

public class MyApplication extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://simplifiedcoding.net/demos/"))
                .build();
    }

    public ApiComponent getNetComponent() {
        return mApiComponent;
    }
}
