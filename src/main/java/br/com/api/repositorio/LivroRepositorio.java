package br.com.api.repositorio;

import br.com.api.entidade.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepositorio extends JpaRepository<Livro,Long> {
}
