package handle;

import entity.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductHandle {
    public static List<Product> PRODUCTS = new ArrayList<Product>();

    /* Them moi san pham */
    public void insert() {
        Scanner inputs = new Scanner(System.in);
        System.out.println("Moi ban nhap thong tin san pham:");

        try {
            System.out.print("Ma: ");
            int id = Integer.parseInt(inputs.nextLine());

            System.out.println("Ten:");
            String name = inputs.nextLine();

            System.out.println("So luong:");
            int quantity = Integer.parseInt(inputs.nextLine());

            System.out.println("Ghi chu");
            String descreption = inputs.nextLine();

            System.out.println("Gia");
            Float price = inputs.nextFloat();

            Product p = new Product(id, name, quantity, descreption, price);
            ProductHandle.PRODUCTS.add(p);

        }catch (InputMismatchException e) {
            System.out.println(" Ban da nhap sai. Moi ban nhap lai :");
        }
    }

    /* Viet ham hien thi san pham */
    public void show() {
        System.out.println("Danh sach hien thi san pham");
        String header = String.format("%s%20s%20s%20s%20s", "Ma", "Ten", "Số lượng", "Gia", "Ghi chu");
        System.out.println(header);
        for (Product p: ProductHandle.PRODUCTS) {
            String row = String.format("%s%20s%20s%20s%20s",p.getId(),p.getName(),p.getQuantity(),p.getPrice(),p.getDescription());
            System.out.println(row);
        }
    }

    /* Viet ham sua san pham */
    public  void update() {
        Scanner inputs = new Scanner(System.in);
        try {
            System.out.println("Moi ban nhap ma san pham can sua:");
            Integer id = Integer.parseInt(inputs.nextLine());
            Product product = null;

            /* kiem tra xem nguoi dung nhap id co dung voi id cua san pham khong */
            for (Product p: ProductHandle.PRODUCTS){
                  if (p.getId().equals(id)){
                      product = p;
                      break;
                  }
            }
            if (product == null) {
                System.out.println("Ma san pham khong ton tai, xin vui long nhap lai:");
            }

            /* hien thi ra thong tin san pham sau khi nhap dung id */
            System.out.println("Thong tin san pham:");
            String header = String.format("%s%20s%20s%20s%20s", "Ma", "Ten", "Số lượng", "Gia", "Ghi chu");
            System.out.println(header);
            String row = String.format("%s%20s%20s%20s%20s",product.getId(),product.getName(),product.getQuantity(),product.getPrice(),product.getDescription());
            System.out.println(row);

            /* thay doi thong tin san pham */
            for (int i = 0; i < ProductHandle.PRODUCTS.size() ; i++) {
                if (id.equals(ProductHandle.PRODUCTS.get(i).getId())) {
                    System.out.println("Ten:");
                    String name = inputs.nextLine();

                    System.out.println("So luong:");
                    int quantity = Integer.parseInt(inputs.nextLine());

                    System.out.println("Ghi chu");
                    String descreption = inputs.nextLine();

                    System.out.println("Gia");
                    Float price = inputs.nextFloat();

                    ProductHandle.PRODUCTS.get(i).setName(name);
                    ProductHandle.PRODUCTS.get(i).setQuantity(quantity);
                    ProductHandle.PRODUCTS.get(i).setDescription(descreption);
                    ProductHandle.PRODUCTS.get(i).setPrice(price);
                }
            }



        }catch (InputMismatchException e) {
            System.out.println(" Ban da nhap sai. Moi ban nhap lai gia tri la 1 so nguyen duong tu 1-7");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Product getById(int id) {
        Product product = new Product();
        for (Product p: ProductHandle.PRODUCTS){
            if (p.getId().equals(id)){
                product = p;
                break;
            }
        }
        return product;
    }
}
