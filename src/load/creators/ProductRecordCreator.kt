package load.creators

import load.ProductRecord
import supermarket.creators.SupermarketConfig as config

class ProductRecordCreator {
    /**
     * Создание экземпляра [ProductRecord] на основе его [name] и [core].
     */
    fun getEntity(name: String) =
        ProductRecord(
            name,
            // TODO: вынести 100г. в константу
            config.RAND_CORE.nextInt(1000, 10000)
        )
}
