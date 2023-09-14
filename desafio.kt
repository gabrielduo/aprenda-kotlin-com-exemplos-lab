// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

// Enum para representar o nível da Formação
enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

// Classe para representar Conteúdo Educacional
data class ConteudoEducacional(val nome: String, val nivel: Nivel)

// Classe para representar Alunos
data class Aluno(val nome: String, val email: String, val telefone: String)

// Classe para representar Formações
data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {
    private val inscritos = mutableListOf<Aluno>()

    // Método para matricular um ou mais Alunos
    fun matricular(vararg alunos: Aluno) {
        inscritos.addAll(alunos)
    }

    // Método para listar os Alunos inscritos
    fun listarInscritos(): List<Aluno> {
        return inscritos.toList()
    }

    // Função criativa que gera certificados personalizados usando let
    fun gerarCertificados() {
        println("Gerando certificados personalizados para os alunos da formação '$nome':")
        inscritos.forEach { aluno ->
            val mensagem = """
                Certificado de Conclusão
                Nome do Aluno: ${aluno.nome}
                Formação: $nome
                Nível da Formação: ${nivel}
                """
            println(mensagem)
        }
    }
}

fun main() {
    // Criar Alunos com nome, email e telefone
    val aluno1 = Aluno("Carlos", "carlos@email.com", "11-2222-3333")
    val aluno2 = Aluno("Isabela", "isabela@email.com", "22-3333-4444")
    val aluno3 = Aluno("Lucas", "lucas@email.com", "33-4444-5555")
    val aluno4 = Aluno("Ana", "ana@email.com", "44-5555-6666")
    val aluno5 = Aluno("Pedro", "pedro@email.com", "55-6666-7777")
    val aluno6 = Aluno("Laura", "laura@email.com", "66-7777-8888")
    val aluno7 = Aluno("Rafael", "rafael@email.com", "77-8888-9999")

    // Criar alguns Conteúdos Educacionais
    val conteudo1 = ConteudoEducacional("Desmistificando Kotlin", Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Trabalhando com Bancos de Dados", Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Modernizando seu Backend", Nivel.AVANCADO)
    val conteudo4 = ConteudoEducacional("Fundamentos de Computação em Nuvem", Nivel.BASICO)
    
    // Criar uma Formação e adicionar conteúdos a ela
    val formacao1 = Formacao("Backend com Kotlin e Java", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2, conteudo3))
    val formacao2 = Formacao("Descubra a Nuvem AWS", Nivel.BASICO, listOf(conteudo4))
    
    // Matricular os Alunos na Formação
    formacao1.matricular(aluno1, aluno2, aluno3, aluno4)
    formacao2.matricular(aluno4, aluno5, aluno6, aluno7)

    // Listar os inscritos na Formação com nome, email e telefone
    val inscritos_formacao1 = formacao1.listarInscritos()
    println("Alunos matriculados na formação 1:")
    inscritos_formacao1.forEach {
        println("Nome: ${it.nome}, Email: ${it.email}, Telefone: ${it.telefone}")
    }
    
    val inscritos_formacao2 = formacao2.listarInscritos()
    println("Alunos matriculados na formação 2:")
    inscritos_formacao2.forEach {
        println("Nome: ${it.nome}, Email: ${it.email}, Telefone: ${it.telefone}")
    }

    // Usar let para gerar certificados personalizados para os alunos
    formacao1.gerarCertificados()
    formacao2.gerarCertificados()
}