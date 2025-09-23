package DAO;

import bean.Usuarios; // Certifique-se de que a classe Usuarios bean existe
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que implementa operações de acesso a dados para a entidade "Usuarios".
 * Segue o padrão estabelecido pela classe DAOAbstract.
 */
public class UsuariosDAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        Usuarios usuario = (Usuarios) object;
        try {
            // Conexão com o banco de dados
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/meu_banco"; // Banco de dados da imagem
            String user = "root";
            String password = "";
            Connection cnt = DriverManager.getConnection(url, user, password);

            // Instrução SQL para inserir um usuário
            // O id_usuario não é incluído pois é AUTO_INCREMENT
            String sql = "INSERT INTO usuario (nome, apelido, cpf, rg, data_nascimento, nivel_acesso, senha, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = cnt.prepareStatement(sql);

            // Definindo os valores para cada parâmetro
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getApelido());
            pst.setString(3, usuario.getCpf());
            pst.setString(4, usuario.getRg());
            // Converte java.util.Date para java.sql.Date
            pst.setDate(5, new java.sql.Date(usuario.getDataNascimento().getTime()));
            pst.setString(6, usuario.getNivelAcesso());
            pst.setString(7, usuario.getSenha());
            //pst.setInt(8, usuario.getAtivo()); // tinyint(1) pode ser tratado como int

            // Executa a instrução
            pst.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAO_Abstract.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Usuarios usuario = (Usuarios) object;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/meu_banco";
            String user = "root";
            String password = "";
            Connection cnt = DriverManager.getConnection(url, user, password);

            String sql = "UPDATE usuario SET nome=?, apelido=?, cpf=?, rg=?, data_nascimento=?, nivel_acesso=?, senha=?, ativo=? WHERE id_usuario=?";
            PreparedStatement pst = cnt.prepareStatement(sql);

            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getApelido());
            pst.setString(3, usuario.getCpf());
            pst.setString(4, usuario.getRg());
            pst.setDate(5, new java.sql.Date(usuario.getDataNascimento().getTime()));
            pst.setString(6, usuario.getNivelAcesso());
            pst.setString(7, usuario.getSenha());
           // pst.setInt(8, usuario.getAtivo());
            pst.setInt(9, usuario.getIdUsuario()); // O ID para a cláusula WHERE

            pst.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAO_Abstract.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Usuarios usuario = (Usuarios) object;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/meu_banco";
            String user = "root";
            String password = "";
            Connection cnt = DriverManager.getConnection(url, user, password);

            String sql = "DELETE FROM usuario WHERE id_usuario = ?";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, usuario.getIdUsuario());
            pst.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAO_Abstract.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Usuarios usuario = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/meu_banco";
            String user = "root";
            String password = "";
            Connection cnt = DriverManager.getConnection(url, user, password);

            String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                usuario = new Usuarios();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setApelido(rs.getString("apelido"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setRg(rs.getString("rg"));
                usuario.setDataNascimento(rs.getDate("data_nascimento"));
                usuario.setNivelAcesso(rs.getString("nivel_acesso"));
                usuario.setSenha(rs.getString("senha"));
                //usuario.setAtivo(rs.getInt("ativo"));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAO_Abstract.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    @Override
    public ArrayList listAll() {
        ArrayList<Usuarios> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/meu_banco";
            String user = "root";
            String password = "";
            Connection cnt = DriverManager.getConnection(url, user, password);

            String sql = "SELECT * FROM usuario ORDER BY nome";
            PreparedStatement pst = cnt.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setApelido(rs.getString("apelido"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setRg(rs.getString("rg"));
                usuario.setDataNascimento(rs.getDate("data_nascimento"));
                usuario.setNivelAcesso(rs.getString("nivel_acesso"));
                usuario.setSenha(rs.getString("senha"));
                //usuario.setAtivo(rs.getInt("ativo"));
                lista.add(usuario);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAO_Abstract.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}