package br.com.karanalpe.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.karanalpe.model.Tarefa;
import br.com.karanalpe.service.TarefaService;
import br.com.karanalpe.util.FacesUtil;

@Named
@ViewScoped
public class ListaTarefaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TarefaService tarefaService;

	private List<Tarefa> tarefas = new ArrayList<>();

	private List<Tarefa> tarefaSelecionadas = new ArrayList<>();

	@PostConstruct
	public void inicializar() {
		tarefas = tarefaService.listAll();
	}

	public void excluirSelecionados() {
		for (Tarefa tarefa : tarefaSelecionadas) {
			tarefaService.excluir(tarefa);
			tarefas.remove(tarefa);
		}

		FacesUtil.addInfoMessage("Tarefa(s) exclu�da(s) com sucesso!");
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public List<Tarefa> getTarefaSelecionadas() {
		return tarefaSelecionadas;
	}

	public void setTarefaSelecionadas(List<Tarefa> tarefaSelecionadas) {
		this.tarefaSelecionadas = tarefaSelecionadas;
	}

}