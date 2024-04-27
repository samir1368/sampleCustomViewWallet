package com.example.myapplication.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Wallet { // It's just sample class
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("type")
    @Expose
    public String type;
}
