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

        cleanScreen(false);

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

        cleanScreen(false);

        return option;
    }

    public void cleanScreen(boolean needEnter) {
        if(needEnter) {
            System.out.print("Enter para continuar");
            input.nextLine();
        }

        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public void executeOption(int option) {
    
        switch (option) {
            case 1:
                registerUser();
                cleanScreen(true);
                break;

            default: 
                System.out.println("Opción inválida.");
                cleanScreen(true);
                break;

        }

    }

    public void registerUser() {
        String name;
        String id;
        int type;

        String msg = "";

        System.out.println("\u001B[38;5;78m-------- \u001B[3mREGISTRO DE USUARIOS --------\u001B[0m\n");
        
        System.out.print("Nombre: ");
        name = input.nextLine();

        System.out.print("\nCédula: ");
        id = input.nextLine();

        do {
            System.out.print("\nPlan de usuario"+"\n1.Estándar"+"\n2.Premium"+"\n>> ");
            type = input.nextInt();
            input.nextLine();
  
        } while (type < 1 || type >2);

        msg = controller.registerUser(name, id, type);

        System.out.println(msg);

    }

    // public void registerProduct() {
    //     String productType;
    //     String name;
    //     String pagesAmount;
    //     String publishDate;
    //     String url;
    //     float price;
    //     int pagesReadAmount;

    //     //Books
    //     String review;
    //     int copiesSoldAmount;

    //     //Magazines
    //     int subscriptionsActivesAmount;
    //     String issueAmount;

    //     String msg = "";

    //     System.out.println("-------- REGISTRO DE PRODUCTOS --------\n");
        
    //     System.out.print("Tipo de producto"+"\n1.Libro"+"\n2.Revista"+"\n>>  ");
    //     productType = input.nextInt();
    //     input.nextLine();

    //     System.out.print("\nNombre: ");
    //     name = input.nextLine();

    //     System.out.print("\nNúmero de páginas: ");
    //     pagesAmount = input.nextDouble();
    //     input.nextLine();

    //     System.out.print("\nFecha de publicación: ");
    //     publishDate = input.nextLine();

    //     System.out.print("\nURL de portada: ");
    //     url = input.nextLine();

    //     System.out.print("\nPrecio de venta o suscripción: ");
    //     price = input.nextFloat();

    //     System.out.println("\nTotal acumulado de páginas leidas: ");

    //     System.out.println(msg);

    // }

}