package chapter04.lec17

fun main(){
    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1200),
        Fruit("사과", 1200),
        Fruit("사과", 1500),
        Fruit("바나나", 3000),
        Fruit("바나나", 3200),
        Fruit("바나나", 2500),
        Fruit("수박", 10000),
    )
    //= 2. 코틀린에서 람다를 다루는 방법 =//
    // 익명 함수
    //람다를 만드는 방법 1
    val isApple1 = fun(fruit: Fruit) = fruit.name == "사과"
    //람다를 만드는 방법 2
    val isApple2 = {fruit: Fruit -> fruit.name == "사과"}

    // 호출 방법
    isApple1(fruits[0])
    isApple1.invoke(fruits[0])

    // 반환 타입 지정 방법
    val isApple3: (Fruit) -> Boolean = {fruit: Fruit -> fruit.name == "사과"}

    val apples: List<Fruit> = filterFruits(fruits, isApple1)

    filterFruits(fruits, { fruit: Fruit -> fruit.name == "사과" })
    filterFruits(fruits) { fruit -> fruit.name == "사과" }
    filterFruits(fruits) { it.name == "사과" }
    filterFruits(fruits) {
        println(it.name)
        it.name == "사과" // 람다 함수에 제일 마지막이 자동으로 return 된다.
    }

}
private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit>{
    val results = mutableListOf<Fruit>()
    for(fruit in fruits){
        if(filter.invoke(fruit)){
            results.add(fruit)
        }
    }
    return  results
}

class Fruit(
    val name: String,
    val price: Int
)