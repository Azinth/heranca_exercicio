package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.util.*;

import static entities.UsedProduct.sdf;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        for (int i=1;i<=n;i++){

            System.out.println("Product #"+i+(" data: "));
            System.out.print("Common, user or imported (c/u/i)? ");
            char pType = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            if (pType == 'i'){
                System.out.print("Customs fee: ");
                Double cFee = sc.nextDouble();
                Product prod = new ImportedProduct(name,price, cFee);
                list.add(prod);
                System.out.println("");
            } else if (pType == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date mDate = sdf.parse(sc.next());
                Product prod = new UsedProduct(name, price, mDate);
                list.add(prod);
                System.out.println("");
            } else {
                Product prod = new Product(name, price);
                list.add(prod);
                System.out.println("");
            }
            }
        System.out.println("");
        System.out.println("PRICE TAGS: ");
        for (Product prod : list){
            System.out.println(prod.priceTag());
        }
        sc.close();
    }
}