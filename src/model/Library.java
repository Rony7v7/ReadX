package model;

import java.util.ArrayList;

public class Library {
    
    private String userName;

    private ArrayList<Product> products;
    private ArrayList<String[]> productsMatrix;

    private int ROWS = 5;
    static final int COLUMNS = 5;

    private int currentPage;
    
    public Library(String userName, ArrayList<Product> products) {
        this.userName = userName;
        this.products = products;

        this.productsMatrix = new ArrayList<String[]>();

        arraylistToMatrix();

        currentPage = 0;
    }

    /**
     * @return the rOWS
     */
    public int getROWS() {
        return ROWS;
    }

    public String getProductIdByCoord(int row, int column) {
        return productsMatrix.get(row+(currentPage*5))[column];
    }

    public void nextPage() {
        if(currentPage < products.size()/25) {
            currentPage++;
        }
    }
 
    public void previousPage() {
        
        if(currentPage > 0) {
            currentPage--;
        }

        
    }

    /**
     * Updates the product arraylist by sorting and assigning it to the array. 
     * Since it is pointing to the same reference, it is not necessary to add 
     * the new products to it. 
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
