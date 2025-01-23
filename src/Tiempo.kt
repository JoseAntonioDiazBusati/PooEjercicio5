class Tiempo (var hora: Int, var minuto: Int, var segundo: Int) {

    constructor(hora: Int) : this(hora, 0, 0)

    constructor(hora: Int, min: Int) : this(hora, min, 0)

    companion object {
        const val MAX_HORA = 23
        const val MAX_SEGUNDOS = 86399
    }

    init {
        validar()
        ajustar()
    }

    private fun validar() {
        require( minuto >= 0) { "Los minutos deben ser positivos o cero!" }
        require( segundo >= 0) { "Los segundos deben ser positivos o cero!" }
        validarHora()
    }

    private fun validarHora() {
        require(hora in 0..MAX_HORA) { "La hora debe estar entre 0 y 23!" }
    }

    private fun ajustar() {
        val (minutosExtra, segundosAjustados) = ajustarUnidad(segundo)
        segundo = segundosAjustados
        minuto += minutosExtra

        val (horasExtra, minutosAjustados) = ajustarUnidad(minuto)
        minuto = minutosAjustados
        hora += horasExtra

        validarHora()
    }

    private fun ajustarUnidad(valor: Int): Pair<Int, Int> {
        val incremento = valor / 60
        val ajustado = valor % 60
        return Pair(incremento, ajustado)
    }

    private fun actualizarTiempoSegundos(){}

    private fun obtenerSegundos():Int{
        return (hora * 3600) + (minuto * 60) + segundo
    }

    fun decrementar(t:Tiempo):Boolean{
        try{
            print("Introduzca el decremento de horas: ")
            val horaReducida = readln().toInt()
            print("Introduzca el decremento de minutos: ")
            val minutoReducido = readln().toInt()
            print("Introduzca el decremento de segundos: ")
            val segundoReducido = readln().toInt()

                if (hora - horaReducida < 0 || segundo - segundoReducido < 0 || minuto - minutoReducido < 0) {
                    throw Exception()
                } else {
                    hora -= horaReducida
                    minuto -= minutoReducido
                    segundo -= segundoReducido

                    return true
                }
        }catch (e:Exception){
            println("NO PUEDE SER MENOR QUE LAS 0:00:00!!!")
            return false
        }
    }

    fun incrementar(t:Tiempo):Boolean {
        try{
            print("Introduzca el aumento de horas: ")
            val horaIncrementada = readln().toInt()
            print("Introduzca el aumento de minutos: ")
            val minutoIncrementado = readln().toInt()
            print("Introduzca el aumento de segundos: ")
            val segundoIncrementado = readln().toInt()

            if (hora+horaIncrementada > MAX_HORA || segundo+segundoIncrementado > MAX_SEGUNDOS) {
                throw Exception()
            } else {
                hora += horaIncrementada
                minuto += minutoIncrementado
                segundo += segundoIncrementado
                ajustar()
                return true
            }
        }catch (e:Exception){
           println("NO PUEDE SUPERAR LAS 23:59:59!!!")
           return false
        }
    }

    fun comparar(t: Tiempo): Int{
        return 0
    }

    fun copiar(): Tiempo{
        return Tiempo(hora,minuto,segundo)
    }

    fun copiar(t:Tiempo): Tiempo{
        this.hora = t.hora
        this.minuto = t.hora
        this.segundo = t.segundo
        return t
    }

    override fun toString(): String {
        return "${"%02d".format(hora)}h ${"%02d".format(minuto)}m ${"%02d".format(segundo)}s"
    }
}