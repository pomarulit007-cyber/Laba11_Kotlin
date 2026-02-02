import gameCharacter.*

fun main() {
    val hero = GameCharacter("Рыцарь Артур")

    hero.displayInfo()

    println("=== Тестирование состояний ===")

    hero.startRunning()
    handleState(hero.currentState)
    hero.displayInfo()

    hero.stopRunning()
    handleState(hero.currentState)
    hero.displayInfo()

    hero.takeDamage(30)
    handleState(hero.currentState)
    hero.displayInfo()

    hero.heal(20)
    handleState(hero.currentState)
    hero.displayInfo()

    hero.takeDamage(50)
    handleState(hero.currentState)
    hero.displayInfo()

    hero.takeDamage(40)
    handleState(hero.currentState)
    hero.displayInfo()

    hero.startRunning()
    handleState(hero.currentState)
    hero.displayInfo()


    val states: List<CharacterState> = listOf(
        CharacterState.Idle,
        CharacterState.Running,
        CharacterState.Attacking(25),
        CharacterState.Dead("Упал с обрыва")
    )

    for (state in states) {
        handleState(state)
    }
}