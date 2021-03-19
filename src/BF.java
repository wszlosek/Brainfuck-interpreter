import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class BF {

    public static String input(){

        Scanner sc = new Scanner(System.in);
        String bf = sc.nextLine();

        for(char ch: bf.toCharArray()){

            if(ch != '+' && ch != '-' && ch != '<' && ch != '>'
                    && ch != '[' && ch!=']' && ch != '.' && ch != ','){

                bf = bf.replaceAll(String.valueOf(ch), "");
            }
        }

        return bf;
    }

    public static String read(ArrayList<Integer> numbers){

        for (Integer i: numbers)
            System.out.print(i.toString() + " ");

        return "";
    }


    public static void interpreter(){

        ArrayList<Integer> output = new ArrayList<Integer>(Collections.nCopies(1, 0));
        String bfCode = input();
        int index = 0;
        int n = 0;
        char ch, c;


        for(int i = 0; i < bfCode.length(); i++){

            ch = bfCode.charAt(i);

            if(ch == '>') {

                index += 1;
                n += 1;

                if(n >= output.size()){

                    output.add(0);
                }
            }

            if(ch == '<') {

                if(index > 0) {

                    index -= 1;
                    n -= 1;
                }
            }

            if(ch == '+'){

                output.set(index, output.get(index)+1);
            }

            if(ch == '-'){

                if(output.get(index) > 0){

                    output.set(index, output.get(index)-1);
                }
            }

            if(ch == '['){

                String loop = "";

                while(bfCode.charAt(i+1) != ']'){

                    loop += bfCode.charAt(i+1);
                    i += 1;
                }

                System.out.println(loop);

                for(int g = 0; g < loop.length(); g++) { //>++++++++[<+++++++++>-]<.>++++[<+++++++>-]<+.+++++++..+++.>>++++++[<+++++++>-]<++.------------.>++++++[<+++++++++>-]<+.<.+++.------.--------.>>>++++[<++++++++>-]<+

                    c = loop.charAt(g);

                    if (c == '>') {

                        index += 1;
                        n += 1;

                        if (n >= output.size()) {

                            output.add(0);
                        }
                    }

                    if (c == '<') {

                        if (index > 0) {

                            index -= 1;
                            n -= 1;
                        }
                    }

                    if (c == '+') {

                        output.set(index, output.get(index) + 1);
                    }

                    if (c == '-') {

                        if (output.get(index) > 0) {

                            output.set(index, output.get(index) - 1);
                        }

                        if(output.get(index) == 0){

                            break;
                        }
                    }
                }
            }
        }

        read(output);
    }


    public static void main(String[] args) {

        interpreter();
    }
}