package com.example.appbanhang02.adapter;

import android.content.Context;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanhang02.R;
import com.example.appbanhang02.activity.DienThoaiActivity;
import com.example.appbanhang02.model.Sanpham;
import com.squareup.picasso.Picasso;

import org.apache.http.conn.ConnectTimeoutException;

import java.util.ArrayList;

public class SanphamAdapter extends RecyclerView.Adapter <SanphamAdapter.ItemHolder>{

    public SanphamAdapter(Context context, ArrayList<Sanpham> arraysanpham) {
        this.context = context;
        this.arraysanpham = arraysanpham;
    }

    Context context;
    ArrayList<Sanpham> arraysanpham;

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_sanphammoinhat,null);
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, final int position) {
        Sanpham sanpham = arraysanpham.get(position);
        holder.txttensanpham.setText(sanpham.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgiasanpham.setText("Giá : " + decimalFormat.format(sanpham.getGiasp() )+ " Đ");
        Picasso.with(context).load(sanpham.getHinhanhsp())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark_disabled)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.imghinhanhsanpham);

    }

    @Override
    public int getItemCount() {
        return arraysanpham.size();
    }

    public class ItemHolder extends  RecyclerView.ViewHolder{
        public ImageView imghinhanhsanpham;
        public TextView txttensanpham , txtgiasanpham;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imghinhanhsanpham = (ImageView) itemView.findViewById(R.id.imgviewsp);
            txtgiasanpham = (TextView) itemView.findViewById(R.id.txtgiasp);
            txttensanpham = (TextView) itemView.findViewById(R.id.txttensp);


        }
    }
}
