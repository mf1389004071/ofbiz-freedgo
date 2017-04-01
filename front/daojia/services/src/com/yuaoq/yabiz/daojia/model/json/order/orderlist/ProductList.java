package com.yuaoq.yabiz.daojia.model.json.order.orderlist;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by changsy on 16/9/19.
 */
public class ProductList {
    public int sku;
    public int price;
    public int discountPrice;
    public String imgPath;
    public String shopId;
    public int num;
    public String name;
    public String orderId;
    public int skuCommentStatus;
    public int productCategory;
    public int promotionType;
    
    public static ProductList objectFromData(String str) {
        
        return new Gson().fromJson(str, ProductList.class);
    }
    
    public static ProductList objectFromData(String str, String key) {
        
        try {
            JSONObject jsonObject = new JSONObject(str);
            
            return new Gson().fromJson(jsonObject.getString(str), ProductList.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static List<ProductList> arrayProductListFromData(String str) {
        
        Type listType = new TypeToken<ArrayList<ProductList>>() {
        }.getType();
        
        return new Gson().fromJson(str, listType);
    }
    
    public int getSku() {
        return sku;
    }
    
    public void setSku(int sku) {
        this.sku = sku;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getDiscountPrice() {
        return discountPrice;
    }
    
    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }
    
    public String getImgPath() {
        return imgPath;
    }
    
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    
    public String getShopId() {
        return shopId;
    }
    
    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
    
    public int getNum() {
        return num;
    }
    
    public void setNum(int num) {
        this.num = num;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public int getSkuCommentStatus() {
        return skuCommentStatus;
    }
    
    public void setSkuCommentStatus(int skuCommentStatus) {
        this.skuCommentStatus = skuCommentStatus;
    }
    
    public int getProductCategory() {
        return productCategory;
    }
    
    public void setProductCategory(int productCategory) {
        this.productCategory = productCategory;
    }
    
    public int getPromotionType() {
        return promotionType;
    }
    
    public void setPromotionType(int promotionType) {
        this.promotionType = promotionType;
    }
}
