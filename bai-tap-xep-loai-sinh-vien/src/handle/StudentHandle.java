package handle;

import entity.Student;

import java.util.Scanner;

public class StudentHandle {
    public Student createStudent(Scanner sc, int i) {

        System.out.println("Mời bạn nhập tên sinh viên thứ " + (i + 1) + ": ");
        String name = sc.nextLine();

        double scoreMath;
        double scorePhysics;
        double scoreChemistry;

        // Kiểm tra giá trị n là 1 sô từ 0 đến 10
        do {
            System.out.println("Mời bạn nhập điểm môn Toán (0-10): ");
            // Yêu cầu giá trị là 1 số từ 0 đến 10
            while (!sc.hasNextDouble()) {
                System.out.println("Mời bạn nhập một số (0-10): ");
                sc.nextLine();
            }
            scoreMath = Double.parseDouble(sc.nextLine());
        } while (scoreMath < 0 || scoreMath > 10);

        // Kiểm soát giá trị n là 1 số từ 0 đến 10
        do {
            System.out.println("Mời bạn nhập điểm môn Vật lý (0-10): ");
            // Yêu cầu giá trị là 1 sô từ 0 đến  10
            while (!sc.hasNextDouble()) {
                System.out.println("Mời bạn nhập điểm môn Vật lý (0-10): ");
                sc.nextLine();
            }
            scorePhysics = Double.parseDouble(sc.nextLine());
        } while (scorePhysics < 0 || scorePhysics > 10);

        // Yêu cầu giá trị là 1 sô từ 0 đến  10
        do {
            System.out.println("Mòi bạn nhập điểm môn Hóa (0-10): ");
            // Yêu cầu giá trị là 1 sô từ 0 đến  10
            while (!sc.hasNextDouble()) {
                System.out.println("Mời bạn nhập điểm môn Hóa (0-10): ");
                sc.nextLine();
            }
            scoreChemistry = Double.parseDouble(sc.nextLine());
        } while (scoreChemistry < 0 || scoreChemistry > 10);

        // Tạo bản ghi sinh viên với tham số
        Student student = new Student(name, scoreMath, scorePhysics, scoreChemistry);

        // Trả về bản ghi sinh viên
        return student;
    }

    public void displayAllStudents(Student[] students) {
        for (Student st : students) {
            System.out.println(st);
        }
    }

    public void calculatePercentage(Student[] students) {
        double soA = 0;
        double soB = 0;
        double soC = 0;

        int n = students.length;

        // Đếm số sinh viên theo xếp loại
        for (int i = 0; i < n; i++) {
            switch (students[i].classification()) {
                case "A": {
                    soA++;
                    break;
                }
                case "B": {
                    soB++;
                    break;
                }
                case "C": {
                    soC++;
                    break;
                }
                default: {
                    break;
                }
            }
        }

        //In ra kết quả tính tỷ lệ
        if (soA + soB + soC > 0) {
            System.out.println("Tỉ lệ sinh viên xếp loại A =" + (soA / (soA + soB + soC) * 100) + "%");
            System.out.println("Tỉ lệ sinh viên xếp loại B =" + (soB / (soA + soB + soC) * 100) + "%");
            System.out.println("Tỉ lệ sinh viên xếp loại C =" + (soC / (soA + soB + soC) * 100) + "%");
        } else {
            System.out.println("Không có dữ liệu.");
        }
    }

}