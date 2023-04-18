import java.util.ArrayList;
import java.util.Scanner;


public class Account {
    String userName;
    String email;
    String password;

    public Account() {
    }

    public Account(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void inputUserName(Scanner scan, ArrayList<Account> arrayAccount) {
        boolean flag;
        do {
            flag = false;
            System.out.print("Nhap username: ");
            this.userName = scan.nextLine();
            if (arrayAccount!=null) {
                for (int i = 0; i < arrayAccount.size(); i++) {
                    if (arrayAccount.get(i).getUserName().equals(this.userName)) {
                        System.out.println("Username da ton tai vui long nhap lai!!!");
                        flag = true;
                        break;
                    }
                }
            }
        } while (flag);
    }

    public void inputEmail(Scanner scan, ArrayList<Account> arrayAccount) {
        boolean flag;
        do {
            flag = false;
            do {
                System.out.print("Nhap email: ");
                this.email = scan.nextLine();
                if (this.email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$") == false) {
                    System.out.println("Vui long nhap lai email ( email@dotmain.com)");
                }
            } while (this.email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$") == false);
            if (arrayAccount!=null) {
                for (int i = 0; i < arrayAccount.size(); i++) {
                    if (arrayAccount.get(i).getEmail().equals(this.email)) {
                        System.out.println("Email da ton tai vui long nhap lai!!!");
                        flag = true;
                        break;
                    }
                }
            }
        } while (flag);
    }

    public void inputPassword(Scanner scan, ArrayList<Account> arrayAccount) {
        do {
            System.out.print("Nhap password: ");
            this.password = scan.nextLine();
            if (this.password.matches("((?=.*[a-z])(?=.*[A-Z])(?=.*[(.,_;)]).{7,15})") == false) {
                System.out.println("Vui long nhap lai password (Pass gồm 7-15 ký tự, có chữa ký tự in hoa in thường và ký tự đặc biệt (. , - _ ;) ");
            }
        } while (this.password.matches("((?=.*[a-z])(?=.*[A-Z])(?=.*[(.,_;)]).{7,15})") == false);
    }
}
