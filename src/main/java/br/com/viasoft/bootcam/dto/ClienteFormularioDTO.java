package br.com.viasoft.bootcam.dto;


import br.com.viasoft.bootcam.model.Cliente;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor

public class ClienteFormularioDTO {
    private Long id;
    @NotEmpty(message = "Amigo, o nome nao pode ser nulo meu parceiro")
    private String nome;
    private String cpf;
    @NotEmpty(message = "Cuuomo assim voce naum tem uno emaaiil???????")
    private String email;

    public Cliente toCliente(){
        Cliente cliente = new Cliente();
        cliente.setNome(this.nome);
        cliente.setCpf(this.cpf);
        cliente.setEmail(this.email);
        return cliente;
    }

    public ClienteFormularioDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
    }

}
