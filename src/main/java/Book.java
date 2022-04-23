public class Book {
    private int numberOfPages;
    private Author author;

    public Book(int numberOfPages, Author author) {
        this.numberOfPages = numberOfPages;
        this.author = author;
    }

    public Book shallowCopy() {
        return new Book(this.numberOfPages, this.author);
    }

    public Book deepCopy() {
        return new Book(this.numberOfPages, new Author(this.author.getName()));
    }

    public Author getAuthor() {
        return this.author;
    }
}