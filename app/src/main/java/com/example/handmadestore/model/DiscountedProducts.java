package com.example.handmadestore.model;

public class DiscountedProducts {   // Жеңілдіктер класы. Осы арқылы жеңілдіктің объектісі жасалады
    Integer id;
    Integer imageurl;

    public DiscountedProducts(Integer id, Integer imageurl) {
        this.id = id;
        this.imageurl = imageurl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageurl() {
        return imageurl;
    }

    public void setImageurl(Integer imageurl) {
        this.imageurl = imageurl;
    }
}
