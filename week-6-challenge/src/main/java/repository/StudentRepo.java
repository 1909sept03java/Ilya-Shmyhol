package repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import model.Student;

public class StudentRepo {

	@RepositoryRestResource(collectionResourceRel = "students", path = "students")
	public interface StudentsRepository extends PagingAndSortingRepository<Student, Long> {

		List<Student> findByName(@Param("name") String name);

	}
}
