package supermarket.model

import load.ProductRecord
import supermarket.model.interfaces.ProductContainer
import supermarket.model.interfaces.Transferring

/**
 * Класс передачи товаров между [source] и [recipient].
 * @param [source] источник товаров.
 * @param [recipient] получатель товаров.
 */
class ProductTransfer(
    override val source: ProductContainer<ProductDescription, ProductRecord>,
    override val recipient: ProductContainer<ProductRecord, ProductDescription>
) : Transferring<ProductRecord, ProductDescription> {
    /**
     * Метод передачи товара от источника получателю.
     * @param [product] передаваемый товар.
     */
    override suspend fun transfer(product: ProductRecord) {
        // Сравниваем сколько в магазине и сколько требуется
        val diff = if (source.getNumber(product.name) >= product.number) {
            product.number
        } else {
            source.getNumber(product.name)
        }
        recipient.add(product.copy(number = diff))
        source.remove(product.copy(number = diff))
    }

    /**
     * Метод обратной передачи товара от получателя источнику.
     * @param [product] передаваемый товар.
     */
    override suspend fun transferBack(product: ProductDescription) {
        val diff = if (recipient.getNumber(product.name) >= product.number) {
            product.number
        } else {
            recipient.getNumber(product.name)
        }
        recipient.remove(product.copy(number = diff))
        source.add(product.copy(number = diff))
    }
}