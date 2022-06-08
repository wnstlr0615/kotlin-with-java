package chapter03.lec10.kotlin

class Penguin (
    species: String,
    ) : Animal(species, 2), Swimable, Flyable{
    override fun move() {
        println("펭귄이 움직입니다~ 꿱꿱")
    }
    private val wingCount: Int = 2

    //open 키워드를 사용하여 오버라이드가 가능하게 한다.
    override val legCount: Int
        get() = super.legCount + this.wingCount
    override val swimAbility: Int
        get() = TODO("Not yet implemented")

    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }

}