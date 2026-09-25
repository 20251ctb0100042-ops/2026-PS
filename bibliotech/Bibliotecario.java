/*
 * Disciplina: 2026-PS
 * Projeto   : bibliotech
 * Arquivo   : Bibliotecario.java
 * Autor     : Luiz Henrique
 * Descricao : Bibliotecario e um tipo de Usuario.
 */

public class Bibliotecario extends Usuario {

    private String registroFuncional;

    public Bibliotecario(
        String nome,
        String matricula,
        String registroFuncional
    ) {
        super(nome, matricula);
        this.registroFuncional = registroFuncional;
    }

    public String getRegistroFuncional() {
        return registroFuncional;
    }

    @Override
    public String toString() {
        return "Bibliotecario " + getNome()
                + " (" + getMatricula()
                + ", funcional " + registroFuncional + ")";
    }
}