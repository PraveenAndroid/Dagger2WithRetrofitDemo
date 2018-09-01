package com.example.pc.dagger2withretrofitdemo.dagger;
import com.example.pc.dagger2withretrofitdemo.view.MainActivityWithDagger;
import javax.inject.Singleton;
import dagger.Component;
/**
 * Created by pc on 9/1/2018.
 */

@Component(modules = {ApiModule.class,AppModule.class})
@Singleton
public interface ApiComponent {

    void inject(MainActivityWithDagger activity);
}
