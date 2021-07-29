package generation.mx.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import generation.mx.models.UserModel;
import generation.mx.services.UserService;

@RestController //Es un controller que necesita interactuar con toda la parte de http
@RequestMapping("/user") //Si colocamos la ruta desde aquí será la ruta principal 
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping //Para que se haga un método get para que esos datos viajen ocultos, no encriptados, pero al menos ocultos. No se especifica ruta, entonces toma lo del controlador. 
	public ArrayList<UserModel> getUsers() { 
		return userService.getUsers();
	}
	
	@PostMapping
	public UserModel saveUser(@RequestBody UserModel user) {
		return userService.saveUser(user);
	}
	
	@GetMapping(path = "/{id}") //Recibirá un id para funcionar. Se recibirá por párametros, como se indica en la siguiente línea.
	public Optional<UserModel> getUserById(@PathVariable("id") Long id){
		return userService.getUserById(id);
		//De esta manera se crea una ruta para un usuario específico.
	}
	
	 //Esto proviene del método delete en UserService
	@DeleteMapping(path = "/{id}")
	public String deleteUser(@PathVariable("id")Long id ) {
		//Se declara clase con String pues lo que se retornará será un mensaje
		boolean ok = userService.deleteUser(id);
		//Se declara variable boolean llamada ok y se usa el userService a través del id.
		
		//ok == true es igual a ok
		if (ok) {
			return "Se eliminó el usuario";
		}else {
			return "No se pudo eliminar al usuario"; 
		}
	}
	
	/*Cuando elimino algo, el método no me avisa. Entonces necesitamos saber si se hizo o no
	 y por eso creamos un método booleano para saber si la acción fue true o false.
	 Intenta borrar el elemento y si se ejecuta de manera normal, devuelve un true
	 sino, devuelve un false. 
	 DeleteMapping me traerá un id. 
	 Al ejecutar el método UserService tendremos un true o false y se retornen los 
	 mensajes necesarios. 
	 El try ayudará por si se quiere eliminar un elemento que ya fue borrado o que 
	 no existe. 
	*/

	//Proviene del finByName de UserService
	@GetMapping("/query")
	public ArrayList<UserModel> getUsersByName(@RequestParam(value = "name", defaultValue = "") String name){
		return userService.getUsersByName(name);
		
	/*Obtengo por el método ger la siguiente dirección users/query 
	 Obtendré poarámetros por la url -RequestParam- cuáles párametros: name
	 lo que se obtenga de Re	uest Param se guarda en una variable del tipo string
	 Lo que se retorna es del userService getByName, el método en esa clase y le pasamos el nombre. 
	 De esa manera se recibe un párametro a través de URl y a partir de ello se hace una búsqueda*/
	}
}