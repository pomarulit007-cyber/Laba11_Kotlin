package example

fun main() {
    handleOrder(OrderState.Created)
    handleOrder(OrderState.Paid)
    handleOrder(OrderState.Cancelled("Нет товара"))
}