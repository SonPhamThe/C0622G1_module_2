package ss3_array_method.practice;

public class Algorithm {
    public static void main(String[] args) {

        for (int i = 1; i < 6; i++) {
            for (int j = -5; j < 6; j++) {
                if (i == j || -i == j) {
                    System.out.print(i);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
        for (int i = 4; i > 0; i--) {
            for (int j = -5; j < 6; j++) {
                if (i == j || -i == j) {
                    System.out.print(i);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }
}
