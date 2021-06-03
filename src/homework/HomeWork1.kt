package homework

// Code with ❤️
//┌────────────────────────────┐
//│ Created by Gökhan ÖZTÜRK   │
//│ ────────────────────────── │
//│ GokhanOZTURK@AndroidEdu.IO │            
//│ ────────────────────────── │
//│ 29.05.2021                 │
//└────────────────────────────┘

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException


private operator fun LocalDate.minus(birthday: String?) {

    try {
        val parsedBirthday = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        val timeDifference = Period.between(parsedBirthday, this)

        if (!timeDifference.isNegative) {
            println("It's been " +
                    "${timeDifference.years} years " +
                    "${timeDifference.months}  months and " +
                    "${timeDifference.days} days since you birth.")
        } else {
            println("It seems you are coming from the future.")
        }

    } catch (e: DateTimeParseException) {
        println(e)
        println("Invalid date or format. Please check your input.\nFormat type must be dd/MM/yyyy")
    }

}


fun main() {
    print("Please enter your birthday - dd/MM/yyyy : ")

    val birthday = readLine()
    val todayDate = LocalDate.now()

    todayDate.minus(birthday)

    todayDate - birthday
    // or
    // todayDate - birthday
}