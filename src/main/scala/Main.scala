import java.util.Scanner;
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing._
import java.awt.event.ActionListener
import java.awt.event.ActionEvent
import scala.collection.immutable.ListMap

/*------------------Con interfaz------------------
object SwingExample extends App {

    //val textArea = new JTextArea("Hello, Swing world")
    val file = new JTextField("Enter file name .txt")
    val scrollPane = new JScrollPane(file)
    val label = new JLabel()

    val frame = new JFrame("Hello, Swing")
    
    frame.setSize(new Dimension(600, 400))
    frame.setLocationRelativeTo(null)
    frame.setVisible(true)

    file.addActionListener(new ActionListener() {
      def actionPerformed(e: ActionEvent): Unit = {
        val nomArch = file.getText()
        val map = LeerArch.LeerArch(nomArch)
        LeerArch.mostrarRes(map, "God")
        LeerArch.estadisticas(map)
        
      }
    })

    frame.getContentPane.add(scrollPane, BorderLayout.CENTER)
}
*/

//------------------Con consola------------------
object Contador {

  def main(args: Array[String]): Unit = {
   
    print("Ingrese el archivo .txt que desea leer: ");
    var nomArch = scala.io.StdIn.readLine()
    print("Ingrese palabra que desea contar: ");
    var pal = scala.io.StdIn.readLine()

    val map = LeerArch.LeerArch(nomArch)
    LeerArch.mostrarRes(map, pal)
    LeerArch.estadisticas(map)

  }

}

object LeerArch {

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
    val contadorTotal = 0
    if(pal.isEmpty()){
      for ((k,v) <- elContador) printf("%s : %d\n", k, v)
    } else{
      val cant = elContador(pal)
      printf("%s : %s\n", pal, cant)
    }
  }
    
  def estadisticas(elContador : Map[String, Int]) = { 
    
    // Mayor a menor
    val res = ListMap(elContador.toSeq.sortWith(_._2 > _._2):_*)
    val top10Mas = res.take(10)
    val topMenor = res.last
    println("")
    println("Top 10 palabras más utilizadas")
    for ((k,v) <- top10Mas) printf("%s : %d\n", k, v)
    println("")
    println("Palabra menos utilizada")
    println(topMenor)
    println("")
 
  }

}
