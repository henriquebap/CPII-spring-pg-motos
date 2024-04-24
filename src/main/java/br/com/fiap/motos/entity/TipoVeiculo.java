package br.com.fiap.motos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "TB_TIPO_VEICULO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_TIPO_VEICULO_NOME", columnNames = { "NM_TIPO_VEICULO" })
})
public class TipoVeiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_VEICULO")
    private Long id;

    @Column(name = "NM_TIPO_VEICULO", length = 50, nullable = false)
    private String nome;

}
