package br.com.movielist.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "import_file_control")
public class ImportFileControl {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "hash_code", nullable = false, length = 64)
	private String hashCode;

	@Column(name = "import_date")
	private LocalDateTime importDate;
	
	public ImportFileControl() {
		
	}

	public ImportFileControl(String hashCode, LocalDateTime importDate) {
		this.hashCode = hashCode;
		this.importDate = importDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public LocalDateTime getImportDate() {
		return importDate;
	}

	public void setImportDate(LocalDateTime importDate) {
		this.importDate = importDate;
	}
	
}
