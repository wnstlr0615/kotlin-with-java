package chapter01.lec03

fun main(){
    //= 1. 기본타입  =//
    val number1 = 10
    // 코틀린에서는 암시적 변경이 불가능 하다
    //val number2 :Long = number1

    // 코틀린에서는 무조건 toLong()메소드로 변경
    val number2 :Long = number1.toLong()

    val number3: Int? = 3
    //변수가 nullable 일 경우 적절하게 처리해주어야한다.
    val number4: Long = number3?.toLong() ?: 0L

    printAgeIfPersonNullable(Lec03Main.Person(10))

    //= 3 Kotlin의 3가지 특이한 타입 =//
    //3_1 Any
    /*
    * java의 Object 역할(모든 객체의 최상위 타입
    * 모든 Primitive Type의 최상의 타입도 Any(자바에서 Primitive 타입이 Object가 아님 )
    * Any 자체로는 null을 포함할수 없어 null을 포함하고 싶다면 Any? 로 표현
    * Any 에 equals/hashCode/toString 존재재
   * */


    //3_2 Unit
    /*
    * Unit는 java의 void와 동일한 역할
    * void와 다르게 Unit는 그자체로 타입 인자로 사용가능(??hard)
    * 함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 긎는 타입을 의미 즉 코틀린의 Unit은 실제 존재하는 타입이라는 것을 의미한다.
    * */

    //3_3 Nothing
    /*
    * Nothing는 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
    * 무조건 예외를 반환하는 함수/ 무한 루프 함수등( fail)
    * */

    //= 4. String Interpolation, String indexing =//
    // 코틀린에서 String을 다루는 법법
   val person = Lec03Main.Person("joon", 20)
    println("이름 :${person.name}, 나이 : ${person.age}")
    val name = "준"
    println("이름 : $name") // {} 생략 가능 {}를 사용하는 것이 가독성이 좋다.

    // 여러줄 선언
    val str = """
        ABC
        ${name}
    """.trimIndent()
    println(str)
    val abc = "ABC"
    println(abc[0]) // 자바에서 는 abc.charAt() 사용
    println(abc[2])


    

}
// Nothing
fun fail(message: String): Nothing{
    throw IllegalArgumentException(message)
}


//= 2. 타입 캐스팅 =//
fun printAgeIfPerson(obj: Any){
    if(obj is Lec03Main.Person){
        // obj as Perseon 생략 가능
        //val person = obj as Lec03Main.Person
        //println(person.age)
        println(obj.age) // 스마트 캐스트
    }
}
// instanceof에 반대
fun printAgeIsNotPerson(obj: Any){
    if(obj !is Lec03Main.Person){
        println("obj is not person")
    }
}

// obj가 null 일 경우
fun printAgeIfPersonNullable(obj: Any?){
    val person = obj as? Lec03Main.Person
    // 그냥 as를 사용할 경우 예외 발생 하지만 as? 를 사용할 경우 null
    println(person?.age)
}