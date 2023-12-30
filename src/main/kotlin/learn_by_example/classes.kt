package learn_by_example

// instanciando uma classe sem atributos:
class Customer

// instanciando classe com construtor com parâmetros:
class Contact(val id: Int, var email: String)

fun main() {
    // não é necessário utilizar new
    val customer = Customer() // construtor padrão gerado pelo kotlin

    val contact = Contact(1, "maryjane@gmail.com")
    println(contact.id)

    // Atualizando variável mutável
    println(contact.email)
    contact.email = "jane@gmail.com"
    println(contact.email)

    val dog: Dog = Yorkshire();
    dog.sayHello()

    val tiger: Tiger = SiberianTiger()
    tiger.sayHello()

    val lion: Lion = AsiaticLion("Rufus")
    lion.sayHello()
}

// Aplicação de herança
// Toda classe kotlin por padrão é final, para permitir a herança da classe, é necessário adicionar o modificador open
open class Dog {
    // Para uma função poder ser sobrescrita, é necessário ter o modificador open
    open fun sayHello() {
        println("Au au!")
    }
}

// Extendendo a classe Dog (equivalente ao extends)
class Yorkshire: Dog() {
    override fun sayHello() {
        println("Wif wif!")
    }
}

// Herança com construtor parametrizado:
open class Tiger(val origin: String) {
    fun sayHello() = println("A tiger from $origin says: grrhhh!")
}

class SiberianTiger: Tiger("Siberia")

// Passando argumentos do construtor para superclasse:
open class Lion(val name: String, val origin: String) {
    open fun sayHello() = println("$name, a lion from $origin says: grrhhh!")
}

class AsiaticLion(name: String): Lion(name = name, origin = "India")

