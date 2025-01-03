package com.ToDoList.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ToDoList.api.Dto.tarefaDto;
import com.ToDoList.api.enums.StatusTarefa;
import com.ToDoList.api.model.Tarefa;
import com.ToDoList.api.repositories.TarefaRepository;

@RestController
@RequestMapping("/tarefas")
public class tarefaController {
	
	@Autowired
	TarefaRepository repository;
	
	@GetMapping
	public ResponseEntity getAll() {
		List<Tarefa> tarefas = repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(tarefas);
		
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity Addtarefa(@RequestBody tarefaDto dto) {
		var tarefa = new Tarefa();
		tarefa.setStatus(StatusTarefa.PENDENTE);	
		BeanUtils.copyProperties(dto, tarefa);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tarefa));
	}
	
	@PutMapping("/atualizarstatus/{id}")
	public ResponseEntity atualizarStatus(@PathVariable(value = "id") Integer id, @RequestBody tarefaDto dto) {
		Optional<Tarefa> tarefa = repository.findById(id);
		if(tarefa.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("tarefa não encontrada!");
		}
		var tarefaModel = tarefa.get();
		tarefaModel.setStatus(StatusTarefa.CONCLUIDO);
		BeanUtils.copyProperties(dto, tarefaModel);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tarefaModel));
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity atualizarTarefa(@PathVariable(value = "id") Integer id, @RequestBody tarefaDto dto) {
		Optional<Tarefa> tarefa = repository.findById(id);
		if(tarefa.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("tarefa não encontrada!");
		}
		var tarefaModel = tarefa.get();
		BeanUtils.copyProperties(dto, tarefaModel);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tarefaModel));
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity apagarTarefa(@PathVariable(value = "id") Integer id) {
		Optional<Tarefa> tarefa = repository.findById(id);
		if(tarefa.isEmpty()) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada!");
		}
		repository.delete(tarefa.get());
		return ResponseEntity.status(HttpStatus.OK).body("tarefa deletada com sucesso!");
		
	}

}

