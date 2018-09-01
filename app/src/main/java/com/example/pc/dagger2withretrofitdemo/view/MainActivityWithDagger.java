package com.example.pc.dagger2withretrofitdemo.view;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.pc.dagger2withretrofitdemo.MyApplication;
import com.example.pc.dagger2withretrofitdemo.R;
import com.example.pc.dagger2withretrofitdemo.adapter.HeroAdapter;
import com.example.pc.dagger2withretrofitdemo.model.Hero;
import com.example.pc.dagger2withretrofitdemo.network.ApiCall;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by pc on 9/1/2018.
 */

public class MainActivityWithDagger extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private HeroAdapter heroAdapter;

    //injecting retrofit
    @Inject
    Retrofit retrofit;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        ((MyApplication) getApplication()).getNetComponent().inject(this);

        getHeroes();
    }


    private void getHeroes() {


        ApiCall api = retrofit.create(ApiCall.class);
        Call<ArrayList<Hero>> call = api.getHeroes();

        call.enqueue(new Callback<ArrayList<Hero>>() {
            @Override
            public void onResponse(Call<ArrayList<Hero>> call, Response<ArrayList<Hero>> response) {

                heroAdapter=new HeroAdapter(MainActivityWithDagger.this,response.body());
                recyclerView.setAdapter(heroAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Hero>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
