package load.creators

import load.AccountBalance
import supermarket.model.Cart
import load.Customer
import supermarket.model.CustomerGeneration
import load.LoadConfig as config

class CustomerCreator {
    companion object {
        var lastID = 0
    }
    /**
     * Создание экземпляра [Customer].
     */
    suspend fun getEntity(): Customer {
        lastID += 1
        return Customer(
            lastID,
            config.CUSTOMER_NAMES[config.RAND_CORE.nextInt(config.CUSTOMER_NAMES.lastIndex)],
            CustomerGeneration.values()[config.RAND_CORE.nextInt(
                CustomerGeneration.values().size
            )],
            Cart(),
            AccountBalanceCreator().getEntity()
        )
    }
}