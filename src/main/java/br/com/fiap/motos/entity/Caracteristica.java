package br.com.fiap.motos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_CARACTERISTICA", uniqueConstraints = {
        @UniqueConstraint(name = "UK_CARACTERISTICA_NOME_VEICULO", columnNames = { "NM_CARACTERISTICA", "VEICULO_ID" })
})
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARACTERISTICA_ID")
    private Long id;

    @Column(name = "NM_CARACTERISTICA", length = 30)
    private String nome;

    @Column(name = "DESC_CARACTERISTICA", length = 20)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "VEICULO_ID")
    private Veiculo veiculo;

}
