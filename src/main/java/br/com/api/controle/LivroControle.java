package br.com.api.controle;

import br.com.api.entidade.Livro;
import br.com.api.repositorio.LivroRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroControle {

   private final LivroRepositorio livroRepositorio;

    public LivroControle(LivroRepositorio livroRepositorio) {
        this.livroRepositorio = livroRepositorio;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Livro salvarLivro(@RequestBody Livro livro){
        return livroRepositorio.save(livro);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Livro>buscarLivros(){
        return livroRepositorio.findAll();
    }
    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id){
        return livroRepositorio.findById(id).get();

    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Long id,@RequestBody Livro livro){
        livro.setId(id);
        return livroRepositorio.save(livro);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void excluirLivro(@PathVariable Long id){
        livroRepositorio.deleteById(id);
    }
}
