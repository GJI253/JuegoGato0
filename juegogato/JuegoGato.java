/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JuegoGato {

    static JButton[][] botones = new JButton[3][3];
    static boolean turnoX = true;
    static boolean juegoActivo = false;
    static int movimientos = 0; 


    public static void main(String[] args) {

        JFrame ventana = new JFrame("Juego del Gato");
        ventana.setSize(400, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        ventana.getContentPane().setBackground(new Color(30,30,30));

        JLabel titulo = new JLabel("GATO");
        titulo.setForeground(Color.pink);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setBounds(150, 10, 200, 40);
        ventana.add(titulo);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));
        panel.setBounds(50, 80, 300, 300);
        ventana.add(panel);

        for(int f = 0; f < 3; f++){
            for(int c = 0; c < 3; c++){

                botones[f][c] = new JButton("");
                botones[f][c].setFont(new Font("Arial", Font.BOLD, 40));
                botones[f][c].setEnabled(false);
                panel.add(botones[f][c]);

                botones[f] [c].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        if(!juegoActivo) return;

                        JButton boton = (JButton)e.getSource();

                        if(boton.getText().equals("")){

                            if(turnoX){
                                boton.setText("X");
                                boton.setForeground(Color.RED); // 🔴 X rojo
                            } else {
                                boton.setText("O");
                                boton.setForeground(Color.BLUE); // 🔵 O azul
                            }

                            movimientos++;
                            turnoX = !turnoX;
                            verificarGanador();
                        }
                    }
                });
            }
        }

      
        JButton empezar = new JButton("Empezar");
        empezar.setBounds(140, 400, 120, 30);
        empezar.setBackground(Color.GREEN);
        empezar.setForeground(Color.BLACK);
        ventana.add(empezar);

        empezar.addActionListener(e -> {
            juegoActivo = true;
            turnoX = true;
            movimientos = 0;


            for(int f = 0; f < 3; f++){
                for(int c = 0; c < 3; c++){
                    botones[f][c].setText("");
                    botones[f][c].setEnabled(true);
                }
            }
        });

        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    static void verificarGanador(){

        for(int i = 0; i < 3; i++){

            if(!botones[i][0].getText().equals("") &&
               botones[i][0].getText().equals(botones[i][1].getText()) &&
               botones[i][1].getText().equals(botones[i][2].getText())){

                mostrarGanador(botones[i][0].getText());
            }

            if(!botones[0][i].getText().equals("") &&
               botones[0][i].getText().equals(botones[1][i].getText()) &&
               botones[1][i].getText().equals(botones[2][i].getText())){

                mostrarGanador(botones[0][i].getText());
            }
        }

        if(!botones[0][0].getText().equals("") &&
           botones[0][0].getText().equals(botones[1][1].getText()) &&
           botones[1][1].getText().equals(botones[2][2].getText())){

            mostrarGanador(botones[0][0].getText());
        }

        if(!botones[0][2].getText().equals("") &&
           botones[0][2].getText().equals(botones[1][1].getText()) &&
           botones[1][1].getText().equals(botones[2][0].getText())){

            mostrarGanador(botones[0][2].getText());
            return;
        }
            
       if(movimientos >= 9 && juegoActivo){
            juegoActivo = false;
             JOptionPane.showMessageDialog(null, "Empate 🤝");

        for(int f = 0; f < 3; f++){
         for(int c = 0; c < 3; c++){
            botones[f][c].setEnabled(false);
        }
    }
}

        }
    

    static void mostrarGanador(String ganador){

        juegoActivo = false;

        if(ganador.equals("X")){
            JOptionPane.showMessageDialog(null, "Gana X 🔴");
        } else {
            JOptionPane.showMessageDialog(null, "Gana Círculo 🔵");
        }

        for(int f = 0; f < 3; f++){
            for(int c = 0; c < 3; c++){
                botones[f][c].setEnabled(false);
            }
        }
    }
}