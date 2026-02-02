package gameCharacter

fun handleState(state: CharacterState) {
    when (state) {
        CharacterState.Idle -> println("Персонаж бездействует")
        CharacterState.Running -> println("Персонаж бежит")
        is CharacterState.Attacking -> println("Персонаж атакует с уроном ${state.damage}")
        is CharacterState.Dead -> println("Персонаж мертв. Причина: ${state.reason}")
    }
}