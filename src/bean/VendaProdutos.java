package bean;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venda_produto")
public class VendaProdutos implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda_produto")
    private int idVendaProdutos;

    @ManyToOne
    @JoinColumn(name = "fk_venda", nullable = false)
    private Vendas vendas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_produto", nullable = false)
    private Produtos produtos;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "valor_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorUnitario;

    public VendaProdutos() {
    }

    public int getIdVendaProduto() {
        return idVendaProdutos;
    }

    public void setIdVendaProduto(int idVendaProdutos) {
        this.idVendaProdutos = idVendaProdutos;
    }

    public Vendas getVenda() {
        return vendas;
    }

    public void setVenda(Vendas vendas) {
        this.vendas = vendas;
    }

    public Produtos getProduto() {
        return produtos;
    }

    public void setProduto(Produtos produtos) {
        this.produtos = produtos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}