import java.util.Scanner;
import java.util.ArrayList;


public class BF {

    public static Scanner sc = new Scanner(System.in);

    public static String input() {

        String bf = sc.nextLine();

        for (char ch : bf.toCharArray()) {

            if (ch != '+' && ch != '-' && ch != '<' && ch != '>'
                    && ch != '[' && ch != ']' && ch != '.' && ch != ',') {

                bf = bf.replaceAll(String.valueOf(ch), "");
            }
        }

        return bf;
    }


    public static void read(int[] output){

        for(int i = 0; i < output.length; i++){

            System.out.print(output[i] + " ");
        }
    }

    public static String toChar(int asciiNum) {

        char ch = (char) asciiNum;
        return String.valueOf(ch);
    }


    public static void interpreter(String code) {

        char ch;
        int c = 0;
        int index = 0;
        int limes = 500;
        int[] output = new int[limes];

        for (int i = 0; i < code.length(); i++) {

            ch = code.charAt(i);

            if (ch == '>') {

                if (index == limes) {

                    index = 0;
                } else {

                    index = index + 1;
                }
            }
            if (ch == '<') {

                if (index != 0) {

                    index = index - 1;
                } else {

                    index = limes;
                }
            }
            if (ch == '+') {

                output[index]++;
            }
            if (ch == '-') {

                output[index]--;
            }
            if (ch == '.') {

                System.out.print((output[index]));
            }
            if (ch == '[') {

                if (output[index] == 0) {

                    i++;
                    while (c > 0 || code.charAt(i) != ']') {

                        if (code.charAt(i) == '[') c++;
                        if (code.charAt(i) == ']') c--;
                        i++;
                    }
                }
            }
            if (ch == ']') {

                if (output[index] != 0) {

                    i--;

                    while (c > 0 || code.charAt(i) != '[') {

                        if (code.charAt(i) == '[') c--;
                        if (code.charAt(i) == ']') c++;
                        i--;
                    }

                    i--;
                }
            }

            if (ch == ',') {

                output[index] = sc.nextInt();
            }
        }


        if(!code.contains(".")) {

            read(output);
        }
    }

    public static void main(String[] args) {

        interpreter(input());
    }

}