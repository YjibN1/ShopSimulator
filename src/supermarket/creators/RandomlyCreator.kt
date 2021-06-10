package supermarket.creators

interface RandomlyCreator<T> {
    fun getEntity():Map<String, T>
}