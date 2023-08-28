package br.com.fiap.domain.entity;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

public class Turma {

    private Long id;

    private Curso curso;

    private Instrutor instrutor;

    private Set<Aluno> alunos = new LinkedHashSet<>();

    private LocalDateTime inicio;

    private LocalDateTime encerramento;


    public Turma() {
    }

    public Turma(Long id, Curso curso, Instrutor instrutor, Set<Aluno> alunos, LocalDateTime inicio, LocalDateTime encerramento) {
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

    public LocalDateTime getInicio() {
        return inicio;
    }

    public Turma setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
        return this;
    }

    public LocalDateTime getEncerramento() {
        return encerramento;
    }

    public Turma setEncerramento(LocalDateTime encerramento) {
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
