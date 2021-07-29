package generation.mx.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity //Quiere decir que es una entidad que interactuará con la base de datos
@Table(name = "users") //Nombre que la tabla tomará en la base de datos
public class UserModel {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // En lugar de que la base de datos asigne el id, se genere desde Java y se utilizará la estrategia Identity.
	@Column(nullable = false) //Este valor no puede ser nulo.
	private long id;
	
	@Column(nullable = false, length = 100, name = "name") //El valor no debe ser nulo, se podrá ingresar 100 caracteres y name
	private String name;
	
	@Column(nullable = false, length = 100) //Valor no puede ser nulo y se ingresarán 100 caracteres.
	private String surname;
	
	@Column(nullable = false, length = 100, unique = true) //Valor no puede ser nulo, se ingresarán 100 caracteres y el campo será único. 
	private String email;
	
	@OneToMany (targetEntity = PostModel.class, mappedBy = "user")  // Se hace la anotación OneToMany= nombre de la clase. Mapped By indica que la relacion es bidireccional a través del atributo user
	@JsonManagedReference //Esto traerá toda la info que tenga abajo.
	private List<PostModel> posts; //Agregamos esta línea porque es la relación de uno a muchos, pues un usuario puede tener muchas publicaciones Dentro de los <> va el tipo de dato, en este caso PostModel
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List getPosts() {
		return posts;
	}

	public void setPosts(List posts) {
		this.posts = posts;
	}
	
}
