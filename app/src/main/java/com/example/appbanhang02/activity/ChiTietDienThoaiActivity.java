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

public class ChiTietDienThoaiActivity extends AppCompatActivity {
    TextView txt_tensp,txt_giasp,txt_motasp;
    Button btn_them;
    ImageView img_dt;
    Spinner sp_soluongsp;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_dien_thoai);
        AnhXa();
        LayduLieu();
    }

    private void AnhXa() {
        txt_tensp = (TextView)findViewById(R.id.txt_tensp);
        txt_giasp = (TextView)findViewById(R.id.txt_giasp);
        txt_motasp = (TextView)findViewById(R.id.txt_motasp);
        btn_them= (Button)findViewById(R.id.btn_them);
        img_dt = (ImageView)findViewById(R.id.img_dt);
        sp_soluongsp = (Spinner)findViewById(R.id.sp_soluongsp);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void LayduLieu(){
        Intent intent = getIntent();
        Sanpham sp = (Sanpham) intent.getSerializableExtra("dienthoai");
        Picasso.with(ChiTietDienThoaiActivity.this).load(sp.getHinhanhsp()).into(img_dt);
        txt_tensp.setText(sp.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txt_giasp.setText("Giá : " + decimalFormat.format(sp.getGiasp() )+ " Đ");
        txt_motasp.setText(sp.getMotasp());
    }
}
