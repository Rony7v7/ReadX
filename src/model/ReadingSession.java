package model;

public class ReadingSession {

    private Product product;
    private String productName;
    private int totalPages;
    private int currentPage;
    private int maxPageRead;

    public ReadingSession(Product product) {
        this.product = product;
        this.productName = product.getName();
        this.totalPages = product.getPagesAmount();

        currentPage = maxPageRead = 1;
        this.product.updatePagesReadAmount(currentPage);

    }

    /**
     * @return the currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return the totalPages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * @param totalPages the totalPages to set
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void nextPage() {
        this.currentPage++;

        if (currentPage > maxPageRead) {
            maxPageRead ++;
            this.product.updatePagesReadAmount(1);
        }
    }

    public void previousPage() {
        this.currentPage = currentPage > 1? currentPage-1 : currentPage;
    }

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
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

}
