import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    private ArrayList<Account> arrayAccount;

    public Program() {
        arrayAccount=new ArrayList<Account>();
    }

    public Program(ArrayList<Account> arrayAccount) {
        this.arrayAccount = arrayAccount;
    }

    public ArrayList<Account> getArrayAccount() {
        return arrayAccount;
    }

    public void setArrayAccount(ArrayList<Account> arrayAccount) {
        this.arrayAccount = arrayAccount;
    }


    public void logIn(Scanner scan) {
        String userName, password;
        boolean flag;
        do {
            flag = true;
            System.out.print("Nhap username: ");
            userName = scan.nextLine();
            if(this.arrayAccount==null){
                System.out.println("Vui long tao tai khoan truoc");
                return;
            }
            for (int i = 0; i < this.arrayAccount.size(); i++) {
                if (this.arrayAccount.get(i).getUserName().equals(userName)) {
                    flag = false;
                }
            }
            if(flag==true){
                System.out.print("Kiem tra lai username!!!");
                return;
            }
        } while (flag);
        System.out.print("Nhap password: ");
        password = scan.nextLine();
        for (int i = 0; i < this.arrayAccount.size(); i++) {
            if (this.arrayAccount.get(i).getUserName().equals(userName) &&
                    this.arrayAccount.get(i).getPassword().equals(password)) {
                success(i);
                break;
            }
        }
        do {
            subMenu();
            switch (Integer.parseInt(scan.nextLine())) {
                case 1:
                    logIn(scan);
                    break;
                case 2:
                    forgotPass(scan, this.arrayAccount);
                    break;
                default:
                    System.out.println("Khong hop le vui long chon lai.");
            }
        } while (flag);

    }

    public void register(Scanner scan) {
        Account account=new Account();
        account.inputUserName(scan,this.arrayAccount);
        account.inputEmail(scan,arrayAccount);
        account.inputPassword(scan,arrayAccount);
        this.arrayAccount.add(account);
    }

    private static void successMenu(String userName) {
        System.out.println("=== Chao mung " + userName + ", ban co the thuc hien cac cong viec sau ===========");
        System.out.println("1.  Thay doi username");
        System.out.println("2.  Thay doi email");
        System.out.println("3.  Thay doi mat khau");
        System.out.println("4.  Dang xuat");
        System.out.println("0.  Thoat chuong trinh");
        System.out.println("Moi chon: ");
    }

    private static void subMenu() {
        System.out.println("1.  Dang nhap lai");
        System.out.println("2.  Quen mat khau");
        System.out.println("Moi chon: ");
    }

    public void success(int i) {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        Account account1 = new Account();
        do {
            successMenu(this.arrayAccount.get(i).getUserName());
            switch (Integer.parseInt(scan.nextLine())) {
                case 1:
                    account1.inputUserName(scan, this.arrayAccount);
                    this.arrayAccount.get(i).setUserName(account1.getUserName());
                    break;
                case 2:
                    account1.inputEmail(scan, this.arrayAccount);
                    this.arrayAccount.get(i).setEmail(account1.getEmail());
                    break;
                case 3:
                    account1.inputPassword(scan, this.arrayAccount);
                    this.arrayAccount.get(i).setPassword(account1.getPassword());
                    break;
                case 4:
                    Main.runn(this);
                    break;
                case 0:
                    System.out.println("Tam biet !!!");
                    System.exit(0);
                default:
                    System.out.println("Khong hop le vui long chon lai.\n");
            }
        } while (flag);

    }

    public void forgotPass(Scanner scan, ArrayList<Account> arrayAccount) {
        Account account = new Account();
        account.inputEmail(scan, arrayAccount);
        for (int i = 0; i < arrayAccount.size(); i++) {
            if (account.getEmail().equals(arrayAccount.get(i))) {
                success(i);
            }
        }
        System.out.println("Chua ton tai tai khoan");
    }
}