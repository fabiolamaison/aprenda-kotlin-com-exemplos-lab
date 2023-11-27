data class Usuario(var nome: String,var idade: Int,val email: String,val cpf: String)

enum class Nivel {BASICO, INTERMEDIARIO, AVANCADO}

enum class Tipo {CURSO, DESAFIO}

data class ConteudoEducacional (var nome: String,
                                val nivel: Nivel,
                                val tipo: Tipo,
                                val duracao: Int = 60,
                                var descricao: String ="",
                                var icone: String = "") {
    
}

data class Formacoes (val nome: String,
                      val nivel: Nivel,
                      var conteudo: List<ConteudoEducacional>,
                      var descricao: String ="",
                      var duracao: Int = 0,
                      var icone: String = "") {
    
    val inscritos = mutableListOf<Usuario>()
    
    init {
        attDuracao()
    }
    
    fun attDuracao (){
        for (i in conteudo) {
            duracao += i.duracao
        }
    }
    
    fun matricular (vararg usuarios: Usuario) {
        for (usuario in usuarios) {
            if(inscritos.contains(usuario)) {
                println("Usuário já inscrito")
            } else {
                inscritos.add(usuario)
                println("${usuario.nome} matriculado com sucesso")
            }
        }
    }
    
    fun matricular (usuarios: MutableList<Usuario>) {
        for (usuario in usuarios) {
            if(inscritos.contains(usuario)) {
                println("Usuário já inscrito")
            } else {
                inscritos.add(usuario)
                println("${usuario.nome} matriculado com sucesso")
            }
        }
    }
}

fun main() {
	val dAbstraindoKotlin: ConteudoEducacional = ConteudoEducacional("Abstraindo Formações da DIO Usando Orientação a Objetos com Kotlin", Nivel.BASICO, Tipo.DESAFIO, 120)
    val dLogicaProgramacao: ConteudoEducacional = ConteudoEducacional("Desafios de Código: Aperfeiçoe Sua Lógica e Pensamento Computacional", Nivel.BASICO, Tipo.DESAFIO, 60)
    val cPoderFuncoesKotlin: ConteudoEducacional = ConteudoEducacional("O Poder das Funções em Kotlin", Nivel.BASICO, Tipo.CURSO, 60)
    
    val backKotlinCont: MutableList<ConteudoEducacional> = mutableListOf(dAbstraindoKotlin, dLogicaProgramacao, cPoderFuncoesKotlin)
    
	val backKotlin: Formacoes = Formacoes("Desenvolvimento Back End com Kotlin", Nivel.BASICO, backKotlinCont)
    
    val usuario1: Usuario = Usuario("Fabio", 29, "fabio@endereco.com", "XXX.XXX.XXX-XX")
    val usuario2: Usuario = Usuario("Aisha", 23, "aisha@endereco.com", "YYY.YYY.YYY-YY")
    val usuario3: Usuario = Usuario("Mauricio", 18, "mauricio@endereco.com", "ZZZ.ZZZ.ZZZ-ZZ")
    val usuario4: Usuario = Usuario("Rebeca", 19, "rebeca@endereco.com", "WWW.WWW.WWW-WW")
    
    val listaUsuarios: MutableList<Usuario> = mutableListOf(usuario1, usuario2, usuario3) 
    val listaUsuarios2: List<Usuario> = listOf(usuario3, usuario4) 
    
    backKotlin.matricular(usuario1)
    backKotlin.matricular(usuario1, usuario2)
    
    backKotlin.matricular(listaUsuarios)
    backKotlin.matricular(*listaUsuarios2.toTypedArray())
    
    println(backKotlin)
}
