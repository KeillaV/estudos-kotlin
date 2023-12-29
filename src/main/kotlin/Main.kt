// Função main:
//fun main() {
//  println("Hello World!");
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
//}

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

fun main() {
  printMessageWithPrefix("Teste 1")
  printMessageWithPrefix("Teste 2", "TESTE")
  // Invertendo a ordem dos parâmetros:
  printMessageWithPrefix(prefix = "TESTE", message = "Teste 3");

  println(sum(4, 6))
  println(multiply(4, 6));

}
