package nat.consultores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nat.consultores.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}

