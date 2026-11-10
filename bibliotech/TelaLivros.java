
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaLivros extends JFrame {

    private final LivroDAO dao = new LivroDAO();

    private final DefaultTableModel modelo;
    private final JTable tabela;

    private final JTextField campoId = new JTextField(8);
    private final JTextField campoTitulo = new JTextField(18);

    private final JLabel status = new JLabel("Pronto.");

    public TelaLivros() {

        setTitle("BiblioTech - Consulta de Livros");
        setSize(850, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        modelo = new DefaultTableModel(
            new Object[]{"ID", "Título", "Autor", "Ano"}, 0
        ) {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return false;
            }
        };

        tabela = new JTable(modelo);

        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // Painel dos controles
        JPanel controles = new JPanel(new GridLayout(2, 1, 5, 5));

        // Primeira linha: busca por ID
        JPanel linhaId = new JPanel(
            new FlowLayout(FlowLayout.LEFT)
        );

        JButton atualizar = new JButton("Atualizar listagem");
        JButton buscar = new JButton("Buscar por ID");
        JButton mostrarTodos = new JButton("Mostrar todos");

        linhaId.add(new JLabel("ID do livro:"));
        linhaId.add(campoId);
        linhaId.add(buscar);
        linhaId.add(atualizar);
        linhaId.add(mostrarTodos);

        // Segunda linha: busca por título
        JPanel linhaTitulo = new JPanel(
            new FlowLayout(FlowLayout.LEFT)
        );

        JButton buscarTitulo = new JButton("Buscar por título");
        JButton limparTitulo = new JButton("Limpar título");

        linhaTitulo.add(new JLabel("Título do livro:"));
        linhaTitulo.add(campoTitulo);
        linhaTitulo.add(buscarTitulo);
        linhaTitulo.add(limparTitulo);

        controles.add(linhaId);
        controles.add(linhaTitulo);

        add(controles, BorderLayout.NORTH);
        add(status, BorderLayout.SOUTH);

        // Ações dos botões
        atualizar.addActionListener(e -> carregarLivros());

        mostrarTodos.addActionListener(e -> carregarLivros());

        buscar.addActionListener(e -> buscarLivro());

        buscarTitulo.addActionListener(e -> buscarPorTitulo());

        campoTitulo.addActionListener(e -> buscarPorTitulo());

        limparTitulo.addActionListener(e -> {
            campoTitulo.setText("");
            campoTitulo.requestFocus();
        });

        carregarLivros();
    }

    // Carrega todos os livros do banco de dados
    private void carregarLivros() {

        modelo.setRowCount(0);

        List<Livro> livros = dao.listarLivros();

        for (Livro livro : livros) {
            adicionarLinha(livro);
        }

        status.setText(
            "Livros apresentados: " + livros.size()
        );
    }

    // Adiciona um livro na tabela
    private void adicionarLinha(Livro livro) {

        modelo.addRow(new Object[]{
            livro.getId(),
            livro.getTitulo(),
            livro.getAutor(),
            livro.getAno()
        });
    }

    // Busca um livro pelo ID informado
    private void buscarLivro() {

        String texto = campoId.getText().trim();

        int id;

        try {
            id = Integer.parseInt(texto);

            if (id <= 0) {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Informe um ID inteiro positivo.",
                "Entrada inválida",
                JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        Livro livro = dao.buscarLivroPorId(id);

        modelo.setRowCount(0);

        if (livro == null) {

            status.setText(
                "Nenhum livro encontrado para o ID " + id
            );

            JOptionPane.showMessageDialog(
                this,
                "Livro não encontrado."
            );

        } else {

            adicionarLinha(livro);

            status.setText(
                "Livro encontrado: " + livro.getTitulo()
            );
        }
    }

    // Busca livros pelo título ou por parte dele
    private void buscarPorTitulo() {

        String titulo = campoTitulo.getText().trim();

        if (titulo.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Informe o título do livro.",
                "Campo obrigatório",
                JOptionPane.WARNING_MESSAGE
            );

            campoTitulo.requestFocus();
            return;
        }

        List<Livro> livros =
            dao.buscarLivrosPorTitulo(titulo);

        modelo.setRowCount(0);

        for (Livro livro : livros) {
            adicionarLinha(livro);
        }

        status.setText(
            "Livros encontrados: " + livros.size()
        );

        if (livros.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Nenhum livro encontrado com esse título."
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new TelaLivros().setVisible(true);
        });
    }
}

