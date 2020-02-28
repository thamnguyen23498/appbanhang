package com.example.appbanhang02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanhang02.R;
import com.example.appbanhang02.model.Loaisp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoaispAdapter extends RecyclerView.Adapter<LoaispAdapter.ViewHolder> {
    ArrayList<Loaisp> loaispArrayList;
    Context context;

    public LoaispAdapter(ArrayList<Loaisp> loaispArrayList, Context context) {
        this.loaispArrayList = loaispArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_loaisp,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Loaisp loaisp = loaispArrayList.get(position);
        holder.txt_loaisp.setText(loaisp.getTenloaisp());
        Picasso.with(context).load(loaisp.getHinhanhloaisp()).into(holder.img_anhloaisp);

    }

    @Override
    public int getItemCount() {
        return loaispArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_loaisp;
        ImageView img_anhloaisp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_loaisp=(TextView)itemView.findViewById(R.id.txt_lsp);
            img_anhloaisp = (ImageView)itemView.findViewById(R.id.img_loaisp);
        }
    }
}