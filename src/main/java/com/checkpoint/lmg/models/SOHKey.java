package com.checkpoint.lmg.models;

public class SOHKey {
    String site;
    String product;

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

    public SOHKey() {
    }

    public SOHKey(String site, String product) {
        this.site = site;
        this.product = product;
    }
}
