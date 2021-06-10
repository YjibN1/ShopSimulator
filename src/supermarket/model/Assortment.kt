package supermarket.model

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import load.ProductRecord
import supermarket.model.interfaces.ProductContainer

class Assortment() : ProductContainer<ProductDescription, ProductRecord> {
    /**
     * Защита [products] от одновременного изменения.
     */
    private val mutex = Mutex()

    /**
     * Коллекция [ProductDescription]
     */
    private val products: MutableMap<String, ProductDescription> = mutableMapOf()

    override fun getNumber(name: String) =
        products[name]?.number ?: 0

    override suspend fun add(product: ProductDescription) {
        mutex.withLock {
            var productNumber = product.number
            if (products.containsKey(product.name)) {
                productNumber += getNumber(product.name)
            }
            products[product.name] = product.copy(number = productNumber)
        }
    }

    fun addSync(product: ProductDescription) {
        var productNumber = product.number
        if (products.containsKey(product.name)) {
            productNumber += getNumber(product.name)
        }
        products[product.name] = product.copy(number = productNumber)
    }

    override suspend fun remove(product: ProductRecord) {
        mutex.withLock {
            val number = getNumber(product.name) - product.number
            if (products.containsKey(product.name)) {
                products[product.name] = products[product.name]!!.copy(number = number)
            }
        }
    }

    override fun toString(): String =
        products.toString()
}