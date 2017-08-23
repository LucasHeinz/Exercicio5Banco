package model;

public abstract class EletroEletronicos {

	private Integer codigo;
	private int volume;
	private String marca;
	
	public EletroEletronicos(Integer codigo, int volume, String marca) {
		this.codigo = codigo;
		this.volume = volume;
		this.marca = marca;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
