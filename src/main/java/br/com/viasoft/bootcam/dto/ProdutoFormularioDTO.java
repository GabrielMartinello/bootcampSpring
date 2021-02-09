package br.com.viasoft.bootcam.dto;

import br.com.viasoft.bootcam.model.Produto;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data

public class ProdutoFormularioDTO {
    @NotEmpty
    private String nome;
    @NotEmpty
    private String autor;
    private String imagem;

    public Produto toProduto() {
        Produto produto = new Produto();
        produto.setNome(this.nome);
        produto.setAutor(this.autor);
        produto.setImagem(this.imagem);

        return produto;
    }
}


