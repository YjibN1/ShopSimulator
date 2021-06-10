package supermarket.model

import load.nameOf

/**
 * Класс скидки на товар.
 * @param [generalDiscount] общая скидка на товар.
 * @param [discountForRetired] скидка для пенсионеров.
 */
data class Discount(
    val generalDiscount: Int,
    val discountForRetired: Int,
) {
    init {
        require(generalDiscount in 0..100) {
            "Процент ${this.nameOf()} задан неверно."
        }
        require(discountForRetired in 0..100) {
            "Процент ${this.nameOf()} задан неверно."
        }
    }
}