package com.crud_oop;
import java.util.ArrayList;

public class Warsneaks implements Transaction{
    private ArrayList<Sepatu> stockSepatu;
    private int maxWidth;

    public Warsneaks(){
        this.stockSepatu = new ArrayList<>();
        this.maxWidth = maxWidth;
    }

    public int getMaxWidth(){
        return maxWidth;
    }

    public void setMaxWidth(int maxWidth){
        this.maxWidth = maxWidth;
    }

    public ArrayList<Sepatu> getStockSepatu(){
        return stockSepatu;
    }

    @Override
    public void restock(String nama, String brand, String harga, String qty){
        stockSepatu.add(new Sepatu(nama, brand, Integer.parseInt(harga), Integer.parseInt(qty)));
    }

    @Override
    public void check_stock(){
        findMaxLength();
        printBorder();
        System.out.printf("|%3s |%-"+this.maxWidth+"s |%-"+this.maxWidth+"s |%-"+this.maxWidth+"s |%-"+this.maxWidth+"s |", "No.","Nama", "Brand", "Harga", "Quantity");
        System.out.println();
        printBorder();
        printRow(this.stockSepatu, this.maxWidth);
        printBorder();
    }

    @Override
    public void update_stock(String index, String nama, String brand, String harga, String qty){
        stockSepatu.set(Integer.parseInt(index)-1, new Sepatu(nama, brand, Integer.parseInt(harga), Integer.parseInt(qty)));
    }

    @Override
    public void beli(String index) {
        stockSepatu.remove(Integer.parseInt(index) - 1);
    }

    public void findMaxLength(){
        for(int i = 0; i < this.stockSepatu.size(); i++){
            if ( this.stockSepatu.get(i).getNama().length() > this.maxWidth ){
                this.maxWidth = this.stockSepatu.get(i).getNama().length();
            }
            if(this.stockSepatu.get(i).getBrand().length() > this.maxWidth){
                this.maxWidth = this.stockSepatu.get(i).getBrand().length();
            }
        }
    }

    public void hapus(){
        stockSepatu.clear();
    }

    public void printBorder(){
        System.out.print("+");
        System.out.print("-".repeat(4)+"+");
        for(int i = 0; i < 4; i++){
            System.out.print("-".repeat(this.maxWidth + 1) + "+");
        }

        System.out.println();
    }

    public void printRow(ArrayList<Sepatu> stockSepatu, int maxWidth){
        for(int i = 0; i < stockSepatu.size(); i++){
            System.out.printf("|%-4s|%-"+maxWidth+"s |%-"+maxWidth+"s |%-"+maxWidth+"s |%-"+maxWidth+"s |", Integer.toString(i+1)+".", stockSepatu.get(i).getNama(), stockSepatu.get(i).getBrand(), stockSepatu.get(i).getHarga(), stockSepatu.get(i).getQty());
            System.out.println();
        }
    }
}
