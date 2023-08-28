package br.com.fiap.domain.view;

import br.com.fiap.domain.entity.Curso;
import br.com.fiap.domain.service.CursoService;

import java.util.List;

public class CursoView implements View<Curso, Long> {

    CursoService service = new CursoService();

    @Override
    public List<Curso> findAll() {
        return service.findAll();
    }

    @Override
    public Curso findById(Long id) {
        return service.findById(id);
    }

    @Override
    public List<Curso> findByName(String texto) {
        return service.findByName(texto);
    }

    @Override
    public Curso persist(Curso curso) {
        return service.persist(curso);
    }
}
