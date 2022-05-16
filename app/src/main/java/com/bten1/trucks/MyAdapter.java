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
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user=list.get(position);
        holder.loadtype.setText(user.getLoadtype());
        holder.loadingpoint.setText(user.getLoadingpoint());
        holder.unloadingpoint.setText(user.getUnloadingpoint());
        holder.freight.setText(user.getFreight());
        holder.tons.setText(user.getTons());
        holder.advance.setText(user.getAdvance());


    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView loadtype,loadingpoint,unloadingpoint,freight,tons,advance;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            loadtype=(TextView) itemView.findViewById(R.id.tvloadType);
            loadingpoint=(TextView) itemView.findViewById(R.id.tvloadingpoint);
            unloadingpoint=(TextView) itemView.findViewById(R.id.tvunloadingpoint);
            freight=(TextView) itemView.findViewById(R.id.tvfreight);
            tons=(TextView) itemView.findViewById(R.id.tvtons);
            advance=(TextView) itemView.findViewById(R.id.tvadvance);


        }
    }

}
