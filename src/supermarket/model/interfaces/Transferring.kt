package supermarket.model.interfaces

/**
 * Интерфейс передачи товара между двумя [ProductContainer].
 */
interface Transferring<T, E> {
    val source: Container<E, T>
    val recipient: Container<T, E>

    suspend fun transfer(product: T)
    suspend fun transferBack(product: E)
}