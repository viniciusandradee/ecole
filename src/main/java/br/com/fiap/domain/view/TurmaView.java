package br.com.fiap.domain.view;

import br.com.fiap.domain.entity.Turma;

import java.util.List;

public class TurmaView implements View<Turma, Long>{

    @Override
    public List<Turma> findAll() {
        return null;
    }

    @Override
    public Turma findById(Long id) {
        return null;
    }

    @Override
    public List<Turma> findByName(String texto) {
        return null;
    }

    @Override
    public Turma persist(Turma turma) {
        return null;
    }
}
