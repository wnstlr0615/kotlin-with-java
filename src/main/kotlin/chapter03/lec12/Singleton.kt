package chapter03.lec12

//= 2. 싱글톤 =//
fun main(){
    println(Singleton.a)
    Singleton.a += 10
    println(Singleton.a)
}
// 코틀린에서의 싱글톤
object Singleton {
    var a: Int = 0
}