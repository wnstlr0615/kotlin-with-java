package chapter01.lec01

fun main(){
    var number1 = 10L;
    val number2 = 10L;

    // var 은 가변 타입 val 은 불변 타입
    // 코틀린에서는 초기값을 입력할 경우 변수 타입을 지정 하지 않아도 된다.
    // 변수 선언 시 val로 선언 하고 필요한 경우에만 var로 바꿔준다.

    var number3 :Long; // 초기값을 지정 하지 않을 경우 변수 타입을 지정해줘야 한다.
    // 코틀린에서는 primitive type 과 reference 타입을 자동으로 boxing unboxing 해준다.


    //ERROR
    var number4 = 10L;
    //number = null  // 코틀린에서 는 기본적으로 null을 허용하지 않는다


    //OK
    // NULL 을 허용해줄 때는 변수 타입? 지정
    var number5:Long?
    number5 = null


    // 객체 타입 선언 시 new 를 사용하지 않는다.
    var person = Lec01Main.Person("joon")
}