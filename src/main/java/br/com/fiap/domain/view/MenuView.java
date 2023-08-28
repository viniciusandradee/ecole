package br.com.fiap.domain.view;

import br.com.fiap.domain.entity.Aluno;
import br.com.fiap.domain.entity.Curso;
import br.com.fiap.domain.entity.Instrutor;
import br.com.fiap.domain.entity.Turma;

import javax.swing.*;

public class MenuView {

    public void show() {

        var alunoView = new AlunoView();
        var cursoView = new CursoView();
        var instrutorView = new InstrutorView();
        var turmaView = new TurmaView();

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
                        
                    4 - Abrir nova Turma
                        40 - Listagem de Matriculas
                        41 - Consulta Matricula pelo id
                        42 - Consulta Matricula pelo nome do Professor 
                        
                                           
                    0 - Sair do Programa
                                        
                    """;

            opcao = Short.parseShort(JOptionPane.showInputDialog(mensagem));


            switch (opcao) {
                //Opções para alunos
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

                //Opções para Professor
                case 2 -> {
                    Instrutor instrutor = instrutorView.persist(null);
                    System.out.println(instrutor);
                }

                case 20 -> {
                    instrutorView.findAll().forEach(System.out::println);
                }

                case 21 -> {
                    Instrutor instrutor = instrutorView.findById(null);
                    System.out.println(instrutor);
                }

                case 22 -> {
                    instrutorView.findByName(null).forEach(System.out::println);
                }

                //Opções para Cursos
                case 3 -> {
                    Curso curso = cursoView.persist(null);
                    System.out.println(curso);
                }

                case 30 -> {
                    cursoView.findAll().forEach(System.out::println);
                }

                case 31 -> {
                    Curso curso = cursoView.findById(null);
                    System.out.println(curso);
                }

                case 32 -> {
                    cursoView.findByName(null).forEach(System.out::println);
                }

                //Opções para matrícula
                case 4 -> {
                    Turma turma = turmaView.persist(null);
                    System.out.println(turma);
                }

                case 40 -> {
                    turmaView.findAll().forEach(System.out::println);
                }

                case 41 -> {
                    Turma turma = turmaView.findById(null);
                    System.out.println(turma);
                }

                case 42 -> { //Buscando pelo nome do professor da Turma
                    turmaView.findByName(null).forEach(System.out::println);
                }

                //Deseja Realmente sair?
                case 0 -> {
                    var sair = JOptionPane.showConfirmDialog(null, "Deseja Realmente Sair do Sistema?", "Sair?", JOptionPane.YES_NO_OPTION);
                    if (sair == 1) opcao = 99;
                }

            }


        } while (opcao > 0);

    }
}
