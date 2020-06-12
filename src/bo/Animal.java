package bo;

public class Animal {

	private int codeAnimal, codeClient;
	private String nomAnimal, couleur, race, espece, tatouage, antecedents, sexe;
	private boolean archive;
	
	public Animal(int codeAnimal, int codeClient, String nomAnimal, String sexe, String couleur, String race,
			String espece, String tatouage, String antecedents, boolean archive) {
		this.codeAnimal = codeAnimal;
		this.codeClient = codeClient;
		this.nomAnimal = nomAnimal;
		this.sexe = sexe;
		this.couleur = couleur;
		this.race = race;
		this.espece = espece;
		this.tatouage = tatouage;
		this.antecedents = antecedents;
		this.archive = archive;
	}
	
	public Animal() {
	}

	public int getCodeAnimal() {
		return codeAnimal;
	}
	public int getCodeClient() {
		return codeClient;
	}
	public String getNomAnimal() {
		return nomAnimal;
	}
	public String getSexe() {
		return sexe;
	}
	public String getCouleur() {
		return couleur;
	}
	public String getRace() {
		return race;
	}
	public String getEspece() {
		return espece;
	}
	public String getTatouage() {
		return tatouage;
	}
	public String getAntecedents() {
		return antecedents;
	}
	public boolean isArchive() {
		return archive;
	}
	public void setCodeAnimal(int codeAnimal) {
		this.codeAnimal = codeAnimal;
	}
	public void setCodeClient(int codeClient) {
		this.codeClient = codeClient;
	}
	public void setNomAnimal(String nomAnimal) {
		this.nomAnimal = nomAnimal;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public void setEspece(String espece) {
		this.espece = espece;
	}
	public void setTatouage(String tatouage) {
		this.tatouage = tatouage;
	}
	public void setAntecedents(String antecedents) {
		this.antecedents = antecedents;
	}
	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	@Override
	public String toString() {
		return "Animal [codeAnimal=" + codeAnimal + ", codeClient=" + codeClient + ", nomAnimal=" + nomAnimal
				+ ", sexe=" + sexe + ", couleur=" + couleur + ", race=" + race + ", espece=" + espece + ", tatouage="
				+ tatouage + ", antecedents=" + antecedents + ", archive=" + archive + "]";
	}
}
