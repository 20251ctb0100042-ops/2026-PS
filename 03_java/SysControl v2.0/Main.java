public class Main {
    public static void main(String[] args) {
        System.out.println(">>> DIAGNÓSTICO DO MÓDULO DE CHAMADOS <<<\n");

        // 1. Instanciação dos chamados
        System.out.println("[1] Registrando novos chamados...");
        Chamado c1 = new Chamado("SUP-101", "Falha de Autenticação", "Usuário não consegue logar", 3);
        Chamado c2 = new Chamado("SUP-102", "Instabilidade no Servidor", "Lentidão nas consultas", 5);
        Chamado c3 = new Chamado("SUP-103", "Ajuste de Saldo", "Divergência de valores");

        System.out.println("-> " + c1.getResumo());
        System.out.println("-> " + c2.getResumo());
        System.out.println("-> " + c3.getResumo());
        System.out.println();

        // 2. Validação de Título Vazio/Branco
        System.out.println("[2] Testando validação de título em branco...");
        if (c1.setTitulo("   ")) {
            System.out.println("✔ Título atualizado com sucesso.");
        } else {
            System.out.println("✖ Falha ao alterar: o novo título é inválido.");
        }
        System.out.println("Título mantido: \"" + c1.getTitulo() + "\"");
        System.out.println();

        // 3. Validação de Prioridade Fora do Limite
        System.out.println("[3] Testando atribuição de prioridade inválida (-15)...");
        if (c1.alterarPrioridade(-15)) {
            System.out.println("✔ Prioridade alterada.");
        } else {
            System.out.println("✖ Falha ao alterar: valor de prioridade fora dos limites permitidos.");
        }
        System.out.println("Prioridade atual: " + c1.getPrioridade());
        System.out.println();

        // 4. Fluxo normal: Atualizar status e adicionar dias
        System.out.println("[4] Executando ciclo normal de atendimento...");
        c1.avancarStatus();
        c1.incrementarDias(15);
        System.out.println("Resultado da atualização: " + c1.getResumo());
        System.out.println();

        // 5. Teste de transição inválida (Encerrar e tentar avançar de novo)
        System.out.println("[5] Testando avanço em chamado já finalizado...");
        c2.avancarStatus(); // Transição 1
        c2.avancarStatus(); // Transição 2 (Encerrado)
        System.out.println("Status atual do chamado 2: " + c2.getStatus());

        if (c2.avancarStatus()) {
            System.out.println("✔ Status avançado com sucesso.");
        } else {
            System.out.println("✖ Ação bloqueada: Não é possível avançar um chamado já concluído.");
        }
        System.out.println();

        // Resumo final
        System.out.println("========================================");
        System.out.println("   RELATÓRIO FINAL DOS CHAMADOS");
        System.out.println("========================================");
        System.out.println("1. " + c1.getResumo());
        System.out.println("2. " + c2.getResumo());
        System.out.println("3. " + c3.getResumo());
    }
}