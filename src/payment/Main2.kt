import payment.*

fun main() {
    println("=== Система обработки платежей ===")

    val processor = PaymentProcessor()

    val payments = listOf(
        Payment("4111111111111111", 1000, CardType.VISA),
        Payment("5555555555555555", 2000, CardType.MASTERCARD),
        Payment("2222222222222222", 1500, CardType.MIR),
        Payment("1234567890123456", 500, CardType.UNKNOWN),
        Payment("123", -100, CardType.VISA) // Неправильный платеж
    )

    for (payment in payments) {
        println("\nОбработка платежа: $payment")
        val result = processor.pay(payment)
        processor.show(result)
    }

    println("\n=== Демонстрация enum ===")
    for (cardType in CardType.values()) {
        println("CardType: $cardType, ordinal: ${cardType.ordinal}")
    }
}