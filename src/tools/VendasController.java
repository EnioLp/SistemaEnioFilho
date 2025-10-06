package tools;

import bean.Vendas;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

public class VendasController extends AbstractTableModel {

    private List<Vendas> lista;

    public void setList(List<Vendas> lista) { 
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public Vendas getBean(int linha) {
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
        Vendas venda = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return venda.getIdVenda();
            case 1: 
                return Util.dateToStr(venda.getDataVenda());
            case 2: 
                return venda.getClientes().getNome();
            case 3: 
                return venda.getVendedor().getNome();
            case 4: 
                NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                return formatoMoeda.format(venda.getValorTotal());
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Data da Venda";
            case 2: return "Cliente";
            case 3: return "Vendedor";
            case 4: return "Valor Total";
            default: return "";
        }
    }
}