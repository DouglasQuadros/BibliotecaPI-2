/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author 181910101
 */
public class DAOFactory {

    private static PessoaDAO pDAO = new PessoaDAO();
    private static LivroDAO lDAO = new LivroDAO();

    public static PessoaDAO getPessoaDAO() {
        return pDAO;
    }

    public static LivroDAO getLivroDAO() {
        return lDAO;
    }
}
