package mk.finki.ukim.mk.lab1.web;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.finki.ukim.mk.lab1.model.Book;
import mk.finki.ukim.mk.lab1.model.dto.BookDto;
import mk.finki.ukim.mk.lab1.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name="Book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
//
//    @Operation(
//            description = "Get endpoint for book",
//            summary = "This is a summary for book get endpoint",
//            responses = {
//                    @ApiResponse(
//                            description = "Success",
//                            responseCode = "200"
//                    ),
//                    @ApiResponse(
//                            description = "Unauthorized",
//                            responseCode = "403"
//                    )
//            }
//    )
    @GetMapping
    public List<Book> findAll() {
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        return this.bookService.save(bookDto)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return this.bookService.update(id, bookDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (this.bookService.findById(id).isPresent()) {
            this.bookService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/rent/{id}")
    public ResponseEntity<Void> rented(@PathVariable Long id) {
        if (this.bookService.findById(id).isPresent()) {
            this.bookService.rented(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
