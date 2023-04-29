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
        int option = 0;

        option = view.showMenu();

        while (option != 0) {
            view.executeOption(option);
            option = view.showMenu();
        }
    }

    public int showMenu() {
        int option = 0;

        cleanScreen();

        System.out.print("\u001B[38;5;78m----------\u001B[3m BIENVENIDO \u001B[38;5;78m----------\n\n"+
                         " 1.\u001B[0m Registrar usuario \u001B[38;5;78m\n"+
                         " 2.\u001B[0m Adquirir producto \u001B[38;5;78m\n"+
                         " 3.\u001B[0m Registrar producto\u001B[38;5;78m\n"+
                         " 4.\u001B[0m Modificar producto\u001B[38;5;78m\n"+
                         " 5.\u001B[0m Eliminar Producto \u001B[38;5;78m\n"+
                         " 6.\u001B[0m Generar reportes  \u001B[38;5;78m\n\n"+
                         " 0.\u001B[0m Salir             \u001B[38;5;78m\n\n"+
                         " >> \u001B[0m ");

        option = input.nextInt();
        input.nextLine(); // Limpiar

        return option;
    }

    public void cleanScreen() {
        System.out.print("Enter para continuar");
        input.nextLine();

        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public void executeOption(int option) {
    
        switch (option) {
            case 1: registerUser();
                break;
            default: System.out.println("\nOpción inválida.");
                break;

        }

    }

    public void registerUser() {
        
    }

}