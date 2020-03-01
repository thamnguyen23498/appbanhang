package com.example.appbanhang02.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbanhang02.R;
import com.example.appbanhang02.adapter.LoaispAdapter;
import com.example.appbanhang02.adapter.SanphamAdapter;
import com.example.appbanhang02.model.Loaisp;
import com.example.appbanhang02.model.Sanpham;
import com.example.appbanhang02.ultil.CheckConnection;
import com.example.appbanhang02.ultil.Server;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

import static com.example.appbanhang02.ultil.Server.DuongdanLoaisp;
import static com.example.appbanhang02.ultil.Server.Duongdanspmoinhat;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView_main ,rcl_loaisp;
    NavigationView navigationView_main;
    DrawerLayout drawerLayout;

    ArrayList<Loaisp> mangloaisp;
    LoaispAdapter loaispAdapter;


    ArrayList<Sanpham> mangsanpham;
    SanphamAdapter sanphamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        ActionBar();
        ActionViewFlipper();
        layDuLieuLoaiSP();
        GetDuLieuSP();



    }

    private void GetDuLieuSP() {
       RequestQueue requestQueue = Volley.newRequestQueue(this);
       StringRequest request = new StringRequest(Request.Method.GET, "http://192.168.101.107/serverappbanhang/getspmoinhat.php",
               new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {
                       try {
                           JSONArray jsonArray = new JSONArray(response);
                           for (int i=0;i<jsonArray.length();i++){
                               JSONObject jsonObject= jsonArray.getJSONObject(i);
                               mangsanpham.add(new Sanpham(
                                       jsonObject.getString("tensp"),
                                       jsonObject.getString("hinhsp"),
                                       jsonObject.getInt("giasp")
                               ));
                           }
                           sanphamAdapter.notifyDataSetChanged();
                       } catch (JSONException e) {
                           e.printStackTrace();
                       }
                   }
               }, new ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
           }
       });
       requestQueue.add(request);
    }

    private void layDuLieuLoaiSP() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, DuongdanLoaisp,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray= new JSONArray(response);
                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                mangloaisp.add(new Loaisp(
                                        jsonObject.getString("tenloaisp"),
                                        jsonObject.getString("hinhloaisp")));
                            }
                            mangloaisp.add(new Loaisp("Liên hệ","https://xgear.vn/wp-content/uploads/2017/05/UX430UA-1.jpg"));
                            mangloaisp.add(new Loaisp("Thông Tin","https://xgear.vn/wp-content/uploads/2017/05/UX430UA-1.jpg"));
                            loaispAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(request);
    }




    private void ActionViewFlipper() {
        ArrayList<String>mangquangcao = new ArrayList<>();
        mangquangcao.add("https://www.thegioididong.com/images/44/207682/apple-macbook-air-2019-i5-16ghz-8gb-128gb-mvfm2sa-6.jpg");
        mangquangcao.add("https://www.thegioididong.com/images/44/207682/apple-macbook-air-2019-i5-16ghz-8gb-128gb-mvfm2sa-12.jpg");
        mangquangcao.add("https://www.thegioididong.com/images/44/207682/apple-macbook-air-2019-i5-16ghz-8gb-128gb-mvfm2sa-13-1.jpg");
        mangquangcao.add("https://www.thegioididong.com/images/44/203194/asus-ux533fd-i5-8265u-8gb-256gb-2gb-gtx1050-156f-c-1.gif");
        mangquangcao.add("https://cdn.tgdd.vn/Products/Images/42/206176/samsung-galaxy-note-10-plus-tgdd-28.jpg");
        mangquangcao.add("https://photo2.tinhte.vn/data/attachment-files/2019/03/4604754_100000_laptop-asus-ux533fd-a9035t-02.jpg");
        mangquangcao.add("https://xgear.vn/wp-content/uploads/2017/05/UX430UA-1.jpg");
        mangquangcao.add("https://cdn.tgdd.vn/Products/Images/42/206176/samsung-galaxy-note-10-plus-tgdd-20.jpg");
        mangquangcao.add("https://www.thegioididong.com/images/42/198986/samsung-galaxy-s10-plus-512gb-white-6.jpg");
        mangquangcao.add("https://www.thegioididong.com/images/42/198986/samsung-galaxy-s10-plus-512gb-white-2.jpg");
        mangquangcao.add("https://www.thegioididong.com/images/42/190321/iphone-xs-max-gold-5.jpg");
        mangquangcao.add("https://www.thegioididong.com/images/42/190321/iphone-xs-max-gold-3.jpg");
        mangquangcao.add("https://cdn.tgdd.vn/Products/Images/42/206176/samsung-galaxy-note-10-plus-tgdd-27.jpg");
        for (int i = 0 ; i<mangquangcao.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        Animation annotation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation annotation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(annotation_slide_in);
        viewFlipper.setOutAnimation(annotation_slide_out);

    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }


    private void Anhxa() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        viewFlipper = (ViewFlipper)findViewById(R.id.viewflipper);
        recyclerView_main = (RecyclerView)findViewById(R.id.recyclerview_spm);
        navigationView_main = (NavigationView)findViewById(R.id.navigation);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawerlayout);
        rcl_loaisp = (RecyclerView) findViewById(R.id.rcl_loaisp);


        mangloaisp = new ArrayList<>();
        loaispAdapter = new LoaispAdapter(mangloaisp,getApplicationContext());
        rcl_loaisp.setHasFixedSize(true);
        rcl_loaisp.setLayoutManager(new LinearLayoutManager(this));
        rcl_loaisp.setAdapter(loaispAdapter);


        mangsanpham = new ArrayList<>();
        sanphamAdapter = new SanphamAdapter(getApplicationContext(),mangsanpham);

        recyclerView_main.setHasFixedSize(true);
        recyclerView_main.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView_main.setAdapter(sanphamAdapter);
    }
}
