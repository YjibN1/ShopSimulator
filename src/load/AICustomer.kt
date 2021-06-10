package load

import kotlinx.coroutines.delay
import load.creators.ShopListCreator
import supermarket.model.interfaces.ProductContainer
import load.LoadConfig.RAND_CORE
import load.LoadConfig.TIME_FOR_ONE_CLIENT_ACTION
import supermarket.model.*

/**
 * Класс с алгоритмом поведения экземпляра [Customer].
 * @param [assortSupMarket] коллекция товаров магазина.
 * @param [customer] данные клиента.
 */
class AICustomer(
    val cashDesks: List<CashDesk>,
    private val assortSupMarket: ProductContainer<ProductDescription, ProductRecord>,
    val customer: Customer
) {
    companion object {
        const val ANSI_RED = "\u001B[31m"
        const val ANSI_YELLOW = "\u001B[33m"
        const val ANSI_RESET = "\u001B[0m"
    }

    private val shoppingList: Map<String, ProductRecord> = ShopListCreator().getEntity()

    // TODO: добавить допустимое время ожидания клиентом в очереди (waitingTime)

    suspend fun startModeling() {
        fillCart()
        joinQueue()
    }

    // Заполняем корзину
    private suspend fun fillCart() {
        println("${ANSI_RED}Клиент: ${customer.id} зашёл в магазин${ANSI_RESET}")
        //println("Список покупок: $shoppingList.")
        println("Клиент: ${customer.id} набирает корзину продуктов")
        transferProduct()
        // Клиент идёт на кассу
        performAnAction()

        // TODO: ожидание в очереди до оплаты
    }

    /**
     * Перекладывание продуктов в корзину из списка покупок с таймером.
     */
    private suspend fun transferProduct() {
        // Перебираем коллекцию желаемых покупок и смотрим, есть ли в магазине
        shoppingList.forEach() {
            if (assortSupMarket.getNumber(it.key) != 0) {
                println("${it.key} ${assortSupMarket.getNumber(it.key)} поместили в корзину")
                // Перекладываем из текущего ассортимента в корзину
                performAnAction()
                ProductTransfer(assortSupMarket, customer.cart).transfer(it.value)
            }
            // Ищем следующий продукт
            performAnAction()
        }
    }

    /* Встаём в очередь */
    private suspend fun joinQueue() {
        // TODO: отрефакторить
        val randCashDesk = RAND_CORE.nextInt(cashDesks.size)
        //!!!!
        cashDesks[randCashDesk].customerQueue.send(customer)
        println("${ANSI_YELLOW}Клиент: ${customer.id} встаёт в очередь на $randCashDesk кассу${ANSI_RESET}")
    }

    /**
     * Совершаем действие.
     */
    private suspend fun performAnAction() =
        delay(TIME_FOR_ONE_CLIENT_ACTION.random(RAND_CORE))
}