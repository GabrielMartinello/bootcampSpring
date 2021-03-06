package br.com.viasoft.bootcam.service;

import br.com.viasoft.bootcam.model.Produto;
import br.com.viasoft.bootcam.repository.ProdutoRepository;
import framework.CrudServiceLmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProdutoServiceImpl extends CrudServiceLmpl<Produto, Long> implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public JpaRepository<Produto, Long> getRepository() {
        return produtoRepository;
    }

    @Override
    public List<Produto> findAll() {
        List<Produto> result = getRepository().findAll();
        Collections.sort(result);
        return result;
    }

    @Override
    public List<Produto> findAllByAutor(String autor) {
        return produtoRepository.findByAutorContainsIgnoreCase(autor);
    }

    @Override
    public void preSave(Produto produto) {
        System.out.println("Passei pelo pre save, o id era nulo");
    }

    @Override
    public void postSave(Produto produto) {
        System.out.println(String.format("Passei pelo post save, o id é %d  ", produto.getId()));
    }
}
