package load.creators

import load.ProductRecord
import load.LoadConfig.RAND_CORE
import load.LoadConfig.PRODUCT_NAMES
import load.LoadConfig.PRODUCT_NUMBER
import load.LoadConfig.NUMBER_OF_PRODUCTS

class ShopListCreator() {
    fun getEntity(): Map<String, ProductRecord> {
        val shopList: MutableMap<String, ProductRecord> = mutableMapOf()
        val products: List<String> = PRODUCT_NAMES

        // TODO: убрать перезапись одного и того же продукта (потеря видов вродуктов)
        repeat(NUMBER_OF_PRODUCTS.random(RAND_CORE)) {
            val prName = products[RAND_CORE.nextInt(products.size)]
            shopList[prName] =
                ProductRecord(
                    prName,
                    PRODUCT_NUMBER.random(RAND_CORE)
                )
        }
        return shopList.toMap()
    }
}