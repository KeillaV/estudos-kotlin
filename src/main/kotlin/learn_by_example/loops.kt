package learn_by_example

// Uso de for each
fun printList(list: List<String>) {
    for (string in list) {
        println("It's a $string!");
    }
}

// Uso de while e do-while
fun eatACake() = println("Eat a cake")
fun bakeACake() = println("Bake a cake")

fun eatOrBakeACake() {
    var cakesEaten = 0
    var cakesBaked = 0

    while (cakesEaten < 5) {
        eatACake()
        cakesEaten++
    }

    do {
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)
}

// Uso de iterators
class Animal(val name: String)

class Zoo(val animals: List<Animal>) {
    operator fun iterator(): Iterator<Animal> {
        return animals.iterator()
    }
}


fun main() {
    val cakes = listOf("carrot cake", "cheese cake", "chocolate cake");
//    printList(cakes);

//    eatOrBakeACake()

    val animals = listOf(Animal("lion"), Animal("penguin"), Animal("tiger"))
    val zoo = Zoo(animals)

    for (animal in zoo) {
        println("Look, it's a ${animal.name}!")
    }

    // 0 <= i <= 3
    for (i in 0..3) {
        print(i)
    }

    // 0 <= i < 5
    for (i in 0 until 5) {
        print(i)
    }
    print(" ")

    // 0 <= i <= 10; i += 2
    for (i in 0..10 step 2) {
        print(i)
    }
    print(" ")

    // 5 >= i >= 0
    for (i in 5 downTo 0) {
        print(i)
    }
    print(" ")

    // Também é possível usar ranges com caracteres:
    for (c in 'a'..'f') {
        print(c)
    }
    print(" ")

    for (c in 'z' downTo 'm' step 2) {
        print(c)
    }

    verifyNumberRange(3)
    verifyNumberRange(7)
    verifyNumberRange(-1)
}

// Também é possível usar ranges em estruturas de condição:
fun verifyNumberRange(number: Int) {
    when (number) {
        in 0..5 -> println("The number is between 0 and 5")
        in 6..10 -> println("The number is between 6 an 10")
        else -> println("The number is out range")
    }
}