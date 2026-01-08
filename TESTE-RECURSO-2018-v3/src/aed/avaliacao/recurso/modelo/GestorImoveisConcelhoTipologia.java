package aed.avaliacao.recurso.modelo;

import java.io.Serializable;
import java.util.Objects;

public class GestorImoveisConcelhoTipologia implements Serializable {
	private static final long serialVersionUID = 1L;

	private String tipologia;
	private Integer totalImoveis;
	private Float media;
	private Double totalPreco;

	public GestorImoveisConcelhoTipologia(String tipologia) {
		this.tipologia = tipologia;
		this.totalImoveis = 0;
		this.media = 0F;
		this.totalPreco = 0.0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GestorImoveisConcelhoTipologia obj = (GestorImoveisConcelhoTipologia) o;
		return Objects.equals(tipologia, obj.tipologia);
	}

	@Override
	public int hashCode () {
		return Objects.hash(tipologia);
	}

	@Override
	public String toString() {
		return " (" + tipologia + ", " + totalImoveis + ", " + media + ", " + totalPreco + ")";
	}

	public String getTipologia() {
		return tipologia;
	}

	public Integer getTotalImoveis() {
		return totalImoveis;
	}

	public Float getMedia() {
		return media;
	}

	public Double getTotalPreco() {
		return totalPreco;
	}

	public void inserir(Imovel imovel) {
		totalImoveis++;
		totalPreco+= imovel.getPreco();
		media=(float)(totalPreco/totalImoveis);
	}
}