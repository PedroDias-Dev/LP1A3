package zoo;

public class Reptil extends Animal implements Alimentavel{
	public Reptil(String nome, int idade, String especie, boolean alimentado, double temperaturaCorporal) {
		super(nome, idade, especie, alimentado);
		this.temperaturaCorporal = temperaturaCorporal;
	}
	
	private double temperaturaCorporal;
	
	@Override
	void emitirSom() {
		System.out.println("ssssssss");
	}

	@Override
	public void alimentar() {
		this.setAlimentado(true);
		System.out.println("reptil alimentada");
	}
}
