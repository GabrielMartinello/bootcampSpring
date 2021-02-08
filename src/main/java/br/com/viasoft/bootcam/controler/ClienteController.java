package br.com.viasoft.bootcam.controler;

import br.com.viasoft.bootcam.model.Cliente;
import br.com.viasoft.bootcam.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/cliente")
    public String getCliente(Model model) {

        List<Cliente> listaCliente = clienteRepository.findAll();
        model.addAttribute("lista", listaCliente);

        return "cliente";

    }
}
