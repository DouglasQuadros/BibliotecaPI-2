/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import dao.LivroDAO;
import dao.DAOFactory;
import java.util.ArrayList;
import model.Livro;

/**
 *
 * @author 181910101
 */
public class LivroServicos {

    public void cadastroLivro(Livro lVO) {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        lDAO.cadastrarLivro(lVO);
    }

    public ArrayList<Livro> getLivros() {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.getLivros();
    }

    public Livro getLivroByDoc(int isbn) {
        LivroDAO cDAO = DAOFactory.getLivroDAO();
        return cDAO.getLivroByDoc(isbn);
    }

    public void atualizarLivro(Livro cVO) {
        LivroDAO cDAO = DAOFactory.getLivroDAO();
        cDAO.atualizarLivro(cVO);
    }

    public void deletarLivro(int isbn) {
        LivroDAO cDAO = DAOFactory.getLivroDAO();
        cDAO.deletarLivro(isbn);
    }

    public void cadastrarLivro(Livro livro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
