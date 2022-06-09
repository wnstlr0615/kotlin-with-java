package chapter03.lec14

import chapter03.lec14.Country.*

// 컴파일러가 Country의 모든 타입을 알고 있어 다른 타입에 대한 로직(else)을 작성 하지 않아도 된다.
fun handleCountry(country: Country){
    when(country){
        KOREA -> TODO()
        AMERICA -> TODO()
    }
}

fun main(){

}

sealed class HyundaiCar(
    val name: String,
    val price: Long
)

class Avante : HyundaiCar("아반떼", 1_000L)
class Sonata : HyundaiCar("소나타", 2_000L)
class Grandeur : HyundaiCar("그렌저", 3_000L)

// 컴파일러가 모든 타입을 알고 있기에 자동으로 추가된다.
fun handleHyundaiCar(hyundaiCar: HyundaiCar){
    when(hyundaiCar){
        is Avante -> TODO()
        is Grandeur -> TODO()
        is Sonata -> TODO()
    }
}