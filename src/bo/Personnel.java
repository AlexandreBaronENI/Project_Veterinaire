package bo;

public class Personnel {

	private int codePers;
	private String nom, motPasse, role;
	private boolean archive;

	public final static String SECRETAIRE = "sec";
	public final static String VETERINAIRE = "vet";
	public final static String ADMIN = "adm";
	
	public Personnel(int codePers, String nom, String motPasse, String role, boolean archive) {
		super();
		this.codePers = codePers;
		this.nom = nom;
		this.motPasse = motPasse;
		this.role = role;
		this.archive = archive;
	}
	public Personnel() {
	}
	public int getCodePers() {
		return codePers;
	}
	public void setCodePers(int codePers) {
		this.codePers = codePers;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isArchive() {
		return archive;
	}
	public void setArchive(boolean archive) {
		this.archive = archive;
	}
	@Override
	public String toString() {
		return "Personnel [codePers=" + codePers + ", nom=" + nom + ", motPasse=" + motPasse + ", role=" + role
				+ ", archive=" + archive + "]";
	}
}
