package br.com.viasoft.bootcam.controler;

import br.com.viasoft.bootcam.dto.ProdutoFormularioDTO;
import br.com.viasoft.bootcam.model.Produto;
import br.com.viasoft.bootcam.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;
    @GetMapping("/produto/novo")
    public String getProduto(ProdutoFormularioDTO produtoFormularioDTO, Model model) {
        var produto = new Produto();
        model.addAttribute("produto", produto);
        return "produto/formularioproduto";
    }

    @PostMapping("/produto/salvar")
    public String formProduto(@Valid ProdutoFormularioDTO produtoDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "produto/formularioproduto";
        }

        Produto produto = produtoDTO.toProduto();
        produtoRepository.save(produto);
        return "produto/formularioproduto";
    }
}
