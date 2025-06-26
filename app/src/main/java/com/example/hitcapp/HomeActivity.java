package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    LinearLayout product1, product2, product3;
    TextView tvAo, tvGiay, tvDayChuyen;
    Button btnBuy1, btnBuy2, btnBuy3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ánh xạ
        product1 = findViewById(R.id.product1);
        product2 = findViewById(R.id.product2);
        product3 = findViewById(R.id.product3);

        tvAo = findViewById(R.id.tvAo);
        tvGiay = findViewById(R.id.tvGiay);
        tvDayChuyen = findViewById(R.id.tvDayChuyen);

        btnBuy1 = findViewById(R.id.btnBuy1);
        btnBuy2 = findViewById(R.id.btnBuy2);
        btnBuy3 = findViewById(R.id.btnBuy3);

        Button btnViewAll = findViewById(R.id.btnAll);
        SearchView searchView = findViewById(R.id.searchView);

        hienTatCaSanPham();

        // Tìm kiếm
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(HomeActivity.this, "Đang tìm: " + query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        // Lọc danh mục
        tvAo.setOnClickListener(v -> locSanPham("ao"));
        tvGiay.setOnClickListener(v -> locSanPham("giay"));
        tvDayChuyen.setOnClickListener(v -> locSanPham("daychuyen"));

        // Nút "Tất cả"
        btnViewAll.setOnClickListener(v -> hienTatCaSanPham());

        // Nút mua
        btnBuy1.setOnClickListener(v ->
                Toast.makeText(this, "Đã thêm sản phẩm 1 vào giỏ hàng", Toast.LENGTH_SHORT).show());

        btnBuy2.setOnClickListener(v ->
                Toast.makeText(this, "Đã thêm sản phẩm 2 vào giỏ hàng", Toast.LENGTH_SHORT).show());

        btnBuy3.setOnClickListener(v ->
                Toast.makeText(this, "Đã thêm sản phẩm 3 vào giỏ hàng", Toast.LENGTH_SHORT).show());

        // Mở chi tiết sản phẩm
        product1.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, productdetailActivity.class);
            intent.putExtra("name", "Áo Mặt Quỷ");
            intent.putExtra("description", "Áo phong cách streetwear, chất liệu cotton, freesize.");
            intent.putExtra("price", "250.000đ");
            intent.putExtra("image", R.drawable.imges);
            startActivity(intent);
        });

        product2.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, productdetailActivity.class);
            intent.putExtra("name", "Giày Nike");
            intent.putExtra("description", "Giày thể thao thời trang Nike, bền, êm chân.");
            intent.putExtra("price", "850.000đ");
            intent.putExtra("image", R.drawable.inmages1);
            startActivity(intent);
        });

        product3.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, productdetailActivity.class);
            intent.putExtra("name", "Dây chuyền đinh đá");
            intent.putExtra("description", "Dây chuyền nam phong cách hầm hố, hợp thời trang.");
            intent.putExtra("price", "320.000đ");
            intent.putExtra("image", R.drawable.inmages2);
            startActivity(intent);
        });
    }

    private void locSanPham(String loai) {
        product1.setVisibility(loai.equals("ao") ? View.VISIBLE : View.GONE);
        product2.setVisibility(loai.equals("giay") ? View.VISIBLE : View.GONE);
        product3.setVisibility(loai.equals("daychuyen") ? View.VISIBLE : View.GONE);
    }

    private void hienTatCaSanPham() {
        product1.setVisibility(View.VISIBLE);
        product2.setVisibility(View.VISIBLE);
        product3.setVisibility(View.VISIBLE);
    }
}
