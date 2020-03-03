package com.example.appbanhang02.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbanhang02.Interface.OnItemClickListener;
import com.example.appbanhang02.R;
import com.example.appbanhang02.adapter.DienThoaiAdapter;
import com.example.appbanhang02.model.Sanpham;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.appbanhang02.ultil.Server.Duongdansp;

public class DienThoaiActivity extends AppCompatActivity implements OnItemClickListener {
        RecyclerView rcl_dienthoai;
        ArrayList<Sanpham> arrSp;
        DienThoaiAdapter sanPhamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dien_thoai);
        Anhxa();
        LaySanPham();
    }
    public void LaySanPham(){

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        Intent intent = getIntent();
        final int maloaisp = intent.getIntExtra("maloaisp",1);
        //Toast.makeText(getApplicationContext(),Integer.toString(maloaisp),Toast.LENGTH_LONG).show();
        StringRequest request = new StringRequest(Request.Method.POST, Duongdansp,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject= jsonArray.getJSONObject(i);
                                //public Sanpham(int masp, String tensp, Integer giasp, String hinhanhsp, String motasp, int maloaisp)
                                arrSp.add(new Sanpham(
                                        jsonObject.getInt("masp"),
                                        jsonObject.getString("tensp"),
                                        jsonObject.getInt("giasp"),
                                        jsonObject.getString("hinhsp"),
                                        jsonObject.getString("motasp"),
                                        jsonObject.getInt("maloaisp")
                                ));

                            }
                            sanPhamAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("maloaisp", String.valueOf(maloaisp));
                return params;
            }
        };
        requestQueue.add(request);
    }

    private void Anhxa() {
        rcl_dienthoai = (RecyclerView)findViewById(R.id.rcl_dienthoai);
        arrSp = new ArrayList<>();
        sanPhamAdapter =new DienThoaiAdapter(arrSp,DienThoaiActivity.this,this);
        rcl_dienthoai.setHasFixedSize(true);
        rcl_dienthoai.setLayoutManager(new LinearLayoutManager(this));
        rcl_dienthoai.setAdapter(sanPhamAdapter);

    }

    @Override
    public void onItemClick(Sanpham sanpham) {
        //Toast.makeText(getApplicationContext(),sanpham.getTensp(),Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), ChiTietSpActivity.class);
        intent.putExtra("dienthoai",sanpham);
        startActivity(intent);
        Log.d("abc","123");
    }
}
