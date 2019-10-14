package WordSearch

/**
  * Created by iodone on {19-9-27}.
  */

object Solution {
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    val rows = board.length
    val colmuns = board(0).length
    val visited = Array.fill(rows, colmuns)(false)
    for (i <- 0 until rows) {
      for (j <- 0 until colmuns) {
        if (searchWord(word, visited, (i, j), board)) return true
      }
    }
    false
  }

  def isInBoard(position: (Int, Int), boad: Array[Array[Char]]) = {
    position._1 < boad.length && position._1 >= 0 && position._2 < boad(0).length && position._2 >= 0
  }

  def searchWord(word: String, visited: Array[Array[Boolean]], position: (Int, Int), board: Array[Array[Char]]): Boolean = {
    val nextActions = Array((0,-1),(-1,0),(0,1),(1,0))

    if (word.isEmpty) true
    else if (isInBoard(position, board) && word.head == board(position._1)(position._2) && !visited(position._1)(position._2)) {
      visited(position._1)(position._2) = true
      for (action <- nextActions) {
        val nextPosition = (action._1 + position._1, action._2 + position._2)
        if (searchWord(word.tail, visited, nextPosition, board) ) return true
      }
      visited(position._1)(position._2) = false
      false
    } else {
      false
    }
  }

  def main(args: Array[String]): Unit = {
    val board = Array(
      Array('A','B','C','E'),
      Array('S','F','C','S'),
      Array('A','D','E','E')
    )
    println(exist(board, "ABCCED"))
    println(exist(board, "SEE"))
    println(exist(board, "ABCB"))
  }
}
