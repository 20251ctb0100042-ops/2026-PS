public class Aluno {

    private String matricula;
    private String nome;
    private String curso;
    private int idade;
    private String atributoExtra;

    public Aluno(String matricula, String nome, String curso, int idade, String atributoExtra) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.idade = idade;
        this.atributoExtra = atributoExtra;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getAtributoExtra() {
        return atributoExtra;
    }

    public void setAtributoExtra(String atributoExtra) {
        this.atributoExtra = atributoExtra;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula
                + " | Nome: " + nome
                + " | Curso: " + curso
                + " | Idade: " + idade
                + " | Atributo extra: " + atributoExtra;
    }
}