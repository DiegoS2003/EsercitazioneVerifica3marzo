
public class Studente {
	private String nome;
	private String cognome;
	private String classe;
	private String path;
	
	public Studente(String nome, String cognome, String classe, String path) {
		this.nome=nome;
		this.cognome=cognome;
		this.classe=classe;
		this.path=path;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
