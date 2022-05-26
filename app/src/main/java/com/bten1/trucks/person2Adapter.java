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

public class person2Adapter extends RecyclerView.Adapter<person2Adapter.MyViewHolder> {

    Context context;
    ArrayList<person2> person2ArrayList;


    public person2Adapter(Context context,ArrayList<person2> person2ArrayList) {
        this.context = context;
        this.person2ArrayList = person2ArrayList;
    }


    @NonNull
    @Override
    public person2Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.person2,parent ,false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull person2Adapter.MyViewHolder holder, int position) {
        person2 person2=person2ArrayList.get(position);
        holder.mail_t.setText(person2.mail_t);
        holder.party_name_t.setText(person2.party_name_t);
        holder.party_phone_no_t.setText(person2.party_phone_no_t);
        holder.freight_t.setText(person2.freight_t);
        holder.load_type_t.setText(person2.load_type_t);
        holder.tons_t.setText(person2.tons_t);
        holder.loading_point_t.setText(person2.loading_point_t);
        holder.unloading_point_t.setText(person2.unloading_point_t);
        holder.advance_amt_t.setText(person2.advance_amt_t);
        holder.delivery_date_t.setText(person2.delivery_date_t);
        context=holder.itemView.getContext();




    }

    @Override
    public int getItemCount() {
        return person2ArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView mail_t,freight_t,load_type_t,tons_t,loading_point_t,unloading_point_t,party_name_t,party_phone_no_t,delivery_date_t,advance_amt_t;
        Button bi;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bi=itemView.findViewById(R.id.fix);
            mail_t=itemView.findViewById(R.id.tvemail2);
            party_name_t=itemView.findViewById(R.id.tvpartyname2);
            party_phone_no_t=itemView.findViewById(R.id.tvpartyrno2);
            freight_t=itemView.findViewById(R.id.tvfreight2);
            load_type_t=itemView.findViewById(R.id.tvloadType2);
            loading_point_t=itemView.findViewById(R.id.tvloadingpoint2);
            unloading_point_t=itemView.findViewById(R.id.tvunloadingpoint2);
            delivery_date_t=itemView.findViewById(R.id.tvdelivery2);
            advance_amt_t=itemView.findViewById(R.id.tvadvance2);
            tons_t=itemView.findViewById(R.id.tvtons2);



        }
    }
}
