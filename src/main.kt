import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import load.LoadSimulator
import supermarket.controller.SupermarketSimulator
import supermarket.model.Balance


fun main() {
    // Объект супермаркета
    val supMarket = SupermarketSimulator()

    // Генератор клиентов
    val creator = LoadSimulator(supMarket.assortment, supMarket.cashDesks)

    runBlocking {
        launch { supMarket.startModeling() }
        launch { creator.startModeling() }
    }

}













const val ANSI_RESET = "\u001B[0m"
const val ANSI_BLACK = "\u001B[30m"
const val ANSI_RED = "\u001B[31m"
const val ANSI_GREEN = "\u001B[32m"
const val ANSI_YELLOW = "\u001B[33m"
const val ANSI_BLUE = "\u001B[34m"
const val ANSI_PURPLE = "\u001B[35m"
const val ANSI_LOL = "\u001b[H\u001b[2J"

fun pr() {
    //Оформление консоли
//https://github.com/ajalt/mordant
//https://opensourcelibs.com/lib/mordant
    println(ANSI_RESET.toString() + "This text is RESET!")
    println(ANSI_BLACK.toString() + "This text is BLACK!")
    println(ANSI_RED.toString() + "This text is RED!")
    println(ANSI_GREEN.toString() + "This text is GREEN!")
    println(ANSI_RESET.toString())

//    const val ANSI
    print(ANSI_LOL);

    println("Какого цвета Владек")

    println(ANSI_YELLOW.toString() + "This text is YELLOW!")
    println(ANSI_BLUE.toString() + "This text is BLUE!")
    println(ANSI_PURPLE.toString() + "This text is PURPLE!")
}