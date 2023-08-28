package br.com.fiap;

import br.com.fiap.domain.entity.Aluno;
import br.com.fiap.domain.view.AlunoView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        AlunoView alunoView = new AlunoView();


        short opcao = 0;

        do {
            String mensagem = """
                    ***************  ECOLE DE LANGUES BENEZINHO  ***************
                                        
                                        
                    Digite:
                                        
                    1 - Cadastro de Aluno
                        10 - Listagem de Alunos
                        11 - Consulta Aluno pelo id
                        12 - Consulta Aluno pelo nome
                        
                    2 - Cadastro de Professor
                        20 - Listagem de Professores
                        21 - Consulta Professor pelo id
                        22 - Consulta Professor pelo nome
                        
                    3 - Cadastro de Curso
                        30 - Listagem de Cursos
                        31 - Consulta Curso pelo id
                        32 - Consulta Curso pelo nome
                        
                    4 - Realizar Matricula
                        40 - Listagem de Matriculas
                        41 - Consulta Matricula pelo id
                        42 - Consulta Matricula pelo nome do Professor 
                        
                                           
                    0 - Sair do Programa
                    """;

            opcao = Short.parseShort(JOptionPane.showInputDialog(mensagem));


            switch (opcao) {

                case 1 -> {
                    Aluno aluno = alunoView.persist(null);
                    System.out.println(aluno);
                }
                case 10 -> {
                    alunoView.findAll().forEach(System.out::println);
                }
                case 11 -> {
                    Aluno aluno = alunoView.findById(null);
                    System.out.println(aluno);
                }
                case 12 -> {
                    alunoView.findByName(null).forEach(System.out::println);
                }





            }


        } while (opcao > 0);


    }

}