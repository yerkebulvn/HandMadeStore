package com.example.handmadestore.model;

public class AllCategoryModel {  // Барлық категориялар класы. Осы арқылы барлық категорияның объектісі жасалады
    Integer id;
    Integer imageUrl;

    public AllCategoryModel(Integer id, Integer imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
