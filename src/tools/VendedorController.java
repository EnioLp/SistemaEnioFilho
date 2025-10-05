package tools;

import bean.Vendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VendedorController extends AbstractTableModel {

    private List<Vendedor> lista;

    public void setList(List<Vendedor> lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public Vendedor getBean(int linha) {
        return lista.get(linha);
    }

    @Override
    public int getRowCount() {
        if (lista == null) {
            return 0;
        }
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vendedor vendedor = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return vendedor.getIdVendedor();
            case 1: return vendedor.getNome();
            case 2: return vendedor.getCpf();
            case 3: return vendedor.getCnpj();
            case 4: return vendedor.getCidade();
            case 5: return vendedor.getTelefone();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Nome";
            case 2: return "CPF";
            case 3: return "CNPJ";
            case 4: return "Cidade";
            case 5: return "Telefone";
            default: return "";
        }
    }
}