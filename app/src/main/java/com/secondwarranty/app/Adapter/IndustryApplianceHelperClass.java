package com.secondwarranty.app.Adapter;

public class IndustryApplianceHelperClass {

    int image;
    String name_of_product;

    public IndustryApplianceHelperClass(int image, String name_of_product) {
        this.image = image;
        this.name_of_product = name_of_product;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName_of_product() {
        return name_of_product;
    }

    public void setName_of_product(String name_of_product) {
        this.name_of_product = name_of_product;
    }
}
