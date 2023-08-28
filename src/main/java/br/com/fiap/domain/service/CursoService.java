package br.com.fiap.domain.service;

import br.com.fiap.domain.entity.Curso;
import br.com.fiap.exception.MetodoNaoImplementadoException;

import java.util.List;

public class CursoService implements Service<Curso, Long>{
    @Override
    public List<Curso> findAll() {
        throw new MetodoNaoImplementadoException("Método não Implementado");
    }

    @Override
    public Curso findById(Long id) {
        throw new MetodoNaoImplementadoException("Método não Implementado");
    }

    @Override
    public List<Curso> findByName(String texto) {
        throw new MetodoNaoImplementadoException("Método não Implementado");
    }

    @Override
    public Curso persist(Curso curso) {
        throw new MetodoNaoImplementadoException("Método não Implementado");
    }
}
