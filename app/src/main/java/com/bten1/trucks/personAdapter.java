package com.bten1.trucks;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class personAdapter extends FirebaseRecyclerAdapter<person,personAdapter.personsViewholder> {

    public personAdapter(@NonNull FirebaseRecyclerOptions<person> options) {
        super(options);
    }



    @Override
    protected void onBindViewHolder(@NonNull personsViewholder holder, int position, @NonNull person model) {
        holder.Email.setText(model.getEmail());
        holder.party_name.setText(model.getParty_name());
        holder.party_phone_no.setText(model.getParty_phone_no());
        holder.Freight.setText(model.getFreight());
        holder.Load_type.setText(model.getLoad_type());
        holder.Tons.setText(model.getTons());
        holder.loading_point.setText(model.getLoading_point());
        holder.unloading_point.setText(model.getUnloading_point());
    }

    @NonNull
    @Override
    public personsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.person,parent,false);
        return new personAdapter.personsViewholder(view);
    }

    public class personsViewholder extends RecyclerView.ViewHolder{
        TextView Email,Freight,Load_type,Tons,loading_point,unloading_point,party_name,party_phone_no;

        public personsViewholder(@NonNull View itemView) {
            super(itemView);
            Email=itemView.findViewById(R.id.tvemail);
            party_name=itemView.findViewById(R.id.tvpartyname);
            party_phone_no=itemView.findViewById(R.id.tvpartyrno);
            Freight=itemView.findViewById(R.id.tvfreight);
            Load_type=itemView.findViewById(R.id.tvloadType);
            loading_point=itemView.findViewById(R.id.tvloadingpoint);
            unloading_point=itemView.findViewById(R.id.tvunloadingpoint);
            Tons=itemView.findViewById(R.id.tvtons);

        }
    }
}