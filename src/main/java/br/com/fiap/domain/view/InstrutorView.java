package br.com.fiap.domain.view;

import br.com.fiap.domain.entity.Instrutor;

import java.util.List;

public class InstrutorView implements View<Instrutor, Long> {
    @Override
    public List<Instrutor> findAll() {
        return null;
    }

    @Override
    public Instrutor findById(Long id) {
        return null;
    }

    @Override
    public List<Instrutor> findByName(String texto) {
        return null;
    }

    @Override
    public Instrutor persist(Instrutor instrutor) {
        return null;
    }
}
