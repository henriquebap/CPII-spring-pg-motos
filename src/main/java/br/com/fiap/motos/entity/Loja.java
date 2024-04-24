package br.com.fiap.motos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_LOJA")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_LOJA")
    @SequenceGenerator(name = "SQ_LOJA", sequenceName = "SQ_LOJA", allocationSize = 1)
    @Column(name = "ID_LOJA")
    private Long id;

    @Column(name = "NOME_LOJA")
    private String nome;

    @ManyToMany
    @JoinTable(name = "TB_LOJA_VEICULO", joinColumns = @JoinColumn(name = "ID_LOJA"), inverseJoinColumns = @JoinColumn(name = "VEICULO_ID"))
    @Builder.Default
    private Set<Veiculo> veiculosComercializados = new LinkedHashSet<>();

}
