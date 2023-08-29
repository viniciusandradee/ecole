package br.com.fiap.domain.view;

import br.com.fiap.domain.entity.Instrutor;
import br.com.fiap.domain.service.InstrutorService;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

public class InstrutorView implements View<Instrutor, Long> {

    InstrutorService service = new InstrutorService();

    @Override
    public List<Instrutor> findAll() {
        return service.findAll();
    }

    @Override
    public Instrutor findById(Long id) {
        Long idInstrutor = Objects.nonNull( id ) && id > 0 ? id : Long.valueOf( JOptionPane.showInputDialog( "ID do Professor" ) );
        return service.findById( idInstrutor );
    }

    @Override
    public List<Instrutor> findByName(String texto) {

        String nome = service.valido( texto ) ? texto : JOptionPane.showInputDialog( "Nome do Professor" );

        while (!service.valido( nome )) {
            nome = JOptionPane.showInputDialog( "Nome do Professor" );
        }

        return service.findByName( nome );

    }

    @Override
    public Instrutor persist(Instrutor instrutor) {
        var valido = false;

        String nome = null;

        do {
            nome = JOptionPane.showInputDialog( "Nome do Professor", Objects.nonNull( instrutor ) && Objects.nonNull( instrutor.getNome() ) ? instrutor.getNome() : "" );
        } while (!service.valido( nome ));


        var i = new Instrutor();
        i.setNome( nome );
        return service.persist( i );
    }
}
