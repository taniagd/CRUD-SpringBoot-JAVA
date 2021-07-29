package generation.mx.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import generation.mx.models.PostModel;

@Repository
public interface PostRepository extends CrudRepository<PostModel, Long>{

	public abstract ArrayList <PostModel> findBytitleContaining(String title);  //Como esto es una interface, los métodos deben ser públicos y abstractos
	
	//Buwsca por título y ordenalos de manera descendente. Los parámetros se agregan en Post Service, línea 37 y 38
	public abstract ArrayList<PostModel> findByTitleContainingOrderByIdDesc(String title);
	
}

