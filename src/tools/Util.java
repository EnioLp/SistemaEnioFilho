package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import javax.swing.JTextField;


public class Util {
    
 public static void habilitar(boolean valor, JComponent... componentes) {
     for (JComponent componente : componentes) {
         componente.setEnabled(valor);
     }
    }

    /**
     * @param componentes
     */
    public static void limpaCampos(JComponent... componentes) {
        for (JComponent componente : componentes) {
            if (componente instanceof JTextField) {
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
       
       
       
public static Date strToDate(String texto) {
    System.out.println("Texto da data para converter: '" + texto + "'");
    String textoLimpo = texto.replace("/", "").trim();
    if (textoLimpo.isEmpty()) {
        return null;
    }

    try {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        return formato.parse(texto);
    } catch (ParseException e) {
        System.err.println("ERRO: O texto '" + texto + "' não está no formato dd/MM/yyyy.");
        return null;
    }
}
    public static String dateToStr(Date data) {
        if (data == null) {
            return "";
        }
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(data);
    }
    public static void mostrar(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    public static boolean perguntar(String pergunta) {
        int resposta = JOptionPane.showConfirmDialog(null, pergunta, "Confirmação", JOptionPane.YES_NO_OPTION);
        return resposta == JOptionPane.YES_OPTION;
    }
    public static boolean isCpfValido(String cpf) {
    cpf = cpf.replace(".", "").replace("-", "").trim();
    if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
        return false;
    }

    try {
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int resto = 11 - (soma % 11);
        char digito10 = (resto == 10 || resto == 11) ? '0' : (char) (resto + '0');
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        resto = 11 - (soma % 11);
        char digito11 = (resto == 10 || resto == 11) ? '0' : (char) (resto + '0');

        return (digito10 == cpf.charAt(9) && digito11 == cpf.charAt(10));
        
    } catch (Exception e) {
        return false;
    }
    }
    
     public static int strToInt(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return 0; 
        }
        return Integer.parseInt(texto.trim());
    }
} 