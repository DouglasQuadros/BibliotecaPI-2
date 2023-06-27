/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Livro;

/**
 *
 * @author 181910101
 */
public class CLivro {

    private ArrayList<Livro> livros = new ArrayList<>();

    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public void removeLivro(Livro livro) {
        livros.remove(livro);
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public Livro getLivroISBN(int isbn) {
        Livro livroEncontrado = null;
        for (Livro livro : livros) {
            if (livro.getIsbn() == isbn) {
                livroEncontrado = livro;
                break;
            }
        }
        return livroEncontrado;
    }
    
    public void mockLivros() {
        Livro livro1 = new Livro();
        livro1.setTitulo("Harry Potter");
        livro1.setAnoFab(2023);
        livro1.setIsbn(12345678);
        livro1.setAutor("Algumai");

        addLivro(livro1);

        Livro livro2 = new Livro();
        livro2.setTitulo("Harry Potter 2");
        livro2.setAnoFab(2023);
        livro2.setIsbn(87654321);
        livro2.setAutor("Algumai2");

        addLivro(livro2);
    }
}
