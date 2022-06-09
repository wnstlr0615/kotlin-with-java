package chapter03.lec14
fun main(){
    val dto1 = PersonDto("joon1", 30)
    val dto2 = PersonDto("joon2", 40)
    println(dto1 == dto2)
    println(dto1 === dto2)
    println(dto1)
    println(dto2)
}
//= 1. Data Class =//
data class PersonDto(
    private var name: String,
    private var age: Int
)