package com.checkpoint.lmg.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "soh")
public class SOHModel {

    @Id
    ObjectId _id;

    @Indexed
    SOHKey key;

    Double qty;
    Double price;

    public SOHModel() {

    }

    public SOHModel(SOHKey key, Double qty, Double price) {
        this.key = key;
        this.qty = qty;
        this.price = price;
    }

    public SOHKey getKey() {
        return key;
    }

    public void setKey(SOHKey key) {
        this.key = key;
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
}
