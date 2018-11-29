package com.example.android.ayodolen.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.ayodolen.DetailWisataActivity;
import com.example.android.ayodolen.Model.Wisata;
import com.example.android.ayodolen.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterWisata extends RecyclerView.Adapter<RecyclerAdapterWisata.MyViewHolder> implements Filterable {

    private List<String> wisata;
    private List<String>  wisataFull;
    private Context mContext;


    public RecyclerAdapterWisata(List<String> wisata, Context mContext) {
        this.wisata = wisata;
        this.mContext = mContext;
        wisataFull = new ArrayList<>(wisata);
    }

    @NonNull
    @Override
    public RecyclerAdapterWisata.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gview_wisata, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(mView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterWisata.MyViewHolder holder, int position) {
        holder.namaWisata.setText(wisata.get(position).toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail = new Intent(mContext,DetailWisataActivity.class);
                mContext.startActivity(detail);
            }
        });


    }

    @Override
    public int getItemCount() {
        return wisata.size();
    }

    @Override
    public Filter getFilter() {
        return WisataFilter;
    }

    private Filter WisataFilter = new Filter(){
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<String> filterWisata = new ArrayList<>();

            if(charSequence == null || charSequence.length() == 0){
                filterWisata.addAll(wisataFull);
            }else{
                String textfilter = charSequence.toString().toLowerCase().trim();
                for (String w : wisataFull){
                    if(w.toString().toLowerCase().contains(textfilter)){
                        filterWisata.add(w);
                    }
                }

            }
            FilterResults results = new FilterResults();
            results.values = filterWisata;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            wisata.clear();
            wisata.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView namaWisata;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgGridWisata);
            namaWisata = itemView.findViewById(R.id.tvGridWisata);
        }
    }


}
