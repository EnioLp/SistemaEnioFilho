package tools;

import javax.swing.JComponent;

import javax.swing.JTextField;


public class Util {
    
 public static void habilitar(boolean valor, JComponent... componentes) {
        // A condição do laço 'for' foi corrigida para 'i < componentes.length'
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);
        }
    }

    /**
     * @param componentes
     */
    public static void limpaCampos(JComponent... componentes) {
        // O laço 'for' que estava faltando
        for (JComponent componente : componentes) {
            // Verifica se o componente atual é um JTextField
            if (componente instanceof JTextField) {
                // Se for, faz o "cast" e define seu texto como uma string vazia
                ((JTextField) componente).setText("");
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
                
                if ((fb.getDocument().getLength() + string.length()) <= maxLength && string.matches("[0-9]*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws javax.swing.text.BadLocationException {
                if (text == null) {
                    return;
                }
                
                if ((fb.getDocument().getLength() - length + text.length()) <= maxLength && text.matches("[0-9]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
            }