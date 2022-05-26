package com.bten1.trucks;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class person3Adapter extends RecyclerView.Adapter<person3Adapter.MyViewHolder> {



    Context context;
    ArrayList<person> personArrayList;

    public person3Adapter(Context context,ArrayList<person> personArrayList) {
        this.context = context;
        this.personArrayList = personArrayList;
    }


    @NonNull
    @Override
    public person3Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.person3,parent ,false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull person3Adapter.MyViewHolder holder, int position) {
        person person=personArrayList.get(position);
        holder.uid.setText(person.uid);
        holder.fixer.setText(person.fixer);
      //  holder.party_phone_no.setText(person.party_phone_no);
        holder.freight.setText(person.freight);
        holder.load_type.setText(person.load_type);
        holder.tons.setText(person.tons);
        holder.loading_point.setText(person.loading_point);
        holder.unloading_point.setText(person.unloading_point);
        holder.advance_amt.setText(person.advance_amt);
        holder.delivery_date.setText(person.delivery_date);



    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView uid,fixer,freight,load_type,tons,loading_point,unloading_point,party_name,party_phone_no,delivery_date,advance_amt;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            uid=itemView.findViewById(R.id.tvuid3);
            fixer=itemView.findViewById(R.id.tvfixer3);
            freight=itemView.findViewById(R.id.tvfreight3);
            load_type=itemView.findViewById(R.id.tvloadType3);
            loading_point=itemView.findViewById(R.id.tvloadingpoint3);
            unloading_point=itemView.findViewById(R.id.tvunloadingpoint3);
            delivery_date=itemView.findViewById(R.id.tvdelivery3);
            advance_amt=itemView.findViewById(R.id.tvadvance3);
            tons=itemView.findViewById(R.id.tvtons3);




        }
    }
}





