package load

import kotlinx.coroutines.*
import load.creators.CustomerCreator
import supermarket.model.ProductDescription
import supermarket.model.interfaces.ProductContainer
import load.LoadConfig.RAND_CORE
import load.LoadConfig.TIME_BETWEEN_CUSTOMERS
import supermarket.model.CashDesk


// Создатель клиентов
class LoadSimulator(
    private val assortSupMarket: ProductContainer<ProductDescription, ProductRecord>,
    private val cashDesks: List<CashDesk>
) {
    /**
     * Создание и запуск экзмпляров нагрузки [AICustomer].
     */
    suspend fun startModeling() {
        var sum = 0L

        // Восстанавливаем контекст
        coroutineScope {
            repeat(5) {
                launch {
                    AICustomer(
                        cashDesks,
                        assortSupMarket,
                        CustomerCreator().getEntity()
                    ).startModeling()
                }
            }
            delay(TIME_BETWEEN_CUSTOMERS.random(RAND_CORE))
        }
    }
}