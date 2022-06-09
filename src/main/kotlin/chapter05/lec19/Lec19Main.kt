package chapter05.lec19

import chapter04.lec18.Fruit

//as import : 다른 패키지의 같은 이름 함수를 동시에 가져오고 싶을 경우
import chapter05.lec19.a.printHelloWorld as printHelloWorldA
import chapter05.lec19.b.printHelloWorld as printHelloWorldB

fun main(){
    printHelloWorldA()
    printHelloWorldB()

    //구조 분해
    val person = Person("joon", 50)
    println(person)
    // 순서를 바꾸면 반대로 입력된다 (순서가 중요하다)
    val (name, age) = person
    //=구조 분해 문법 을 사용하기전
    val name1 = person.component1() // 첫번 째 변수
    val age1 = person.component2() // 두번 째 변수
    println("이름 : $name, 나이 : $age")

    val person1 = Person1("준", 50)
    val (name2, age2) = person1
    println("이름 : $name2, 나이 : $age2")

    val numbers = listOf(1, 2, 3)
    numbers.map {it + 1}
        .forEach {println(it)}
    // forEach 함수에서는 continue와 break 등을 사용할 수 없다.
    // 사용하기 위해서는 block으로 감싸주어야한다.

    run{
        numbers.forEach { number -> // forEach 블럭에서 break와 continue를 사용하는 방법
            if (number == 3) {
                //return@run // break를 사용하는 방법
                return@forEach //continue를 사용하는 방법
            }
            println(number)
        }
    }
    // 라벨 기능
    loop@ for(i in 1..100){
        for(j in 1.. 100) {
            if (j == 2) {
                break@loop
            }
            print("$i $j")
        }
    }

}

//= 4. TakeIf 와 TakeUnless =//
fun getNumberOrNullV1(number: Int): Int? {
    return  if (number <= 0){
        null
    } else{
        number
    }
}
// 조건이 참이면 number 반환 아니면 null 반환
fun getNumberOrNullV2(number: Int): Int?{
    return number.takeIf { it > 0 }
}
// 조건이 거짓이면 number 반환 참이면 null 반환
fun getNumberOrNullV3(number: Int): Int?{
    return number.takeUnless { it > 0 }
}

//= 1. Type Alias와 as import =//
typealias FruitFilter = (Fruit) -> Boolean // 함수 타입 축약
private fun filterFruits(
    fruits: List<Fruit>, filter: FruitFilter
): List<Fruit>{
    return fruits.filter(filter)
}

data class UltraSuperGuardianTribe(
    val name: String
)

typealias USGTMap = Map<String, UltraSuperGuardianTribe> //긴 클래스를 컬랙션에 넣을 때 축약

// 구조 분해 : 복합적인 값을 분해하여 여러 번수를 한번에 초기화 하는 것

data class Person(
    val name: String,
    val age: Int
)
//data class 는 componentN이란 함수를 자동으로 만들어 준다.

// data 클래스가 아닐 경우 컴포넌트 함수를 직접 만들어 줄 수 있다.
class Person1(
    val name: String,
    val age: Int
){
    operator fun component1() = this.name
    operator fun component2() = this.age

}

//= 3. Jump와 Label =//
// return / breakk /continue
// return : 기본적으로 가장 가까운 enclosing function 또는 익명 함수로 값이 반환된다.
// break : 가장 가까운 루프가 제거된다.
// continue : 가장 가까운 루프를 다음 step으로 보낸다.