fun main() {
    // var é uma variável mutável, pode ter seu valor reatribuído:
    var a: String = "Hello world!"; // Tipo definido
    println(a)
    var b = 10; // Tipo inferido
    println(b)
    b += 5; // atualizando valor
    println(b)

    // val é uma variávei imutável, só pode ter seu valor atribuído uma vez
    val pi: Double = 3.14
    println(pi)
    val c = 5
    println(c)

    verifyStudentAprovation("Marta", 9.5)
    verifyStudentAprovation("João", 5.0)
    verifyStudentAprovation("Carla", 6.7)

    // NULL SAFETY:
    // Para impedir as NullPointerException, as variáveis por padrão não podem receber valor null
    var notNull: String = "Non null" // non-null
    // notNull = null // Gera erro de compilação

    // Para tipos inferidos, o compilador tabmém assume o tipo non-null
    var inferredNonNull = "Infered non null"
    // inferredNonNull = null // Gera erro de compilação

    // Para declarar variáveis que podem assumir valor nulo, é necessário adicionar ?
    var nullable: String? = null // Não gera erro de compilação

    // Para funções que recebem valores non-null, passar um valor nullable como atributo gera um erro de compilação
    println(stringLengthNonNull(notNull))
//    stringLengthNonNull(nullable) // Gera erro de compilação

    // Função com condição para caso a string seja nula:
    println(stringLengthNullable(nullable))
}

fun stringLengthNonNull(string: String): Int {
    return string.length
}

fun stringLengthNullable(string: String?): Int {
    // Adiciona uma condição para caso a string ser nula retornar o valor 0
    // ?: -> Elvis operator
    return string?.length ?: 0
}

// Exemplo de aplicação de variável val:
fun verifyStudentAprovation(studentName: String, grade: Double) {
    val situation: String;
    if (grade >= 7) {
        situation = "aprovado(a)"
    } else if (grade < 7 && grade >= 6) {
        situation = "em recuperação"
    } else {
        situation = "reprovado(a)"
    }

    println("$studentName está $situation")
}