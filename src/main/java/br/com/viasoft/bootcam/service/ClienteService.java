package br.com.viasoft.bootcam.service;

import br.com.viasoft.bootcam.model.Cliente;
import framework.CrudServiceImpl;

import java.util.List;

public interface ClienteService extends CrudServiceImpl<Cliente, Long> {
    List<Cliente> findAllByNome(String nome);
}
