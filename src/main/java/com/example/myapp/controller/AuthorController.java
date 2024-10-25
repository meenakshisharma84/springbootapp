import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import com.example.myapp.service.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "author-list";  // Renders the JSP page "author-list.jsp"
    }

    @GetMapping("/authors/new")
    public String showCreateForm(Model model) {
        model.addAttribute("author", new Author());
        return "author-form";  // Renders the form to create a new author
    }

    @PostMapping("/authors")
    public String createAuthor(@ModelAttribute("author") Author author) {
        authorService.createAuthor(author);
        return "redirect:/authors";  // Redirect to the list of authors
    }

    @GetMapping("/authors/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long authorId, Model model) {
        Author author = null; // Ensure initialization
        author = authorService.findById(authorId); // Example assignment
        if (author == null) {
        // Handle the case where the author is not found, if necessary
        }
        

        // Author author = authorService.updateAuthor(id, author);
        model.addAttribute("author", author);
        return "author-form";  // Pre-filled form for updating the author
    }

    @PostMapping("/authors/update/{id}")
    public String updateAuthor(@PathVariable("id") Long id, @ModelAttribute("author") Author author) {
        authorService.updateAuthor(id, author);
        return "redirect:/authors";
    }
}
