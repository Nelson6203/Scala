import java.util.Scanner;


object Contador {

  def main(args: Array[String]): Unit = {
   
    print("Ingrese archivo .txt que desea leer: ");
    var nomArch = scala.io.StdIn.readLine()
    print("Ingrese palabra que desea contar: ");
    var pal = scala.io.StdIn.readLine()

    val map = LeerArch.LeerArch(nomArch)
    LeerArch.mostrarRes(map, pal)

  }

}
object LeerArch {
  /*
    This object has two functions
      1. LeerArch(): read the file line by line and split the string from the spaces
      and put them into Map. Map Key: the word found, Value: occurrences of the word

      2. mostrarRes() : simple print function for print a Map.
  */

  def LeerArch(nomArch : String): Map[String, Int] ={
    val elContador = scala.io.Source.fromFile("src//Files//" + nomArch)
      .getLines
      .flatMap(_.split("\\W+"))
      .foldLeft(Map.empty[String, Int]){
        (cuenta, palabra) => cuenta + (palabra -> (cuenta.getOrElse(palabra, 0) + 1))
      }
    return elContador
  }

  def mostrarRes(elContador : Map[String, Int], pal : String): Unit = {
    if(pal.isEmpty()){
      for ((k,v) <- elContador) printf("%s : %d\n", k, v)
    } else{
      val cant = elContador(pal)
      printf("%s : %s\n", pal, cant)
    }
  }

}