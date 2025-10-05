package bean;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto", catalog = "meu_banco")
public class Produtos implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto", unique = true, nullable = false)
    private int idProduto;

    @Column(name = "codigo_livro", unique = true, nullable = false, length = 30)
    private String codigoLivro;
    
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "ano_publicado", nullable = false)
    private int anoPublicado;

    @Column(name = "genero", nullable = false, length = 100)
    private String genero;

    @Column(name = "autor", nullable = false, length = 150)
    private String autor;

    @Column(name = "editora", nullable = false, length = 100)
    private String editora;

    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    public Produtos() {
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getCodigoLivro() {
        return codigoLivro; 
    }
    
    public void setCodigoLivro(String codigoLivro) { 
        this.codigoLivro = codigoLivro; 
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublicado() {
        return anoPublicado;
    }

    public void setAnoPublicado(int anoPublicado) {
        this.anoPublicado = anoPublicado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}