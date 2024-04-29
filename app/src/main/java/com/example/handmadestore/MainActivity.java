package com.example.handmadestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.example.handmadestore.adapter.CategoryAdapter;
import com.example.handmadestore.adapter.DiscountedProductAdapter;
import com.example.handmadestore.adapter.RecentlyViewedAdapter;
import com.example.handmadestore.model.AllCategoryModel;
import com.example.handmadestore.model.Category;
import com.example.handmadestore.model.DiscountedProducts;
import com.example.handmadestore.model.RecentlyViewed;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView discountedRecyclerView, categoryRecyclerView , recentlyViewedRecycler; // Жылжымалы тізімдер
    DiscountedProductAdapter discountedProductAdapter;  // Жеңілдіктер адаптері
    RecentlyViewedAdapter recentlyViewedAdapter;    // Тауарлар адаптері
    List<DiscountedProducts> discountedProductsList;    // Жеңілдіктер тізімі
    List<RecentlyViewed> recentlyViewedList;    // Тауарлар тізімі
    CategoryAdapter categoryAdapter;    // категориялар адаптері
    List<Category> categoryList;    // Категориялар тізімі
    ImageView allCategoryImageView; // Экранда көрсетілетін сурет

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //  Activity құрылғанда орындалатын код
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountedRecyclerView=findViewById(R.id.discountedRecycler);
        //тізімді мәліметтермен толтыру
        discountedProductsList =new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1,R.drawable.discountkulon));
        discountedProductsList.add(new DiscountedProducts(2,R.drawable.discountmonshaq));
        discountedProductsList.add(new DiscountedProducts(3,R.drawable.discountsyrga));
        discountedProductsList.add(new DiscountedProducts(4,R.drawable.discountkulon));
        discountedProductsList.add(new DiscountedProducts(5,R.drawable.discountmonshaq));
        discountedProductsList.add(new DiscountedProducts(6,R.drawable.discountsyrga));
        setDiscountedRecycler(discountedProductsList);

        categoryRecyclerView =findViewById(R.id.catagoryRecycler);
        //тізімді мәліметтермен толтыру
        categoryList =new ArrayList<>();
        categoryList.add(new Category(1,R.drawable.ic_alqa));
        categoryList.add(new Category(2,R.drawable.ic_kulon));
        categoryList.add(new Category(3,R.drawable.ic_monshak));
        categoryList.add(new Category(4,R.drawable.ic_syrga));

        setCategoryRecycler();

        allCategoryImageView =findViewById(R.id.allCategoryImage);
        allCategoryImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    // Категорияның суреті басылғанда орындалатын код
                Intent intent=new Intent(MainActivity.this,AllCategory.class);  // Барлық категориялар эктивитиі ашылады
                startActivity(intent);
            }
        });

        recentlyViewedRecycler =findViewById(R.id.recently_items);
        //тізімді мәліметтермен толтыру
        recentlyViewedList =new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Қолдан жасалған алқа (ұзындығы 48 см)","Қолдан жасалған алқа полимерлі саздан жасалған.\n" +
                "Ожерель экструдорлық техникада ілгегі бар балауыз сымдарда жасалған.\n" +
                "Алқа сіздің кез келген киіміңізді сергітеді және безендіреді.\n" +
                "Ожерельдің ұзындығы 48 см, орталық бөліктің өлшемі 8 см.\n" +
                "Басқа түсте жасауға болады. Өндіріс мерзімі 3-5 күн.","7260 тг","1","дана",R.drawable.card_alqa48,R.drawable.alqa48_full));
        recentlyViewedList.add(new RecentlyViewed("Кулон 'жазғы'","Қолдан жасалған Кулон экструдорлық техникада полимерлі саздан жасалған.\n" +
                "Декорация өзінің жарқын түсімен және ерекше дизайнымен қуантады. Кез-келген киімге сәйкес келеді және сіздің келбетіңізге ерекше әсер береді.\n" +
                "Ілгегі бар балауыз сымдардағы Кулон өлшемі 9 см.\n" +
                "Сымның ұзындығы 50 см.\n" +
                "3-5 күн ішінде басқа түсте жасауға болады.","5940 тг","1","дана",R.drawable.card_kulon50,R.drawable.kulon50_full));
        recentlyViewedList.add(new RecentlyViewed("Сырға аюлар","Қолдан жасалған сырғалар, силиконды гипоаллергенді қалампырлары бар жоғары сапалы полимерлі саздан жасалған\n" +
                "Өлшемі 1,7 * 2 см\n" +
                "Өнім судан қорықпайды","850 тг","1","дана",R.drawable.card_syrgaaiu,R.drawable.syrgaaiu_full));
        recentlyViewedList.add(new RecentlyViewed("Сырға 'BOTEH RED'","Қолдан жасалған сырғалар силиконды гипоаллергенді қалампырлары бар жоғары сапалы полимерлі саздан жасалған.\n" +
                "Өлшемі 2,5 * 4,5 см\n" +
                "Құрамында химиялық және алкоголь бар құрамдардан аулақ болыңыз.","2000 тг","1","дана",R.drawable.card_syrgaboh,R.drawable.syrgaboh_full));
        setRecentlyRecycler();
    }

    private void setRecentlyRecycler() {    //  Тізімді recycler ге көшіру
        RecyclerView.LayoutManager  layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }

    private void setCategoryRecycler() {    //  Тізімді recycler ге көшіру
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setDiscountedRecycler(List<DiscountedProducts> dataList) { //  Тізімді recycler ге көшіру
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        discountedRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter =new DiscountedProductAdapter(this,dataList);
        discountedRecyclerView.setAdapter(discountedProductAdapter);
    }

}