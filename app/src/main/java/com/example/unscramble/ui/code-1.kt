class GameViewModel : ViewModel() {
    // Game UI state
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    
    // Update state menggunakan flow
    _uiState.update { currentState ->
        currentState.copy(
            isGuessedWordWrong = false,
            currentScrambledWord = pickRandomWordAndShuffle(),
            currentWordCount = currentState.currentWordCount.inc(),
            score = updatedScore
        )
    }
}