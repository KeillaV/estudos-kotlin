// instanciando uma classe sem atributos:
class Customer

// instanciando classe com construtor com parâmetros:
class Contact(val id: Int, var email: String)


// implementação de generics:
// Classe para representação de pilha genérica para elementos E
class GenericStack<E>(vararg items: E) {
    private val elements: MutableList<E> = items.toMutableList();
    // Inline functions:
    fun push(element: E) = elements.add(element)

    fun peek(): E = elements.last()

    fun pop(): E = elements.removeLast() // elements.removeAt(elements.size - 1)

    fun isEmpty(): Boolean = elements.isEmpty()

    fun size(): Int = elements.size

    // Sobescrevendo o toString:
    // joinToString -> cria uma string com todos os elementos separados pelo valor repassado como parâmetro
    override fun toString() = "{${elements.joinToString(", ")}}"
}

// Função genérica
fun <E> genericStackOf(vararg elements: E) = GenericStack(*elements)


fun main() {
    // não é necessário utilizar new
    val customer = Customer() // construtor padrão gerado pelo kotlin

    val contact = Contact(1, "maryjane@gmail.com")
    println(contact.id)

    // Atualizando variável mutável
    println(contact.email)
    contact.email = "jane@gmail.com"
    println(contact.email)


    val stack: GenericStack<Int> = genericStackOf(1, 2, 3, 4, 5)
    println(stack)
    stack.push(6)
    println(stack)

    println(stack.size())
    // Referenciando retorno de método dentro de string
    println("peek(): ${stack.peek()}")
    println(stack.size())

    for (i in 1..stack.size()) {
        println("pop(): ${stack.pop()}")
    }
}