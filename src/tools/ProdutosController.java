package tools;

import bean.Produtos;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

public class ProdutosController extends AbstractTableModel {

    private List<Produtos> lista;

    public void setList(List<Produtos> lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public Produtos getBean(int linha) {
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
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produtos produtos = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return produtos.getIdProduto();
            case 1: return produtos.getTitulo();
            case 2: return produtos.getAutor();
            case 3: return produtos.getEditora();
            case 4: 
                NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                return formatoMoeda.format(produtos.getPreco());
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Título";
            case 2: return "Autor";
            case 3: return "Editora";
            case 4: return "Preço";
            default: return "";
        }
    }
}