package handle;

import entity.Employee;
import view.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuHandle {
//        xu li menu
    public void menuHandle(int choice ,Scanner scanner, ArrayList<Employee> arrayList){
        Menu menu = new Menu();
        if (choice == 1){
            System.out.println(arrayList);
        }
        else if (choice == 2){
            MenuHandle.deleteEmployee(scanner,arrayList);
        }
        else if (choice == 3){
            MenuHandle.updateEmployee(scanner,arrayList);
        }
        else if (choice == 4){
            MenuHandle.findEmployeeBySalary(scanner,arrayList);
        }
        else if (choice == 0){
            System.exit(0);
        }
        else{
            System.out.println("Nhap tu 1 den 4 thoi");
            menuHandle(menu.menuInput(scanner),scanner,arrayList);
        }
    }
//    xoa nhan vien theo id
    static void deleteEmployee(Scanner scanner, ArrayList<Employee> arrayList){
        System.out.println("Nhap id nhan vien muon xoa");
        int id = scanner.nextInt();
        for (Employee employee : arrayList) {
            if (employee.getId()==id) {
                arrayList.remove(employee);
            }
            else {
                System.out.println("Khong tim thay nhan vien");
            }
        }
    }
//       cap nhap thong tin theo id
    static void updateEmployee(Scanner scanner, ArrayList<Employee> arrayList){
        System.out.println("Cap nhap thong tin nhan vien theo id: ");
        System.out.println("Nhap id nhan vien muon cap nhap");
        int id = Integer.parseInt(scanner.nextLine());
        for (Employee employee : arrayList) {
            if (employee.getId()==id) {
                EmployeeHandle employeeHandle = new EmployeeHandle();
                arrayList.set(id, employeeHandle.employeeInput(scanner));
            }
            else {
                System.out.println("Khong tim thay nhan vien");
            }
        }
    }
//     tim nhan vien theo luong
    static void findEmployeeBySalary(Scanner scanner, ArrayList<Employee> arrayList){
        System.out.println("Nhap luong cua nhan vien muon tim");
        double salary = Double.parseDouble(scanner.nextLine());
        for (Employee employee : arrayList) {
            if (employee.getSalary()==salary) {
                System.out.println(employee);
            }
            else {
                System.out.println("Khong co nhan vien nao");}
        }
    }
}
