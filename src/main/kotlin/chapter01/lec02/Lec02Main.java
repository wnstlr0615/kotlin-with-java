package chapter01.lec02;

import org.jetbrains.annotations.Nullable;

// 자바에서 null을 다루는 방법
public class Lec02Main {
    public static void main(String[] args) {

    }

    public boolean startsWithA1(String str){
        if(str == null){
            throw new IllegalArgumentException("null 이 들어왔습니다.");
        }
        return str.startsWith("A");
    }

    public Boolean startsWithA2(String str){
        if(str == null){
            return null;
        }
        return str.startsWith("A");
    }

    public boolean startsWithA3(String str){
        if(str == null){
            return false;
        }
        return str.startsWith("A");
    }
    static class Person{
        String name;

        public Person(String name) {
            this.name = name;
        }
        @Nullable
        public String getName() {
            return name;
        }
    }
}


