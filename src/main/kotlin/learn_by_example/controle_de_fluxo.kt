package learn_by_example

 // WHEN: substituto para switch case
// Utilizando como declaração:

// Any: equivalente a classe Object no Java
// is: equivalente a instanceOf
fun cases(obj: Any) {
    when (obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        // default
        else -> println("Unknown")
    }
}

// Utilizando como expressão (para atribuição de variáveis):
fun whenAssign(obj: Any): Any {
    val result = when(obj) {
        1 -> "one"
        "Hello" -> 1
        is Long -> false
        else -> 42
    }

    return result
}

// Inline function para retornar maior valor:
// If sendo usado como expression (equivalente ao ternário)
fun max(a: Int, b: Int) = if (a > b) a else b


fun main() {
    cases("Hello")
    cases(1)
    cases(5L)
    cases(true)
    cases(4)

    println(whenAssign(1))
    println(whenAssign("Hello"))
    println(whenAssign(1L))
    println(whenAssign("Teste"))
}