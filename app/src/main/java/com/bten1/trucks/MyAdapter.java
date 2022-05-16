package com.bten1.trucks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;
    ArrayList<User> list;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v=LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user=list.get(position);
        holder.loadtypec.setText(user.getLoadtype());
        holder.loadingpointc.setText(user.getLoadingpoint());
        holder.unloadingpointc.setText(user.getUnloadingpoint());
        holder.freightc.setText(user.getFreight());
        holder.tonsc.setText(user.getTons());
        holder.advancec.setText(user.getAdvance());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView loadtypec,loadingpointc,unloadingpointc,freightc,tonsc,advancec;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            loadtypec=itemView.findViewById(R.id.loadtypevalue1);
            loadingpointc=itemView.findViewById(R.id.loadingpointvalue1);
            unloadingpointc=itemView.findViewById(R.id.unloadingpointvalue1);
            freightc=itemView.findViewById(R.id.freightvalue1);
            tonsc=itemView.findViewById(R.id.tonsvalue1);
            advancec=itemView.findViewById(R.id.advancevalue1);

        }
    }

}
