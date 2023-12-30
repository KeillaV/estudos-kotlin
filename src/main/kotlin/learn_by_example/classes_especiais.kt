package learn_by_example

// Data classes : facilita a criação de classes usadas para guardar valores
// Possui métodos úteis para cópia, gerar representação em string, etc.

data class User(val name: String, val id: Int) {
    override fun equals(other: Any?): Boolean = other is User && other.id == this.id
}

fun main() {
    val user: User = User("João", 1)
    println(user)

    val secondUser: User = User("João", 1)
    println(user == secondUser)

    println(user.hashCode())
    println(user.copy())
    println(user.copy(name = "Maria"))

    val state = State.RUNNING

    println(greetMammal(Cat("Snow")))
    println(greetMammal(Human("Alex", "developer")))

    // Acessar um company object é similar a chamar métodos estáticos no Java:
    BigBen.getBongs(10)
}

// Enum classes:
enum class State {
    IDLE, RUNNING, FINISHED
}

// Sealed classes: classes que só podem ser herdadas por classes que estejam no mesmo pacote
sealed class Mammal(val name: String)

class Cat(val catName: String): Mammal(catName)
class Human(val humanName: String, val job: String): Mammal(humanName)

fun greetMammal(mammal: Mammal): String {
    when (mammal) {
        is Human -> return "Hello ${mammal.name}, you're working as a ${mammal.job}"
        is Cat -> return "Hello ${mammal.name}"
    }
}

// Palavra-chave object: usada para obter um tipo data com uma única implementação (Singleton)
// A palavra chave garante que será criada apenas uma instância daquela classe

// Declaração:
object DoAuth {
    fun takeParams(username: String, password: String) {
        println("$username: $password")
    }
}

// Companion objects:
// Declaração de object dentro de uma classe (companheiro?)
// Similar aos métodos estáticos em Java

class BigBen {
    companion object Bonger {
        fun getBongs(times: Int) {
            for (i in 0..times) {
                print("BONG ")
            }
        }
    }
}
