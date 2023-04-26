package ui;

import java.util.Scanner;
import model.ReadXSystem;

public class Main{

    private ReadXSystem controller;
    private Scanner input;

    public Main(){
        this.controller = new ReadXSystem();
        this.input = new Scanner(System.in);
    }
    public static void main(String[] args) {
        Main view = new Main();

        view.cleanScreen();
        view.showMenu();
    }

    public void showMenu() {

        System.out.print("\u001B[38;5;78m----------\u001B[3m BIENVENIDO \u001B[38;5;78m----------\n\n"+
                         " 1.\u001B[0m Registrar usuario \u001B[38;5;78m\n"+
                         " 2.\u001B[0m Adquirir producto \u001B[38;5;78m\n"+
                         " 3.\u001B[0m Registrar producto\u001B[38;5;78m\n"+
                         " 4.\u001B[0m Modificar producto\u001B[38;5;78m\n"+
                         " 5.\u001B[0m Eliminar Producto \u001B[38;5;78m\n"+
                         " 6.\u001B[0m Generar reportes  \u001B[38;5;78m\n\n"+
                         " 0.\u001B[0m Salir             \u001B[38;5;78m\n\n"+
                         " >> \u001B[0m ");
    }

    public void cleanScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

}