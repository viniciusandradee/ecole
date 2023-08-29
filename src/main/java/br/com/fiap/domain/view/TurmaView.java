package br.com.fiap.domain.view;

import br.com.fiap.domain.entity.Curso;
import br.com.fiap.domain.entity.Instrutor;
import br.com.fiap.domain.entity.Turma;
import br.com.fiap.domain.service.CursoService;
import br.com.fiap.domain.service.InstrutorService;
import br.com.fiap.domain.service.TurmaService;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

public class TurmaView extends Component implements View<Turma, Long> {

    TurmaService service = new TurmaService();

    @Override
    public List<Turma> findAll() {
        return service.findAll();
    }

    @Override
    public Turma findById(Long id) {
        Long identificador = Long.valueOf( JOptionPane.showInputDialog( "ID da Turma", Objects.nonNull( id ) ? id : 0 ) );
        return service.findById( identificador );
    }

    @Override
    public List<Turma> findByName(String texto) {
        String nome = service.valido( texto ) ? texto : JOptionPane.showInputDialog( "Nome do Professor" );

        while (!service.valido( nome )) {
            nome = JOptionPane.showInputDialog( "Nome do Professor" );
        }

        return service.findByName( nome );
    }

    @Override
    public Turma persist(Turma turma) {

        CursoService cursoService = new CursoService();
        InstrutorService instrutorService = new InstrutorService();


        var cursos = cursoService.findAll();

        Curso curso = (Curso) JOptionPane.showInputDialog( null, "Selecione o Curso", "Curso", JOptionPane.QUESTION_MESSAGE, null, cursos.toArray(), Objects.nonNull( cursos ) ? cursos.get( 0 ) : null );

        var instrutores = instrutorService.findAll();

        Instrutor instrutor = (Instrutor) JOptionPane.showInputDialog( null, "Selecione o Professor", "Professor", JOptionPane.QUESTION_MESSAGE, null, instrutores.toArray(), Objects.nonNull( instrutores ) ? instrutores.get( 0 ) : null );


        LocalDate inicio = null;
        LocalDate fim = null;

        JDateChooser jdInicio = new JDateChooser();
        JDateChooser jdFim = new JDateChooser();

        jdInicio.setCalendar( new GregorianCalendar() );
        jdFim.setCalendar( new GregorianCalendar() );


        if (JOptionPane.showConfirmDialog( this, new Object[]{"Inicio do Curso", jdInicio}, "Data Inicial", JOptionPane.PLAIN_MESSAGE ) == 0) {
            System.out.println( "Data Inicial=" + jdInicio.getDate().toString() );
            inicio = LocalDate.ofInstant( jdInicio.getDate().toInstant(), ZoneId.of( String.valueOf( TimeZone.getDefault() ) ) );
        }

        if (JOptionPane.showConfirmDialog( this, new Object[]{"Fim do Curso", jdFim}, "Data Final", JOptionPane.PLAIN_MESSAGE ) == 0) {
            System.out.println( "Data Final=" + jdFim.getDate().toString() );
            fim = LocalDate.ofInstant( jdFim.getDate().toInstant(), ZoneId.of( String.valueOf( TimeZone.getDefault() ) ) );
        }


        Turma t = new Turma();
        t.setCurso( curso ).setInstrutor( instrutor ).setInicio( inicio ).setEncerramento( fim );
        return service.persist( t );


    }
}
