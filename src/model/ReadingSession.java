package model;

/**
 * Represents a reading session of a product. It is used to keep track of the pages read by the user.
 * It provides methods to return and modify the current page, total pages, and max page read. 
 */
public class ReadingSession {

    private Product product;
    private String productName;
    private int totalPages;
    private int currentPage;
    private int maxPageRead;

    /**
     * Constructs a ReadingSession object with the given product.
     * Initializes the current page to 1 and sets the total pages based on the product.
     * Updates the pages read amount of the product to 1.
     *
     * @param product The product associated with the reading session.
     */
    public ReadingSession(Product product) {
        this.product = product;
        this.productName = product.getName();
        this.totalPages = product.getPagesAmount();

        currentPage = maxPageRead = 1;
        this.product.updatePagesReadAmount(currentPage);

    }

    /**
     * Returns the current page of the reading session.
     * 
     * @return the currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * Sets the current page of the reading session.
     * 
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * Returns the total pages of the reading session.
     * 
     * @return the totalPages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * Sets the total pages of the reading session.
     * 
     * @param totalPages the totalPages to set
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * Moves to the next page of the reading session.
     * If the current page exceeds the maximum page read, updates the maximum page read and updates the pages read amount of the product.
     */
    public void nextPage() {
        this.currentPage++;

        if (currentPage > maxPageRead) {
            maxPageRead ++;
            this.product.updatePagesReadAmount(1);
        }
    }

    /**
     * Moves to the previous page of the reading session.
     * If the current page is already at the first page, it remains unchanged.
     */
    public void previousPage() {
        this.currentPage = currentPage > 1? currentPage-1 : currentPage;
    }

    /**
     * Returns a string representation of the reading session, including the product name, current page, total pages, and navigation instructions.
     *
     * @return A string representation of the reading session.
     */
    @Override
    public String toString() {
        return  "\nReading Session in progress:\n\n"+
                "Reading: "+productName+
                "\n\nReading page "+currentPage+"/"+totalPages+
                "\n\nType A to previous page"+
                "\nType D to next page"+
                "\nType S to back to library";
            }

    /**
     * Returns the product associated with the reading session.
     * 
     * @return The associated product.
     */
    public Product getProduct() {
        return product;
    }

}
