package br.com.karanalpe.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.karanalpe.exception.NegocioException;
import br.com.karanalpe.model.Tarefa;

public class TarefaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Tarefa salvar(Tarefa tarefa) {
		return manager.merge(tarefa);
	}

	public void excluir(Tarefa tarefa) {
		try {
			tarefa = porId(tarefa.getId());
			manager.remove(tarefa);
			manager.flush();

		} catch (Exception e) {
			throw new NegocioException("Tarefa N�o pode ser exclu�da");
		}
	}

	public Tarefa porId(Long id) {
		return manager.find(Tarefa.class, id);
	}

	public List<Tarefa> listAll() {
		return manager.createNativeQuery("select * from tarefa", Tarefa.class).getResultList();
	}
}
