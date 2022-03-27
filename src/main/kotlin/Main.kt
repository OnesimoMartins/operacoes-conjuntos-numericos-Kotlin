import kotlin.system.exitProcess

class Main
    fun main(args: Array<String>) {

        val conjuntoA: ArrayList<Float>
        val conjuntoB: ArrayList<Float>

        telaInicial()
        when (lerNumeroPeloTeclado().toInt()) {
            1 -> {
                println("Conjunto A: ")
                conjuntoA = criarConjunto()
                println("\nConjunto B: ")
                conjuntoB = criarConjunto()
                executarTodasOpercoes(conjuntoA, conjuntoB)
            }
            2  -> {
                conjuntoA = gerarConjunto()
                conjuntoB = gerarConjunto()
                executarTodasOpercoes(conjuntoA, conjuntoB)
            }
            else -> {
                println("----Operação inválida----")
                exitProcess(1)

            }
        }
    }



