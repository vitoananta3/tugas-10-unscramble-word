@Composable
fun GameScreen(gameViewModel: GameViewModel = viewModel()) {
    val gameUiState by gameViewModel.uiState.collectAsState()
    
    // UI bereaksi terhadap perubahan state
    GameLayout(
        currentScrambledWord = gameUiState.currentScrambledWord,
        wordCount = gameUiState.currentWordCount,
        isGuessWrong = gameUiState.isGuessedWordWrong,
        userGuess = gameViewModel.userGuess,
        onUserGuessChanged = { gameViewModel.updateUserGuess(it) },
        onKeyboardDone = { gameViewModel.checkUserGuess() }
    )
    
    if (gameUiState.isGameOver) {
        FinalScoreDialog(
            score = gameUiState.score,
            onPlayAgain = { gameViewModel.resetGame() }
        )
    }
}