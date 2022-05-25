package com.bten1.trucks;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class personAdapter extends FirebaseRecyclerAdapter<person,personAdapter.personsViewholder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     */
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
        holder.advance_amt.setText(model.getAdvance_amt());
        holder.delivery_date.setText(model.getDelivery_date());
    }

    @NonNull
    @Override
    public personsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.person,parent,false);
        return new personsViewholder(view);
    }

    public static class personsViewholder extends RecyclerView.ViewHolder{
        TextView Freight,Load_type,Tons,loading_point,unloading_point,advance_amt,party_name,party_phone_no,Email,delivery_date;

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
            delivery_date=itemView.findViewById(R.id.tvdelivery);
            advance_amt=itemView.findViewById(R.id.tvadvance);

        }
    }
}






















/*
public class personAdapter extends FirebaseRecyclerAdapter<person,personAdapter.personsViewholder> {


    Context context;
    ArrayList<person> personArrayList;
    private onItemClickListener listener;
    public interface onItemClickListener{
        // void onItemClicked(long documentReference,int position);
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(onItemClickListener listener){
        this.listener=listener;
    }


    public personAdapter(Context context,ArrayList<person> personArrayList) {
        this.context = context;
        this.personArrayList = personArrayList;
    }





    /*  Context context;
    ArrayList<person> personArrayList;
    private onItemClickListener listener;

    public personAdapter(FirebaseRecyclerOptions<person> options) {
        super(options);

    }


    public interface onItemClickListener{
        // void onItemClicked(long documentReference,int position);
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(onItemClickListener listener){
        this.listener=listener;
    }


    public personAdapter(@NonNull FirebaseRecyclerOptions<person> options,Context context,ArrayList<person> personArrayList) {
        super(options);
        this.context = context;
        this.personArrayList = personArrayList;
    }
*/
/*
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
        holder.bi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent intent=new Intent(context,loading.class);
                intent.putExtra("Email",model.getEmail());
                intent.putExtra("Load_Type",model.getLoad_type());
                intent.putExtra("loading_point",model.getLoading_point());
                intent.putExtra("unloading_point",model.getLoading_point());
                intent.putExtra("Freight",model.getFreight());
                intent.putExtra("Advance_Amount",model.getAdvance_amt());
                intent.putExtra("Tons",model.getTons());
                intent.putExtra("Delivery_Date",model.getDelivery_date());
                intent.putExtra("party_phone_number",model.getParty_phone_no());
                intent.putExtra("party_name",model.getParty_name());
                context.startActivity(intent);

            }
        });





    }



    @NonNull
    @Override
    public personsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.person,parent,false);
        return new personAdapter.personsViewholder(view);
    }

    public class personsViewholder extends RecyclerView.ViewHolder{
        TextView Email,Freight,Load_type,Tons,loading_point,unloading_point,party_name,party_phone_no;
        Button bi;

        public personsViewholder(@NonNull View itemView) {
            super(itemView);
            bi=itemView.findViewById(R.id.fix);
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
}*/