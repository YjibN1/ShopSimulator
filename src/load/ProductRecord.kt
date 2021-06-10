package load

import supermarket.model.Product

data class ProductRecord(
    override val name: String,
    override val number: Int
) : Product(name, number) {
    init {
        require(name.isNotEmpty()) {
            "Поле с наименованием ${this.nameOf()} не может быть пустым."
        }
        require(number >= 0) {
            "Количество ${this.nameOf()} не может быть отрицательным."
        }
    }
}
