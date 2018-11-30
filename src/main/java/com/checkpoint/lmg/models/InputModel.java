package com.checkpoint.lmg.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputModel {

    @JsonProperty("site")
    private String site;
    @JsonProperty("product")
    private String product;
    @JsonProperty("qty")
    private Double qty;
    @JsonProperty("price")
    private Double price;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public SOHModel convertToDBModel() {
        SOHKey key = new SOHKey(site, product);
        SOHModel model = new SOHModel(key, qty, price);
        return model;
    }
}