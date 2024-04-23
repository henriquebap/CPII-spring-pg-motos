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
    @JoinColumn(
        name = "VEICULO",
        referencedColumnName = "ID_VEICULO",
        foreignKey = @ForeignKey(name = "FK_LOJA_VEICULO"),
        nullable = false
    )
    private Set<Veiculo> veiculosComercializados = new LinkedHashSet<>();

}
