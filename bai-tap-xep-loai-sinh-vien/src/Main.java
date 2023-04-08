import entity.Student;
import handle.StudentHandle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        // Yêu cầu người dùng nhập 1 số nguyên dương
        do {
            System.out.println("Mời bạn nhập số sinh viên : ");
            // Yeu cau gia tri so nguyen
            while (!sc.hasNextInt()) {
                System.out.println("Mời bạn nhập 1 số nguyên :");
                sc.nextLine();
            }
            n = Integer.parseInt(sc.nextLine());
        } while (n <= 0);

        // Khai báo đối tượng
        StudentHandle studentHandle = new StudentHandle();
        Student[] students = new Student[n];

        // Tạo bản ghi đối tượng
        for (int i = 0; i < n; i++) {
            students[i] = studentHandle.createStudent(sc, i);
        }

        // Gọi ra tất cả các học sinh
        studentHandle.displayAllStudents(students);

        // Gọi ra phương thức tính tỉ lệ % xếp loại học sinh
        studentHandle.calculatePercentage(students);
    }
}