package michelavivacqua.w6d31044.controllers;

import michelavivacqua.w6d31044.entities.Autore;
import michelavivacqua.w6d31044.services.AutoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

 @RestController
    @RequestMapping("/authors")
    public class AutoriController {
        @Autowired
        private AutoriService autoriService;

        // 1. GET http://localhost:3001/authors (ritorna la lista di autori)
        @GetMapping
        private List<Autore> getAllAutori(){
            return this.autoriService.getAutoriList();
        }



        // 2. GET http://localhost:3001/authors/{{authorId}} (ritorna un singolo autore)
        @GetMapping("/{authorId}")
        private Autore findAutoreById(@PathVariable int authorId){
            return this.autoriService.findById(authorId);
        }

        // 3. POST http://localhost:3001/authors (+ body) (crea un nuovo autore)
        @PostMapping
        @ResponseStatus(HttpStatus.CREATED) // Status Code 201
        private Autore saveAutore(@RequestBody Autore body){
            return this.autoriService.saveAutore(body);
        }

        // 4. PUT http://localhost:3001/authors/{{authorId}} (+ body) (modifica lo specifico autore)
        @PutMapping("/{authorId}")
        private Autore findByIdAndUpdate(@PathVariable int authorId, @RequestBody Autore body){
            return this.autoriService.findByIdAndUpdate(authorId, body);
        }



     // 5. DELETE http://localhost:3001/authors/{authorId} (cancella lo specifico autore)
     @DeleteMapping("/{authorId}")
     @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204
     public void deleteAutoreById(@PathVariable int authorId) {
         this.autoriService.findByIdAndDelete(authorId);
     }
    }

