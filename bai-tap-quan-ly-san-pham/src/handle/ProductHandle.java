package handle;

import entity.Product;

import java.text.Collator;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductHandle {
    //Thêm n sản phẩm vòa danh sách
    public void addRecords(Scanner sc, Input inputControl, List<Product> products) {
        System.out.println("Nhap so san pham muon them vao:");
        int n = inputControl.getInput(sc, 0, null);
        for (int i = 0; i < n; i++) {
            Product product = create(sc, inputControl, i);
            /*add sản phẩm i vao array list*/
            products.add(product);
        }
    }

    // Khởi tạo 1 sản phẩm và trả về dạng product
    public Product create(Scanner sc, Input inputControl, int i) {

        System.out.println("Nhap ten san pham thu " + (i + 1) + ": ");
        String name = sc.nextLine();

        System.out.println("Nhap mo ta san pham thu " + (i + 1) + ": ");
        String description = sc.nextLine();

        System.out.println("Nhap don vi san pham thu " + (i + 1) + ": ");
        String unit = sc.nextLine();

        System.out.println("Nhap so luong cua san pham thu " + (i + 1) + ": ");
        int quantity = inputControl.getInput(sc, 0, null);

        System.out.println("Nhap gia cua san pham thu " + (i + 1) + ": ");
        double price = inputControl.getInput(sc, 0, null);

        // Khởi tọa bản ghi theo dạng tham số
        Product product = new Product(name, description, unit, quantity, price);

        // Trả về bản ghi
        return product;
    }

    //Liệt kê toàn bộ sản phẩm trong list
    public void displayAll(List<Product> products) {
        System.out.println("Danh sach san pham nhu sau:");
        for (Product pr : products) {
            System.out.println(pr);
        }
    }

    // Tìm sản phẩm theo tên
    public void searchByName(Scanner sc, List<Product> products) {
        System.out.println("Nhap ten san pham can tim:");
        String name = sc.nextLine();
        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equalsIgnoreCase(name)) {
                count++;
                System.out.println(products.get(i));
            }
        }
        if (count == 0) {
            System.out.println("Khong tim thay san pham ten '" + name + "'.");
        }
    }

    // Tìm sản phẩm theo id và cập nhật số lượng sản phẩm
    public void searchById(Scanner sc, Input inputControl, List<Product> products) {
        System.out.println("Nhap id san pham can tim:");
        int id = inputControl.getInput(sc, 1, null);

        //Do id là unique nên dùng try catch để không phải loop hết toàn bộ
        try {
            System.out.println(products.get(id-1));
            System.out.println("Cap nhat so luong cho san pham " + id + ":");
            products.get(id-1).setQuantity(inputControl.getInput(sc, 0, null));
            //Cập nhật số lượng và in ra bản ghi sau khi cập nhật
            System.out.println("San pham sau khi cap nhat so luong:");
            System.out.println(products.get(id-1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Khong tim thay san pham id '" + id + "'.");
        }
    }

    //Tìm sản phẩm theo số lượng tối đa
    public void searchByMaxQuantity(Scanner sc, Input inputControl, List<Product> products) {
        System.out.println("Nhap so luong san pham toi da:");
        int maxQuantity = inputControl.getInput(sc, 1, null);
        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getQuantity() < maxQuantity) {
                count++;
                System.out.println(products.get(i));
            }
        }
        if (count == 0) {
            System.out.println("Khong tim thay san pham nao.");
        }

    }

    //Tìm sản phẩm theo mức giá
    public void searchByPrice(List<Product> products, int input) {

        for (int i = 0; i < products.size(); i++) {
            if (input == 1 && products.get(i).getPrice() < 50000) {
                System.out.println(products.get(i));
            } else if (input == 2 && products.get(i).getPrice() >= 50000 && products.get(i).getPrice() < 100000) {
                System.out.println(products.get(i));
            } else if (input == 3 && products.get(i).getPrice() >= 100000) {
                System.out.println(products.get(i));
            } else {
            }
            ;
        }
        if (products.size() == 0) {
            System.out.println("Khong tim thay san pham nao.");
        }
    }

    public void sortArray(List<Product> products, int field, int direction) {
        switch (direction) {
            // sắp xếp tăng dần
            case 1: {
                int count = 1;
                while (count>0) {
                    count = 0;
                    for (int i = 0; i < products.size() - 1; i++) {
                        switch (field) {
                            // theo ID
                            case 1: {
                                if (products.get(i).getId() > products.get(i + 1).getId()) {
                                    count++;
                                    Collections.swap(products, i, i + 1);
                                }
                                break;
                            }
                            // theo name
                            case 2: {
                                if (compareString(products.get(i).getName(), products.get(i + 1).getName()) > 0) {
                                    count++;
                                    Collections.swap(products, i, i + 1);
                                }
                                break;
                            }
                            // theo description
                            case 3: {
                                if (compareString(products.get(i).getDescription(), products.get(i + 1).getDescription()) > 0) {
                                    count++;
                                    Collections.swap(products, i, i + 1);
                                }
                                break;
                            }
                            // theo unit
                            case 4: {
                                if (compareString(products.get(i).getUnit(), products.get(i + 1).getUnit()) > 0) {
                                    count++;
                                    Collections.swap(products, i, i + 1);
                                }
                                break;
                            }
                            // theo quantity
                            case 5: {
                                if (products.get(i).getQuantity() > products.get(i + 1).getQuantity()) {
                                    count++;
                                    Collections.swap(products, i, i + 1);
                                }
                                break;
                            }
                            // theo price
                            case 6: {
                                if (products.get(i).getPrice() > products.get(i + 1).getPrice()) {
                                    count++;
                                    Collections.swap(products, i, i + 1);
                                }
                                break;
                            }
                        }
                    }
                }
                break;
            }
            // Sắp xếp giảm dần
            case 2: {
                int count = 1;
                while (count>0) {
                    count = 0;
                    for (int i = 0; i < products.size() - 1; i++) {
                        switch (field) {
                            // theo Id
                            case 1: {
                                if (products.get(i).getId() < products.get(i + 1).getId()) {
                                    count++;
                                    Collections.swap(products, i, i + 1);
                                }
                                break;
                            }
                            // theo name
                            case 2: {
                                if (compareString(products.get(i).getName(), products.get(i + 1).getName()) < 0) {
                                    count++;
                                    Collections.swap(products, i, i + 1);
                                }
                                break;
                            }
                            // theo description
                            case 3: {
                                if (compareString(products.get(i).getDescription(), products.get(i + 1).getDescription()) < 0) {
                                    count++;
                                    Collections.swap(products, i, i + 1);
                                }
                                break;
                            }
                            // theo unit
                            case 4: {
                                if (compareString(products.get(i).getUnit(), products.get(i + 1).getUnit()) < 0) {
                                    count++;
                                    Collections.swap(products, i, i + 1);
                                }
                                break;
                            }
                            // theo quantity
                            case 5: {
                                if (products.get(i).getQuantity() < products.get(i + 1).getQuantity()) {
                                    count++;
                                    Collections.swap(products, i, i + 1);
                                }
                                break;
                            }
                            // theo price
                            case 6: {
                                if (products.get(i).getPrice() < products.get(i + 1).getPrice()) {
                                    count++;
                                    Collections.swap(products, i, i + 1);
                                }
                                break;
                            }
                        }
                    }
                }
                break;
            }
        }
        System.out.println("Hoan thanh sap xep.");
    }

    public int compareString(String string1, String string2) {

        if (string1 == null && string2 != null) {
            return 1;
        } else if (string1 != null && string2 == null) {
            return -1;
        } else if (string1 == null && string2 == null) {
            return 0;
        } else {
            // Khởi tạo Collator
            Collator col = Collator.getInstance();

            // Trả về so sánh
            return col.compare(string1, string2);
        }
    }
}
