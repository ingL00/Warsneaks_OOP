package com.crud_oop;

public interface Transaction {
    void restock(String nama, String brand, String harga, String qty);
    void check_stock();
    void update_stock(String index, String nama, String brand, String harga, String qty);
    void beli(String index);
}
