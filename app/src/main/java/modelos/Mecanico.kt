package modelos

data class Mecanico(
    val nombre: String, val imagen: String, val telefono: String,
    val aceite: Int, val afinacion: Int, val alfombra: Int,
    val alineacion: Int, val amortiguadores: Int, val asientos: Int,
    val balanceo: Int, val bandas: Int, val empastado: Int,
    val encerado: Int, val pulido: Int)
