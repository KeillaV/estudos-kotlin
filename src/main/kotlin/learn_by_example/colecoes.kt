package learn_by_example

fun main() {
    // As listas podem ser mutáveis (MutableList) ou read-only (List)
    // Listas mutáveis podem ser alteradas, listas read-only não

    val users: MutableList<Int> = mutableListOf(1, 2, 3)
    val usersReadOnly: List<Int> = users

    println("Users size: ${usersReadOnly.size}")

    users.add(4)
    users.add(5)

    println("Users size: ${usersReadOnly.size}")

    usersReadOnly.forEach {
        i -> println("User ID: $i")
    }

//    usersReadOnly.add(6) // Erro!


    // Sets: estrutura que não permite a adição de elementos duplicados
    // Pode ser mutável (MutableSet) ou read-only (Set)

    val issues: MutableSet<String> = mutableSetOf("description 1", "description 2", "description 3")
    fun addIssue(description: String): Boolean = issues.add(description)
    fun getStatusLog(isAdded: Boolean): String = if (isAdded) "registered" else "marked as duplicate and rejected"

    val newIssue = "description 4"
    val existingIssue = "description 1"

    println("$newIssue ${getStatusLog(addIssue(newIssue))}")

    println("$existingIssue ${getStatusLog(addIssue(existingIssue))}")

    // Map: coleção de pares chave/valor, onde a chave é única e serve para recuperar o valor correspondente
    // Pode ser mutável (MutableMap) ou read-only (Map)

    val playerPoints: MutableMap<Int, Int> = mutableMapOf(1 to 10, 2 to 15, 3 to 30)

    fun addPlayerPoints(playerId: Int) {
        if (playerPoints.containsKey(playerId)) {
            println("Updating player $playerId points!")
            playerPoints[playerId] = playerPoints.getValue(playerId).plus(5)
        } else {
            println("The given player id does not exist!")
        }
    }

    fun playerStatus() {
        playerPoints.forEach {
            k, v -> println("Player $k: $v points")
        }
    }

    playerStatus()
    addPlayerPoints(2)
    addPlayerPoints(5)
    addPlayerPoints(1)
    playerStatus()
}



