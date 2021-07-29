package generation.mx.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import generation.mx.models.UserModel;
import generation.mx.repositories.UserRepository;

@Service
public class UserService {

	@Autowired //Prepara toda la parte de la inicialización del objeto, lo cual se hace tradicionalmente con new UserRepository, pero esto lo facilita
	UserRepository userRepository; //Invocamos la interface del Repository y luego creamos un objeto
	
	//Creamos métodos que tienen interacción con mi base de datos
	public ArrayList<UserModel> getUsers() { //ArrayList es el tipo de dato que me devolverá, en este caso una lista de objetos de UserModel
		return (ArrayList<UserModel>) userRepository.findAll();
		
		//Hacemos el return. UserRepository hará todas las interacciones que tienen que ver con base de datos y como heredamos ya hay algunos métodos heredados. 
		//Usando findAll nos traerá todos los usuarios. El ArrayList traerá los datos como UserModel, por eso se hizo el casteo (lo que está entre paréntesis).
		
		}
	public UserModel saveUser(UserModel user){
		String name = user.getName();
		String surname = user.getSurname();
		String email = user.getEmail();
		
		//Se declaran variables name, surname, email y obtendré los valores que tienen
		
		if (name != null && surname !=null && email != null) {
			return userRepository.save(user);
			
			//Si esos valores no están vacíos voy a devolver los datos
		}
			return user;
			//Pero si están vacíos se devolverá solo el usuario.
	}
	
	public Optional<UserModel> getUserById(Long id) {//Para recibir un solo usuario. Método es de tipo UserModel
		//Optional UserModel sirve para cachar un error que daría 
	return userRepository.findById(id); //Retorna un UserModel. UserRepository hace todo a nivel base de datos.
	}
	
	//Método para borrar.
	public boolean deleteUser(Long id) {
		//Metemos el borrado en TryAndCatch para evitar fallas en el sistema
		try {
			userRepository.deleteById(id);
			return true; 
			//Usará el repositorio para buscar entre los métodos definidos y heredados y habrá uno que me permitirá borrar elementos.
			//Si estp se ejecuta me regrese un true y sino un false.
		} catch (Exception error) {
			return false;
		}

	}
	//Esto se creo para que se pudiera usar el método findByName creado en UserRepository
	public ArrayList<UserModel> getUsersByName(String name){
		return userRepository.findByName(name);
	}
}
