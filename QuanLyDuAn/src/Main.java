import entity.Order;
import entity.Product;
import handle.OrderHandle;
import handle.ProductHandle;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
/* Tao mot menu cho nguoi dung chon */
    public static void menu() {
        System.out.println("-------------Danh sach chuc nang--------------");
        System.out.println("1. Them moi san pham");
        System.out.println("2. Hien thi san pham");
        System.out.println("3. Sua san pham");
        System.out.println("4. Mua hang");
        System.out.println("5. Hien thi danh sach don hang");
        System.out.println("6. Thoat");
    }

    public static void main ( String[] args) {
        int function = 0;
        do {
            Scanner inputs =new Scanner(System.in);
            menu();

            try {
                System.out.print("Moi ban chon chuc nang:");
                function = inputs.nextInt();

                ProductHandle productHandle = new ProductHandle();

                OrderHandle orderHandle = new OrderHandle();

                switch (function){
                    case 1:
                        productHandle.insert();
                        break;

                    case 2:
                        productHandle.show();
                        break;

                    case 3:
                        productHandle.update();
                        break;

                    case 4:
                        orderHandle.order();
                        break;

                    case 5:
                        orderHandle.show();
                        break;

                    default:
                        break;
                    }
            }catch (InputMismatchException e) {
                System.out.println(" Ban da nhap sai. Moi ban nhap lai gia tri la 1 so nguyen duong tu 1-7");
                }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while (function != 7);
        System.out.println("Cam on ban da su dung phan mem");

    }
}
