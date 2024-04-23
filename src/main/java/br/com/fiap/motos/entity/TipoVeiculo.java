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
@Table(name = "TB_TIPOVEICULO",
        uniqueConstraints = {
            @UniqueConstraint(
                name = "UK_VEICULO_TIPO", columnNames = {"NM_TIPOVEICULO", "NM_VEICULO"}
            )
        })
public class TipoVeiculo {

    @Id
    //veri
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NM_TIPOVEICULO")
    private String nome;
}
