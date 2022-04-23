import jdk.jfr.StackTrace;

import static org.junit.jupiter.api.Assertions.*;

class BookCopyTest {

    @Test
    public void testShallowCopy() {
        Author author = new Author("Rauf");
        Book book = new Book(250, author);
        Book clonedBook = book.shallowCopy();
        clonedBook.getAuthor().setName("Orxan");
        Assertions.assertEquals("Orxan", book.getAuthor().getName());
    }

    @Test
    public void testDeepCopy() {
        Author author = new Author("Rauf");
        Book book = new Book(250, author);
        Book clonedBook = book.deepCopy();
        clonedBook.getAuthor().setName("Orxan");
        Assertions.assertEquals("Rauf", book.getAuthor().getName());
    }

}