class GameViewModel : ViewModel() {
    // State global menggunakan StateFlow
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    
    // State lokal untuk input user
    var userGuess by mutableStateOf("")
        private set
        
    fun updateUserGuess(guessedWord: String){
        userGuess = guessedWord
    }
}