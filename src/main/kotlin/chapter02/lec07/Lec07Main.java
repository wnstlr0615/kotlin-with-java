package chapter02.lec07;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;

public class Lec07Main {
    public static void main(String[] args) {


    }
    //== 1. try catch finally 구문 ==//
    private int parseIntOrThrow(@NotNull String str){
        try{
            return Integer.parseInt(str);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(String.format("주어진 %s는 숫자가 아닙니다.", str));
        }
    }
    @Nullable
    private Integer parseIntOrNull(@NotNull String str){
        try{
            return Integer.parseInt(str);
        }catch (NumberFormatException e){
            return null;
        }
    }
    //== 2. Checked Exception 과 UncheckedException ==//
    public void readFile() throws IOException {
        File currentFile = new File(".");
        File file = new File(currentFile.getAbsoluteFile() + "/a.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        System.out.println(reader.readLine());
        reader.close();
    }
    //== 3. try with resources ==//
    //Resource 자동 종료
    public void readFile(String path) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            System.out.println(reader.readLine());
        }
    }
}
