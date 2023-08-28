package br.com.fiap.domain.service;

import br.com.fiap.domain.entity.Aluno;
import br.com.fiap.exception.MetodoNaoImplementadoException;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class AlunoService implements Service<Aluno, Long> {


    @Override
    public List<Aluno> findAll() {
        throw new MetodoNaoImplementadoException("Método não Implementado");
    }

    @Override
    public Aluno findById(Long id) {
        throw new MetodoNaoImplementadoException("Método não Implementado");
    }

    @Override
    public List<Aluno> findByName(String texto) {
        throw new MetodoNaoImplementadoException("Método não Implementado");
    }

    /**
     * Gere matricula de forma randômica.
     * e-mail deve ser validado
     * id deve ser gerado pelo repository
     *
     * @param aluno
     * @return
     */
    @Override
    public Aluno persist(Aluno aluno) {
        throw new MetodoNaoImplementadoException("Método não Implementado");
    }

    /**
     * Validando email
     * @param emailAddress
     * @return
     */
    public boolean validarEmail(String emailAddress) {
        //Expressão Regular. Para saber mais:
        //Dica de leitura: Expressões Regulares: Uma Abordagem Divertida
        //ISBN 13: 978-8575224748
        var regexPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    /**
     * Gerando matricula randomicamente
     * @return
     */
    public String gerarMatricula() {
        Random r = new Random();
        var matricula = LocalDate.now().getYear() + "." + r.nextInt(1000, 9999) + "-" + r.nextInt(10, 99);
        return matricula;
    }

}
