package chapter03.lec12;

public class Lec12Main {
    public static void main(String[] args) {
        // 자바에서 코틀린의 static 변수나 함수를 사용하는 방법
        //이름이 없는 경우
        //Person person1 = Person.Companion.newBaby("joon");
        // 이름을 지정한 경우
        Person person2 = Person.Factory.newBaby("joon");

        // 코틀린 스태틱 메소드에 @JvmStatic 를 붙여줄 경우 바로 사용 가능
        Person person3 =Person.newBaby("joon");

        moveSomething(new Movable() {
            @Override
            public void move() {

            }
            @Override
            public void fly() {

            }
        });

    }

    public static void moveSomething(Movable movable){
        movable.move();
        movable.fly();
    }
}


