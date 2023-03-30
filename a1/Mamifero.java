package zoo;

public class Mamifero extends Animal implements Alimentavel{
	public Mamifero(String nome, int idade, String especie, boolean alimentado, int tempoGestacao) {
		super(nome, idade, especie, alimentado);
		this.tempoGestacao = tempoGestacao;
	}

	private int tempoGestacao;
	
	@Override
	void emitirSom() {
		// TODO Auto-generated method stub
		System.out.println("miau");
	}
	
	@Override
	public void alimentar() {
		this.setAlimentado(true);
		System.out.println("mamifero alimentada");
	}
}
