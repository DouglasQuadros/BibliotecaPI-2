/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Livro;

/**
 *
 * @author 181910101
 */
public class LivroDAO {

    public void cadastrarLivro(Livro cVO) {
        try {
            // buscar conexão com BD
            Connection con = Conexao.getConexao();
            // criar script SQL de insert
            String sql = "INSERT INTO livros VALUES (null, ?, ?, ?, ?)";
            // criar espaço para executar o script
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cVO.getTitulo());
            pst.setInt(2, cVO.getAnoFab());
            pst.setInt(3, cVO.getIsbn());
            pst.setString(4, cVO.getAutor());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Livro.\n" + e.getMessage());
        }
    }
    
    public ArrayList<Livro> getLivros() {
        ArrayList<Livro> livros = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "SELECT * FROM livros";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Livro c = new Livro();
                c.setIdLivro(rs.getString("idLivro"));
                c.setTitulo(rs.getString("titulo"));
                c.setAnoFab(rs.getInt("anoFab"));
                c.setIsbn(rs.getInt("isbn"));
                c.setAutor(rs.getString("autor"));
                livros.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar livros.\n" + e.getMessage());
        }
        return livros;
    }
    
    public Livro getLivroByDoc(int idLivro) {
        Livro c = new Livro();
        try {
            Connection con = Conexao.getConexao();
            String sql = "SELECT * FROM livros WHERE idLivro = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idLivro);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c.setIdLivro(rs.getString("idLivro"));
                c.setTitulo(rs.getString("titulo"));
                c.setAnoFab(rs.getInt("anoFab"));
                c.setIsbn(rs.getInt("isbn"));
                c.setAutor(rs.getString("autor"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Livro por ID.\n" + e.getMessage());
        }
        return c;
    }
    
    public void atualizarLivro(Livro cVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "UPDATE livros SET titulo = ?, anoFab = ?, isbn = ?, autor = ? WHERE idLivro = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cVO.getTitulo());
            pst.setInt(2, cVO.getAnoFab());
            pst.setInt(3, cVO.getIsbn());
            pst.setString(4, cVO.getAutor());
            pst.setString(5, cVO.getIdLivro());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Livro.\n" + e.getMessage());
        }
    }
    
    public void deletarLivro(int idLivro) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "DELETE FROM livros WHERE idLivro = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idLivro);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Livro.\n" + e.getMessage());
        }
    }

    
}