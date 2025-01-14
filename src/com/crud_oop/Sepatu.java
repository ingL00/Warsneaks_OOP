package com.crud_oop;

public class Sepatu{
    String nama;
    String brand;
    int harga;
    int qty;

    public Sepatu(String nama, String brand, int harga, int qty){
        this.nama = nama;
        this.brand = brand;
        this.harga = harga;
        this.qty = qty;
    }

    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public int getHarga(){
        return harga;
    }
    public void setHarga(int harga){
        this.harga = harga;
    }
    public int getQty(){
        return qty;
    }
    public void setQty(int qty){
        this.qty = qty;
    }
}

