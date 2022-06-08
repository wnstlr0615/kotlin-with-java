package chapter03.lec10.kotlin

abstract class Animal(
    protected val species: String,
    protected open val legCount: Int
) {
    abstract fun move()
}