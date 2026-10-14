fun main() {
    println(agoToText(seconds = 30))
    println(agoToText(seconds = 120))
    println(agoToText(seconds = 3600 * 3))
    println(agoToText(seconds = 3600 * 25))
    println(agoToText(seconds = 3600 * 50))
    println(agoToText(seconds = 3600 * 100))
}

fun agoToText(seconds: Int): String = when {
    seconds in 0..60 -> "был(а) только что"
    seconds in 61..(60 * 60) -> {
        val minutes = seconds / 60
        "был(а) $minutes ${minutesWord(minutes)} назад"
    }
    seconds in (60 * 60 + 1)..(24 * 60 * 60) -> {
        val hours = seconds / (60 * 60)
        "был(а) $hours ${hoursWord(hours)} назад"
    }
    seconds in (24 * 60 * 60 + 1)..(2 * 24 * 60 * 60) -> "был(а) вчера"
    seconds in (2 * 24 * 60 * 60 + 1)..(3 * 24 * 60 * 60) -> "был(а) позавчера"
    else -> "был(а) давно"
}

fun minutesWord(minutes: Int): String = when {
    minutes % 10 == 1 && minutes % 100 != 11 -> "минуту"
    minutes % 10 in 2..4 && minutes % 100 !in 12..14 -> "минуты"
    else -> "минут"
}

fun hoursWord(hours: Int): String = when {
    hours % 10 == 1 && hours % 100 != 11 -> "час"
    hours % 10 in 2..4 && hours % 100 !in 12..14 -> "часа"
    else -> "часов"
}