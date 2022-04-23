import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    public void testShallowCopyFail() {
        Author author = new Author("Rauf");
        Book book = new Book(250, author);
        Book clonedBook = book.shallowCopy();
        clonedBook.getAuthor().setName("Orxan");
        Assertions.assertNotEquals("Rauf", book.getAuthor().getName());
    }

    @Test
    public void testDeepCopy() {
        Author author = new Author("Rauf");
        Book book = new Book(250, author);
        Book clonedBook = book.deepCopy();
        clonedBook.getAuthor().setName("Orxan");
        Assertions.assertEquals("Rauf", book.getAuthor().getName());
    }

    @Test
    public void testCollectionsImmutability() {
        final List<Integer> finalList = new ArrayList<>();
        final List<Integer> unmodifiableList = Collections.unmodifiableList(Arrays.asList(1, 2, 3));
        Assertions.assertDoesNotThrow(() -> finalList.add(4));
        Assertions.assertThrows(UnsupportedOperationException.class, () -> unmodifiableList.add(4));
    }

}