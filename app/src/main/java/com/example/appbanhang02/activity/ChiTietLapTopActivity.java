package com.example.appbanhang02.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.appbanhang02.R;
import com.example.appbanhang02.model.Sanpham;
import com.squareup.picasso.Picasso;

public class ChiTietLapTopActivity extends AppCompatActivity {
        TextView txt_tenlaptop,txt_gialaptop,txt_motalaptop;
        Button btn_themlaptop;
        ImageView img_laptop;
        Spinner sp_soluonglaptop;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_lap_top);
        Anhxa();
        LayDuLieuLaptop();
    }

    private void Anhxa() {
        txt_tenlaptop = (TextView)findViewById(R.id.txt_tenlaptop);
        txt_gialaptop = (TextView)findViewById(R.id.txt_gialaptop);
        txt_motalaptop = (TextView)findViewById(R.id.txt_motalaptop);
        btn_themlaptop = (Button)findViewById(R.id.btn_themlaptop);
        img_laptop = (ImageView)findViewById(R.id.img_laptop);
        sp_soluonglaptop = (Spinner)findViewById(R.id.sp_soluonglaptop);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void LayDuLieuLaptop(){
        Intent intent = getIntent();
        Sanpham sp = (Sanpham) intent.getSerializableExtra("laptop");
        Picasso.with(ChiTietLapTopActivity.this).load(sp.getHinhanhsp()).into(img_laptop);
        txt_tenlaptop.setText(sp.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txt_gialaptop.setText("Giá : " + decimalFormat.format(sp.getGiasp() )+ " Đ");
        txt_motalaptop.setText(sp.getMotasp());
    }
}
