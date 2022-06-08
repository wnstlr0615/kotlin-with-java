package chapter02.lec08


//= 1. 함수 선언 문법 =//
fun max1(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}
//public 은 생략 가능 (default 가 public)
// 결과가 Expression 일 경우 = 으로 표기 가능
// 결과 값이 둘다 Int 일 경우 코틀린 에서 추론 가능 하므로 반환 값 생략 가능( = 은 사용할 경우에 가능)
// 블록을 사용할 경우 Unit 타입이 아닌 경우에는 명시적으로 반환 값을 지정 해주어야한다.
// if 문 괄호도 한줄일 경우 생략 가능
fun max2(a: Int, b: Int) = if(a > b) a else  b

fun main(){
    // 기본 값 설정으로 하나의 함수로 커버 가능
    repeat("Hello word")


    //= 3. names argument =//
    // num은 기본 값을 사용하면서 userNewLine를 false 로 선언 하고 싶을 경우 이름을 지정하여 사용
    //repeat("Hello word", false)  해당 함수는 num 값을 입력하지 않고 useNewLine에 false를 입력하려고 하기 떄문에 에러 발생
    repeat("Hello word", useNewLine = false) // 이름을 사용하여 지정 하면 num은 default 값을 사용할 수 있다.

    // 다음 과 같이 같은 매개변수를 입력받는 함수의 경우 순서가 바뀌어도 컴파일러에서 에러를 잡아 주지 못한다.
    prinNameAndGender("joon", "남자")

    // 코틀린에서는 builder를 통해 지정해 주듯이 이름을 이용하여 접근이 가능하다.
    prinNameAndGender( name = "joon", gender = "남자")

    // 단 코틀린에서 java 함수를 가져다 사용할 경우에는 named argument를 사용 할 수 없다.
    //Lec08Main.printNameAndGender(name = "joon", gender = "남자") //자바 함수 호출 예시

    // 코틀린에서의 가변인자
    printAll("A", "B", "C")

    val strings = arrayOf("A", "B", "C")
    // spread연산자(*)를 통해 배열 안에 문자들을 꺼내 준다.
    printAll(*strings)

}
//=  2.  default 파라미터 =//
fun repeat(
    str: String,
    num: Int = 3,
    useNewLine: Boolean = true
){
    for(i in 1..num){
        if(useNewLine){
            println(str)
        }else{
            print(str)
        }
    }
}

fun prinNameAndGender(name: String, gender: String){
    println(name)
    println(gender)
}

//== 4. 같은 타입의 여러 파라미터 받기 (가변인자) ==//

fun printAll(vararg strings: String){
    for( str in strings){
        println(str)
    }
}
