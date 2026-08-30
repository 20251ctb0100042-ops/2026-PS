public class Aluno {

    private String nome;
    private String matricula;
    private String curso;
    private String cidade;

    public Aluno(String nome, String matricula, String curso, String cidade) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    // toString: define a apresentacao textual da ficha
    @Override
    public String toString() {
        return matricula + " | " + nome + " | " + curso + " | " + cidade;
    }
}