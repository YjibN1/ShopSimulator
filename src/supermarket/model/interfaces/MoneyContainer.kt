package supermarket.model.interfaces

interface MoneyContainer<T, E> : Container<T, E> {
    fun getTotalBalance(): Int
}