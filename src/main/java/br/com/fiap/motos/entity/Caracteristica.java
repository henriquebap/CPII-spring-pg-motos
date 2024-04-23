package br.com.fiap.motos.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
@Table(name = "TB_CARACTERISTICA",
        uniqueConstraints = { 
            @UniqueConstraint(
                name = "UK_CARACTERISTICA_NOME",columnNames = {"NM_CARACTERISTICA", "NM_VEICULO"}
        )
    }
    )
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = )
    private Long id;

    //30 digitos
    private String nome;

    //20 digitos
    private String descricao;

    private Veiculo veiculo;


}
