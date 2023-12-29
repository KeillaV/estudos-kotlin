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
}