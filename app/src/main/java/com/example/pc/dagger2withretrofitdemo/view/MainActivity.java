package com.example.pc.dagger2withretrofitdemo.view;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.example.pc.dagger2withretrofitdemo.R;
import com.example.pc.dagger2withretrofitdemo.adapter.HeroAdapter;
import com.example.pc.dagger2withretrofitdemo.model.Hero;
import com.example.pc.dagger2withretrofitdemo.network.ApiCall;
import com.example.pc.dagger2withretrofitdemo.network.NetworkClient;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private NetworkClient networkClient;
    private ApiCall apiCall;
    private HeroAdapter heroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        apiCall= NetworkClient.getRetrofit().create(ApiCall.class);

        getHeros();
    }

    private void getHeros() {

       final Call<ArrayList<Hero>> heroCall=apiCall.getHeroes();

        Log.d("url",heroCall.request().url()+"");

       heroCall.enqueue(new Callback<ArrayList<Hero>>() {
           @Override
           public void onResponse(Call<ArrayList<Hero>> call, Response<ArrayList<Hero>> response) {

              // heroAdapter=new HeroAdapter(MainActivity.this,response.body());
              // recyclerView.setAdapter(heroAdapter);
           }

           @Override
           public void onFailure(Call<ArrayList<Hero>> call, Throwable t) {

           }
       });
    }

    @Override
    protected void onResume() {
        super.onResume();
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
