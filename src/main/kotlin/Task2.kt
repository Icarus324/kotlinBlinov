package task2

fun calculateCommission(
    cardType: String = "VK Pay",
    previousTransfers: Int = 0,
    transferAmount: Int
): Int = when (cardType) {
    "VK Pay" -> 0

    "MasterCard", "Maestro" -> {
        val total = previousTransfers + transferAmount
        if (total <= 75_000) 0
        else (transferAmount * 0.006).toInt() + 20
    }

    "Visa", "Мир" -> {
        val commission = (transferAmount * 0.0075).toInt()
        if (commission < 35) 35 else commission
    }

    else -> 0
}

fun main() {
    println(calculateCommission(transferAmount = 1000))
    println(calculateCommission(cardType = "MasterCard", previousTransfers = 0, transferAmount = 100_000))
    println(calculateCommission(cardType = "Visa", transferAmount = 1000))
    println(calculateCommission(cardType = "Мир", transferAmount = 10_000))
    println(calculateCommission(cardType = "Maestro", previousTransfers = 50_000, transferAmount = 30_000))
}