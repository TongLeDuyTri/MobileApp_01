package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class productdetailActivity extends AppCompatActivity {

    ImageView imageProduct;
    TextView textProductName, textProductDescription, textProductPrice;
    Button buttonAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetail); // dùng layout đúng tên file

        // Ánh xạ view
        imageProduct = findViewById(R.id.imageProduct);
        textProductName = findViewById(R.id.textProductName);
        textProductDescription = findViewById(R.id.textProductDescription);
        textProductPrice = findViewById(R.id.textProductPrice);
        buttonAddToCart = findViewById(R.id.buttonAddToCart);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String description = intent.getStringExtra("description");
            String price = intent.getStringExtra("price");
            int imageRes = intent.getIntExtra("image", R.drawable.imges); // hình mặc định

            // Gán dữ liệu
            textProductName.setText(name);
            textProductDescription.setText(description);
            textProductPrice.setText("Giá: " + price);
            imageProduct.setImageResource(imageRes);
        }

        // Xử lý nút "Thêm vào giỏ hàng"
        buttonAddToCart.setOnClickListener(v -> {
            Toast.makeText(this, "Đã thêm vào giỏ hàng!", Toast.LENGTH_SHORT).show();
        });
    }
}
