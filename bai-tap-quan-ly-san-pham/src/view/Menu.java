package view;

import entity.Product;
import handle.Input;
import handle.ProductHandle;

import java.util.List;
import java.util.Scanner;

public class Menu {
    Input inputControl = new Input();
    Scanner sc = new Scanner(System.in);

    public int inputMain(Scanner sc) {
        System.out.println("Nhap lua chon cua ban (1-8):");
        System.out.println("1: Them san pham.");
        System.out.println("2: Xem danh sach san pham.");
        System.out.println("3: Tim san pham theo ten.");
        System.out.println("4: Tim san pham theo id.");
        System.out.println("5: Tim san pham co so luong <n.");
        System.out.println("6: Tim san pham theo muc gia.");
        System.out.println("7: Sap xep danh sach san pham.");
        System.out.println("8: Exit.");

        return inputControl.getInput(sc, 1, 8);
    }

    public int inputPrice(Scanner sc) {
        System.out.println("Chon muc gia can filter (1-4):");
        System.out.println("1: Duoi 50,000.");
        System.out.println("2: Tu 50,000 den duoi 100,000.");
        System.out.println("3: Tu 100,000 tro len.");
        System.out.println("4: Thoat ra.");

        return inputControl.getInput(sc, 1, 4);
    }

    public int inputField(Scanner sc) {
        System.out.println("Lua chon truong de sap xep (1-7):");
        System.out.println("1: Theo Id.");
        System.out.println("2: Theo ten.");
        System.out.println("3: Theo mo ta.");
        System.out.println("4: Theo don vi tinh.");
        System.out.println("5: Theo so luong.");
        System.out.println("6: Theo gia.");
        System.out.println("7: Thoat ra.");

        return inputControl.getInput(sc, 1, 7);
    }

    public int inputSortDirection(Scanner sc) {
        System.out.println("Lua chon thu tu sap xep (1-2):");
        System.out.println("1: Tang dan.");
        System.out.println("2: Giam dan.");

        return inputControl.getInput(sc, 1, 2);
    }

    public void callMainMenu(ProductHandle productHandle, List<Product> products) {
        int input = inputMain(sc);
        while (input != 8) {
            // Xu ly tung lua chon
            switch (input) {
                case 1: {
                    productHandle.addRecords(sc, inputControl, products);
                    break;
                }
                case 2: {
                    productHandle.displayAll(products);
                    break;
                }
                case 3: {
                    productHandle.searchByName(sc, products);
                    break;
                }
                case 4: {
                    productHandle.searchById(sc, inputControl, products);
                    break;
                }
                case 5: {
                    productHandle.searchByMaxQuantity(sc, inputControl, products);
                    break;
                }
                case 6: {
                    int inputPrice = inputPrice(sc);
                    while (inputPrice != 4) {
                        // Thực hiện tìm kiếm
                        productHandle.searchByPrice(products, inputPrice);
                        // Sau khiu tìm kếm call lại menu chọn mức giá
                        inputPrice = inputPrice(sc);
                    }
                    break;
                }
                case 7: {
                    int inputField = inputField(sc);
                    while (inputField!= 7) {
                        // Chọn thứ tự săp xếp
                        int sortDirection = inputSortDirection(sc);
                        // Thực hiện sắp xếp
                        productHandle.sortArray(products, inputField, sortDirection);
                        // Sawu khi sắp xếp call lại menu chọn Field cần sắp xếp
                        inputField = inputField(sc);
                    }
                    break;
                }
                case 8: {
                    //Exit
                    break;
                }
            }
            // Call lại main menu
            input = inputMain(sc);
        }
    }
}
