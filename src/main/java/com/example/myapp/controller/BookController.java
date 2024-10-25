import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.myapp.service.ResourceNotFoundException;





@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String listBooks(Model model, @RequestParam("authorId") Long authorId) {
        model.addAttribute("books", bookService.getBooksByAuthor(authorId));
        return "book-list";  // Renders the JSP page "book-list.jsp"
    }

    @GetMapping("/books/new")
    public String showCreateBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book-form";
    }

    @PostMapping("/books")
    public String createBook(@ModelAttribute("book") Book book) {
        bookService.createBook(book);
        return "redirect:/books";  // Redirect to the list of books
    }
}
