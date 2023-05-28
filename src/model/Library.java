package model;

import java.util.ArrayList;

/**
 * The Library class represents a library and provides functionality related to managing products and pages.
 * Each library is associated with a user and contains a collection of products.
 */
public class Library {
    
    private String userName;

    private ArrayList<Product> products;
    private ArrayList<String[]> productsMatrix;

    private int ROWS = 5;
    static final int COLUMNS = 5;

    private int currentPage;
    
    /**
     * Constructs a Library object with the given user name and list of products.
     *
     * @param userName  The name of the user associated with the library.
     * @param products  The list of products in the library.
     */
    public Library(String userName, ArrayList<Product> products) {
        this.userName = userName;
        this.products = products;

        this.productsMatrix = new ArrayList<String[]>();

        arraylistToMatrix();

        currentPage = 0;
    }

    /**
     * Returns the number of rows in the library matrix
     * 
     * @return the number of rows
     */
    public int getROWS() {
        return ROWS;
    }

    /**
     * Returns the product ID at the specified coordinates in the library matrix.
     *
     * @param row     The row index.
     * @param column  The column index.
     * @return The product ID.
     */
    public String getProductIdByCoord(int row, int column) {
        return productsMatrix.get(row+(currentPage*5))[column];
    }

    /**
     * Moves to the next page in the library.
     * If there are no more pages, the current page remains unchanged.
     */
    public void nextPage() {
        if(currentPage < products.size()/25) {
            currentPage++;
        }
    }
 
    /**
     * Moves to the previous page in the library.
     * If already on the first page, the current page remains unchanged.
     */
    public void previousPage() {
        
        if(currentPage > 0) {
            currentPage--;
        }

        
    }

    /**
     * Updates the product arraylist by sorting and assigning it to the array. 
     * Since it is pointing to the same reference, it is not necessary to add 
     * the new products to it. 
     * Adjusts the number of rows in the matrix to be a multiple of 5.
     */
    public void updateProducts() {
        sortProductsByDate();
        
        ROWS = (int) Math.ceil(products.size() / 5.0);

        while(ROWS%5 != 0) { // Ajust matrix size to be multiple of 5 
            ROWS++;
        }

        arraylistToMatrix();
    }

    /**
     * sorts products by publish date
     */
    public void sortProductsByDate() {
        products.sort((product1, product2) -> product1.getPublishDate().compareTo(product2.getPublishDate()));
    }

    /**
     * Converts the product ArrayList to a matrix representation.
     * Each row in the matrix corresponds to a page in the library.
     * Empty cells are filled with "---" if there are fewer products than the matrix size.
     */
    public void arraylistToMatrix() {
        productsMatrix.clear();

        String[] row;

        int indexArraylist = 0;

        for(int i = 0; i < ROWS; i++) {
            row = new String[COLUMNS];

            for(int j = 0; j < COLUMNS; j++) {
                
                if(indexArraylist < products.size()) {
                    row[j] = products.get(indexArraylist).getId();
                    indexArraylist++;
                } else {
                    row[j] = "---";
                }
            }
            productsMatrix.add(row);
        }

    }

    /**
     * Converts the matrix representation of the library to a formatted string.
     *
     * @return The string representation of the matrix.
     */
    public String matrixToString() {
        String matrixString = "\n    |  0  |  1  |  2  |  3  |  4  |\n";
        int rowCounter = 0;

        for(int i = currentPage*5; i < 5+currentPage*5; i++){
            matrixString += "| "+rowCounter+" | ";
            rowCounter++;

            for(int j = 0; j < COLUMNS; j++){
                matrixString += productsMatrix.get(i)[j] + " | ";
            }
            matrixString += "\n";
        }

        return matrixString;
    }

    /**
     * Returns a string representation of the library, including the user's name, the matrix, and instructions for navigation.
     *
     * @return The string representation of the library.
     */
    @Override
    public String toString() {
        return "\nLibrary of " + userName+"\n"+
        matrixToString()+
        "\nType the coord (x,y) or the product id to init a reading session"+
        "\nType A to previous page"+
        "\nType D to next page"+
        "\nType S to exit";
    }

}
