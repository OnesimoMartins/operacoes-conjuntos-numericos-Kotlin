import kotlin.collections.ArrayList

fun cardinal(conjunto: ArrayList<Float>)=conjunto.size

fun uniao(conjuntoA: ArrayList<Float>, conjuntoB: ArrayList<Float>):List<Float>{
    //une a lista A e B, retira os elementos repetidos e ordena-a
    return  ArrayList(HashSet<Float>(conjuntoA+conjuntoB))
}

fun interseccao(conjuntoA: ArrayList<Float>, conjuntoB: ArrayList<Float>):List<Float>{
  val resultado=ArrayList<Float>()

    for (item in conjuntoA){
        // para cada elemento de A, verifca se existe em B e se ainda não esta na lista de intersecção, caso não adicana na mesm
      if(conjuntoB.contains(item) && !resultado.contains(item))
         resultado.add(item)
    }
    resultado.sort()
   return resultado
}

fun diferenca(conjuntoA: ArrayList<Float>, conjuntoB: ArrayList<Float>):List<Float> {
  //cria uma cópia do conjunto A, organiza o conjunto B e remove todas as ocorrências de B em A
    val conjuntoAcopy = ArrayList(conjuntoA)
    conjuntoAcopy.removeAll(conjuntoB.toSet())
    return conjuntoAcopy
}

fun complementar(conjuntoA:ArrayList<Float>,conjuntoB:ArrayList<Float>):Pair<Boolean,List<Float>?>{
    val aux=ArrayList<Float>()

    conjuntoB.forEach{// encontra todas as ocorrências de B em A e adiciona em aux
        if(conjuntoA.contains(it))
            aux.add(it)
    }
    if (aux == conjuntoB) {// se o conjunto B estiver contido em A retorne o conjunto A sem o conjunto B
        //TODO
        conjuntoA.removeAll(conjuntoB.toSet())
        return Pair(true, conjuntoA)
    }
    // se o conjunto B for vazio retorna o conjunto A
    else if (conjuntoB.isEmpty()) return Pair (true ,conjuntoA)

    //caso algum elemento de B não esteja em A, retorne false, pois, a operação não foi efetuada
    return Pair(false,null)
}

fun produto(conjuntoA: ArrayList<Float>, conjuntoB: ArrayList<Float>):ArrayList<ArrayList<Float>>{
  val resultado=ArrayList<ArrayList<Float>>()

    conjuntoA.forEach { itA ->
        conjuntoB.forEach{itB->// para cada ‘item’ do conjunto A una com todos os elementos do conjunto B
            resultado.add(ArrayList(listOf(itA as Float,itB as Float )))
        }
    }
    return resultado
}

fun conjuntoPartes(conjunto:ArrayList<Float>):List<List<Float>> {

   val combinacoes=ArrayList<List<Float>>()
   conjunto.forEach{
       combinacoes.add(listOf(it))// adiciona cada elemento da lista como um conjunto
   }
    fazCombinacoes(combinacoes,conjunto, 0 ,conjunto.size-1 )

    if (conjunto.size!=2)
        combinacoes.add(conjunto)

    combinacoes.add(listOf())//adiciona o conjunto vazio

  return combinacoes
}

private fun fazCombinacoes(combinacoes:ArrayList<List<Float>>,dados:ArrayList<Float>,
             inicio:Int,fim:Int){
    if (inicio==dados.size){// caso estejamos no ultimo elemento da lista, adicione a lista completa
        return
    }
    else if(inicio<=fim){//verifica se ainda não estamos no fim da lista
        val num =dados[inicio]
        for (i in inicio+1..fim){// repita do elemento a seguir ao início ate o último
                                     // elemnto da lista, adionando este par na lista de combinações
            combinacoes.add(ArrayList(listOf(num,dados[i])))
        }
        fazCombinacoes(combinacoes,dados,inicio+1,fim)//recursividade para todos elementos da lista
    }
}

