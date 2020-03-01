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

public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.ViewHolder> {
    ArrayList<Sanpham> arrSp;
    Context context;
    OnItemClickListener listener;

    public LaptopAdapter(ArrayList<Sanpham> arrSp, Context context,OnItemClickListener listener) {
        this.arrSp = arrSp;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_dien_thoai,parent,false);
        return new ViewHolder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.BindData(arrSp.get(position));
    }

    @Override
    public int getItemCount() {
        return arrSp.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_sp;
        TextView txt_tenlaptop,txt_gia,txt_mottalaptop;
        private Sanpham sanpham;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(sanpham);
                }
            });
            img_sp = (ImageView)itemView.findViewById(R.id.img_sp);

            txt_gia = (TextView)itemView.findViewById(R.id.txt_gia);
            txt_mottalaptop = (TextView)itemView.findViewById(R.id.txt_mottadienthoai);
            txt_tenlaptop = (TextView)itemView.findViewById(R.id.txt_tendienthoai);
        }
        @RequiresApi(api = Build.VERSION_CODES.N)
        public void BindData(Sanpham sanpham){
            this.sanpham = sanpham;
            txt_tenlaptop.setText(sanpham.getTensp());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            txt_gia.setText("Giá : " + decimalFormat.format(sanpham.getGiasp() )+ " Đ");
            txt_mottalaptop.setText(sanpham.getMotasp());
            Picasso.with(context).load(sanpham.getHinhanhsp()).into(img_sp);
        }
    }
}
