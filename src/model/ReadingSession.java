package model;

public class ReadingSession {

    private Product product;
    private String productName;
    private int totalPages;
    private int currentPage;
    private boolean nextPageIsNew;

    public ReadingSession(Product product) {
        this.productName = product.getName();
        this.totalPages = product.getPagesAmount();

        currentPage = 1;
        product.setPagesReadAmount(currentPage);

        this.nextPageIsNew = true;
    }

    public void nextPage() {
        this.currentPage++;

        // if(nextPageIsNew){
        //     product.setPagesReadAmount(product.getPagesReadAmount()+1);
        // }
    }

    public void previousPage() {
        currentPage = currentPage > 1? currentPage-1 : currentPage;
        nextPageIsNew = false;
    }

    @Override
    public String toString() {
        return "\nReading Session in progress:\n\nReading: "+productName+"\n\nReading page "+currentPage+"/"+totalPages;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }
}
