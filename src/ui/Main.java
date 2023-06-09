package ui;

import java.util.Scanner;
import model.ReadXSystem;

/**
 * Constructs a Main object that serves as the user interface for the ReadXSystem application.
 * It provides methods for displaying the menu, handling user input, and executing the selected options.
 */
public class Main{

    private ReadXSystem controller;
    private Scanner input;

    /**
     * Creates a new Main object and initializes the controller and input scanner.
     */
    public Main(){
        this.controller = new ReadXSystem();
        this.input = new Scanner(System.in);
    }

    /**
     * The main method of the application.
     * It creates an instance of Main, initializes the ReadXSystem, displays the menu, and handles user input until the user chooses to exit.
     *
     * @param args The command-line arguments.
     */
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

    /**
     * Displays the menu to the user and retrieves their choice.
     *
     * @return The user's menu choice.
     */    
    public int showMenu() {
        int option = 0;

        cleanScreen(false);

        System.out.print("\u001B[38;5;78m----------\u001B[3m WELCOME \u001B[38;5;78m----------\n\n"+
                         " 1.\u001B[0m Register user \u001B[38;5;78m\n"+
                         " 2.\u001B[0m Register product \u001B[38;5;78m\n"+
                         " 3.\u001B[0m Modify product \u001B[38;5;78m\n"+
                         " 4.\u001B[0m Delete Product \u001B[38;5;78m\n"+
                         " 5.\u001B[0m Purchase product \u001B[38;5;78m\n"+
                         " 6.\u001B[0m Cancel subscription to  a magazine \u001B[38;5;78m\n"+
                         " 7.\u001B[0m Show library \u001B[38;5;78m\n"+
                         " 8.\u001B[0m Generate reports \u001B[38;5;78m\n\n"+
                         " 0.\u001B[0m Exit             \u001B[38;5;78m\n\n"+
                         " >> \u001B[0m ");

        option = input.nextInt();
        input.nextLine();

        cleanScreen(false);

        return option;
    }

    /**
     * Clears the screen and optionally prompts the user to press enter.
     *
     * @param needEnter Indicates whether the user should be prompted to press enter.
     */
    public void cleanScreen(boolean needEnter) {
        if(needEnter) {
            System.out.print("\nEnter to continue");
            input.nextLine();
        }

        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    /**
     * Executes the selected option based on the user's choice.
     *
     * @param option The user's menu choice.
     */
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

            case 5:
                purchaseProduct();
                break;

            case 6:
                cancelMagazineSubscription();
                break;

            case 7:
                showLibrary();
                break;

            case 8:
                generateReports();
                break;
                
            default: 
                System.out.println("Invalid option.");
                break;

        }
        cleanScreen(true);
    }

    /**
     * Registers a new user by prompting for their name, ID, and user plan.
     */
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

        System.out.print("\nUser plan"+"\n1.Regular"+"\n2.Premium");
        type = validateIntInRange(1, 2);

        msg = controller.registerUser(name, id, type);

        System.out.println(msg);

    }

    /**
     * Registers a new product by prompting for its details and type.
     */
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
        
        System.out.print("Type of product"+"\n1. Book"+"\n2. Magazine");
        productType = validateIntInRange(1, 2);

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
            System.out.print("1. Science Fiction \n2. Fantasy \n3. Historical novel ");
            genre = validateIntInRange(1, 3);

            System.out.print("\nReview: ");
            review = input.nextLine();

            msg = controller.registerProduct(name, pagesAmount, publishDate, url, price, genre,review);

        } else if(productType == 2) {

            System.out.println("\nCategory");
            System.out.print("1. Varieties \n2. Design \n3. Scientific ");
            category = validateIntInRange(1, 3);

            System.out.println("\nIssue frecuency");
            System.out.print("1. Diary \n2. Weekly \n3. Monthly \n4. Yearly ");
            issueAmount = validateIntInRange(1, 4);

            msg = controller.registerProduct(name, pagesAmount, publishDate, url, price, category, issueAmount);
    
        } 

        System.out.println(msg);

    }
    
    /**
     * Modifies an existing product by prompting for the product ID and the new details.
     */
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
                    System.out.print("1. Science Fiction \n2. Fantasy \n3. Historical novel ");  //Validar
                    nGenre = validateIntInRange(0, 3);

                    System.out.print("\nReview: ");
                    nReview = input.nextLine();

                    msg = controller.modifyProduct(id,nName, nPagesAmount, nPublishDate, nUrl, nPrice, nGenre, nReview, 0, 0);

                } else if(nProductType == 2) {

                    System.out.println("\nCategory");
                    System.out.println("1. Varieties \n2. Design \n3. Scientific");
                    nCategory = validateIntInRange(0, 3);

                    System.out.println("\nIssue frecuency");
                    System.out.print("1. Diary \n2. Weekly \n3. Monthly \n4. Yearly ");
                    nIssueAmount =validateIntInRange(0, 4);

                    msg = controller.modifyProduct(id,nName, nPagesAmount, nPublishDate, nUrl, nPrice, 0, "0", nCategory, nIssueAmount);
                }
            }
        
        }

        System.out.println(msg);
    } 

    /**
     * Deletes a product by prompting for the product ID.
     */
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

    /**
     * Allows a user to purchase a product by adding it to their cart.
     */
    public void purchaseProduct() {
        String productsInfo = controller.getProductsInfo();
        String usersInfo = controller.getUsersInfo();

        String productId;
        String userId;

        String msg = "There are no products to purchase or there are not users to purchase products.";

        int continueBuyOption;

        System.out.println("-------- PURCHASE PRODUCT --------\n");

        if(!(usersInfo.isBlank()) && !(productsInfo.isBlank())) {
            
            System.out.println(usersInfo);
            System.out.print("Type user id: ");

            userId = input.nextLine();

            msg = "\nUser not found.";

            if(controller.searchUserById(userId) != null) {
                do{
                    System.out.println("\n"+productsInfo);
                    System.out.print("\nType product id: ");
                    productId = input.nextLine();

                    msg = controller.addProductToCart(productId, userId);
                    System.out.println(msg);

                    System.out.print("\nContinue buying?\n1. Yes\n2. No ");
                    continueBuyOption = validateIntInRange(1, 2);

                }while(continueBuyOption == 1);

                msg = controller.purchaseCart(userId);

            }

        }

        System.out.println(msg);

    }

    /**
     * Cancels a magazine subscription for a user by removing it from their subscriptions.
     */
    public void cancelMagazineSubscription() {
        String usersInfo = controller.getUsersInfo();
        String magazinesInfo;
        
        String magazineId;
        String userId;
        
        String msg = "There are no users registered.";
        
        System.out.println("-------- CANCEL MAGAZINE SUBSCRIPTION --------\n");

        if(!usersInfo.isBlank()) {
            
            System.out.println(usersInfo);
            System.out.print("Type user id: ");

            userId = input.nextLine();
            msg = "\nUser not found.";
            
            magazinesInfo = controller.getUserMagazines(userId);

            if(controller.searchUserById(userId) != null && !(magazinesInfo.isBlank()) ) {

                System.out.println(magazinesInfo);
                System.out.print("Type magazine id: ");

                magazineId = input.nextLine();

                msg = controller.cancelMagazineSubscription(userId, magazineId);
            } else {
                msg = "There are no magazines to cancel subscription.";
            }

        }

        System.out.println(msg);
    }

    /**
     * Displays the user's library and allows navigation through the library.
     */
    public void showLibrary() {
        String userId;
        String usersInfo = controller.getUsersInfo();

        String option;

        int page = 0;

        String msg = "\nThere are not users to show their library.";

        System.out.println("----------- LIBRARY -----------\n");
        System.out.println(usersInfo);

        if(!usersInfo.isBlank()) {
            msg = "\nUser not found.";

            System.out.print("Type user id: ");
            userId = input.nextLine();

            if(controller.searchUserById(userId) != null) {
                do{
                    msg = controller.getLibrary(userId, page);
                    System.out.print(msg+"\n>> ");
                    option = input.nextLine();
                    
                    cleanScreen(false);
                    
                    if(option.length() == 1) {
    
                        msg = controller.navigateLibrary(option, userId);
                        System.out.println(msg);
    
                    } else if(option.length() == 3 ){
                        initReadingSession(userId, option);
                    } else {
                        System.out.println("\nId or coordinates not found.");
                    }
    
                }while((option.charAt(0) == 'A' || option.charAt(0) == 'D')|| option.charAt(0) != 'S' );
            } else {
                System.out.println(msg);
            }

        } else {
            System.out.println(msg);
        }



    }

    /**
     * Initializes a reading session for a user and a specific product.
     *
     * @param userId      The ID of the user.
     * @param productLink The link or identifier of the product.
     */
    public void initReadingSession(String userId, String productLink) {
        char option = ' ';
        String msg;
        
        do{
            cleanScreen(false);
            msg = controller.initReadingSession(userId, productLink, option);

            option = 'S';
            if(!msg.isBlank()) {
                System.out.print(msg+"\n>> ");
                option = input.next().charAt(0);
                input.nextLine();
            } else {
                System.out.println("\nId or coordinates not found.");
            }
            
            if(option != 'A' && option != 'D' && option != 'S') {
                System.out.println("\nInvalid option.");
            }
  
        } while(option == 'A' || option == 'D' || option != 'S');

    } 

    /**
     * Generates reports based on the user's choice.
     */
    public void generateReports(){
        String msg = " ";
        int option;

        System.out.println("-------- GENERATE REPORTS --------\n");
        System.out.println( "Choose the report you want to generate: \n"+
                            "\n1. Total accumulated number of pages read by product type"+
                            "\n2. Most read genre and categorie"+
                            "\n3. Top 5 most-read books and Top 5 most-read magazines"+
                            "\n4. Sales report by genre"+
                            "\n5. Subscriptions report by category"
                          );
        option = validateIntInRange(1, 5);

        msg = controller.generateReports(option);

        System.out.println(msg);
    }
    
    //---------------------------------------------------
    
    /**
     * Validates an integer input within the specified range.
     *
     * @param min The minimum allowed value.
     * @param max The maximum allowed value.
     * @return The validated integer input.
     */
    public int validateIntInRange(int min, int max) {

        int option = 0;
        System.out.println("");

        do{
            System.out.print(">> ");
            option = input.nextInt();
            input.nextLine();

            if(option < min || option > max) {
                System.out.println("\r\t\tInvalid option.");
            }

        }while(option < min || option > max);

        return option;
    }
    


}