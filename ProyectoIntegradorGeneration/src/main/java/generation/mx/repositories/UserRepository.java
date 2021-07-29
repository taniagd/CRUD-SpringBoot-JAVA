package generation.mx.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import generation.mx.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> { //Se hereda de la clase Crud repository usando la palabra extends. El primer dato es el Modelo (UserModel) y luego el tipo de dato que es Long, salió del id pues es el tipo de dato utilizado. 

	public abstract ArrayList<UserModel> findByName(String name); //Se crea un método publico y abstracto, llamadado findByName es para buscar usuarios por nombre. 
	
	
	
}
