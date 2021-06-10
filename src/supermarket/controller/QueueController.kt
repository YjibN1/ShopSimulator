package supermarket.controller

import load.Customer
import kotlinx.coroutines.channels.Channel

class QueueController {
    // Очередь
    val queue = Channel<Customer>()

    // Добавляем в очередь
    suspend fun addCustomer(customer: Customer) {
        queue.send(customer)
    }

    // Убираем из очереди
    suspend fun removeCustomer(): Customer =
        queue.receive()
}