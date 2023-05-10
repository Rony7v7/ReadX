/* 
 * DUDAS:
 * 
 * Usar ennumeraciones
 * 
 * Al borrar productos se elimina de cada user?
 * Cómo buscar productos?
 * 
 * Como funcionan las referencias
 * 
 * Asinar una matriz completa de 5*nProductos a cada user, y luego se imprime acotada
 * 
 * Crear pre tests
 * 
*/

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

        view.controller.initSystem();

        option = view.showMenu();

        while (option != 0) {
            view.executeOption(option);
            option = view.showMenu();
        }
    }

    public int showMenu() {
        int option = 0;

        cleanScreen(false);

        System.out.print("\u001B[38;5;78m----------\u001B[3m WELCOME \u001B[38;5;78m----------\n\n"+
                         " 1.\u001B[0m Register user \u001B[38;5;78m\n"+
                         " 2.\u001B[0m Register product \u001B[38;5;78m\n"+
                         " 3.\u001B[0m Modify product \u001B[38;5;78m\n"+
                         " 4.\u001B[0m Delete Product \u001B[38;5;78m\n"+
                         " 5.\u001B[0m Purchase product \u001B[38;5;78m\n"+
                         " 6.\u001B[0m Generate reports \u001B[38;5;78m\n\n"+
                         " 0.\u001B[0m Exit             \u001B[38;5;78m\n\n"+
                         " >> \u001B[0m ");

        option = input.nextInt();
        input.nextLine(); // Limpiar

        cleanScreen(false);

        return option;
    }

    public void cleanScreen(boolean needEnter) {
        if(needEnter) {
            System.out.print("\nEnter to continue");
            input.nextLine();
        }

        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public void executeOption(int option) {
    
        switch (option) {
            case 1:
                registerUser();
                break;
            
            case 2:
                registerProduct();
                break;

            case 3:
                modifyProduct();
                break;

            case 4:
                deleteProduct();
                break;
                
            default: 
                System.out.println("Invalid option.");
                break;

        }
        cleanScreen(true);
    }

    public void registerUser() {
        String name;
        String id;
        int type;

        String msg = "";

        System.out.println("\u001B[38;5;78m-------- \u001B[3mREGISTER USER --------\u001B[0m\n");
        
        System.out.print("Name: ");
        name = input.nextLine();

        System.out.print("\nId: ");
        id = input.nextLine();

        do {
            System.out.print("\nUser plan"+"\n1.Regular"+"\n2.Premium"+"\n>> ");
            type = input.nextInt();
            input.nextLine();
  
        } while (type < 1 || type >2);

        msg = controller.registerUser(name, id, type);

        System.out.println(msg);

    }

    public void registerProduct() {
        int productType;
        String name;
        int pagesAmount;
        String publishDate;
        String url;
        float price;

        //Books
        int genre;
        String review;

        //Magazines
        int category;
        int issueAmount;

        String msg = "";

        System.out.println("-------- REGISTER PRODUCT --------\n");
        
        System.out.print("Type of product"+"\n1. Book"+"\n2. Magazine"+"\n>>  "); //Validar
        productType = input.nextInt();
        input.nextLine();

        System.out.print("\nName: ");
        name = input.nextLine();

        System.out.print("\nAmount of pages: ");
        pagesAmount = input.nextInt();
        input.nextLine();

        System.out.print("\nPublish date ('dd/mm/yyyy'): ");
        publishDate = input.nextLine();

        System.out.print("\nCover URL: ");
        url = input.nextLine();

        System.out.print("\nSelling/Subscription price(USD): $");
        price = input.nextFloat();

        if(productType == 1) {

            System.out.println("\nGenre");
            System.out.print("1. Science Fiction \n2. Fantasy \n3. Historical novel \n>> ");  //Validar
            genre = input.nextInt();
            input.nextLine();

            System.out.print("\nReview: ");
            review = input.nextLine();

            msg = controller.registerProduct(name, pagesAmount, publishDate, url, price, genre,review);

        } else if(productType == 2) {

            System.out.println("\nCategory");
            System.out.print("1. Varieties \n2. Design \n3. Scientific \n>> ");  //Validar
            category = input.nextInt();

            System.out.println("\nIssue frecuency");
            System.out.print("1. Diary \n2. Weekly \n3. Monthly \n4. Yearly \n>> "); //Validar
            issueAmount = input.nextInt();
            input.nextLine();

            msg = controller.registerProduct(name, pagesAmount, publishDate, url, price, category, issueAmount);
    
        } 

        System.out.println(msg);

    }

    public void modifyProduct() {

        String msg = "There are no products to modify.";

        String id;
        String productsInfo = controller.getProductsInfo();
        String fullProductInfo = "";

        //------- New parameters-----
        int nProductType;
        String nName;
        int nPagesAmount;
        String nPublishDate;
        String nUrl;
        float nPrice;

        //-Books
        int nGenre;
        String nReview;

        //-Magazines
        int nCategory;
        int nIssueAmount;

        System.out.println("-------- MODIFY PRODUCT --------\n");

        if(!(productsInfo.isBlank())) {

            System.out.println(productsInfo);
            System.out.print("Type product id: ");

            id = input.nextLine();

            //check if the product exists
            nProductType = controller.getProductType(id);

            if(nProductType != 0) {
                fullProductInfo = controller.getFullProductInfo(id);
            }
            
            System.out.println("\n"+fullProductInfo);

            msg = "Id not found.";

            if(!(fullProductInfo.isBlank())) {

                System.out.println("\nFill in the data you wish to modify, otherwise type '0'");

                System.out.print("\nName: ");
                nName = input.nextLine();

                System.out.print("\nAmount of pages: ");
                nPagesAmount = input.nextInt();
                input.nextLine();

                System.out.print("\nPublish date ('dd/mm/yyyy'): ");
                nPublishDate = input.nextLine();

                System.out.print("\nCover URL: ");
                nUrl = input.nextLine();

                System.out.print("\nSelling/Subscription price(USD): $");
                nPrice = input.nextFloat();

                if(nProductType == 1) {

                    System.out.println("\nGenre");
                    System.out.print("1. Science Fiction \n2. Fantasy \n3. Historical novel \n>> ");  //Validar
                    nGenre = input.nextInt();
                    input.nextLine();

                    System.out.print("\nReview: ");
                    nReview = input.nextLine();

                    msg = controller.modifyProduct(id,nName, nPagesAmount, nPublishDate, nUrl, nPrice, nGenre, nReview, 0, 0);

                } else if(nProductType == 2) {

                    System.out.println("\nCategory");
                    System.out.print("1. Varieties \n2. Design \n3. Scientific \n>> ");  //Validar
                    nCategory = input.nextInt();

                    System.out.println("\nIssue frecuency");
                    System.out.print("1. Diary \n2. Weekly \n3. Monthly \n4. Yearly \n>> "); //Validar
                    nIssueAmount = input.nextInt();
                    input.nextLine();

                    msg = controller.modifyProduct(id,nName, nPagesAmount, nPublishDate, nUrl, nPrice, 0, "0", nCategory, nIssueAmount);
                }
            }
        
        }

        System.out.println(msg);
    } 

    public void deleteProduct() {
        String productsInfo = controller.getProductsInfo();
        String msg = "There are no products to delete.";

        System.out.println("-------- DELETE PRODUCT --------\n");
        System.out.println(productsInfo);

        if(!(productsInfo.isBlank())) {
            System.out.print("Type product id: ");
            String id = input.nextLine();

            msg =controller.deleteProduct(id);
        } 

        System.out.println(msg);
    }

    // public void purchaseProduct() {
    //     String productsInfo = controller.getProductsInfo();
    //     String usersInfo = controller.getUsersInfo();

    //     String productId;
    //     String userId;

    //     String msg = "\nThere are no products to purchase or there are not users to purchase products.";

    //     System.out.println("-------- PURCHASE PRODUCT --------\n");

    //     if(!(usersInfo.isBlank()) && !(productsInfo.isBlank())) {
            
    //         System.out.println(usersInfo);
    //         System.out.print("Type user id: ");
    //         userId = input.nextLine();

    //         do {
    //             System.out.print("Type product id (-1 to end buy): ");
    //             productId = input.nextLine();

    //             if(!(productId.equals("-1"))) {
    //                 msg += controller.purchaseProduct(userId, productId);
    //             }

    //         }while(!(productId.equals("-1")));

            
    

    //         msg = controller.purchaseProduct(userId, productId);

    //     }

    //     System.out.println(msg);

    // }

    //---------------------------------------------------


}