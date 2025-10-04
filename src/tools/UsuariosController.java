
package tools;

import bean.Usuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UsuariosController extends AbstractTableModel {

    private List<Usuarios> lista;
    public void setList(List<Usuarios> lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public Usuarios getBean(int linha) {
        return lista.get(linha);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuarios usuario = lista.get(rowIndex);
        if (columnIndex == 0) {
            return usuario.getIdUsuario();
        }
        if (columnIndex == 1) {
            return usuario.getNome();
        }
        if (columnIndex == 2) {
            return usuario.getApelido();
        }
        if (columnIndex == 3) {
            return usuario.getCpf();
        }
         if (columnIndex == 4) {
            return usuario.getRg();
        }
          if (columnIndex == 5) {
            return usuario.getDataNascimento();
        }
           if (columnIndex == 6) {
           int nivel = usuario.getNivelAcesso();
           switch (nivel) {
           case 1: return "Administrativo";
           case 2: return "Vendedor";
           case 3: return "Estagiário";
           default: return "Indefinido";
        }
           }
            if (columnIndex == 7) {
            return usuario.isAtivo() ? "Sim" : "Não"; 
        }
        return "";
           }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID";
        }
        if (column == 1) {
            return "Nome";
        }
        if (column == 2) {
            return "Apelido";
        }
        if (column == 3) {
            return "CPF";
        }
        if (column == 4) {
            return "RG";
        }
        if (column == 5) {
            return "DataNascimento";
        }
        if (column == 6) {
            return "NivelAcesso";
        }
        if (column == 7) {
            return "Ativo?";
        }
        return "";
    }
}