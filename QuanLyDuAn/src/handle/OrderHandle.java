package handle;
import entity.OrderDetail;


import entity.Order;
import entity.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OrderHandle {
    /* Tao ra collections luu lai danh sach cac don dat hang */
    public static List<Order> ORDERS = new ArrayList<Order>();

    /* Hien thi phan mua hang */
    public void order() {
        Scanner inputs = new Scanner(System.in);
        System.out.println(" ---------------Moi ban mua san pham--------------");
        try {
            System.out.print("Moi ban nhap ma dat hang:");
            int id = Integer.parseInt(inputs.nextLine());

            System.out.println(" Moi ban nhap ten khach hang");
            String customerName = inputs.nextLine();

            System.out.println("Moi  ban nhap so dien thoai khach hang");
            String phone = inputs.nextLine();

            System.out.println("Moi ban nhap email khach hang");
            String email = inputs.nextLine();


            Order order = new Order (id, customerName, phone, email);

            /* Cho nguoi dung nhap cac ban pham */
            Integer productId = -1;

           while (true) {
                inputs = new Scanner(System.in);
                System.out.println("Moi ban Nhap ma san pham (Nhap -1 de ket thuc):");
                productId = inputs.nextInt();

                if (productId.equals(-1)) {
                    break;
                }
                System.out.println("Moi ban nhap so luong:");
               int quantity = inputs.nextInt();

//          Kiem tra ma san pham nhap vao co ton tai khong
                Product product = null;
                for (Product p: ProductHandle.PRODUCTS) {
                    if (p.getId().equals(productId)){
                        product = p;
                        break;
                    }
                }
                if (product == null){
                    System.out.println("Ma san pham khong ton tai");
                }

                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setId(1);
                orderDetail.setOrderId(order.getId());
                orderDetail.setPrice(product.getPrice());
                orderDetail.setProductId(productId);
                orderDetail.setQuantity(quantity);

                order.getOrderDetails().add(orderDetail);

            }

                OrderHandle.ORDERS.add(order);


        }catch (InputMismatchException e) {
            System.out.println(" Ban da nhap sai. Moi ban nhap lai gia tri la 1 so nguyen duong tu 1-7");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void show() {
        System.out.println("Danh sach dat hang");
        String header = String.format("%s%20s%20s%20s", "Ma", "Ten khach hang", "Số dien thoai", "Email");
        System.out.println(header);
        ProductHandle productHandle = new ProductHandle();

        for (Order order: OrderHandle.ORDERS) {

            String row = String.format("%s%20s%20s%20s",order.getId(),order.getCustomerName(),order.getPhone(),order.getEmail());
            System.out.println(row);

            String orderDetailHeader = String.format("%30s%20s%20s%20s", "STT", "Ten san pham", "Gia", "So luong");
            System.out.println(orderDetailHeader);

            int i=1 ;
            for (OrderDetail od: order.getOrderDetails()) {

                Product p = productHandle.getById(od.getProductId());

               String orderDetailRow= String.format("%30s%20s%20s%20s", i , p.getName(), od.getPrice(), od.getQuantity());
                System.out.println(orderDetailRow);
               i++;

            }
        }
    }
}
