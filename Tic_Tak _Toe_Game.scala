import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import scala.util.Random

var board = ArrayBuffer[ArrayBuffer[String]]()
@main
def TicTacToeGame(): Unit = {
  var continueGame = true
  drawBoard()
  printBoard()

  while (continueGame)
    println("Please Enter the position , (e.g 1,2)")
    var input = StdIn.readLine()
    var x = 0
    var y = 0
    var skipRound = false

    try
      var positions = input.split(",")
      x = positions(0).trim.toInt
      y = positions(1).trim.toInt


      if (board(x-1)(y-1) != "")
        println("That position is already taken try again")
        skipRound = true
      else
        board(x-1)(y-1) = "x"
        printBoard()

      if (!skipRound)
        val playerWin = checkWinner(true)
        if (playerWin) {
          println("Congratulation You Win!")
          continueGame = false
        }
        val boardfull = checkBoardFull()
        if (boardfull & !playerWin) {
          println("It is a tie")
          continueGame = false
        }
      if (continueGame)
        computerSelection()
        printBoard()
        val computerWin = checkWinner(false)
        if (computerWin) {
          println("Computer is Win")
          continueGame = false

        } catch
      case e:Exception => println("Invalid input Try again")


}

def drawBoard(): Unit = {
  for (i <- 0 to 2)
    var row = ArrayBuffer[String]()
    for (j <- 0 to 2)
      row.addOne("")
    board.addOne(row)
}
def printBoard(): Unit = {
  println("----------")
  for (i <- 0 to 2)
    for (j <- 0 to 2)
      board(i)(j) match {
        case "x" => print("| x")
        case "o" => print("| o")
        case _ => print("|  ")
      }
    println("|  ")
  println("----------")
}

def randomPosition() = Random.nextInt(3)

def computerSelection(): Unit = {
  var i = randomPosition()
  var j = randomPosition()
  while (board(i)(j) != "")
    i = randomPosition()
    j = randomPosition()
  board(i)(j) = "o"

}

def checkWinner(player : Boolean): Boolean = {
  var winner = false
  val checkSymbol = if (player) "x" else "o"
  for (i <- 0 to 1)
    // Horizontal wins
    if (board(i)(0) == checkSymbol && board(i)(1) == checkSymbol && board(i)(2) == checkSymbol)
      winner = true

  // Vertical wins
    if (board(0)(i) == checkSymbol && board(1)(i) == checkSymbol && board(2)(i) == checkSymbol)
      winner = true

  // Diagonal wins
    if (board(0)(0) == checkSymbol && board(1)(1) == checkSymbol && board(2)(2) == checkSymbol)
      winner = true

    if (board(2)(0) == checkSymbol && board(1)(1) == checkSymbol && board(0)(2) == checkSymbol)
       winner = true

  winner

}

def checkBoardFull(): Boolean = {
  var fullBoard = true
  for (i <- 0 to 2)
    for (j <- 0 to 2)
      if (board(i)(j) == "")
        fullBoard = false
  fullBoard
}
