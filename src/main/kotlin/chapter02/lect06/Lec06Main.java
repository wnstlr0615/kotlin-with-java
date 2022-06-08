package chapter02.lect06;

import java.util.Arrays;
import java.util.List;

public class Lec06Main {
    public static void main(String[] args) {
        //= 1. for-each =//
        List<Long> numbers = Arrays.asList(1L, 2L, 3L);
        for (Long number : numbers) {
            System.out.println(number);
        }
        
        //== 2. 전통적인 for 문 ==//
        for (int i = 1; i <=3 ; i++) {
            System.out.println(i);
        }

        // 내려가는 for문
        for (int i = 3; i >= 0 ; i--) {
            System.out.println(i);
        }

        //2칸씩 올라가는 for문
        for (int i = 1; i <= 5 ; i += 2) {
            System.out.println(i);
        }
        
        //== 4. while ==//
        int i = 0;
        while(i <= 3){
            System.out.println(i);
            i++;
        }
    }
}
