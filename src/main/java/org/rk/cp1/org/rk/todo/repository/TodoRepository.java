package org.rk.cp1.org.rk.todo.repository;

import org.rk.cp1.org.rk.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}

