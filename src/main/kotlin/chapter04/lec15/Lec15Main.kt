package chapter04.lec15

fun main(){
    //= 1. 배열 =//
    val arr = arrayOf(100, 200)
    // 값을 차례로 출력
    for(i in arr){
      println("${i}")
    }

    // 인덱스 출력
    for(i in arr.indices){
        println("${i} ${arr[i]}")
    }
    // 인덱스와 값 출력
    for((idx, value) in arr.withIndex()){
        println("$idx $value")
    }

    // 배열에 새로운 값 추가
    arr.plus(100)
    println(arr.indices)

    //== 2. 코틀린에서의 Collection ==//
    // List
    val numbers = listOf(100, 200) // 불변
    val emptyList = emptyList<Int>() // 빈 리스트의 경우 타입 지정 필수
    printNumbers(emptyList()) // 타입 추론이 가능하다면 지정 하지 않을 수 있다.

    println(numbers[0])
    for(number in numbers){
        println(number)
    }
    for((idx, value) in numbers.withIndex()){
        println("$idx $value")
    }

    //가변 리스트
    // 불변 리스트를 만들고 필요에 따라서 가변리스트로 변환 하기기
   val numbers1 = mutableListOf(100, 200)
    numbers1.add(300)

    //set(list와 동일한 메소드를 가짐짐)
   val set = mutableSetOf(100, 200)
    for((idx, value) in set.withIndex()){
        println("$idx $value")
    }

    // map
    val oldMap =  mutableMapOf<Int, String>()
    oldMap[1] = "MONDAY"
    oldMap[2] = "TUESDAY"

    val map = mapOf(1 to "MONDAY", 2 to "TUESDAY")
    for(key in oldMap.keys){
        println(key)
        println(oldMap[key])
    }

    for((key, value) in oldMap.entries){
        println(key)
        println(oldMap[key])
    }

}

private fun printNumbers(numbers: List<Int>){

}