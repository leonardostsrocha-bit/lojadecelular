package projeto.lojadecelular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.lojadecelular.model.celular;

public interface lojar extends JpaRepository<celular, Long> {
}