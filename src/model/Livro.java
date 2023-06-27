/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 181910101
 */
public class Livro {
    private String idLivro;
    private String titulo;
    private int anoFab;
    private int isbn;
    private String autor; //agregação da classe model Pessoa com Carro

    public Livro(String idLivro, String titulo, int anoFab, int isbn, String autor) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.anoFab = anoFab;
        this.isbn = isbn;
        this.autor = autor;
    }

    public Livro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(String idLivros) {
        this.idLivro = idLivros;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoFab() {
        return anoFab;
    }

    public void setAnoFab(int anoFab) {
        this.anoFab = anoFab;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "\n---" + "\nidLivros:\t" + idLivro + "\ntitulo:\t" + titulo + "\nanoFab:\t" + anoFab + "\nisbn:\t" + isbn + "\nautor:\t" + autor;
    }
   
}//fim Classe Livro
