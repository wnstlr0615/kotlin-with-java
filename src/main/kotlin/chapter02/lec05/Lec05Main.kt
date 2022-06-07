package chapter02.lec05
//= 1. if문 =//
fun validateScoreIsNotNegative(score: Int){ // 함수에서 Unit(void)는 생략 할 수 있다.
    if(score < 0){
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
    }
}


fun getPassOrFail(score: Int): String{
    // 코틀린에서는 결과가 하나인 Expression 타입
    // 코틀린에서는 3항 연산자가 없다
    return if(score >= 50){
        "P"
    }else{
        "F"
    }
}
// return 로 if를 반환 할 수 있다.
fun getGrade(score: Int): String{
    return if(score >= 90){
        "A"
    }else if(score >= 80){
        "B"
    }else if(score >= 70){
        "C"
    }else{
        "D"
    }
}

// 코틀린 타입
fun validate(score: Int){ // 함수에서 Unit(void)는 생략 할 수 있다.
    if(score !in 0..100){
        println("score 가 0 ~ 100 범위 안에 존재 하지 않습니다.")
    }
}
fun main(){
    //= 2. Expression & Statement =//
    // Expression : 하나의 값으로 도출되는 문장 (= 결과가 하나로 확실한 것)
    // Statement : 프로그램의 문장, 하나의 값으로 도출되지 않는다(결과가 여러개 일 수 있는것 if문 내에 return 이 여러 개인 경우)
    //Java 에서 if-else는 Statement , 코틀린에서는 Expression
}

// 코틀린으로 switch 표현
fun getGradeWithSwitch(score: Int): String{
    return when(score){
        in 90..99 -> "A" // (표현식) -> 반환 값
        in 80..89 -> "B"// 표현식에는 Expression이 들어 갈 수 있다 is
        in 70..79 -> "C"
        else -> "D"
    }
}

fun startsWithA(obj: Any): Boolean{
    return when(obj){
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber(number: Int){
    when(number){
        1, 0, -1 -> println("어디서 많이 본 숫자입니다.")
        else -> println("1, 0, -1이 아닙니다.")
    }
}

fun judgeNumber2(number: Int){
    when{
        number == 0 -> println("주어진 숫자는 0 입니다.")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어진 숫자는 홀 수 입니다.")
    }
}