package learn_by_example
// para funções sem retorno: não colocar nada ou usar Unit (representação de unidade de algo)
fun printMessageWithUnitReturn(message: String): Unit {
  println(message)
}

fun printMessageWithoutReturn(message: String) {
  println(message)
}

// Funções com parâmetros com valores default
// Se não passarem nada no parâmetro prefix, o valor vai ser INFO
fun printMessageWithPrefix(message: String, prefix: String = "INFO") {
  // NÃO PRECISA CONCATENAR
  println("[$prefix] $message")
}

// Mesma função em Java:
//  public static void printMessageWithPrefixJava(String message, String prefix) {
//    if (prefix.length() == 0) {
//      prefix = "INFO";
//    }
//    System.out.println(String.format("[%s] %s", prefix, message));
//  }

// Exemplo de função com retorno:
fun sum(x: Int, y: Int): Int {
  return x + y
}

// Inline function:
fun multiply(x: Int, y: Int) = x * y

// vararg: parâmetro que recebe uma quantidade indefinida de um determinado tipo (como uma lista)
fun printAllValues(vararg messages: String) {
  // É possível iterar pelos valores da variável vararg:
  for (message in messages) println(message);
}

// Exemplo de função com vararg + outro parâmetro:
// Isso é possível graças à capacidade de usar parâmetros nomeados
fun printAllValuesWithPrefix(vararg messages: String, prefix: String) {
  for (message in messages) println("$prefix: $message");
}

// Em funções que chamam outras funções passando vararg, é necessário usar *
fun log(vararg entries: String) {
  printAllValues(*entries)
}


fun main() {
  println("Hello World!");

//
//  // Referenciando variáveis dentro de uma String:
//  val number1 = 5;
//  val number2 = 10;
//  println("$number1 + $number2 = " + (number1 + number2));
//
//  // Criando e iterando sobre um map:
//  val mapExample = mapOf(8 to "Eight", 9 to "Nine", 10 to "Ten");
//  for ((k, v) in mapExample) {
//    println("$k -> $v");
//  }

//  printMessageWithPrefix("Teste 1")
//  printMessageWithPrefix("Teste 2", "TESTE")
//  // Invertendo a ordem dos parâmetros:
//  printMessageWithPrefix(prefix = "TESTE", message = "Teste 3");
//
//  println(sum(4, 6))
//  println(multiply(4, 6));

  printAllValues("Teste 1", "Teste 2", "Teste 3", "Teste 4", "Teste 5")
  printAllValuesWithPrefix(
    "Teste 1", "Teste 2", "Teste 3", "Teste 4", "Teste 5",
            prefix = "TESTE"
  )

  log("Teste 1", "Teste 2", "Teste 3")
}
