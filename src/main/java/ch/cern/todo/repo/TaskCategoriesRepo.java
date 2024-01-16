package ch.cern.todo.repo;

import ch.cern.todo.model.TaskCategories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCategoriesRepo extends CrudRepository<TaskCategories,Integer> {
}
