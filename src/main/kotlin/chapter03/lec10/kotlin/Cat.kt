package chapter03.lec10.kotlin

class Cat(
    species: String
) : Animal(species, 4){ // 상위 클래스 생성자 바로 호출

    override fun move() {
        println("고양이가 사뿐 사뿐 걸어가~")
    }

}