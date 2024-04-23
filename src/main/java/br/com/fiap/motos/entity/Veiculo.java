package br.com.fiap.motos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor



@Entity
///Pensar melhor sobre depois
@Table(name = "TB_VEICULO")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VEICULO")
    @SequenceGenerator(name = "SQ_VEICULO", sequenceName = "SQ_VEICULO", allocationSize = 1)
    @Column(name = "veiculo_id")
    private Long id;

    @Column(name = "NM_VEICULO")
    private String nome;

    @Column(name = "ANO_F_VEICULO")
    private Year anoDeFabricacao;

    @Column(name = "COR_VEICULO")
    private String cor;

    @Column(name = "PRECO_VEICULO")
    private Double preco;

    @Column(name = "CC_VEICULO")
    private Short cilindradas;

    @Column(name = "MODELO_VEICULO")
    private String modelo;

    @Column(name = "PALAVRA_EFEITO_VEICULO", length = 15 )
    private String palavraDeEfeito;

    @JoinColumn(
        name = "FABRICANTE",
        referencedColumnName = "ID_FABRICANTE",
        foreignKey = @ForeignKey(name="FK_VEICULO_FABRICANTE"),
        nullable = false
    )
    private Fabricante fabricante;

    //finalizar com o resto da tabela   
    @ManyToOne
    private TipoVeiculo tipo;

    @ManyToMany
    @JoinTable(
        name = "TB_VEICULO_ACESSORIO",
        joinColumns = @JoinColumn(name = "veiculo_id"),
        inverseJoinColumns = @JoinColumn(name = "acessorio_id")
    )
    private Set<Acessorio> acessorios = new LinkedHashSet<>();

}
