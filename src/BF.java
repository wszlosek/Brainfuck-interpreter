import java.util.Scanner;
import java.util.ArrayList;

import static java.util.Collections.*;


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


    public static void read(ArrayList output) {

        for (Object o : output) {

            System.out.print(o + " ");
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
        int maxIndex = 0;
        ArrayList<Integer> output = new ArrayList<Integer>(nCopies(1, 0));

        for (int i = 0; i < code.length(); i++) {

            ch = code.charAt(i);

            if (ch == '>') {

                if (index == limes) {

                    index = 0;

                } else {

                    index = index + 1;

                    if (index > maxIndex) {

                        maxIndex = index;
                        output.add(0);
                    }

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

                output.set(index, output.get(index) + 1);
            }

            if (ch == '-') {

                output.set(index, output.get(index) - 1);
            }

            if (ch == '.') {

                if (code.contains(",")) {

                    System.out.print(output.get(index));
                } else {

                    System.out.print(toChar(output.get(index)));
                }
            }

            if (ch == '[') {

                if (output.get(index) == 0) {

                    i += 1;

                    while (c > 0 || code.charAt(i) != ']') {

                        if (code.charAt(i) == '[')
                            c += 1;
                        if (code.charAt(i) == ']')
                            c -= 1;

                        i += 1;
                    }
                }
            }

            if (ch == ']') {

                if (output.get(index) != 0) {

                    i -= 1;

                    while (c > 0 || code.charAt(i) != '[') {

                        if (code.charAt(i) == '[')
                            c -= 1;
                        if (code.charAt(i) == ']')
                            c += 1;

                        i -= 1;
                    }

                    i -= 1;
                }
            }

            if (ch == ',') {

                output.set(index, sc.nextInt());
            }
        }


        if (!code.contains(".")) {

            read(output);
        }
    }


    public static void main(String[] args) {

        interpreter(input());
    }

}