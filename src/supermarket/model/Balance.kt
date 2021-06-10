package supermarket.model

import load.nameOf

data class Balance(val cash: Int, val card: Int, val bonuses: Int) {
    init {
        require(cash >= 0) {
            "Поле cash ${this.nameOf()} не может быть отрицательным."
        }
        require(card >= 0) {
            "Поле card ${this.nameOf()} не может быть отрицательным."
        }
        require(bonuses >= 0) {
            "Поле bonuses ${this.nameOf()} не может быть отрицательным."
        }
    }
}