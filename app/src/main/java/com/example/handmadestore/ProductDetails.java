package com.example.handmadestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity { // Тауарды толықтай көрсететін эктивити
    ImageView imageViewProduct, imageViewBack;   // Экрандағы суреттер
    TextView txtName, txtDesc, txtPrice;    // Тексттер

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //  Activity құрылғанда орындалатын код
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Intent i =getIntent();  // Интент арқылы мәліметтерді алдыңғы эктивитеден алады
        String name = i.getStringExtra("name");
        String desc = i.getStringExtra("desc");
        String price = i.getStringExtra("price");
        int image = i.getIntExtra("image",R.drawable.alqa48_full);
        // UI элементтерін инициализациялау
        txtName = findViewById(R.id.lblPName);
        txtDesc = findViewById(R.id.lblPDesc);
        txtPrice = findViewById(R.id.lblPPrice);
        imageViewProduct= findViewById(R.id.imgProduct);
        imageViewBack = findViewById(R.id.imgBack);
        // Тексттерге мәліметтерді енгізу
        txtName.setText(name);
        txtPrice.setText(price);
        txtDesc.setText(desc);
        imageViewProduct.setImageResource(image);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    // Артқа қайту батырмасының тыңдаушысы
                Intent intent =new Intent(ProductDetails.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}