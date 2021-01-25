package net.islbd.filterablerecycleview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContentCustomAdapter extends RecyclerView.Adapter<ContentCustomAdapter.Viewholder> {

    private List<ContentModel> contentModelList;
    private Context context;
    public ContentCustomAdapter(List<ContentModel> contentModelList,Context context){
        this.contentModelList = contentModelList;
        this.context = context;
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_list_layout, parent,false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.tvCountryName.setText(contentModelList.get(position).getTitle());
        holder.tvConnectmsc.setText(contentModelList.get(position).getCatName());
        holder.tvDetails.setText(contentModelList.get(position).getDecontent());
    }

    @Override
    public int getItemCount() {
        return contentModelList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{
        TextView tvCountryName, tvConnectmsc, tvDetails;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tvCountryName = itemView.findViewById(R.id.textViewTitle);
            tvConnectmsc = itemView.findViewById(R.id.textViewcate);
            tvDetails = itemView.findViewById(R.id.textViewConDetails);
        }
    }
}
