import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Program program=new Program();
        runn(program);
    }

    private static void startMenu() {
        System.out.println("==============");
        System.out.println("1.  Dang nhap");
        System.out.println("2.  Dang ky");
        System.out.println("Moi chon: ");
    }
    public static void runn(Program program) {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        do {
            startMenu();
            switch (Integer.parseInt(scan.nextLine())) {
                case 1:
                    program.logIn(scan);
                    break;
                case 2:
                    program.register(scan);
                    break;
                default:
                    System.out.println("Khong hop le vui long chon lai!!\n");
            }
        } while (flag);
    }
}