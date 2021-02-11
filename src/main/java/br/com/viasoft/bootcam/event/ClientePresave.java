package br.com.viasoft.bootcam.event;

import br.com.viasoft.bootcam.model.Cliente;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class ClientePresave extends ApplicationEvent {
    @Getter
    private Cliente cliente;

    public ClientePresave(Object source, Cliente cliente) {
        super(source);
        this.cliente = cliente;
    }
}
