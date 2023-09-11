enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val name: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuarios: List<Usuario>) {
        for(u in usuarios) {
	        inscritos.add(u)
        }
    }

    fun listarInscritos() {
        println("======================================")
        println("Formação: ${nome} - Nivel: ${nivel}")
        for (i in inscritos) {
            println("Nome: ${i.name}")
        }
    }
}

fun main() {
    // Cria disciplinas
    val disciplineKotlin = ConteudoEducacional("Kotlin")
    val disciplineAndroid = ConteudoEducacional("Android", 200)
    val disciplineNode = ConteudoEducacional("Node", 200)
    var disciplineJavascript = ConteudoEducacional("Javascript", 150)
    var disciplineMongodb = ConteudoEducacional("Mongodb", 100)

    // Cria conteudos
    val conteudosKotlin = listOf<ConteudoEducacional>(disciplineKotlin, disciplineAndroid)
    val conteudosNode = listOf<ConteudoEducacional>(disciplineNode, disciplineJavascript, disciplineMongodb)

    // Cria formação
    var formacaoKotlin = Formacao("Mobile Kotlin", Nivel.BASICO, conteudosKotlin)
    var formacaoNode = Formacao("Backend Node", Nivel.INTERMEDIARIO, conteudosNode)
    
    // Cria usuario
    var alunosKotlin: List<Usuario> = listOf(Usuario("Julian Campos"), Usuario("Marina"))
    var alunosNode: List<Usuario> = listOf(Usuario("Alice"), Usuario("Henrique"))
    
    // Matricula usuarios
    formacaoKotlin.matricular(alunosKotlin)
    formacaoNode.matricular(alunosNode)
    
    // lista usuarios matriculados
    formacaoKotlin.listarInscritos()
    formacaoNode.listarInscritos()
}