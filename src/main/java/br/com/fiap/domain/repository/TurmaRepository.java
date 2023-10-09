package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Curso;
import br.com.fiap.domain.entity.Instrutor;
import br.com.fiap.domain.entity.Turma;
import br.com.fiap.infra.ConnectionFactory;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class TurmaRepository implements Repository<Turma,Long>{

    private CursoRepository cursoRepository = CursoRepository.build();
    private InstrutorRepository instrutorRepository = InstrutorRepository.build();


    private static AtomicReference<TurmaRepository> instance = new AtomicReference<>();

    private TurmaRepository(){
    }

    public static TurmaRepository build(){
        TurmaRepository result = instance.get();
        if (Objects.isNull(result)){
            TurmaRepository repository = new TurmaRepository();
            if (instance.compareAndSet(null,repository)){
                result = repository;
            }
            else {
                result = instance.get();
            }
        }
        return result;
    }
    @Override
    public List<Turma> findAll() {
        List<Turma> turmas = new ArrayList<>();


        try {
            var factory = ConnectionFactory.build();
            Connection connection = factory.getConnection();

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM turma");

            if (rs.isBeforeFirst()){
                while (rs.next()){
                    Long id = rs.getLong("TURMA_ID");
                    Date inicio = rs.getDate("INICIO");
                    Date encerramento = rs.getDate("ENCERRAMENTO");
                    var id_curso = rs.getInt("CURSO_ID");
                    var id_instrutor = rs.getInt("INSTRUTOR_ID");
                    var curso = cursoRepository.findById(id);
                    var instrutor = instrutorRepository.findById(id);
                    turmas.add(new Turma(id,curso,instrutor,null, inicio.toLocalDate(),encerramento.toLocalDate()));
                }
            }
            st.close();
            rs.close();
            connection.close();

        }
        catch (SQLException e){
            System.err.println( "Não foi possivel consultar os dados!\n" + e.getMessage() );
        }
        return turmas;
    }

    @Override
    public Turma findById(Long id) {
        Turma turma = null;
        var sql = "SELECT * FROM TURMA WHERE TURMA_ID=?";

        var factory = ConnectionFactory.build();
        Connection connection = factory.getConnection();

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();

            if (rs.isBeforeFirst()){
                while (rs.next()){
                    Long id_turma = rs.getLong("TURMA_ID");
                    Date inicio = rs.getDate("INICIO");
                    Date encerramento = rs.getDate("ENCERRAMENTO");
                    var id_curso = rs.getInt("CURSO_ID");
                    var id_instrutor = rs.getInt("INSTRUTOR_ID");
                    var curso = cursoRepository.findById(id);
                    var instrutor = instrutorRepository.findById(id);
                    turma = new Turma(id_turma,curso,instrutor,null, inicio.toLocalDate(),encerramento.toLocalDate());

                }
            }
            else{
                System.out.println( "Turma não encontrada com o id = " + id );
            }
            rs.close();
            ps.close();
            connection.close();
        }
        catch (SQLException e){
            System.err.println( "Não foi possível executar a consulta: \n" + e.getMessage());
        }
        return turma;
    }

    @Override
    public List<Turma> findByName(String texto) {
        List<Turma> turmas = new ArrayList<>();
        List<Curso> cursos = cursoRepository.findByName(texto);
        if (cursos.size() >= 1) {
            for (Curso curso : cursos) {
                var idCurso = curso.getId();

                var factory = ConnectionFactory.build();
                Connection connection = factory.getConnection();

                var sql = "SELECT * FROM TURMA WHERE CURSO_ID=?";
                try {
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setLong(1, idCurso);
                    ResultSet rs = ps.executeQuery();

                    if (rs.isBeforeFirst()) {
                        while (rs.next()) {
                            Long id_turma = rs.getLong("TURMA_ID");
                            Date inicio = rs.getDate("INICIO");
                            Date encerramento = rs.getDate("ENCERRAMENTO");
                            var id_curso = rs.getLong("CURSO_ID");
                            var id_instrutor = rs.getLong("INSTRUTOR_ID");
                            var curso_turma = cursoRepository.findById(id_curso);
                            var instrutor = instrutorRepository.findById(id_instrutor);
                            var turma = new Turma(id_turma, curso_turma, instrutor, null, inicio.toLocalDate(), encerramento.toLocalDate());
                            turmas.add(turma);
                        }
                    } else {
                        System.out.println("Turma não encontrada com o nome = " + texto);
                    }
                    rs.close();
                    ps.close();
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Não foi possível executar a consulta: \n" + e.getMessage());
                }
            }

        }
        return turmas;

    }

    @Override
    public Turma persist(Turma turma) {
        var sql = "BEGIN" +
                " INSERT INTO turma (CURSO_ID, INSTRUTOR_ID, INICIO, ENCERRAMENTO) " +
                "VALUES (?,?,?,?) " +
                "returning TURMA_ID into ?; " +
                "END;" +
                "";
        var factory = ConnectionFactory.build();
        Connection connection = factory.getConnection();

        CallableStatement cs = null;
        try {
            cs = connection.prepareCall( sql );
            cs.setLong( 1, turma.getCurso().getId() );
            cs.setLong(2, turma.getInstrutor().getId());
            cs.setDate(3, Date.valueOf(turma.getInicio()));
            cs.setDate(4, Date.valueOf(turma.getEncerramento()));
            cs.registerOutParameter( 5, Types.BIGINT );
            cs.executeUpdate();
            turma.setId( cs.getLong( 5 ) );
            cs.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println( "Não foi possível executar o comando!\n" + e.getMessage() );
        }
        return turma;
    }
}