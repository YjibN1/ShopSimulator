package load.creators

import load.AccountBalance
import load.LoadConfig.AMOUNT_OF_CURRENCY
import load.LoadConfig.RAND_CORE
import supermarket.model.Assortment
import supermarket.model.Balance

class AccountBalanceCreator {
    suspend fun getEntity(): AccountBalance {
        val balance = AccountBalance()
        balance.add(
            Balance(
                AMOUNT_OF_CURRENCY.random(RAND_CORE),
                AMOUNT_OF_CURRENCY.random(RAND_CORE),
                AMOUNT_OF_CURRENCY.random(RAND_CORE)
            )
        )
        return balance
    }
}