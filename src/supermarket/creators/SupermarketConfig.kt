package supermarket.creators

import kotlin.random.Random

object SupermarketConfig {
    /**
     * Зерно создателей, реализующих [RandomlyCreator]
     */
    const val SEED = 897152L
    val RAND_CORE = Random(SEED)

    /**
     * Наименования продуктов.
     */
    val PRODUCT_NAMES = listOf(
        "Apples", "Bananas", "Beer", "Bread", "Buckwheat", "Cheese", "Cheesecakes",
        "Cigarettes", "Cognac", "Cookies", "Cucumbers", "Drying", "Dumplings",
        "Eggs", "Gum", "Juice", "Lemonade", "Milk", "Noodles", "Oranges", "Pears",
        "Potatoes", "Rice", "Sausage", "Stew", "Sweets", "Tomatoes", "Vodka", "Wine"
    )

    val PRODUCT_NUMBER = 1000..10000
    val PRODUCT_PRICE = 100..1_000

    /* Моделирование */
    val customerSpawnRate = 10_000L
    val lengthOfDay = 24_000L
    val numberOfDays = 7

    /* Количество касс */
    val NUMB_OF_CASH_DESK = 2..6
    val QUEUE_LENGTH = 6..12

    /* Скидки */
    val GENERAL_DISCOUNT = 0..15
    val RETIRED_DISCOUNT = 0..5
}