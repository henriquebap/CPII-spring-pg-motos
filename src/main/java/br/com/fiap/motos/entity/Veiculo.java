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
import jakarta.persistence.FetchType;
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
@Table(name = "TB_VEICULO")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VEICULO")
    @SequenceGenerator(name = "SQ_VEICULO", sequenceName = "SQ_VEICULO", allocationSize = 1)
    @Column(name = "VEICULO_ID")
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

    @Column(name = "PALAVRA_EFEITO_VEICULO", length = 15)
    private String palavraDeEfeito;

    @ManyToOne
    @JoinColumn(name = "FABRICANTE_ID", referencedColumnName = "ID_FABRICANTE", foreignKey = @ForeignKey(name = "FK_VEICULO_FABRICANTE"), nullable = false)
    private Fabricante fabricante;

    @ManyToOne
    @JoinColumn(name = "TIPO_VEICULO_ID", foreignKey = @ForeignKey(name = "FK_VEICULO_TIPO_VEICULO"))
    private TipoVeiculo tipo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TB_VEICULO_ACESSORIO", joinColumns = @JoinColumn(name = "VEICULO_ID"), inverseJoinColumns = @JoinColumn(name = "ACESSORIO_ID"))
    @Builder.Default
    private Set<Acessorio> acessorios = new LinkedHashSet<>();

}
