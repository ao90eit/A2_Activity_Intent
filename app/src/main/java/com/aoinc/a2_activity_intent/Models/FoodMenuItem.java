package com.aoinc.a2_activity_intent.Models;

import java.io.Serializable;

public class FoodMenuItem implements Serializable {
    private int imageResourceID;
    private String foodName;
    private float foodPrice;
    private int foodAmount;
    private String specialInstructions;

    public FoodMenuItem(int imageResourceID, String foodName, float foodPrice, int foodAmount, String specialInstructions) {
        this.imageResourceID = imageResourceID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodAmount = foodAmount;
        this.specialInstructions = specialInstructions;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public float getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(float foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }
}
