package br.com.karanalpe.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.karanalpe.dao.TarefaDAO;
import br.com.karanalpe.model.Tarefa;
import br.com.karanalpe.util.Transacional;

public class TarefaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TarefaDAO tarefaDao;

	@Transacional
	public void salvar(Tarefa tarefa) {
		if (tarefa.isInclusao()) {
			tarefa.setCriacao(new Date());
		}

		if (tarefa.isEdicao()) {
			tarefa.setEdicao(new Date());
		}

		tarefaDao.salvar(tarefa);
	}

	@Transacional
	public void excluir(Tarefa tarefa) {
		tarefaDao.excluir(tarefa);
	}

	public List<Tarefa> listAll() {
		return tarefaDao.listAll();
	}

	public Tarefa porId(Long id) {
		return tarefaDao.porId(id);
	}
}
