package handle;

import entity.Account;

import java.util.Scanner;

public class AccountHandle {
    public Account inputAccount(Scanner scanner){
        System.out.println("Mời bạn nhập tên: ");
        String name = scanner.nextLine();

        System.out.println("Mời bạn nhập số tài khoản: ");
        int accountNumber = Integer.parseInt(scanner.nextLine());

        System.out.println("Mời bạn nhập email: ");
        String email = scanner.nextLine();

        System.out.println("Mời bạn nhập số dư tài khoản: ");
        double accountBalance = Double.parseDouble(scanner.nextLine());
        return new Account(name,accountNumber,email,accountBalance);
    }
}