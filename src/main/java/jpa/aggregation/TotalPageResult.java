package jpa.aggregation;

public class TotalPageResult {
	
	private String auteur;
	private Long totalPages;
	
	public TotalPageResult(String auteur, Long totalPages) {
		super();
		this.auteur = auteur;
		this.totalPages = totalPages;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}
	
	
}
