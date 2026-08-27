public class Chamado {
    private final String idChamado;
    private String titulo;
    private String descricao;
    private int prioridade;
    private String status;
    private int diasAberto;

    public Chamado(String idChamado, String titulo, String descricao, int prioridade) {
        if (idChamado == null || idChamado.isBlank() || 
            titulo == null || titulo.isBlank() || 
            descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Campos de texto não podem ficar vazios!");
        }

        if (prioridade < 1 || prioridade > 5) {
            throw new IllegalArgumentException("A prioridade deve ser entre 1 e 5.");
        }

        this.idChamado = idChamado;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = "ABERTO";
        this.diasAberto = 0;
    }

    public Chamado(String idChamado, String titulo, String descricao) {
        this(idChamado, titulo, descricao, 1);
    }

    // Getters
    public String getIdChamado() { return idChamado; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public int getPrioridade() { return prioridade; }
    public String getStatus() { return status; }
    public int getDiasAberto() { return diasAberto; }

    public boolean setTitulo(String novoTitulo) {
        if (novoTitulo != null && !novoTitulo.isBlank()) {
            this.titulo = novoTitulo;
            return true;
        }
        return false;
    }

    public boolean alterarPrioridade(int novaPrioridade) {
        if ("FECHADO".equals(this.status) || novaPrioridade < 1 || novaPrioridade > 5) {
            return false;
        }
        this.prioridade = novaPrioridade;
        return true;
    }

    public boolean avancarStatus() {
        switch (this.status) {
            case "ABERTO" -> {
                this.status = "EM_ANDAMENTO";
                return true;
            }
            case "EM_ANDAMENTO" -> {
                this.status = "FECHADO";
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public boolean incrementarDias(int dias) {
        if ("FECHADO".equals(this.status) || dias <= 0) {
            return false;
        }
        this.diasAberto += dias;
        return true;
    }

    public String getResumo() {
        return String.format("ID: %s | Título: %s | Status: %s | Prioridade: %d | Dias aberto: %d",
                idChamado, titulo, status, prioridade, diasAberto);
    }
}