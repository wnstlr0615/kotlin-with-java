package chapter03.lec11

fun main(){

}

val NUM = 3
fun add(a: Int, b: Int): Int{
    return a + b
}

fun add1(a: Int, b: Int) = a + b

open class Cat protected constructor(

){

}
// 파일 최상단에 바로 유틸함수 작성 가능
fun isDirectoryPath(path: String): Boolean{
    return path.endsWith("/")
}

fun isDirectoryPath1(path: String) = path.endsWith("/")


class Car(
    internal val name: String, // getter와 setter에 한번에 접근 지시어 설정
    private var owner: String,
    _price: Int
){
    var price = _price
    private set // setter에만 접근 지시어 설정
}