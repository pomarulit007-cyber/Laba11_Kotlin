import resources.*
import modules.*

fun handleModuleResult(result: ModuleResult) {
    when (result) {
        is ModuleResult.Success -> println("УСПЕХ: ${result.message}")
        is ModuleResult.ResourceProduced ->
            println("Произведено: ${result.resourceName} +${result.amount}")
        is ModuleResult.NotEnoughResources ->
            println("Недостаточно ресурса ${result.resourceName}. " +
                    "Нужно: ${result.required}, есть: ${result.available}")
        is ModuleResult.Error -> println("ОШИБКА: ${result.reason}")
    }
}

fun main() {
    println("=== Galaxy Outpost Manager ===")

    val manager = ResourceManager()
    manager.add(OutpostResource(id = 1, name = "Minerals", amount = 120))
    manager.add(OutpostResource(id = 2, name = "Gas", amount = 40))

    val generator = EnergyGenerator()
    val lab = ResearchLab()

    println("\nЗапуск модулей:")
    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)

    handleModuleResult(generatorResult)
    handleModuleResult(labResult)

    println("\nРесурсы базы:")
    manager.printAll()
}