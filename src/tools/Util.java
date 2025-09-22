package tools;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class Util {

    public static void habilitaBotoes(JButton incluir, JButton alterar, JButton excluir, JButton confirmar, JButton cancelar, JButton pesquisar, boolean estado) {
        incluir.setEnabled(estado);
        alterar.setEnabled(estado);
        excluir.setEnabled(estado);
        confirmar.setEnabled(!estado);
        cancelar.setEnabled(!estado);
        pesquisar.setEnabled(estado);
    }

    /**
     * Limpa o conteúdo de uma lista de componentes na tela.
     * @param componentes Lista de JComponent a serem limpos.
     */
    public static void limpaCampos(JComponent... componentes) {
         for (JComponent componente : componentes) {
        if (componente instanceof JTextField) {
            ((JTextField) componente).setText("");
        } else if (componente instanceof JFormattedTextField) {
            ((JFormattedTextField) componente).setValue(null);
        } else if (componente instanceof JComboBox) {
            ((JComboBox) componente).setSelectedIndex(-1);
        } else if (componente instanceof JCheckBox) {
            ((JCheckBox) componente).setSelected(false);
        }
        }
    }
    
      public static void validarLetras(javax.swing.JTextField textField, int maxLength) {
        ((javax.swing.text.AbstractDocument) textField.getDocument()).setDocumentFilter(new javax.swing.text.DocumentFilter() {
            
            @Override
            public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
                if (string == null) {
                    return;
                }
                if ((fb.getDocument().getLength() + string.length()) <= maxLength && string.matches("[a-zA-Z\\s]*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws javax.swing.text.BadLocationException {
                if (text == null) {
                    return;
                }
                if ((fb.getDocument().getLength() - length + text.length()) <= maxLength && text.matches("[a-zA-Z\\s]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
       public static void validarLetrasMaiusculas(javax.swing.JTextField textField, int maxLength) {
        ((javax.swing.text.AbstractDocument) textField.getDocument()).setDocumentFilter(new javax.swing.text.DocumentFilter() {
            
            @Override
            public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
                if (string == null) {
                    return;
                }
                // Converte a string para maiúsculo ANTES de validar e inserir
                String textoMaiusculo = string.toUpperCase();
                
                if ((fb.getDocument().getLength() + textoMaiusculo.length()) <= maxLength && textoMaiusculo.matches("[A-Z\\s]*")) {
                    super.insertString(fb, offset, textoMaiusculo, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws javax.swing.text.BadLocationException {
                if (text == null) {
                    return;
                }
                // Converte o texto para maiúsculo ANTES de validar e substituir
                String textoMaiusculo = text.toUpperCase();

                if ((fb.getDocument().getLength() - length + textoMaiusculo.length()) <= maxLength && textoMaiusculo.matches("[A-Z\\s]*")) {
                    super.replace(fb, offset, length, textoMaiusculo, attrs);
                }
            }
        });
    }
       public static void validarNumeros(javax.swing.JTextField textField, int maxLength) {
        ((javax.swing.text.AbstractDocument) textField.getDocument()).setDocumentFilter(new javax.swing.text.DocumentFilter() {
            
            @Override
            public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
                if (string == null) {
                    return;
                }
                // Verifica o tamanho e se contém apenas dígitos
                if ((fb.getDocument().getLength() + string.length()) <= maxLength && string.matches("[0-9]*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws javax.swing.text.BadLocationException {
                if (text == null) {
                    return;
                }
                // Verifica o tamanho e se contém apenas dígitos
                if ((fb.getDocument().getLength() - length + text.length()) <= maxLength && text.matches("[0-9]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
}