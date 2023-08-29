package br.com.fiap.domain.view;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class BackGr extends JFrame {

    JDC data = new JDC();
    JPanel painel = new JPanel();

    public BackGr() {
        setSize( 450, 100 );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        painel.add( data );
        data.setPreferredSize( new Dimension( 120, 20 ) );

        JTextField f = new JTextField();
        painel.add( f );
        f.setEditable( false );
        f.setPreferredSize( new Dimension( 200, 20 ) );

        JButton btSetar = new JButton( "Clique" );
        painel.add( btSetar );
        btSetar.setPreferredSize( new Dimension( 70, 20 ) );

        btSetar.addActionListener( (ActionEvent e) -> {
            Date valor = data.getData();
            f.setText( "" + valor );
        } );
        add( painel );
    }

    public static void main(String[] args) {
        BackGr bg = new BackGr();
        bg.setVisible( true );
    }
}

class JDC extends JDateChooser {

    public JDC() {

    }

    public void setData(Object valor) {
        setDate( ((Date) valor) );
    }

    public Date getData() {
        JDateChooser calendario = new JDateChooser( new Date(), "dd/MM/yyyy" );
        return (calendario.getDate());
    }
}