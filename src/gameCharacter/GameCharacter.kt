package gameCharacter

class GameCharacter(val name: String) {
    private var _health: Int = 100
    var currentState: CharacterState = CharacterState.Idle

    val health: Int
        get() = _health

    fun takeDamage(damage: Int) {
        if (_health > 0) {
            _health -= damage
            if (_health <= 0) {
                _health = 0
                currentState = CharacterState.Dead("Потерял все здоровье")
            } else {
                currentState = CharacterState.Attacking(damage)
            }
        }
    }

    fun heal(amount: Int) {
        if (_health > 0) {
            _health += amount
            if (_health > 100) _health = 100
            currentState = CharacterState.Idle
        }
    }

    fun startRunning() {
        if (_health > 0) {
            currentState = CharacterState.Running
        }
    }

    fun stopRunning() {
        if (_health > 0) {
            currentState = CharacterState.Idle
        }
    }

    fun displayInfo() {
        println("=== Информация о персонаже ===")
        println("Имя: $name")
        println("Здоровье: $_health")

        when (val state = currentState) {
            CharacterState.Idle -> println("Состояние: Бездействие")
            CharacterState.Running -> println("Состояние: Бег")
            is CharacterState.Attacking -> println("Состояние: Атака (урон: ${state.damage})")
            is CharacterState.Dead -> println("Состояние: Мертв (причина: ${state.reason})")
        }
        println()
    }
}