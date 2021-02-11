package br.com.viasoft.bootcam.repository;

import br.com.viasoft.bootcam.model.Cliente;
import br.com.viasoft.bootcam.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface
ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findAllByNome(String nome);
    List<Cliente> findByNomeContainsIgnoreCase(String nome);
}
