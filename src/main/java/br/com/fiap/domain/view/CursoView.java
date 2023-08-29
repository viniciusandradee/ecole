package br.com.fiap.domain.view;

import br.com.fiap.domain.entity.Curso;
import br.com.fiap.domain.service.CursoService;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

public class CursoView implements View<Curso, Long> {

    CursoService service = new CursoService();

    @Override
    public List<Curso> findAll() {
        return service.findAll();
    }

    @Override
    public Curso findById(Long id) {
        Long identificador = Long.valueOf(JOptionPane.showInputDialog("ID do Curso", Objects.nonNull(id) ? id : 0));
        return service.findById(identificador);
    }

    @Override
    public List<Curso> findByName(String texto) {
        String nome = service.valido( texto ) ? texto : JOptionPane.showInputDialog( "Nome do Curso" );

        while (!service.valido( nome )) {
            nome = JOptionPane.showInputDialog( "Nome do Curso" );
        }

        return service.findByName( nome );
    }

    @Override
    public Curso persist(Curso curso) {

        var valido = false;

        String nome = null;

        do {
            nome = JOptionPane.showInputDialog( "Nome do Curso", Objects.nonNull( curso ) && Objects.nonNull( curso.getNome() ) ? curso.getNome() : "" );
        } while (!service.valido( nome ));

        Short cargaHoraria = null;

        do {
            cargaHoraria = Short.valueOf( JOptionPane.showInputDialog( "carga horária", Objects.nonNull( curso ) && Objects.nonNull( curso.getCargaHoraria() ) ? curso.getCargaHoraria() : "" ) );
            valido = cargaHoraria > 0 ? true : false;
        } while (valido == false);


        Curso c = new Curso();
        c.setNome( nome ).setCargaHoraria( cargaHoraria );
        return service.persist( c );
    }
}
