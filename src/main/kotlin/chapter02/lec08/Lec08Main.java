package chapter02.lec08;

public class Lec08Main {
    //= 1. 함수 선언 문법 =//
    public int main(int a, int b){
        if(a > b){
            return a;
        }
        return b;
    }
    //== 2. default 파라미터 (메소드 오버로딩 기능)==//
    public void repeat(String str, int num, boolean useNewLine){
        for (int i = 1; i <= num ; i++) {
            if(useNewLine){
                System.out.println(str);
            }else{
                System.out.print(str);
            }
        }
    }

    public void repeat(String str, int num){
        repeat(str, num, true);
    }

    public void repeat(String str){
        repeat(str, 3, true);
    }

    public static void printNameAndGender(String name, String gender){
        System.out.println(name);
        System.out.println(gender);
    }

    //== 4. 같은 타입의 여러 파라미터 받기 (가변인자) ==//
    public static void printAll(String... strings){
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
