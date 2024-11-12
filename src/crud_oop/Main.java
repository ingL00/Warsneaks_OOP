package crud_oop;
import java.util.ArrayList;
import java.util.Scanner;

interface Transaction{
    void restock(String nama, String brand, String harga, String qty);
    void check_stock();
    void update_stock(String index, String nama, String brand, String harga, String qty);
    void beli(String index);
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Warsneaks stock = new Warsneaks();

        // Switch Case Temporary Parameter
        String choose_index = "";
        String temp_nama = "";
        String temp_brand = "";
        String temp_harga = "";
        String temp_qty = "";

        // Initial Stock
        stock.restock("Gel Lyte III", "Asics", "3200", "1");
        stock.restock("Vapor Fly", "Nike", "5000", "1");
        stock.restock("Air Tuban III", "Nike", "10200", "1");
        stock.restock("Cloud 5", "On Cloud", "3000", "1");
        stock.restock("Predito", "Adidas", "3200", "1");
        stock.restock("Chuck Taylor", "Converse", "700", "1");
        stock.restock("Classic Slip-on", "Vans", "1200", "1");
        stock.restock("Vapor Fly", "Nike", "5000", "1");
        stock.restock("Gel Lyte III", "Asics", "3200", "1");
        stock.restock("Vapor Fly", "Nike", "5000", "1");

        String menu = "9999999";
        do{
            clrScreen();
            stock.check_stock();
            System.out.println("Pilih Menu: ");
            System.out.println("1. Restock Sepatu");
            System.out.println("2. Update Stock Sepatu");
            System.out.println("3. Sepatu Terbeli");
            System.out.println("0. Exit");
            System.out.print(">> ");
            menu = scan.nextLine();
            switch (menu){
                case "1":
                    // Add Sepatu
                    if (stock.getStockSepatu().size() >= 10){
                        penuh();
                        scan.nextLine();
                        break;
                    }
                    System.out.printf("%-18s", "Nama sepatu:");
                    temp_nama = scan.nextLine();
                    System.out.printf("%-18s", "Brand sepatu:");
                    temp_brand = scan.nextLine();
                    System.out.printf("%-18s", "Harga sepatu:");
                    temp_harga = scan.nextLine();
                    System.out.printf("%-18s", "Jumlah sepatu:");
                    temp_qty = scan.nextLine();
                    stock.restock(temp_nama, temp_brand, temp_harga, temp_qty);
                    temp_nama = ""; temp_brand = "";temp_harga = "";temp_qty = ""; // fflush stdin
                    System.out.println("Add Sepatu");
                    break;
                case "2":
                    // Update Sepatu
                    System.out.println("Update Sepatu");
                    System.out.printf("Pilih sepatu nomor berapa yang akan di Update? ");
                    choose_index = scan.nextLine();
                    System.out.printf("%-18s:", "Nama sepatu");
                    temp_nama = scan.nextLine();
                    System.out.printf("%-18s:", "Brand sepatu");
                    temp_brand = scan.nextLine();
                    System.out.printf("%-18s:", "Harga sepatu");
                    temp_harga = scan.nextLine();
                    System.out.printf("%-18s:", "Jumlah sepatu");
                    temp_qty = scan.nextLine();
                    stock.update_stock(choose_index, temp_nama, temp_brand, temp_harga, temp_qty);
                    choose_index = "";temp_nama = ""; temp_brand = "";temp_harga = "";temp_qty = ""; // fflush stdin
                    break;
                case "3":
                    // Beli Sepatu
                    System.out.println("Beli Sepatu");
                    System.out.printf("Pilih sepatu nomor berapa yang akan di Beli? ");
                    choose_index = scan.nextLine();
                    stock.beli(choose_index);
                    choose_index = "";
                    break;
                case "0":
                    // Exit
                    System.out.println("Exit");
                    menu = "0";
                    break;
                default:
                    System.out.println("Pilih 1, 2, 3, 4 atau 0");
            }
        }while(!menu.equals("0"));
    }
    public static void clrScreen(){
        for(int i = 0 ; i<33; i++){
            System.out.println();
        }
    }

    public static void penuh(){
        System.out.println("d8888b. d88888b d8b   db db    db db   db      d888b   .d88b.  d8888b. db       .d88b.  db   dD ");
        System.out.println("88  `8D 88'     888o  88 88    88 88   88     88' Y8b .8P  Y8. 88  `8D 88      .8P  Y8. 88 ,8P' ");
        System.out.println("88oodD' 88ooooo 88V8o 88 88    88 88ooo88     88      88    88 88oooY' 88      88    88 88,8P   ");
        System.out.println("88~~~   88~~~~~ 88 V8o88 88    88 88~~~88     88  ooo 88    88 88~~~b. 88      88    88 88`8b   ");
        System.out.println("88      88.     88  V888 88b  d88 88   88     88. ~8~ `8b  d8' 88   8D 88booo. `8b  d8' 88 `88. ");
        System.out.println("88      Y88888P VP   V8P ~Y8888P' YP   YP      Y888P   `Y88P'  Y8888P' Y88888P  `Y88P'  YP   YD ");
    }
}
