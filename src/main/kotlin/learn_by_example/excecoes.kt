package learn_by_example

import java.lang.ArithmeticException

fun main() {
    // Try é uma expression, pode ser atribuída a uma variável
    val a = 10
    val b = 2
    val c = 0

    val divisaoAB = try { a/b } catch (e: ArithmeticException) { 0 }
    val divisaoAC = try { a/c } catch (e: ArithmeticException) { 0 }

    println(divisaoAB)
    println(divisaoAC)

    // Não existem exceções checadas, como no Java (exceções com tratamento obrigatório)

}