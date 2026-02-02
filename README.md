# Galaxy Outpost Manager

Учебный проект на Kotlin, демонстрирующий основы объектно-ориентированного программирования и архитектурные приёмы языка.

## Sealed-классы

Sealed-классы используются для представления ограниченного набора состояний или результатов, которые известны на этапе компиляции.

Они позволяют:
- гарантировать обработку всех возможных вариантов;
- безопасно использовать конструкцию when без else;
- удобно описывать состояния, события и результаты действий.

**Пример: результат работы модуля**
```kotlin
sealed class ModuleResult {
    data class Success(val message: String) : ModuleResult()
    data class ResourceProduced(val resourceName: String, val amount: Int) : ModuleResult()
    data class NotEnoughResources(
        val resourceName: String,
        val required: Int,
        val available: Int
    ): ModuleResult()
    data class Error(val reason: String) : ModuleResult()
}