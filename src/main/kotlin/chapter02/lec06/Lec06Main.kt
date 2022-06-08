package chapter02.lec06

fun main(){
    //= 1. for-each =//
    println("for- each 문")
    val numbers = listOf(1L, 2L, 3L)
    for(number in numbers){
        println(number)
    }

    //== 2. 전통적인 for 문 ==//
    println("전통적인 for문")
    for(i in 1..3){
        println(i)
    }


    //= 3.Progression 과 Range =//
    // for 문 동작 원리 1..5 사용시 등차 수열 생성후 step 함수 실행 후 2 대입
    println("내려가는 for문")
    for(i in 3 downTo 1){
        println(i)
    }

    println("2칸씩 증가")
    for(i in 1..5 step 2){
        println(i)
    }
    //== 4. while ==//
    println("while")
    var i = 0
    while(i <= 3){
        println(i)
        i++
    }
}