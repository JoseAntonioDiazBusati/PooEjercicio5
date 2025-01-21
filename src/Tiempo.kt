class Tiempo (var hora: Int, var minuto: Int, var segundo: Int) {

    //constructor(hora: Int, minuto: Int,segundo: Int): this(hora,minuto,0)

    //constructor(hora: Int, minuto: Int,segundo: Int): this(hora,0,0)

    init {
        require(hora in 0..23) {"No pueden ser más de 24 horas o menos de 0."}
        require(minuto >= 0) {"No pueden ser menos de 0 minutos."}
        require(segundo >= 0) {"No pueden ser menos de 0 segundos."}
    }

    fun modificarTiempo(){
        do {
            if (segundo >= 60){
                segundo -= 60
                minuto++
            }
            if (minuto >= 60){
                minuto -= 60
                hora++
            }
            if (hora >=24){
                hora -= 24
            }
        }while (segundo >= 60 || minuto >= 60)
    }


    fun decrementar(t:Tiempo):Boolean{
        return true
    }

    fun incrementar(t:Tiempo):Boolean {
        return true
    }

    fun comparar(t: Tiempo): Int{
        return 0
    }

    override fun toString(): String {
        return "${hora}h ${minuto}m ${segundo}s"
    }
}