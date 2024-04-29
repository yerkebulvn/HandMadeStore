package com.example.handmadestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.example.handmadestore.adapter.AllCategoryAdapter;
import com.example.handmadestore.model.AllCategoryModel;

import java.util.ArrayList;
import java.util.List;

public class AllCategory extends AppCompatActivity {
    RecyclerView allCategoryRecyclerView;   // Жылжымалы тізім интерфейсі
    AllCategoryAdapter allCategoryAdapter;  // Барлық категориялар адаптері
    List<AllCategoryModel> allCategoriesList;   // Категориялар тізімі
    ImageView backImageView;    // Экранда көрсетілетін сурет

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //  Activity құрылғанда орындалатын код
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);
        // UI элементтерінің инициализациясы
        allCategoryRecyclerView =findViewById(R.id.allCategoryRview);
        backImageView = findViewById(R.id.back);
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    // Артқа қайту батырмасының тыңдаушысы
                Intent back = new Intent(AllCategory.this , MainActivity.class);
                startActivity(back);
                finish();
            }
        });

        allCategoriesList =new ArrayList<>();   //  Тізім инициализациясы мен оны толтыру
        allCategoriesList.add(new AllCategoryModel(1,R.drawable.ic_alqa));
        allCategoriesList.add(new AllCategoryModel(2,R.drawable.ic_kulon));
        allCategoriesList.add(new AllCategoryModel(3,R.drawable.ic_monshak));
        allCategoriesList.add(new AllCategoryModel(4,R.drawable.ic_syrga));
        setAllCategoryRecycler();
    }

    private void setAllCategoryRecycler() { //  Тізімді recycler ге көшіру
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,4);
        allCategoryRecyclerView.setLayoutManager(layoutManager);

        allCategoryRecyclerView.addItemDecoration(new GridSpacingItemDecoration(4 ,dpToPx(16) ,true) );
        allCategoryRecyclerView.setItemAnimator(new DefaultItemAnimator());

        allCategoryAdapter = new AllCategoryAdapter(this,allCategoriesList);
        allCategoryRecyclerView.setAdapter(allCategoryAdapter);
    }
    // енді бізге аралықты басқару үшін кейбір элементтерді безендіру класы қажет

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration{
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parentRecyclerView, RecyclerView.State state){
            int position = parentRecyclerView.getChildAdapterPosition(view); // Элемент позициясы
            int column = position % spanCount; //   Элементтер Бағанасы

            if (includeEdge){
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if(position < spanCount){ // жоғарғы бұрыш
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // элементтің астыңғы жағы
            }
            else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount){
                    outRect.top = spacing; // элементтің үсті
                }
            }
        }
    }
    /**
     * dp ны pixel ге конвертациялау
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}