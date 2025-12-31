package aed.avaliacao.recurso.modelo;

import java.io.Serializable;
import java.util.Objects;

public class GestorImoveisMediaTipologia implements Serializable {
	private static final long serialVersionUID = 1L;

	private String tipologia;
	private Integer numeroImoveis;
	private Double media;
	private Double precoTotal;

	public GestorImoveisMediaTipologia(String tipologia) {
		this.tipologia = tipologia;
		this.numeroImoveis = 0;
		this.media = 0.0;
		this.precoTotal = 0.0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GestorImoveisMediaTipologia obj = (GestorImoveisMediaTipologia) o;
		return Objects.equals(tipologia, obj.tipologia);
	}

	@Override
	public int hashCode () {
		return Objects.hash(tipologia);
	}

	@Override
	public String toString() {
		return " (" + tipologia + ", " + numeroImoveis + ", " + media + ", " + precoTotal + ")";
	}

	public double getMedia() {
		return media;
	}

	public void inserir(Imovel imovel){
		numeroImoveis++;
		precoTotal+=imovel.getPreco();
		media=precoTotal/numeroImoveis;
	}
}