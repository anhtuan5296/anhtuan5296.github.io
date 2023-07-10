package entity;

import service.IAccount;

import java.util.Scanner;

public class Account implements IAccount {
    private String name;
    private int accountNumber;
    private String email;
    private double accountBalance;

    public Account(String name, int accountNumber, String email, double accountBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.email = email;
        this.accountBalance = accountBalance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void recharge(Scanner scanner) {
        System.out.println("Mời bạn nhập số tiền muốn nạp: ");
        double amount = Double.parseDouble(scanner.nextLine());
        double acountBalanceNew = accountBalance + amount;
        System.out.println("Số dư tài khoản là: " + acountBalanceNew);
    }

    @Override
    public void email(Scanner scanner) {
        System.out.println("Mời bạn nhập email muốn đổi: ");
        String emailNew = scanner.nextLine();
        setEmail(emailNew);
        System.out.println("Đã cập nhật thành công.");
    }

    @Override
    public void displayInfor(Scanner scanner) {
        System.out.println("Thông tin tài khoản là: " + name + " " + accountNumber + " " +email +  " " + accountBalance );
    }
}