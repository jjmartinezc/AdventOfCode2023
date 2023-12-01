package day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day01 {

    private static String day = "day01";
    private static String input = "Input.txt";
    private static List<String> list = new ArrayList<>() {};

    public static void main(String[] args) throws Exception{
        readFile();
        Integer total = sumList(numbers(list));
        System.out.println(total);
    }

    public static void readFile()
            throws IOException {
        String file ="src/main/java/"+day+"/"+input;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine;
        while ((currentLine = reader.readLine()) != null){
            list.add(currentLine);
            System.out.println(currentLine);
        }

        reader.close();
    }

    private static List<Integer> numbers(List<String> strings){
        IntStream stream;
        Integer number = 0;
        List<Integer> listOfNumb= new ArrayList<>();
        for (int i = 0; i < strings.size(); i++){
            stream = strings.get(i).chars();

            String s1 = stream.filter(Character::isDigit)
                    .collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append)
                    .toString();


            int size = s1.length();
            number = Integer.parseInt(""+s1.charAt(0)+s1.charAt(size-1));
            System.out.println(number);
            listOfNumb.add(number);
        }
        return listOfNumb;
    }

    public static Integer sumList(List<Integer> list){
        Integer sum = 0;
        for (int i = 0; i < list.size(); i++){
            sum = sum + list.get(i);
        }
        return sum;
    }


}