package supermarket.model

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import load.ProductRecord
import supermarket.model.interfaces.ProductContainer

// Корзина
class Cart : ProductContainer<ProductRecord, ProductDescription> {
    /**
     * Защита [products] от одновременного изменения.
     */
    private val mutex = Mutex()

    /**
     * Коллекция [MutableMap]
     */
    private val products: MutableMap<String, ProductRecord> = mutableMapOf()

    override fun getNumber(name: String) =
        products.getOrDefault(name, ProductRecord(name, 0)).number

    override suspend fun add(product: ProductRecord) {
        mutex.withLock {
            var productNumber = product.number
            if (products.containsKey(product.name)) {
                productNumber += getNumber(product.name)
            }
            products[product.name] = ProductRecord(product.name, productNumber)
        }
    }

    override suspend fun remove(product: ProductDescription) {
        mutex.withLock {
            products[product.name] = ProductRecord(
                product.name,
                getNumber(product.name) - product.number
            )
        }
    }

    override fun toString() =
        products.toString()
}