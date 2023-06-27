/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

/**
 *
 * @author 181910101
 */
public class ServicosFactory {

    private static PessoaServicos pessoaS = new PessoaServicos();
    private static LivroServicos livroS = new LivroServicos();

    public static PessoaServicos getPessoaServicos() {
        return pessoaS;
    }

    public static LivroServicos getLivroServicos() {
        return livroS;
    }
}
