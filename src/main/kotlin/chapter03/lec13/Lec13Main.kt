package chapter03.lec13

fun main(){
    //val javaHouse = House("se")
}

class House(
    private var address: String,
    private var livingRoom: LivingRoom = LivingRoom(10.0),
    private var kitchenRoom: KitchenRoom
){
    // 코틀린에서 권장되는 중첩 클래스
    class LivingRoom(
        private var area: Double
    )

    //코틀린에서 권장되지않는 중첩 클래스
    // 기본 적으로 바깥 클래스를 참조 하지 않으면 바깥클래스를 참조하고 싶으면 inner 키워드를 추가한다.
    inner class KitchenRoom(
        private var area: Double
    ){
        val address: String
            get() = this@House.address // 바깥 클래스를 참조하는 방법
    }
}