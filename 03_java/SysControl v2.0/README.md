# SysControl - Módulo Chamado

## Variante
- Entidade: Chamado (Matrícula final 8)
- Iniciais do nome usadas: JU
- Dia de nascimento usado: 15

## Regras e Validações Implementadas
1. Campos de texto (idChamado, titulo, descricao) não podem ser nulos ou vazios.
2. Prioridade precisa estar entre 1 e 5.
3. Não permite alterar prioridade, avançar status ou incrementar dias de um chamado FECHADO.

## Desafios Complementares Escolhidos
1. Construtor alternativo com menos parâmetros (define prioridade padrão 1).
2. Método getResumo() que retorna o resumo em texto.
3. Retorno de false para impedir operações inválidas.

## Como Executar
1. Compilar os arquivos Chamado.java e Main.java.
2. Executar a classe Main.

## Resultado dos Testes
- Teste 1: Chamados criados com sucesso.
- Teste 2: Alteração de título para texto vazio recusada.
- Teste 3: Alteração de prioridade para -15 recusada.
- Teste 4: Status avançado e 15 dias incrementados com sucesso.
- Teste 5: Tentativa de avançar chamado já FECHADO recusada.