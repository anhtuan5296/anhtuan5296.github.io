package view;

import java.util.Scanner;

public class Menu {
    public int menuInput(Scanner scanner){
        System.out.println("Nhap lua chon cua ban");
        System.out.println("1 - xuất danh sách nhân viên");
        System.out.println("2 - Xóa nhân viên theo id");
        System.out.println("3 - Cập nhật thông tin nhân viên theo id");
        System.out.println("4 - Tìm kiếm nhân viên theo lương");
        System.out.println("0 - Thoat chuong trinh");
        return Integer.parseInt(scanner.nextLine());
    }
}
