object WordCount {

  def main(args: Array[String]): Unit = {

    val map = ReadFile.readFile()
    ReadFile.printContent(map)

  }

}
object ReadFile {
  /*
    This object has two functions
      1. readFile(): read the file line by line and split the string from the spaces
      and put them into Map. Map Key: the word found, Value: occurrences of the word

      2. printContent() : simple print function for print a Map.
  */

  def readFile(): Map[String, Int] ={
    val counter = scala.io.Source.fromFile("src//Files//theFile.txt")
      .getLines
      .flatMap(_.split("\\W+"))
      .foldLeft(Map.empty[String, Int]){
        (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
      }
    return counter
  }

  def printContent(counter : Map[String, Int]): Unit = {
    for ((k,v) <- counter) printf("%s : %d\n", k, v)
  }

}