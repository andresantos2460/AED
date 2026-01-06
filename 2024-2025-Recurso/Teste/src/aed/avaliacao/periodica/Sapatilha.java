package aed.avaliacao.periodica;

import java.io.Serializable;
import java.util.Objects;

public class Sapatilha implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer tamanho;
	private String marca;
	private String cor;
	private Integer stock;

	public Sapatilha(String marca,String cor,Integer tamanho,Integer stock) {
		this.tamanho = tamanho;
		this.marca = marca;
		this.cor = cor;
		this.stock = stock;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Sapatilha obj = (Sapatilha) o;
		return Objects.equals(tamanho, obj.tamanho) && Objects.equals(marca, obj.marca) && Objects.equals(cor, obj.cor) && Objects.equals(stock, obj.stock);
	}

	@Override
	public int hashCode () {
		return Objects.hash(tamanho, marca, cor, stock);
	}

	@Override
	public String toString() {
		return " (" + tamanho + ", " + marca + ", " + cor + ", " + stock + ")";
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public String getMarca() {
		return marca;
	}

	public String getCor() {
		return cor;
	}

	public Integer getStock() {
		return stock;
	}
}