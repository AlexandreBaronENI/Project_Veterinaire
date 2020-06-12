package bo;
import java.util.Date;

public class Rdv {

	private String dateRdv;
	private int codeAnimal;	
	private int codePersonnel;
	private Personnel veto;
	private Animal animal;
	private Client client;
	public Rdv(String dateRdv, int codeAnimal, int codePersonnel) {
		super();
		this.dateRdv = dateRdv;
		this.codeAnimal = codeAnimal;
		this.codePersonnel = codePersonnel;
	}
	public String getDateRdv() {
		return dateRdv;
	}
	public void setDateRdv(String dateRdv) {
		this.dateRdv = dateRdv;
	}
	public int getCodeAnimal() {
		return codeAnimal;
	}
	public void setCodeAnimal(int codeAnimal) {
		this.codeAnimal = codeAnimal;
	}
	public int getCodePersonnel() {
		return codePersonnel;
	}
	public void setCodePersonnel(int codePersonnel) {
		this.codePersonnel = codePersonnel;
	}
	public Personnel getVeto() {
		return veto;
	}
	public void setVeto(Personnel veto) {
		this.veto = veto;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "Rdv [dateRdv=" + dateRdv + ", codeAnimal=" + codeAnimal + ", codePersonnel=" + codePersonnel + ", veto="
				+ veto + ", animal=" + animal + ", client=" + client + "]";
	}

}
