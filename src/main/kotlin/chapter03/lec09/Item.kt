package chapter03.lec09
fun main(){
    val item = Item(1L, "joon")
    println(item.name)
    item.name = "jun"
    println(item.name)

    println(item.count)

    val item1 = Item(1L, "joon", 10)

    println(item1.canSell)
    println(item1.isEmpty())
}

class Item(
    val itemId: Long,
    name: String,
    var count: Int
) {
    var name: String = name
        set(value) {
            field = value.uppercase()
        }
    get() = field.plus(" Welcome!!")

    init{
        if(count < 0) throw IllegalArgumentException("아이템 갯수는 0개 이상이어야 합니다.")
    }
    constructor(itemId: Long, name: String): this(itemId, name, 0){
        println("부 생성자")
    }

    val canSell: Boolean = this.count > 0
    fun isEmpty() = this.count == 0
}