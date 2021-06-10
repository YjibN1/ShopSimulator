package load

import kotlin.random.Random

// TODO: считывать конфиг с ajax файла
object LoadConfig {
    /**
     * Имена клиентов магазина.
     */
    val CUSTOMER_NAMES = listOf(
        "Alexey", "Anton", "Boris", "Vadim", "Valeriy", "Vladimir",
        "Gleb", "Denis", "Egor", "Ivan", "Kirill", "Nikita", "Pavel",
        "Eduard", "Yuriy", "Alisa", "Alina", "Viktoria", "Diana", "Elena",
        "Yelizaveta", "Ksenia", "Ludmila", "Marina", "Nadezhda", "Olesya",
        "Olga", "Svetlana", "Tatiana", "Yana"
    )

    /**
     * Наименования товаров супермаркета.
     */
    val PRODUCT_NAMES = listOf(
        "Apples", "Bananas", "Beer", "Bread", "Buckwheat", "Cheese", "Cheesecakes",
        "Cigarettes", "Cognac", "Cookies", "Cucumbers", "Drying", "Dumplings",
        "Eggs", "Gum", "Juice", "Lemonade", "Milk", "Noodles", "Oranges", "Pears",
        "Potatoes", "Rice", "Sausage", "Stew", "Sweets", "Tomatoes", "Vodka", "Wine"
    )

    /* Зерно модели */
    const val SEED_OF_SIMULATOR = 54564L
    val RAND_CORE = Random(SEED_OF_SIMULATOR)

    /* Количество каждой валюты у клиента */
    val AMOUNT_OF_CURRENCY = 0..100_000

    /* Время между появлением новых клиентов */
   val TIME_BETWEEN_CUSTOMERS = 40..1800L

    /* Количество продуктов для одного покупателя */
    val NUMBER_OF_PRODUCTS = 2..8

    /* Количество продукта для одного покупателя */
    val PRODUCT_NUMBER = 10..1000

    // TODO: расширить виды и доступ продуктов
    /* Вес продукта для одного покупателя */
    val PRODUCT_WEIGHT = 10..1000

    /* Время для одного действия клиента */
    val TIME_FOR_ONE_CLIENT_ACTION = 10..100L

    /* Время на кассе для одного клиента */
    val TIME_AT_CASH_DESK = 50..100L



//    val lengthOfDay = 24_000L
//    val numberOfDays = 7


}