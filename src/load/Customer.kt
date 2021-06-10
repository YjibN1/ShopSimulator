package load

import supermarket.model.Cart
import supermarket.model.CustomerGeneration

/**
 * Класс данных, описывающий модель клиента супермаркета.
 *
 * @param [id] id номер клиента.
 * @param [name] имя клиента.
 * @param [age] возрастное поколение клиента (ребёнок, взрослый, пенсионер).
 * @param [cart] корзина с продуктами.
 * @param [payMethod] метод оплаты (наличные, карта, бонусы).
 */
data class Customer(
    val id: Int,
    val name: String,
    val age: CustomerGeneration,
    val cart: Cart,
    val wallet: AccountBalance

) {
    // Инициализатор
    init {
        require(id > 0) {
            "Поле id ${this.nameOf()} не может быть отрицательным."
        }
        require(name.isNotEmpty()) {
            "Поле с именем ${this.nameOf()} не может быть пустым."
        }
    }
}