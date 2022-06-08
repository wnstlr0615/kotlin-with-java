package chapter03.lec09

fun main(){
    val person = Person("joon", 20)
    println(person.name)
    println(person.age)

    // 자바 클래스도 .변수명으로 접근 가능
    val javaPerson = Lec09Main.JavaPerson("joon", 20)
    println(person.name)
    println(person.age)

    //부생성자로 생성
    val person1 = Person()
    println(person1.name)
    println(person1.age)

    // 코틀린에서는 부생성자보다 default parameter를 권장한다다
}
//== 1. 클래스와 프로퍼티 ==//
// 생성 자를 통해 변수 생성 가능
class Person( // < -- 주 생성자 (primary constructor) 반드시 존재 해야한다.
    val name: String, // = "joon"  // default 파라미터로 부생성자를 대신 할 수 있다.
    var age: Int, // = 20
    otherName: String = "테스트" // 커스텀 setter를 만들기 위해 추가 변수
){
    var otherName: String = otherName
        set(value) { // 입력시 대문자로 입력시켜주는 custom setter
            field = value.uppercase()
        }

    /* // 커스텀 getter을 생성하는 방법 (name을 호출 시 대문자로 반환)
    val name = name
    get() = field.uppercase() // filed(backing field)로 호출 name으로 호출시 get() 메소드를 불러오면서 무한 루프 발생
    */

    //메소드 추가가
   fun getUppercaseName(): String = this.name.uppercase()

// getter를 변경하지 않고 프로퍼티 정의
//    val getUppercaseName: String
//        get() = this.name.uppercase()

    //= 2. 생성 자와 init =//
    init{ // 초기화 블럭은 생성자가 호출되는 시점에 호출된다.
        if(age <= 0){
            throw IllegalArgumentException("나이는 ${age} 일 수 없습니다.")
        }
        println("초기화 불록")
    }
    // 기본 생성자 이외에 추가 생성자
    // 부 생성자로 최종적으로 주 생성자를 호출해야 한다.
    constructor(name: String): this(name, 1){
        println("부 생성자 1")
    }
    constructor(): this("joon"){
        println("부 생성자 2")
    }
    //getter 와 setter 자동 생성

    /*fun isAdult(): Boolean{  // 함수처럼 구현하는 방법
        return this.age >= 20
    }*/

    //= 3. 커스텀 getter, setter =//
    // 프로퍼티처럼 만드는 방법
    val isAdult: Boolean
        get() { // 괄호 생략 후  = 으로 사용가능
            return this.age >= 20
        }

}