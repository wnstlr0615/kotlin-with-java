package chapter04.lec16

import chapter03.lec12.Person

fun main(){
    var str = "ABC"
    println(str.lasChar()) // String 클래스에 있는 함수 처럼 이용 할 수 있음
    val lasChar1: Char = str.lasChar1

    // 선언 타입에 따라 확장 함수 호출이 정해진다.
    val train: Train = Train()
    train.isExpensive() // Train의 확장 함수

    var str1: Train = Srt()
    str1.isExpensive() // Train의 확장 함수

    var str2: Srt = Srt()
    str2.isExpensive() // Srt의 확장함수

    //= 2. 중위 함수 =//
    println(3.add1(5))
    println(3.add2(5))
    // 중위함수 (예시 step, downTo)
    println(3 add2 5)

}

//= 1. 확장 함수 =//
// this를 수신객체, String를 수식 객체 타입
// 확장 함수는 클래스에 있는 private 또는 protected 멤버를 가져올 수 없다.
fun String.lasChar(): Char{
    return this[this.length - 1]
}
val String.lasChar1: Char
    get() = this[this.length - 1]

open class Train(
    val name: String = "새마을기차",
    val price: Int = 5_000
)
fun Train.isExpensive(): Boolean{
    println("Train의 확장 함수")
    return this.price >= 10000
}

class Srt : Train("SRT", 40_000)
fun  Srt.isExpensive(): Boolean{
    println("Srt의 확장 함수")
    return this.price >= 10000
}

//= 2. 중위 함수 =//

//일반 확장 함수(3.add(2))
fun Int.add1(other: Int) = this + other

//중위 함수  (함수를 다르게 부르는 방법으로 3 add 2 로 호출 가능)
// 멤버 함수에도 붙일 수 있다
infix fun Int.add2(other: Int) = this + other

//= 3. inline 함수 =//
// inline 함수 사용 시 함수를 호출하지 않고 본문을(this + other) 바로 대입 하여 오버 헤드를 줄일 수 있다.
// 코틀린에서는 성능에 따라서 자동으로 inline 를 붙여준다.
inline fun Int.add3(other: Int) = this + other

//= 4. 지역함수 함수 내에 있는 함수 =//

// 지역 함수 사용전
fun createPerson1(firstName: String, lastName: String): Person{
    if(firstName.isEmpty()){
        throw IllegalArgumentException("firstName 은 비어 있을 수 없습니다. 현재 값 : ${firstName}")
    }

    if(lastName.isEmpty()){
        throw IllegalArgumentException("lastName 은 비어 있을 수 없습니다. 현재 값 : ${lastName}")
    }
    return Person(firstName.plus(lastName))
}

fun createPerson2(firstName: String, lastName: String): Person{
    fun validateName(name: String, fieldName: String){
        if(name.isEmpty()){
            throw IllegalArgumentException("${fieldName} 은 비어 있을 수 없습니다. 현재 값 : ${name}")
        }
    }
    validateName(firstName, "firstName")
    validateName(lastName, "lastName")
    return Person(firstName.plus(lastName))
}

