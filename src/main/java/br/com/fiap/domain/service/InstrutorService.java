package br.com.fiap.domain.service;

import br.com.fiap.domain.entity.Instrutor;
import br.com.fiap.exception.MetodoNaoImplementadoException;

import java.util.List;

public class InstrutorService implements Service<Instrutor, Long> {
    @Override
    public List<Instrutor> findAll() {
        throw new MetodoNaoImplementadoException("Método não Implementado");
    }

    @Override
    public Instrutor findById(Long id) {
        throw new MetodoNaoImplementadoException("Método não Implementado");
    }

    @Override
    public List<Instrutor> findByName(String texto) {
        throw new MetodoNaoImplementadoException("Método não Implementado");
    }

    @Override
    public Instrutor persist(Instrutor instrutor) {
        throw new MetodoNaoImplementadoException("Método não Implementado");
    }
}
