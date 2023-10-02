///* დავალება I: (2 ქულა)
//დაწერეთ ფუნქცია, რომელიც მიიღებს 2 მთელ რიცხვს (n და m) და დააბრუნებს მთელი რიცხვების მასივს. ფუნქციამ უნდა
//გამოიანგარიშოს n - დან m - მდე დიაპაზონში ყველა ისეთი რიცხვი-პალინდრომი, რომელიც კვადრატში ახარისხებისას
//კვლავ პალინდრომს იძლევა. */

fun isPal(num: Int): Boolean {
    val strNum = num.toString()
    return strNum == strNum.reversed()
}

fun Palindrome(start: Int, end: Int): List<Int> {
    val result = mutableListOf<Int>()

    for (number in start..end) {
        if (isPal(number)) {
            val square = number * number
            if (isPal(square)) {
                result.add(number)
            }
        }
    }

    return result
}

fun main() {
    println("შეიყვანეთ n: ")
    val n = readLine()?.toIntOrNull() ?: 0

    println("შეიყვანეთ n: ")
    val m = readLine()?.toIntOrNull() ?: 1000

    val palindromes = Palindrome(n, m)

    if (palindromes.isEmpty()) {
        println("Error!")
    } else {
        println("პალინდრომები : ${palindromes.joinToString(", ")}")
    }
}


/*
*  დავალება III: (1 ქულა)
*  დაწერეთ ფუნქცია, რომელიც პარამეტრად მიიღებს ერთ მთელ რიცხვს
*  n – ს და დააბრუნებს მთელი რიცხვების მასივს,
*  რომელიც შედგენილი იქნება n - ის ყველა მარტივი გამყოფით. */

fun primeDivisors(inputNumber: Int): List<Int> {
    val divs = mutableListOf<Int>()
    var num = inputNumber

    if (num <= 1) {
        return divs
    }

    while (num % 2 == 0) {
        divs.add(2)
        num /= 2
    }

    var divisor = 3

    while (divisor * divisor <= num) {
        while (num % divisor == 0) {
            divs.add(divisor)
            num /= divisor
        }
        divisor += 2
    }

    if (num > 1) {
        divs.add(num)
    }

    return divs
}

fun main() {
    print("შეიყვანეთ ნატურალური რიცხვი: ")
    val n = readLine()?.toIntOrNull() ?: 0

    val result = primeDivisors(n)
    println("მარტივი გამყოფებია : $result")
}
