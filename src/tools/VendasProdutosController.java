package tools;

import bean.Produtos;
import bean.VendaProdutos;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

public class VendasProdutosController extends AbstractTableModel {

    private List<VendaProdutos> lista;

    public void setList(List<VendaProdutos> lista) { 
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public VendaProdutos getBean(int linha) {
        return lista.get(linha);
    }

    @Override
    public int getRowCount() {
        if (lista == null) return 0;
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VendaProdutos vendaProdutos = lista.get(rowIndex);
        Produtos produtos = vendaProdutos.getProduto();

        switch (columnIndex) {
            case 0: 
                return produtos.getCodigoLivro();
            case 1: 
                return produtos.getTitulo();
            case 2:
                NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                BigDecimal subtotal = vendaProdutos.getValorUnitario().multiply(new BigDecimal(vendaProdutos.getQuantidade()));
                return formatoMoeda.format(subtotal);
            default: 
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Cód. Produto";
            case 1: return "Título";
            case 2: return "Subtotal";
            default: return "";
        }
    }
}