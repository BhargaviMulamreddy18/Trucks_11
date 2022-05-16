package com.bten1.trucks;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;
    ArrayList<user> list;

    public MyAdapter(Context context, ArrayList<user> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        user use=list.get(position);
        holder.loadtypec.setText(use.getLoadtypec());
        holder.loadingpointc.setText(use.getLoadingpointc());
        holder.unloadingpointc.setText(use.getUnloadingpointc());
        holder.freightc.setText(use.getFreightc());
        holder.tonsc.setText(use.getTonsc());
        holder.advancec.setText(use.getAdvancec());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView loadtypec,loadingpointc,unloadingpointc,freightc,tonsc,advancec;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            loadtypec=itemView.findViewById(R.id.loadtype1);
            loadingpointc=itemView.findViewById(R.id.loadingpoint1);
            unloadingpointc=itemView.findViewById(R.id.unloadingpoint1);
            freightc=itemView.findViewById(R.id.freight1);
            tonsc=itemView.findViewById(R.id.tons1);
            advancec=itemView.findViewById(R.id.advance1);


        }
    }

}
