package com.bten1.trucks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder>{
    Context context1;
    ArrayList<Model> list1;
    public MainAdapter(Context context1, ArrayList<Model> list1) {

            this.context1 = context1;
            this.list1 = list1;
        }




    @NonNull
    @Override
    public MainAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context1).inflate(R.layout.item,parent,false);
        return new MainAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MyViewHolder holder, int position) {

        Model model=list1.get(position);
        holder.truckno.setText(model.getTruckno());

    }

    @Override
    public int getItemCount() {

        return list1.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView truckno;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            truckno=(TextView) itemView.findViewById(R.id.truckno);



        }
    }

}
