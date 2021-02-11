package br.com.viasoft.bootcam.service;

import br.com.viasoft.bootcam.event.ClientePresave;
import br.com.viasoft.bootcam.model.Cliente;
import br.com.viasoft.bootcam.model.Produto;
import br.com.viasoft.bootcam.repository.ClienteRepository;
import framework.CrudServiceLmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class ClienteServicelmpl extends CrudServiceLmpl<Cliente, Long> implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        List<Cliente> result = getRepository().findAll();
        Collections.sort(result);
        return result;
    }

    @Override
    public List<Cliente> findAllByNome(String nome) {
        return clienteRepository.findByNomeContainsIgnoreCase(nome);
    }

    @Override
    public JpaRepository<Cliente, Long> getRepository() {
        return clienteRepository;
    }

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @Override
    public void preSave(Cliente cliente) {
        System.out.println("Passei por aqui e o id foi nulo >:(");
    }

    @Override
    public void postSave(Cliente cliente) {
        applicationEventPublisher.publishEvent(new ClientePresave(this,cliente));

        System.out.println(String.format("Passei pelo post save, o id é %d  ", cliente.getId()));
    }
}
