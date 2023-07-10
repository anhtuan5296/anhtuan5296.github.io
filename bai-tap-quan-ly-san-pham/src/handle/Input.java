package handle;

import java.util.Scanner;

public class Input {
    public int getInput(Scanner sc, Integer min, Integer max) {
        int input;
        do {
            System.out.println("Moi ban nhap 1 so" + valueRange(String.valueOf(min), String.valueOf(max)) + ":");
            // Cho người dùng nhập vào 1 giá trị số:
            while (!sc.hasNextInt()) {
                System.out.println("Moi ban nhap 1 so" + valueRange(String.valueOf(min), String.valueOf(max)) + ":");
                sc.nextLine();
            }
            input = Integer.parseInt(sc.nextLine());
        } while (!stopCondition(String.valueOf(min), String.valueOf(max), input, null));
        return input;
    }

    public double getInput(Scanner sc, Double min, Double max) {
        double input;
        do {
            System.out.println("Moi ban nhap 1 so " + valueRange(String.valueOf(min), String.valueOf(max)) + ":");

            // Cho người dùng nhập vào 1 giá trị số:
            while (!sc.hasNextDouble()) {
                System.out.println("Mơi ban nhap 1 so " + valueRange(String.valueOf(min), String.valueOf(max)) + ":");
                sc.nextLine();
            }
            input = Double.parseDouble(sc.nextLine());
        } while (!stopCondition(String.valueOf(min), String.valueOf(max), null, input));
        return input;
    }

    public String valueRange(String min, String max) {
        if (min.equalsIgnoreCase("null") && max.equalsIgnoreCase("null")) {
            return "";
        } else if (min.equalsIgnoreCase("null")) {
            return "<=" + max;
        } else if (max.equalsIgnoreCase("null")) {
            return ">=" + min;
        } else {
            return " tu " + min + " den " + max;
        }
    }

    public boolean stopCondition(String minStr, String maxStr, Integer inputInt, Double inputDouble) {
        if (inputDouble == null) {
            //Truyền vào thanh Int 2 số min max
            Integer min = 0;
            Integer max = 0;
            try {
                if (minStr != null)
                    min = Integer.parseInt(minStr);
            } catch (NumberFormatException e) {
                min = null;
            }
            try {
                if (maxStr != null)
                    max = Integer.parseInt(maxStr);
            } catch (NumberFormatException e) {
                max = null;
            }
            //Trả về True nếu input nằm trong Min Max
            if (min == null && max == null) {
                return true;
            } else if (min == null) {
                if (inputInt <= max) {
                    return true;
                } else {
                    return false;
                }
            } else if (max == null) {
                if (inputInt >= min) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (inputInt >= min && inputInt <= max) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            //Chuyển đổi 02 số min max truyền vào thanh Double
            Double min = 0.0;
            Double max = 0.0;
            try {
                if (minStr != null)
                    min = Double.parseDouble(minStr);
            } catch (NumberFormatException e) {
                min = null;
            }
            try {
                if (maxStr != null)
                    max = Double.parseDouble(maxStr);
            } catch (NumberFormatException e) {
                max = null;
            }
            //Trả về true nếu input nằm trong Min Max
            if (min == null && max == null) {
                return true;
            } else if (min == null) {
                if (inputDouble <= max) {
                    return true;
                } else {
                    return false;
                }
            } else if (max == null) {
                if (inputDouble >= min) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (inputDouble >= min && inputDouble <= max) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }


}