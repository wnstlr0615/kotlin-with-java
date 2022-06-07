package chapter01.lec03;

import chapter01.lec02.Lec02Main;

import static chapter01.lec02.Lec02Main.*;

public class Lec03Main {
    public static void main(String[] args) {
        // 자바에서는 암시적 타입 변경이 가능
        int number1 = 10;
        long number2 = number1;
        System.out.println(number1 + number2); // long으로 암시적으로 변경되어 계산

        // 자바에서의 String을 다루는 법
        Person person = new Person("joon", 200);
        String format = "이름 : %s , 나이 : %d";
        System.out.println(String.format(format, person.name, person.age));

    }
    // 2. 타입 캐스팅
    public static void printAgeIfPerson(Object obj){
        if(obj instanceof Person){
            Person person = (Person) obj;
            System.out.println(person.age);
        }
    }
    public static void printAgeIsNotPerson(Object obj){ //  person 객체가 아니라면
        if(!(obj instanceof Person)){
            System.out.println("obj is not instanceof person");
        }
    }


    static class Person{
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Person(int age) {
            this.age = age;
        }


    }
}
