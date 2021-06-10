package supermarket.creators

import load.AccountBalance
import load.creators.CustomerCreator
import supermarket.creators.SupermarketConfig.NUMB_OF_CASH_DESK
import supermarket.creators.SupermarketConfig.QUEUE_LENGTH
import supermarket.creators.SupermarketConfig.RAND_CORE
import supermarket.model.CashDesk

class CashDeskCreator {
    companion object {
        var lastID = 1
    }

    fun getEntity(): List<CashDesk> {
        val cashDesks: MutableList<CashDesk> = mutableListOf()
        repeat(NUMB_OF_CASH_DESK.random(RAND_CORE)) {
            lastID += 1
            cashDesks.add(
                CashDesk(
                    lastID,
                    AccountBalance()
                )
            )
        }
        return cashDesks.toList()
    }
}