package supermarket.model.interfaces

interface Container<T, E> {
    suspend fun add(product: T)
    suspend fun remove(product: E)
}