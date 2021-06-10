package supermarket.controller

import kotlinx.coroutines.*
import supermarket.creators.AssortmentCreator
import supermarket.creators.CashDeskCreator
import supermarket.model.Assortment

class SupermarketSimulator() {

    // Заполняем ассортимент продуктов
    val assortment = AssortmentCreator().getMapOfEntities()

    // Создаём кассы
    val cashDesks = CashDeskCreator().getEntity()

    suspend fun startModeling() =
        coroutineScope { // Создание coroutine scope
            // Запускаем кассы
            cashDesks.forEach() {
                launch(Dispatchers.Default) {
                    CashDeskController(it).startModeling()
                }
            }
        }
}

