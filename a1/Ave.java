package zoo;

public class Ave extends Animal implements Alimentavel {
	public Ave(String nome, int idade, String especie, boolean alimentado, String tipoBico) {
		super(nome, idade, especie, alimentado);
		this.tipoBico = tipoBico;
	}
	
	private String tipoBico;

	@Override
	void emitirSom() {
		System.out.println("piu");
	}

	@Override
	public void alimentar() {
		this.setAlimentado(true);
		System.out.println("ave alimentada");
	}
}
