package learn_by_example


// High-Order functions: é uma função que recebe outra função como parâmetro e/ou retorna uma função
fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun sum(x: Int, y: Int) = x + y
fun multiply(x: Int, y: Int) = x * y

// High-order function retornando função
fun operation(): (Int) -> Int {
    return ::square
}

fun square(x: Int) = x * x

data class Item(val name: String, val price: Float)
data class Order(val items: Collection<Item>)

// Extension function: permite extender funções e propriedades dos elementos de forma global
// Extendendo funções para classe Order
fun Order.maxPricedItemValue(): Float {
   return this.items.maxByOrNull { it.price }?.price ?: 0F
}

fun Order.maxPricedItemName() = this.items.maxByOrNull { it.price }?.name ?: "NO PRODUCTS"

// extendendo propriedades de Order
val Order.commaDelimitedItemNames: String
    get() = items.map { it.name }.joinToString()

fun main() {
    // Infix functions: funções de membros de classes ou extensões com um único parâmetro
//    infix fun Int.times(str: String) = str.repeat(this)
//    println(2 times "Bye ")

    // Infix function nativa
    val pair = "Ferrari" to "Katrina"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    class Person(val name: String) {
        val likedPeople = mutableListOf<Person>()
        infix fun likes(other: Person) = likedPeople.add(other)

    }
    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia


    // Operator functions: a chamada da função pode ser realizada com o símbolo operador correspondente
    operator fun Int.times(str: String) = str.repeat(this)
    println(2 * "Bye ")

    val str = "A new life begins"
    operator fun String.get(range: IntRange) = substring(range)
    println(str[0..10])

    val sumResult = calculate(6, 5, ::sum)
    val multResult = calculate(6, 5, ::multiply)
    // Lambda functions: são uma maneira simples de criar funções ad-hoc. Permitem a inferência de tipo e o "it" implícito
    val subtResult = calculate(6, 5, {a, b -> a - b})
    println("Sum: $sumResult " +
            "\nMultiply: $multResult" +
            "\nSubtraction: $subtResult")

    // Diferentes exemplos de funções lambda
    val upperCase1: (String) -> String = { str: String -> str.uppercase()}
    val upperCase2: (String) -> String = { str -> str.uppercase() }
    val upperCase3 = { str: String -> str.uppercase() }
    val upperCase4: (String) -> String = { it.uppercase() }
    val upperCase5: (String) -> String = String::uppercase

    println(upperCase1("hello"))
    println(upperCase2("hello"))
    println(upperCase3("hello"))
    println(upperCase4("hello"))
    println(upperCase5("hello"))

    val func = operation()
    println(func(3))

    val order = Order(listOf(
        Item("Bread", 25.0F),
        Item("Wine", 29.0F),
        Item("Water", 12.0F)))

    println("Max priced item name: ${order.maxPricedItemName()}")
    println("Max priced item price: ${order.maxPricedItemValue()}")
    println("Items: ${order.commaDelimitedItemNames}")
}