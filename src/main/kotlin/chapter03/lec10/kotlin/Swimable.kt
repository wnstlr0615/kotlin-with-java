package chapter03.lec10.kotlin

interface Swimable {
    val swimAbility: Int // backing field 가 없는 프로퍼티는 인터페이스에서 만들 수 있다.
    fun act(){
        println("어푸 어푸")
    }
}