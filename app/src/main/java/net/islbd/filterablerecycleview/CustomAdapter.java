package net.islbd.filterablerecycleview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private List<Medicinedatum> medicineDatum;
    public CustomAdapter(List<Medicinedatum> medicineDatum){
        this.medicineDatum = medicineDatum;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewName.setText(medicineDatum.get(position).getBrandName());
        holder.textViewCompanyName.setText(medicineDatum.get(position).getCompanyName());
        holder.textViewPower.setText(medicineDatum.get(position).getMedPower());
        holder.textViewPrice.setText(medicineDatum.get(position).getSizePrice());
    }

    @Override
    public int getItemCount() {
        return medicineDatum.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName, textViewCompanyName, textViewPower, textViewPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewCompanyName = itemView.findViewById(R.id.textViewCompany);
            textViewPower = itemView.findViewById(R.id.textViewPower);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String groupId = medicineDatum.get(getAdapterPosition()).getGroupId();
                    Context context = view.getContext();
                    Intent intent = new Intent(context, MedDetailsActivity.class);
                    intent.putExtra("groupid", groupId);
                    context.startActivity(intent);
                }
            });
        }
    }

    public void filterList(List<Medicinedatum> medicineDatum) {
        this.medicineDatum = medicineDatum;
        notifyDataSetChanged();
    }
}