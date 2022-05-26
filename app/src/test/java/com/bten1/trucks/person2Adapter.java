package com.bten1.trucks;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class person2Adapter extends FirebaseRecyclerAdapter<person2,person2Adapter.persons2Viewholder> {

    Context context;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     */
    public person2Adapter(@NonNull FirebaseRecyclerOptions<person> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull person2Adapter.persons2Viewholder holder, int position, @NonNull person2 model) {
        holder.Email_t.setText(model.getEmail_t());
        holder.party_name_t.setText(model.getParty_name_t());
        holder.party_phone_no_t.setText(model.getParty_phone_no_t());
        holder.Freight_t.setText(model.getFreight_t());
        holder.Load_type_t.setText(model.getLoad_type_t());
        holder.Tons_t.setText(model.getTons_t());
        holder.loading_point_t.setText(model.getLoading_point_t());
        holder.unloading_point_t.setText(model.getUnloading_point_t());
        holder.advance_amt_t.setText(model.getAdvance_amt_t());
        holder.delivery_date_t.setText(model.getDelivery_date_t());


    }

    @NonNull
    @Override
    public person2Adapter.persons2Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person2, parent, false);
        return new person2Adapter.persons2Viewholder(view);
    }

    public static class persons2Viewholder extends RecyclerView.ViewHolder {
        TextView Freight_t, Load_type_t, Tons_t, loading_point_t, unloading_point_t, advance_amt_t, party_name_t, party_phone_no_t, Email_t, delivery_date_t;
        Button bi;

        public persons2Viewholder(@NonNull View itemView) {
            super(itemView);

            Email_t = itemView.findViewById(R.id.tvemail);
            party_name_t = itemView.findViewById(R.id.tvpartyname);
            party_phone_no_t = itemView.findViewById(R.id.tvpartyrno);
            Freight_t = itemView.findViewById(R.id.tvfreight);
            Load_type_t = itemView.findViewById(R.id.tvloadType);
            loading_point_t = itemView.findViewById(R.id.tvloadingpoint);
            unloading_point_t = itemView.findViewById(R.id.tvunloadingpoint);
            Tons_t = itemView.findViewById(R.id.tvtons);
            delivery_date_t = itemView.findViewById(R.id.tvdelivery);
            advance_amt_t = itemView.findViewById(R.id.tvadvance);
        }
    }
}




