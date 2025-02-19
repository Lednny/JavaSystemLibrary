public class Book {
    private String title;
    private String author;
    private String type; // GENERO
    private int stock;

    public Book(String title, String author, String type, int stock) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.stock = stock;
    }

    public String toString(){
        return "Título: " + title + "\n Autor: " + author + "\n Género: " + type + "\n Stock: " + stock + "\n";
    }

    // Print data
    public void mostrarInfo(){ 
        System.out.println("Título:   " + title);
        System.out.println("Autor:    " + author);
        System.out.println("Gènero:   " + type);
        if (stock > 0) {
            System.out.println("En stock: " + stock);
        } else {
            System.out.println("Sin stock: " + stock);
        }    
    }

    // METODOS

    public boolean prestado() {
        if (this.stock > 0) {
            this.stock--;
            return true;
        }
        return false;
    }

//    public void reduceStock  (int Quantity) {
//        if(Quantity > 0 && Quantity <= 2){
//            stock -= Quantity;
//        } else {
//            System.out.println("No hay suficiente stock.");
//        }
//        
//    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    public int getStock() {
        return stock;
    }
    

        //Método para devolver un libro
    public void devolver() {
        stock++;  
    }
}
