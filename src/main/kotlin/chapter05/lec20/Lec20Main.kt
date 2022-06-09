package chapter05.lec20

import chapter03.lec14.PersonDto
import chapter05.lec19.Person

fun main(){
    val person = Person("joon", 100)

    // 그 값 자체를 반환 (age 값을 반환 )
    val value1 = person.let{
        it.age
    }
    val value2 = person.run{
        this.age
    }
    //객체를 반환 Person 반환환
   val value3 = person.also{
        it.age
    }
    val value4 = person.apply{
        this.age
    }

    //= 3. 언제 어떤 scope funtion을 사용해야할까? =//
    // 3.1 let
    // 하나 이상의 함수를 call chain 결과를 호출 할 때
    val strings = listOf("APPLE", "CAR")
    strings.map{it.length}
        .filter {it > 3}
        .let(::println)
    //non-null 값에 대해서만 code block를 실행 시킬 때
    val str: String? = "Hello"
    val length = str?.let{
        println(it.uppercase())
        it.length
    }
    val numbers = listOf("one", "two", "three", "four")
    //일회성으로 제한된 영역에서 지역 변수를 만들 때
    val modifiedFirstItem = numbers.first()
        .let{firstItem ->
            if(firstItem.length > 5) firstItem else "!$firstItem!"
        }.uppercase()
    println(modifiedFirstItem)

    //3.2 run
    // 객체 초기화와 반환 값의 계산을 동시에 해야 할 때
    // 객체를 만들어 DB에 바라 저장하고 인스턴스를 활용할 때
    //val person1 = Person("joon", 100).run(personRepository::save)
    /*val person1 = Person("joon", 100).run{
        hobby = "독서"
        personRepository.save(this)
    }
     */
    //val person = personRepository.save(Person("joon", 100))

    //3.3 apply
    //객체 그자체를 반환, 객체 설정을 할 때에 객체를 수정하는 로직이 call chain 중간에 필요할 때
    fun createPerson(
        name: String,
        age: Int,
        hobby: String
    ): Person{
       return Person(
           name = name,
           age = age,
       ).apply{
           //this.hobby = hobby
       }
    }
    /*
    val person2 = Person("joon", 100)
    person.apply{this.growIld()}
        .let{println(it)}
    */

    //3.4 also
    // 객체 그자 체 반환
    // 객체를 수정하는 로직이 call chain 중간에 필요할 때
    mutableListOf("one", "two", "three")
        .also {println("four 추가 이전 지금 값 : $it")}
        .add("four")
    //3.5 with
    //특정 객체를 다른 객체로 변환 해야 하는데 모듈 간의 의존성에 의해 정적 팩토리 혹은 toClass 할수를 만들기 어려울 때
    return with(person){
        PersonDto(
            name = name,
            age = age
        )
    }
    //this를 생략할 수 있어 필드가 많아도 코드가 간결해진다.

}
//= 1, scope function은 무엇인가? =//
fun printPerson(person: Person?){
    if(person != null){
        println(person.name)
        println(person.age)
    }
}

// 리팩터링
//람다를 사용해 일시적인 영역을 만들고 코드를 더 간결하게 만들거나, method chaning에 활용하는 함수
//let
fun printPerons1(person: Person?){
    person?.let{ //scope function 의 한종류
        println(it.name)
        println(it.age)
    }
}
//= 2. scope function의 분류 =//
// let, run, also, apply, with
// let, run  람다의 결과 반환
//also, apply 객체 그자체 반환

//let, also 는 it 사용
// run, apply 는 this 사용


//this : 생략이 가능한 대시 다른 이름을 붙일 수 없다.
//it : 생략이 불가능 한 대신, 다른 이름을 붙일 수 있다.

//with(파라미터 람다: this를 사용해 접근하고, this는 생략 가능하다.
