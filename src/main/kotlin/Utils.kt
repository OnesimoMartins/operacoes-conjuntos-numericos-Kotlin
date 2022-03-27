import kotlin.random.Random

// gera e ordena um conjunto numérico de 10 elementos com números de 1 a 20
fun gerarConjunto(): ArrayList<Float> {
    val resultado =ArrayList<Float>()

    while (resultado.size!=10){// enquanto a lista não tiver 10 números, adicione os números randomicos
        val rand:Number=Random.nextInt(20).toFloat()
        if (!resultado.contains(rand as Float))
            resultado.add(rand)
    }

    resultado.sort()//ordena os elemetos do conjunto
    return ArrayList(HashSet(resultado))
}

//cria um conjunto numérico de n elementos
fun criarConjunto():ArrayList<Float>{
    val conjunto=ArrayList<Float>()
    while (true){
        print("\n Digite o elemento :")
        conjunto.add(lerNumeroPeloTeclado() as Float)
        print("Deseja continuar? (S/N) :")
        if ((lerStringPeloTeclado()?.uppercase() ?: 'S') == "N"){
            println("Conjunto Criado com sucesso")
            break
        }
    }

    return ArrayList(HashSet(conjunto).toList())

}
fun lerNumeroPeloTeclado():Number{
    try {
   return( readLine()?.toFloat() ?: throw  NumberFormatException())
      }catch (err:NumberFormatException){
        println("---NÚMERO INVÁLIDO INSERIDO---")
    }
   return -1
}
fun lerStringPeloTeclado()= readLine()
fun transformaListaEmString(lista:List<Any>)=// funcao que substitui '[]' por '{}'
    lista.toString().replace("[","{").replace("]","} ")


fun executarTodasOpercoes(conjuntoA: ArrayList<Float>, conjuntoB: ArrayList<Float>){
    println("\t\t\t\nCONJUNTO A: ${transformaListaEmString(conjuntoA)}")
    println("\t\t\t\nCONJUNTO B: ${transformaListaEmString(conjuntoB)}")
    println("\t\n--------Apresentando Todas as operações entre os conjuntos A e B -------- \n")
    println("CARDINAL de A: ${cardinal(conjuntoA)}")
    println("CARDINAL de B: ${cardinal(conjuntoB)}")
    println("UNIÃO : ${transformaListaEmString(uniao(conjuntoA,conjuntoB))}")

    println("INTERSECÇÃO: ${
        if(interseccao(conjuntoA, conjuntoB).isEmpty()) " NÃO HÁ INTERSECÇÃO ENTRE OS CONJUNTOS "
        else transformaListaEmString(interseccao(conjuntoA, conjuntoB))
    }")
    println("DIFERENÇA (A-B) : ${transformaListaEmString(diferenca(conjuntoA,conjuntoB))}")
    println("DIFERENÇA (B-A) : ${transformaListaEmString(diferenca(conjuntoB,conjuntoA))}")

   val(isComplementarA,complementarA)=complementar(ArrayList(conjuntoB),ArrayList(conjuntoA))
    println("COMPLEMENTAR de B em A : ${
        if(isComplementarA) complementarA?.let { transformaListaEmString(it) }
        else "NÃO EXISTE COMPLEMENTAR DE B EM A"
    }")

   val(isComplementarB,complementarB)=complementar(ArrayList(conjuntoA),ArrayList(conjuntoB))
    println("COMPLEMENTAR de A em B : ${
        if(isComplementarB) complementarB?.let { transformaListaEmString(it) }
        else "NÃO EXISTE COMPLEMENTAR DE A EM B"
    }")

    println("\nPRODUTO (AXB): ${produto(conjuntoA,conjuntoB)} \n")
    println("\nCONJUNTO DAS PARTES(PARTIÇÃO) A: ${transformaListaEmString(conjuntoPartes(conjuntoA))} \n")
    println("\nCONJUNTO DAS PARTES(PARTIÇÃO) B: ${ transformaListaEmString(conjuntoPartes(conjuntoB))} \n")
}