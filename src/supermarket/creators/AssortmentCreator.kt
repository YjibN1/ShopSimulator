package supermarket.creators

import supermarket.creators.SupermarketConfig.GENERAL_DISCOUNT
import supermarket.creators.SupermarketConfig.PRODUCT_NUMBER
import supermarket.creators.SupermarketConfig.PRODUCT_PRICE
import supermarket.creators.SupermarketConfig.RAND_CORE
import supermarket.creators.SupermarketConfig.RETIRED_DISCOUNT
import supermarket.model.Assortment
import supermarket.model.Discount
import supermarket.model.ProductDescription
import supermarket.model.ProductDispensing

class AssortmentCreator {
    /**
     * Создание [Map] случайно сгенерированных экземпляров [ProductDescription].
     */
    fun getMapOfEntities(): Assortment {
        val assortSupMarket = Assortment()
        SupermarketConfig.PRODUCT_NAMES.forEach {
            assortSupMarket.addSync(getProductDescription(it))
        }
        return assortSupMarket
    }

    /**
     * Создание экземпляра [ProductDescription] на основе его [name] и [core].
     */
    private fun getProductDescription(name: String) =
        ProductDescription(
            name,
            // TODO: вынести 100г. в константу
            100 * PRODUCT_NUMBER.random(RAND_CORE),
            ProductDispensing.values()[
                    RAND_CORE.nextInt(ProductDispensing.values().size)
            ],
            PRODUCT_PRICE.random(RAND_CORE),
            getDiscount(),
            // Каждый 10й товар запрещён для продажи детям
            RAND_CORE.nextInt(0, 10) != 0
        )

    /**
     * Создание экземпляра [Discount].
     */
    private fun getDiscount() =
        Discount(
            GENERAL_DISCOUNT.random(RAND_CORE),
            RETIRED_DISCOUNT.random(RAND_CORE)
        )
}