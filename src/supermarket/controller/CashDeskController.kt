package supermarket.controller

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import load.AICustomer
import load.LoadConfig.RAND_CORE
import load.LoadConfig.TIME_AT_CASH_DESK
import supermarket.model.Cart
import supermarket.model.CashDesk

// Контроллер кассы
class CashDeskController(val cashDesk: CashDesk) {
    companion object{
        const val ANSI_GREEN = "\u001B[32m"
        const val ANSI_RESET = "\u001B[0m"
    }
    /* Обработка клиентов */
    suspend fun startModeling() {
        while (true) {
            val y = cashDesk.customerQueue.receive()
            // Вызвать метод запроса оплаты
            delay(TIME_AT_CASH_DESK.random(RAND_CORE))
            println("${ANSI_GREEN}Клиент: ${y.id} обслужен на кассе ${cashDesk.id}$ANSI_RESET")
        }
    }
}