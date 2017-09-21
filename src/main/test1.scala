/**
  * Created by geco on 20/06/17.
  */

class escribeCha {
  def escribe: String = "cha"
}
class escribeChe {
}
class escribeChaChe extends escribeCha {
  override def escribe: String = "che"
}
val cha = {new escribeCha}.escribe
val chache = {new escribeChaChe}.escribe
println(cha)
println(chache)
