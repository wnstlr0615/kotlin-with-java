package chapter04.lec18


private val  List<Fruit>.samePriceFilter: List<Fruit>
    get() = this.filter(Fruit::isSamePrice)

fun main(){
    val fruits = listOf(
        Fruit(1L,"사과", 1000, 1000),
        Fruit(2L,"사과", 1200, 1200),
        Fruit(3L,"사과", 1200, 1200),
        Fruit(4L,"사과", 1500, 1500),
        Fruit(5L,"바나나", 3000,  3000),
        Fruit(6L,"바나나", 3200,  3200),
        Fruit(7L,"바나나", 2500,  2500),
        Fruit(8L,"수박", 10000, 10000)
    )
    // 사과만 호출
    val apples = fruits.filter { fruit -> fruit.name == "사과" }

    //인덱스도 같이 출력
    val apples2 = fruits.filterIndexed {idx, fruit ->
        println(idx)
        fruit.name == "사과"
    }
    // map
    val applePrices =
        fruits.filter { fruit -> fruit.name == "사과" }
            .map { fruit -> fruit.currentPrice }
    val applePrices2 =
        fruits.filter { fruit -> fruit.name == "사과" }
            .mapIndexed { idx ,fruit ->
                println(idx)
                fruit.currentPrice
            }
    // null은 제외
    val applePrices3 =
        fruits.filter { fruit -> fruit.name == "사과" }
            .mapNotNull { fruit -> fruit.nullOrValue() }

    //= 2. 다양한 컬렉션 처리 가능 =//
    // 모든 과일이 사과인지
    val isAllApple = fruits.all {fruit ->  fruit.name == "사과" }
    // 사과가 없는지
    val isNoApple = fruits.none {fruit ->  fruit.name == "사과" }
    //사과가 하나라도 있는지
    val isAnyApple = fruits.any() {fruit ->  fruit.factoryPrice >= 10_000 }
    //과일 중 사과 개수
    val countApple = fruits.count() {fruit ->  fruit.name == "사과"}
    // 오름차순 정렬
    val sortedFruitsAsc = fruits.sortedBy { fruit -> fruit.currentPrice }
    // 내림차순 정렬
    val sortedFruitsDesc = fruits.sortedByDescending { fruit -> fruit.currentPrice }
    // 중복 제거
    val distinctFruitNames = fruits.distinctBy { fruit -> fruit.name }
        .map{it.name}

    // 첫번째 과일
    val fruitFirst = fruits.first() // null이 아니여야함
    val fruitFirstNullAble = fruits.firstOrNull() // null이 아니여야함

    // 마지막 과일
    val fruitLast = fruits.last() // null이 아니여야함
    val fruitLastNullAble = fruits.lastOrNull() // null이 아니여야함


    //= 3. List 를 map으로 =//
    // 과일 이름으로 그룹핑핑
    val mapGroupBy: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }

    //중복되지 않은 키를 통한 매핑
    val mapAssociateBy: Map<Long, Fruit> = fruits.associateBy { fruit -> fruit.id }

    // 과일이름 과 List<출고가> 매핑
    val mapGroupByName: Map<String, List<Long>> = fruits.groupBy(
            { fruit -> fruit.name },
            { fruit -> fruit.currentPrice}
        )

    //아이디를 통한 출고가
    val mapAssociateById: Map<Long, Long> = fruits.associateBy(
        { fruit -> fruit.id },
        {fruit -> fruit.currentPrice}
    )

    // map으로 변형 후 필터링 처리
    val map: Map<String, List<Fruit>> = fruits.groupBy {fruit -> fruit.name}
        .filter{(key, value) -> key == "사과"}



    //= 4. 중첩된 컬렉션 처리 =//
    // 중첩 컬렉션 처리

    val fruitsInList: List<List<Fruit>> = listOf(
        listOf(
            Fruit(1L,"사과", 1000, 1000),
            Fruit(2L,"사과", 1200, 1200),
            Fruit(3L,"사과", 1200, 1200),
            Fruit(4L,"사과", 1500, 1500)
        ),
        listOf(
            Fruit(5L,"바나나", 3000,  3000),
            Fruit(6L,"바나나", 3200,  3200),
            Fruit(7L,"바나나", 2500,  2500)
        ),
        listOf(
            Fruit(8L,"수박", 10000, 10000)
        )
    )
    // 출고가와 현재가가 동일한 과일일
    val samePriceFruits = fruitsInList.flatMap {list ->
        list.filter { fruit ->
            fruit.factoryPrice == fruit.currentPrice
        }
    }
    // 확장 함수 사용
    val samePriceFruits1 = fruitsInList.flatMap{list -> list.samePriceFilter}
    // 중첩 리스트를 하나의 리스트로 만듬
    val flattenFruit = fruitsInList.flatten()

}
private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit>{
    return fruits.filter(filter)
}
data class Fruit(
    val id: Long,
    val name: String,
    val factoryPrice: Long = 0L,
    val currentPrice: Long = 0L
){
    fun nullOrValue() :Fruit?{
        return if(factoryPrice == 0L) null else this
    }
    // 중첩 컬렉션 처리
    val isSamePrice: Boolean
        get() = factoryPrice == currentPrice

}