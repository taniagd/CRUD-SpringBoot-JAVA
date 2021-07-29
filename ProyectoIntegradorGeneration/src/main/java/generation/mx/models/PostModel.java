package generation.mx.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "posts")
public class PostModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (nullable = false)
	private long id;
	
	@Column(nullable = false, length = 200)
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@ManyToOne //Relación muchos a uno de la clase UserModel user.
	@JsonBackReference //Con esto se le dice que omita algunos datos, ´pues es la consulta secundaria
	private UserModel user;	
	//También se puede usar @JsonIgnore en lugar de JsonBackReference. Es uno o el otro.
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}


}
