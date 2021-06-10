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
