package com.ToDoList.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ToDoList.api.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

}
