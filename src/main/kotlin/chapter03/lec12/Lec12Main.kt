package chapter03.lec12

//= 3. 익명 클래스 사용 방법 =//
fun main(){
    moveSomething(object : Movable{
        override fun move() {
            println("무브 무브")
        }

        override fun fly() {
            println("날다 날다")
        }

    })
}

private fun moveSomething(movable: Movable){
    movable.move()
    movable.fly()
}

//= 1. static 함수와 변수  =//

class Person(
    var name: String,
    var age: Int = 1
){
    private  val MIN_AGE: Int = 1
    //코틀린에서는 static 이 존재 하지 않는다. (companion object를 사용한다.)
    //companion object에 유틸성 함수들을 넣어도 되지만, 최상단 파일을 활용하는 것을 추천
    companion object  Factory : Log {
        private const val MIN_AGE = 0  // const를 붙여주면 컴파일 시 변수가 할당되고 붙이지 않을 경우 런타임시 할당
        //const 는 기본 타입과 String에만 붙일 수 있음
        //fun newBaby(name: String) = Person(name, MIN_AGE)
        @JvmStatic
        fun newBaby(name: String): Person{
            return Person(name, MIN_AGE)
        }

        override fun lon() {
            println("나는 Person 클래스의 동행객체 Factory 에요.")
        }
    }
}

interface Log{
    fun lon()
}