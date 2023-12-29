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