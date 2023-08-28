package br.com.fiap.domain.entity;

public class Instrutor {

    private Long id;

    private String nome;


    public Instrutor() {
    }

    public Instrutor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public Instrutor setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Instrutor setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        return "Instrutor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
