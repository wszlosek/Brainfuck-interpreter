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

    public static String toChar(int asciiNum){

        char ch = (char) asciiNum;
        return String.valueOf(ch);
    }


    public static void interpreter(String code){

        ArrayList<Integer> output = new ArrayList<Integer>(Collections.nCopies(2, 0));
        int index = 1;
        int n = 1;
        char ch, c;
        int flag;


        for(int i = 0; i < code.length(); i++){

            flag = 0;
            ch = code.charAt(i);

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

            if(ch == '.'){

                System.out.print(toChar(output.get(index)));
            }

            if(ch == '['){

                String loop = "";

                while(code.charAt(i+1) != ']'){

                    loop += code.charAt(i+1);
                    i += 1;
                }

                while(flag == 0){

                    for(int g = 0; g < loop.length(); g++){

                        c = loop.charAt(g);

                        if(c == '>') {

                            index += 1;
                            n += 1;

                            if(n >= output.size()){

                                output.add(0);
                            }
                        }

                        if(c == '<') {

                            if(index > 0) {

                                index -= 1;
                                n -= 1;
                            }
                        }

                        if(c == '+'){

                            output.set(index, output.get(index)+1);
                        }

                        if(c == '-'){

                            if(output.get(index) > 0){

                                output.set(index, output.get(index)-1);
                            }

                            if(output.get(index) == 0){
                                flag = 1;
                                break;
                            }
                        }

                        if(ch == '.'){

                            System.out.print(toChar(output.get(index)));
                        }

                    }
                }

            }
        }
    }


    public static void main(String[] args) {

        String bfCode = input();
        interpreter(bfCode);
    }
}

//>++++++++[<+++++++++>-]<.>++++[<+++++++>-]<+.+++++++..+++.>>++++++[<+++++++>-]<+
//+.------------.>++++++[<+++++++++>-]<+.<.+++.------.--------.>>>++++[<++++++++>-
//]<+.