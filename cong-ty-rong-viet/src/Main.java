import entity.Employee;
import handle.EmployeeHandle;
import handle.MenuHandle;
import view.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> arrayList = new ArrayList<>();
        EmployeeHandle employeeHandle = new EmployeeHandle();
        MenuHandle menuHandle = new MenuHandle();
        Menu menu = new Menu();
        System.out.println("Nhap so nhan vien");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n ; i++) {
            Employee employee = employeeHandle.employeeInput(scanner);
            employeeHandle.checkSalary(scanner, employee);
            arrayList.add(employee);
        }
        menuHandle.menuHandle(menu.menuInput(scanner),scanner,arrayList);
    }
}