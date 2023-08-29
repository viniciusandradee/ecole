package br.com.fiap.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

public class Turma {

    private Long id;

    private Curso curso;

    private Instrutor instrutor;

    private Set<Aluno> alunos = new LinkedHashSet<>();

    private LocalDate inicio;

    private LocalDate encerramento;


    public Turma() {
    }

    public Turma(Long id, Curso curso, Instrutor instrutor, Set<Aluno> alunos, LocalDate inicio, LocalDate encerramento) {
        this.id = id;
        this.curso = curso;
        this.instrutor = instrutor;
        this.alunos = alunos;
        this.inicio = inicio;
        this.encerramento = encerramento;
    }

    public Long getId() {
        return id;
    }

    public Turma setId(Long id) {
        this.id = id;
        return this;
    }

    public Curso getCurso() {
        return curso;
    }

    public Turma setCurso(Curso curso) {
        this.curso = curso;
        return this;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public Turma setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
        return this;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public Turma setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
        return this;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public Turma setInicio(LocalDate inicio) {
        this.inicio = inicio;
        return this;
    }

    public LocalDate getEncerramento() {
        return encerramento;
    }

    public Turma setEncerramento(LocalDate encerramento) {
        this.encerramento = encerramento;
        return this;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", curso=" + curso +
                ", instrutor=" + instrutor +
                ", alunos=" + alunos +
                ", inicio=" + inicio +
                ", encerramento=" + encerramento +
                '}';
    }
}
