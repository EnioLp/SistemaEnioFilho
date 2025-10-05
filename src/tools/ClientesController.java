package tools;

import bean.Clientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClientesController extends AbstractTableModel {

    private List<Clientes> lista;

    /**
     * Atualiza a lista de dados da tabela.
     */
    public void setList(List<Clientes> lista) {
        this.lista = lista;
        this.fireTableDataChanged(); // Notifica a JTable que os dados mudaram
    }
    
    /**
     * Retorna o objeto Clientes da linha selecionada.
     */
    public Clientes getBean(int linha) {
        return lista.get(linha);
    }

    @Override
    public int getRowCount() {
        // Adiciona uma verificação para evitar NullPointerException se a lista estiver vazia
        if (lista == null) {
            return 0;
        }
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        // Define o número de colunas que serão exibidas
        return 6; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Pega o objeto cliente da linha específica
        Clientes cliente = lista.get(rowIndex);
        
        // Retorna o valor de cada célula da tabela, baseado na coluna
        switch (columnIndex) {
            case 0: return cliente.getIdCliente();
            case 1: return cliente.getNome();
            case 2: return cliente.getCpf();
            case 3: return cliente.getEmail();
            case 4: return cliente.getCidade();
            case 5: return cliente.getEstado();
            default: return ""; // Retorna vazio para colunas inesperadas
        }
    }

    @Override
    public String getColumnName(int column) {
        // Define o nome do cabeçalho de cada coluna
        switch (column) {
            case 0: return "ID";
            case 1: return "Nome";
            case 2: return "CPF";
            case 3: return "Email";
            case 4: return "Cidade";
            case 5: return "Estado";
            default: return "";
        }
    }
}