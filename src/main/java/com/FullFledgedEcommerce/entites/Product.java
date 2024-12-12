package com.FullFledgedEcommerce.entites;



public class Product {

    private Long id;

    private String name;

    private String price;

    private String description;

    private Long userid;

    public Product() {
    }

    public Product(Long userid, Long id, String name, String price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.userid = userid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
