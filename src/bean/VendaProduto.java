package bean;
// Generated 22/09/2025 12:00:35 by Hibernate Tools 4.3.1

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="venda_produto", catalog="meu_banco")
public class VendaProduto implements Serializable {

    private int idVendaItem;
    private Livro livro;
    private Venda venda;
    private int quantidade;
    private double precoUnitario;

    public VendaProduto() {
    }

    public VendaProduto(Livro livro, Venda venda, int quantidade, double precoUnitario) {
        this.livro = livro;
        this.venda = venda;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_venda_item", unique = true, nullable = false)
    public int getIdVendaItem() {
        return this.idVendaItem;
    }

    public void setIdVendaItem(int idVendaItem) {
        this.idVendaItem = idVendaItem;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_livro", nullable = false)
    public Livro getLivro() {
        return this.livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_venda", nullable = false)
    public Venda getVenda() {
        return this.venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Column(name = "quantidade", nullable = false)
    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Column(name = "preco_unitario", nullable = false, precision = 10, scale = 2)
    public double getPrecoUnitario() {
        return this.precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}