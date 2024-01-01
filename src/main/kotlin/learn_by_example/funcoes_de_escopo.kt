package learn_by_example

// Função let: pode ser usada para escopo e check de nulls.
// Quando chamado, o let executa o bloco de código passado e retorna o resultado da última expressão

fun customPrint(s: String) {
    print(s.uppercase())
}

fun printNonNull(str: String?) {
    println("Printing $str: ")
    // Verificando se string é nula
    // Se for nula, não imprime
    str?.let {
        print("\t")
        customPrint(it)
        println()
    }
}

fun printIfBothNonNull(strOne: String?, strTwo: String?) {
    // Caso exista mais que uma variável, é possível nomear as variáveis dentro do let
    strOne?.let { firstString ->
        strTwo?.let { secondString ->
            customPrint("$firstString : $secondString")
            println()
        }
    }
}

class Parrot(val name: String)
fun petParrot(parrot: Parrot?) {
    // Verificando se parrot é nulo
    parrot?.let {
        val parrotName = parrot.name
        println("Petting Parrot $parrotName, it's so cute!")
    }
}

// Função run: faz o mesmo que o let, a diferença é que o objeto pode ser referenciado como this dentro da função, permitindo a chamada dos métodos
fun getNullableLength(ns: String?) {
    println("\nFor \"$ns\": ")
    ns?.run {
        println("is empty? ${isEmpty()}")
        println("length = $length")
        length
    }
}

// Função apply: executa um bloco de código e retorna o objeto em si
// Usada para inicializar objetos
data class Person(var name: String, var age: Int, var about: String) {
    constructor() : this("", 0, "")
}

fun writeCreationLog(p: Person?) {
    p?.run {
        println("A new person $name was created.")
    }
}

class Configuration(val host: String, val port: String)
fun main() {
    val empty = "test".let {
        customPrint(it)
        it.isEmpty()
    }
    println(" is empty: $empty")
    printNonNull(null)
    printNonNull("Test 2")
    printIfBothNonNull(null, null)
    printIfBothNonNull(null, "Test")
    printIfBothNonNull("Test", null)
    printIfBothNonNull("Test 1", "Test 2")

    petParrot(Parrot("Billy"))
    petParrot(null)

    getNullableLength(null)
    getNullableLength("")
    getNullableLength("Teste")

    // Função with: permite acessar os atributos de uma instância sem mencioná-la
    val configuration = Configuration("localhost", "8080")
    // Ao invés de:
//    println("${configuration.host}:${configuration.port}")

    // Com with:
    with(configuration) {
        println("$host:$port")
    }

    // Também é possível usar o run:
    configuration.run {
        println("$host:$port")
    }

    val jake = Person()

    // Inicializando atributos com apply:
    jake.apply {
        name = "Jake"
        age = 30
        about = "Android Developer"
    }

    // Função also: funciona como o apply, a diferença é que o objeto dentro da função é referenciado como it

    println(jake.toString())

    val mary = Person("Mary", 20, "Baker")
        .also {
        writeCreationLog(it)
        }
}