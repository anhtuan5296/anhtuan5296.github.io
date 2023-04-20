import entity.Account;
import handle.AccountHandle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountHandle accountHandle = new AccountHandle();
        Account account = accountHandle.inputAccount(scanner);
        account.recharge(scanner);
        account.email(scanner);
        account.displayInfor(scanner);

    }
}