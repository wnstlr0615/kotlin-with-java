package chapter01.lec01;

public class Lec01Main {

    public static void main(String[] args) {
        long number1 = 10L; // 가변 객체
        final long  number2 = 10L; // 불변 객체


        Long number3 = 10L;
        long number4 = 10L;

        Person person = new Person("joon");
    }

    static class Person{
        String name;

        public Person(String name) {
            this.name = name;
        }
    }
}
