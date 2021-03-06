package br.com.viasoft.bootcam.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Produto implements Comparable<Produto> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nome;
    private String autor;
    @Column(length = 1024)
    private String imagem;

    @Override
    public int compareTo(Produto o) {
        return nome.compareTo(o.nome);
    }
}




