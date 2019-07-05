package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Paciente;

/**
 * Classe de serviços para o {@link Paciente}.
 * 
 * @author Vinícius Henrique Santos Araújo
 *
 */
@Stateless
public class ServicePaciente {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Método que cadastra um novo paciente no banco de dados.
	 * 
	 * @param paciente: paciente a ser cadastrado
	 * @throws Exception - Caso já tenha algum paciente cadastrado com o mesmo CPF.
	 */
	public void cadastrarPaciente(Paciente paciente) throws Exception {

		List<Paciente> pacientesCPF = listarPacientesPorCPF(paciente);
		if (pacientesCPF.isEmpty()) {
			this.em.persist(paciente);
		} else {
			throw new Exception("Já existe um paciente cadastrado com esse CPF");
		}
	}

	/**
	 * Método que lista os clientes cadastrados no banco de dados.
	 * 
	 * @return uma lista com todos os pacientes.
	 */
	public List<Paciente> listarPacientes() {
		return this.em.createQuery("SELECT p FROM Paciente p", Paciente.class).getResultList();
	}

	public void excluirPaciente(Paciente paciente) {
		this.em.remove(this.em.merge(paciente));
	}

	/**
	 * Método que busca um paciente pelo seu CPF.
	 * @param paciente
	 * @return
	 */
	public List<Paciente> listarPacientesPorCPF(Paciente paciente) {
		return this.em.createQuery("SELECT p FROM Paciente p where p.CPF=:p1", Paciente.class)
				.setParameter("p1", paciente.getCPF()).getResultList();
	}

}
