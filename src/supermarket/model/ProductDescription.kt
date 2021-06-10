package supermarket.model

import load.nameOf

/**
 * Класс, описывающий товар.
 * @param [name] наименование.
 * @param [packing] формат фасовки (штучно или развес).
 * @param [number] количество (nшт. или 100*nг.).
 * @param [price] цена товара (за 1шт. или 100 г.).
 * @param [discount] скидка на товар.
 * @param [sellToChild] разрешен ли товар в продажу детям.
 */
data class ProductDescription(
    override val name: String,
    override val number: Int,
    val packing: ProductDispensing,
    val price: Int,
    val discount: Discount,
    val sellToChild: Boolean
) : Product(name, number) {
    // TODO: Написать класс для Руб. Коп.
    init {
        require(name.isNotEmpty()) {
            "Поле с наименованием ${this.nameOf()} не может быть пустым."
        }
        require(number >= 0) {
            "Количество ${this.nameOf()} не может быть отрицательным."
        }
        require(price > 0) {
            "Цена ${this.nameOf()} не может быть не положительной."
        }
    }
/*
    fun toProductRecord() =
        ProductRecord(this.name, this.number)*/
}