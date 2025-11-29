import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import scala.util.Random


val words = List("elbow", "writer", "circle", "polish", "bridge", "store", "fang", "scarecrow", "show", "jeans", "wilderness", "attempt", "waxing", "aftermath", "banana", "wrist", "wheel", "spring", "cherries", "nerve")
var word = ""
val guesses = ArrayBuffer[Char]()
var remainingGuesses = 6
var mistakes = 0


@main
def hangMan(): Unit = {
  setupGame()

}

def setupGame(): Unit = {
  word = words(Random.nextInt(words.size)).toUpperCase
  println(word)
  for (i <- word.indices )
    guesses.addOne('_')

  var gameOver =false

  while(!gameOver) {
    printGameStatus()
    println("Please Enter a latter")
    val input = StdIn.readLine()
    if (input.isEmpty)
      println("That is a valid input , please inter again")
    else
      var latter = input(0).toUpper
      if (word.contains(latter))
        for (i <- word.indices)
          if (word.charAt(i) == latter)
            guesses(i) = latter
          if (!guesses.contains('_')) {
            println(s"Congratulations, You Wine ### The Word is $word")
            gameOver = true
          }
      else {
        println("Sorry, that is not part of word")
        remainingGuesses -= 1
        mistakes +=1
        if (mistakes == 6) {
          println(s"Sorry, You have lost ### The Word is $word ")
          gameOver = true
        }
        }

  }


}

def printGameStatus(): Unit = {
  mistakes match {
    case 0 => print0Mistakes()
    case 1 => print1Mistakes()
    case 2 => print2Mistakes()
    case 3 => print3Mistakes()
    case 4 => print4Mistakes()
    case 5 => print5Mistakes()
    case 6 => print6Mistakes()
  }
  print("Word:")
  for (i <- guesses)
    print(s"$i ")
  println(s"\nYou Have $remainingGuesses guess(es) left")
}

def print0Mistakes() =
  println("  |------|-")
  println("  |      |")
  println("  |       ")
  println("  |")
  println("  |")
  println("  |")
  println(" /|\\")
  println("/ | \\")

def print1Mistakes() =
  println("  |------|-")
  println("  |      |")
  println("  |      O")
  println("  |")
  println("  |")
  println("  |")
  println(" /|\\")
  println("/ | \\")

def print2Mistakes() =
  println("  |------|-")
  println("  |      |")
  println("  |      O")
  println("  |      |")
  println("  |      |")
  println("  |")
  println(" /|\\")
  println("/ | \\")

def print3Mistakes() =
  println("  |------|-")
  println("  |      |")
  println("  |      O")
  println("  |     /|")
  println("  |      |")
  println("  |")
  println(" /|\\")
  println("/ | \\")

def print4Mistakes() =
  println("  |------|-")
  println("  |      |")
  println("  |      O")
  println("  |     /|\\")
  println("  |      |")
  println("  |")
  println(" /|\\")
  println("/ | \\")

def print5Mistakes() =
  println("  |------|-")
  println("  |      |")
  println("  |      O")
  println("  |     /|\\")
  println("  |      |")
  println("  |     /")
  println(" /|\\")
  println("/ | \\")

def print6Mistakes() =
  println("  |------|-")
  println("  |      |")
  println("  |      O")
  println("  |     /|\\")
  println("  |      |")
  println("  |     / \\")
  println(" /|\\")
  println("/ | \\")
