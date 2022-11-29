package modelos

class MecanicaProviderPrueba {
    companion object{
        val mecanicaList = listOf<Mecanica>(

            Mecanica(
                "Afinación",
                "https://refsul.com/wp-content/uploads/2019/02/afinacion.jpg",
                "afinacion"
            ),
            Mecanica(
                "Cambio de bandas",
                "https://autolab.mx/wp-content/uploads/2021/09/cambioa-banda.jpg",
                "bandas"
            ),
            Mecanica(
                "Cambio de aceite",
                "https://motor.elpais.com/wp-content/uploads/2019/04/cambio-aceite-coche.jpg",
                "aceite"
            )
        )
    }
}