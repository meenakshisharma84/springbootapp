import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.example.myapp.service.ResourceNotFoundException; // Adjust if in a different package


@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooksByAuthor(Long authorId) {
        return bookRepository.findByAuthor_Id(authorId);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        book.setTitle(bookDetails.getTitle());
        return bookRepository.save(book);
    }
}
