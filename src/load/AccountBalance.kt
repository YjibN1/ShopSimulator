package load

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import supermarket.model.Balance
import supermarket.model.interfaces.MoneyContainer
import supermarket.model.interfaces.ProductContainer

class AccountBalance : MoneyContainer<Balance, Balance> {
    /**
     * Защита [totalBalance] от одновременного изменения.
     */
    private val mutex = Mutex()
    private var totalBalance: Balance = Balance(0, 0, 0)

    override fun getTotalBalance() =
        with(totalBalance) {
            cash + card + bonuses
        }

    override suspend fun add(product: Balance) {
        mutex.withLock {
            with(totalBalance) {
                totalBalance = totalBalance.copy(
                    cash = cash + product.cash,
                    card = card + product.card,
                    bonuses = bonuses + product.bonuses
                )
            }
        }
    }

    override suspend fun remove(product: Balance) {
        mutex.withLock {
            with(totalBalance) {
                totalBalance = totalBalance.copy(
                    cash = cash - product.cash,
                    card = card - product.card,
                    bonuses = bonuses - product.bonuses
                )
            }
        }
    }

    override fun toString(): String {
        return "${this.nameOf()}(cash=${totalBalance.cash}, card=${totalBalance.card}, " +
                "bonuses=${totalBalance.bonuses})"
    }
}