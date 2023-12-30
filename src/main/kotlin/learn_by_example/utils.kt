package learn_by_example

fun main() {
    // filter: permite a filtragem de coleções a partir de um predicado
    // É retornada uma lista de valores que fazem match com o predicado utilizado
    val numbers = listOf(-3, -2, -1, 0, 1, 2, 3)
    val positives = numbers.filter{ i -> i > 0 }
    val negatives = numbers.filter { it < 0 } // palavra reservada it pode ser usada para referenciar o objeto de valor do predicado

    println("All numbers: $numbers")
    println("Only positives: $positives")
    println("Only negatives: $negatives")

    // map: permite a alteração de todos os elementos da coleção com base no predicado
    val doubled = numbers.map { x -> x * 2 }
    println("Doubled numbers: $doubled")
    val tripled = numbers.map { it * 3 }
    println("Tripled numbers: $tripled")

    // any: retorna true se existir ao menos um elemento que atenda ao predicado informado
    val anyNegative = numbers.any { it < 0 }
    val anyGreaterThan6 = numbers.any { it > 6 }
    println("Are there any negative numbers: $anyNegative")
    println("Are there any number greater than 6: $anyGreaterThan6")


    // flatMap: transforma cada elemento da coleção em um objeto iterável e retorna uma lista única dos resultados
    val fruitsBag = listOf("Apple", "Banana", "Orange")
    val vegetablesBag = listOf("Lettuce", "Carrot", "Pepper")
    val cart = listOf(fruitsBag, vegetablesBag) // uma lista que contém duas listas

    val mapBag = cart.map { it }
    val flatMapBag = cart.flatMap { it }

    println("Your bags: $mapBag")
    println("All your items: $flatMapBag")
}