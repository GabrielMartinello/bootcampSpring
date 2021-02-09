package br.com.viasoft.bootcam.service;

import br.com.viasoft.bootcam.model.Produto;
import framework.CrudServiceImpl;

import java.util.List;

public interface ProdutoService extends CrudServiceImpl<Produto, Long> {
    List<Produto> findAllByAutor(String autor);
}
