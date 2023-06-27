/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biblioteca.pi;

import controller.CLivro;
import controller.CPessoa;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Livro;
import model.Pessoa;
import servicos.LivroServicos;
import servicos.PessoaServicos;
import servicos.ServicosFactory;
import util.Validadores;
import view.JFPrincipal;

/**
 *
 * @author 181910101
 */
public class BibliotecaPI {

    public static CPessoa cadPessoa = new CPessoa();
    public static CLivro cadLivro = new CLivro();
    static Scanner leia = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFPrincipal janela = new JFPrincipal();
        janela.setVisible(true);

    }//fim método main

    public static int leiaNumInt() {
        Scanner leiaNum = new Scanner(System.in);
        try {
            return leiaNum.nextInt();
        } catch (InputMismatchException i) {
            System.out.println("Erro: " + i.getMessage() + "\nTente novamente!");
            leiaNumInt();
        }
        return 99;
    }

    public static void menuP() {
        System.out.println("-- Menu Principal --");
        System.out.println("1 - Ger. Pessoa");
        System.out.println("2 - Ger. Livro");
        System.out.println("0 - Sair");
        System.out.print("Digite aqui: ");
    }//fim menuP

    public static void subMenu(int opM) {
        String subM = null;
        if (opM == 1) {
            subM = "Pessoa";
        }
        if (opM == 2) {
            subM = "Livro";
        }
        System.out.println("-- Ger. " + subM + " --");
        System.out.println("1 - Cadastrar " + subM);
        System.out.println("2 - Editar " + subM);
        System.out.println("3 - Listar " + subM + "s");
        System.out.println("4 - Deletar " + subM);
        System.out.println("0 - Voltar");
        System.out.print("Digite aqui: ");
    }// fim subMenu

    private static void cadastrarPessoa() {
        System.out.println("-- Cadastro de Pessoa --");
        PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
        int idPessoa;
        String nome;
        String cpf;
        String endereco;
        String telefone;
        boolean tcpf = true;

        do {
            System.out.print("Informe o CPF: ");
            cpf = leia.nextLine();
            tcpf = Validadores.isCPF(cpf);
            if (tcpf) {
                if (pessoaS.getPessoaByDoc(cpf).getCpf() != null) {
                    System.out.println("CPF já cadastrado!");
                    System.out.println("1 - Tentar novamente");
                    System.out.println("2 - Cancelar cadastro");
                    System.out.print("Digite aqui: ");
                    int op = leiaNumInt();
                    if (op == 2) {
                        return;
                    }
                } else {
                    tcpf = false;
                }
            } else {
                System.out.println("CPF inválido!");
                System.out.println("1 - Tentar novamente");
                System.out.println("2 - Cancelar cadastro");
                System.out.print("Digite aqui: ");
                int op = leiaNumInt();
                if (op == 2) {
                    return;
                }
                tcpf = true;
            }
        } while (tcpf);
        System.out.print("Informe o nome: ");
        nome = leia.nextLine();
        System.out.print("Informe o endereço: ");
        endereco = leia.nextLine();
        System.out.print("Informe o telefone: ");
        telefone = leia.nextLine();
        idPessoa = cadPessoa.geraID();
        Pessoa p = new Pessoa(idPessoa, nome, cpf, endereco, telefone);
        pessoaS.cadastroPessoa(p);
        System.out.println(p.getNome() + " cadastrado com sucesso!");
    }

    private static void cadastrarLivro() {
        System.out.println("-- Cadastro de Livro --");
        LivroServicos livroS = ServicosFactory.getLivroServicos();

        System.out.print("Informe o título: ");
        String titulo = leia.nextLine();

        System.out.print("Informe o ano de fabricação: ");
        int anoFab = leiaNumInt();

        System.out.print("Informe o ISBN: ");
        int isbn = leiaNumInt();

        System.out.print("Informe o autor: ");
        String autor = leia.nextLine();
        String idLivro = null;
        Livro livro = new Livro(idLivro, titulo, anoFab, isbn, autor);
        livroS.cadastrarLivro(livro);

        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void editarPessoa() {
        PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
        System.out.println("-- Editar Pessoa --");
        boolean isCPF;
        do {
            System.out.print("Informe o CPF da Pessoa a ser editado: ");
            String cpf = leia.nextLine();
            isCPF = Validadores.isCPF(cpf);
            if (isCPF) {
                Pessoa p = pessoaS.getPessoaByDoc(cpf);
                if (p.getCpf() != null) {
                    do {
                        System.out.println("Quais dados de " + p.getNome() + " deseja alterar?");
                        System.out.println("1 - Nome");
                        System.out.println("2 - Endereço");
                        System.out.println("3 - Telefone");
                        System.out.println("4 - Todos");
                        System.out.println("0 - Voltar");
                        System.out.print("Digite aqui: ");
                        int op = leiaNumInt();
                        if (op == 1 || op == 4) {
                            System.out.print("Informe o novo nome: ");
                            p.setNome(leia.nextLine());
                        }
                        if (op == 2 || op == 4) {
                            System.out.print("Informe o novo endereço: ");
                            p.setEndereco(leia.nextLine());
                        }
                        if (op == 3 || op == 4) {
                            System.out.print("Informe o novo telefone: ");
                            p.setTelefone(leia.nextLine());
                        }
                        if (op == 0) {
                            System.out.println("Operação cancelada pelo usuário!");
                            isCPF = false;
                        }
                        if (op < 0 || op > 4) {
                            System.out.println("Opção inválida, tente novamente!");
                        }
                        if (op > 0 && op < 4) {
                            pessoaS.atualizarPessoa(p);
                        }
                    } while (isCPF);
                } else {
                    System.out.println("CPF não cadastrado!");
                    isCPF = false;
                }
            } else {
                System.out.println("CPF inválido!");
                System.out.print("Deseja tentar novamente? \n 1 - Sim | 2 - Não: ");
                int op = leiaNumInt();
                if (op == 1) {
                    isCPF = true;
                } else {
                    isCPF = false;
                }
            }
        } while (isCPF);
    }

    private static void editarLivro() {
        System.out.println("-- Editar Livro --");
        LivroServicos livroS = ServicosFactory.getLivroServicos();

        System.out.print("Informe o ISBN do livro a ser editado: ");
        int isbn = leiaNumInt();

        Livro livro = livroS.getLivroByDoc(isbn);

        if (livro != null) {
            System.out.print("Informe o novo título: ");
            livro.setTitulo(leia.nextLine());

            System.out.print("Informe o novo ano de fabricação: ");
            livro.setAnoFab(leiaNumInt());

            System.out.print("Informe o novo autor: ");
            livro.setAutor(leia.nextLine());

            livroS.atualizarLivro(livro);
            System.out.println("Livro atualizado com sucesso!");
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    private static void listarPessoa() {
        System.out.println("-- Lista de Pessoas --");
        PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
        if (pessoaS.getPessoas().isEmpty()) {
            System.out.println("Não tem Pessoas cadastras no sistema!");
        } else {
            for (Pessoa pessoa : pessoaS.getPessoas()) {
                System.out.println(pessoa.toString());
            }
        }
    }

    private static void listarLivro() {
        System.out.println("-- Lista de Livros --");
        LivroServicos livroS = ServicosFactory.getLivroServicos();
        if (livroS.getLivros().isEmpty()) {
            System.out.println("Não tem Livros cadastrados no sistema!");
        } else {
            for (Livro livro : livroS.getLivros()) {
                System.out.println(livro.toString());
            }
        }
    }

    private static void deletarPessoa() {
        PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
        System.out.println("-- Deletar Pessoa --");
        boolean delCPF = false;
        do {
            System.out.print("Informe o CPF da Pessoa a ser deletada: ");
            String cpf = leia.nextLine();
            delCPF = Validadores.isCPF(cpf);
            if (delCPF) {
                Pessoa p = pessoaS.getPessoaByDoc(cpf);
                if (p.getCpf() != null) {
                    System.out.println("Deseja realmente deletar " + p.getNome() + "?");
                    System.out.print("1 - Sim | 2 - Não: ");
                    int op = leiaNumInt();
                    if (op == 1) {
                        //cadPessoa.removePessoa(p);
                        pessoaS.deletarPessoa(cpf);
                        System.out.println("Pessoa deletada com sucesso!");
                        delCPF = false;
                    } else {
                        System.out.println("Operação cancelada pelo usuário!");
                        delCPF = false;
                    }
                } else {
                    System.out.println("CPF não cadastrado!");
                    System.out.println("Deseja tentar novamente?");
                    System.out.print("1 - Sim | 2 - Não: ");
                    int op = leiaNumInt();
                    if (op == 1) {
                        delCPF = true;
                    } else {
                        delCPF = false;
                    }
                }
            } else {
                System.out.println("CPF inválido!"
                        + "\nTente novamente.");
                delCPF = true;
            }
        } while (delCPF);
    }//fim do deletarPessoa

    private static void deletarLivro() {
        System.out.println("-- Deletar Livro --");
        LivroServicos livroS = ServicosFactory.getLivroServicos();

        System.out.print("Informe o ISBN do livro a ser deletado: ");
        int isbn = leiaNumInt();

        Livro livro = livroS.getLivroByDoc(isbn);

        if (livro != null) {
            System.out.println("Deseja realmente deletar o livro " + livro.getTitulo() + "?");
            System.out.print("1 - Sim | 2 - Não: ");
            int op = leiaNumInt();

            if (op == 1) {
                livroS.deletarLivro(isbn);
                System.out.println("Livro deletado com sucesso!");
            } else {
                System.out.println("Operação cancelada pelo usuário.");
            }
        }
    }
}//fim classe
