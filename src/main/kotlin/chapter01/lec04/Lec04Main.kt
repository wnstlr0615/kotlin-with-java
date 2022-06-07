package chapter01.lec04

import chapter01.lec04.Lec04Main.JavaMoney

fun main(){
    //= 1. 단항 연산자 / 산술 연산자 =//
    //++, --, +, -, *, /, %

    //= 2. 비교 연산자와 동등성 동일성 =//
    // >, <, >=, <=

    val money1 = JavaMoney(2000L)
    val money2 = JavaMoney(1000L)
    val money3 = money1 // money1, money3는 동일
    // 코틀린에서 객체 비교시 compareTo 를 자동으로 호출
    if(money1 > money2){
        println("Money1이 Money2보다 금액이 큽니다.")
    }


    // 동등성(Equality) : 두 객체의 값이 같은가
    // 동일성(Identity) : 두 객체가 완전히 동일한가 , 주소가 같은가가
    // == 비교는 동일한지 비교
    // 동등성 비교에 equals() tkdyd


    val money4 = JavaMoney(2000L)

    //코틀린에서 동일성은 === 사용, 동등성은 == 사용 자동으로 equals()를 호출해준다.
    println("money1 == money3 (동등성 비교)  : ${money1 == money3}")
    println("money1 === money3 (동일성 비교)  : ${money1 === money3}")
    println("money1 == money4 (동등성 비교) : ${money1 == money4}")
    println("money1 === money4 (동일성 비교) : ${money1 === money4}")

    //= 3. 논리연산자와 코틀린에 있는 특이한 연산자 =//
    // 논리 연산자 (&&, ||, !) 자바처럼 Lazy 연산 수행
    if(fun1() || fun2()){ // Lazy 연산을 수행하여 앞에가 참인 경우 뒤에 함수는 검사하지 않는다.
        println("본문")
    }
    //코틀린에 있는 특이한 연산자
    // (in, !in) // 컬렉션 범위에 포함되어 있거나 포함되어 있지 않다.
    // (a..b)  a 부터 b까지의 번위 객체를 생성
    // a[i] i번째 값 반환

    //= 4. 연산자 오버로딩 =//

    val money5 = Money(1000L)
    val money6 = Money(2000L)
    val money7 = money5 + money6
    println(money7)
}

fun fun1(): Boolean{
    println("fun 1")
    return true;
}

fun fun2(): Boolean{
    println("fun 2")
    return false;
}

data class Money(
    val money: Long
){
    operator fun plus(other: Money): Money{
        return Money(money + other.money)
    }
}