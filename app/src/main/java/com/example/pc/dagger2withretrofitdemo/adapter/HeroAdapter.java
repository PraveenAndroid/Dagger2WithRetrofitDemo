package com.example.pc.dagger2withretrofitdemo.adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.dagger2withretrofitdemo.R;
import com.example.pc.dagger2withretrofitdemo.model.Hero;
import com.example.pc.dagger2withretrofitdemo.view.MainActivityWithDagger;

import java.util.ArrayList;

/**
 * Created by pc on 9/1/2018.
 */

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.MyViewHolder> {

    public Context context;
    public ArrayList<Hero> list;

    public HeroAdapter(MainActivityWithDagger callback, ArrayList<Hero> body) {

        this.context=callback;
        this.list=body;
    }

    @NonNull
    @Override
    public HeroAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.adapter_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroAdapter.MyViewHolder holder, int position) {

        holder.textView.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text);
        }
    }
}
