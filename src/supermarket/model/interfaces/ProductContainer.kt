package supermarket.model.interfaces

interface ProductContainer<T, E> : Container<T, E> {
    fun getNumber(name: String): Int
}