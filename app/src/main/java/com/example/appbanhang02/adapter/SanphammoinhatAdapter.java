package com.example.appbanhang02.adapter;

import android.content.Context;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanhang02.Interface.OnItemClickListener;
import com.example.appbanhang02.R;
import com.example.appbanhang02.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SanphammoinhatAdapter extends RecyclerView.Adapter <SanphammoinhatAdapter.ItemHolder>{

    public SanphammoinhatAdapter(Context context, ArrayList<Sanpham> arraysanpham,OnItemClickListener listener) {
        this.context = context;
        this.arraysanpham = arraysanpham;
        this.listener = listener;
    }
    OnItemClickListener listener;
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
        holder.BindData(arraysanpham.get(position));


    }

    @Override
    public int getItemCount() {
        return arraysanpham.size();
    }

    public class ItemHolder extends  RecyclerView.ViewHolder{
        public ImageView imghinhanhsanpham;
        public TextView txttensanpham , txtgiasanpham;
        Sanpham sanpham;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(sanpham);
                }
            });
            imghinhanhsanpham = (ImageView) itemView.findViewById(R.id.imgviewsp);
            txtgiasanpham = (TextView) itemView.findViewById(R.id.txtgiasp);
            txttensanpham = (TextView) itemView.findViewById(R.id.txttensp);
        }
        @RequiresApi(api = Build.VERSION_CODES.N)
        public void BindData(Sanpham sanpham){
            this.sanpham = sanpham;
            txttensanpham.setText(this.sanpham.getTensp());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            txtgiasanpham.setText("Giá : " + decimalFormat.format(this.sanpham.getGiasp() )+ " Đ");
            Picasso.with(context).load(this.sanpham.getHinhanhsp())
                    .placeholder(R.drawable.common_google_signin_btn_icon_dark_disabled)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(imghinhanhsanpham);
        }
    }
}
