package chapter01.lec02

fun main(){
    // 2. safeCall과 Elvis 연산자
    //= SaveCall 연산자 =//
    val str : String? = "ABC"
    //println(str.length) NULL을 허용하는 객체에 대하여 메소드 실행 시 에러 표시
    println(str?.length) // null이 아닐 경우에만 메소드 실행 아닐 경우 null 반환

    //= Elvis 연산자=//
    println(str?.length ?:0) // 앞의 연산 결과가 null 일경우 뒤의 값 사용

    // 4. 플랫폼 타입 : 코틀린이 null 관련 정보를 알수 없는 타입(@Nullable 가 없는 경우)
    // 코틀린과 자바에서는 어노이션을통해 null 여부를 확인 할 수 있다.
    // @Nullable 과같은 어노테이션이 없다면 컴파일러에서는 에러가 발생하지 않고 런타임때 에러가 발생하게된다.
    val person = Lec02Main.Person(null)
    //startsWithA(person.getName())


}
fun startsWithA(str :String): Boolean{
    return str.startsWith("A")
}



//3. null 이 아님을 단언
fun startsWith(str :String?):Boolean{
    return str!!.startsWith("A") // 느낌표로 선언시  절대로 null이 아님을 명시
}


//= saveCall 과 Elvis 사용 =//
fun startsWithA11(str :String?): Boolean { // null 이 들어 올 수 있음을 명시
    return str?.startsWith("A")
        ?:throw IllegalArgumentException("null이 들어왔습니다.")
}

fun startsWithA12(str :String?): Boolean? {
    return str?.startsWith("A")
}

fun startsWithA13(str :String?): Boolean {
    return str?.startsWith("A")
        ?: false
}


//= 자바 코드를 기본 적으로 옮긴 코드 =//
// 1. 코틀린에서 null을 다루는 방법
fun startsWithA1(str :String?): Boolean { // null 이 들어 올 수 있음을 명시
    if(str == null){
        throw IllegalArgumentException("null 이 들어왔습니다.")
    }
    return str.startsWith("A")
}

fun startsWithA2(str :String?): Boolean? {
    if(str == null){
        return  null
    }
    return str.startsWith("A")
}

fun startsWithA3(str :String?): Boolean {
    if(str == null){ //
        return  false
    }
    return str.startsWith("A")
}

// 3과 동일
// null 체크를 하지 않고 str.startsWith() 메소드 사용 시 컴파일러에서 에러 표시
fun startsWithA4(str :String?): Boolean {
    //return str.startsWith("A")   <-  null 허용 String 타입이 들어오므로 그냥 사용 시 컴파일러에서 에러 표시시
    return false; // < 상관 없는 false
}