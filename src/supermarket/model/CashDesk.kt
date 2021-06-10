package supermarket.model

import kotlinx.coroutines.channels.Channel
import load.AccountBalance
import load.Customer
import load.nameOf
import supermarket.creators.SupermarketConfig.RAND_CORE
import supermarket.creators.SupermarketConfig.QUEUE_LENGTH


// Касса
data class CashDesk(val id: Int, val balance: AccountBalance) {
    val customerQueue = Channel<Customer>(QUEUE_LENGTH.random(RAND_CORE))
    // Инициализатор
    init {
        require(id > 0) {
            "Поле id ${this.nameOf()} не может быть отрицательным."
        }
    }

}