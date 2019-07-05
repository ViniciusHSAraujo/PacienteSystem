package web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import entities.Paciente;
import services.ServicePaciente;
import util.JSFUtils;

@RequestScoped
@Named
public class PacienteBean {

	private Paciente paciente;

	/**
	 * @EJB Injeta o ServicePaciente no PacienteBeam
	 */
	@EJB
	private ServicePaciente servicePaciente;

	public PacienteBean() {
		this.paciente = new Paciente();
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void cadastrarPaciente() {
		try {
			this.servicePaciente.cadastrarPaciente(paciente);
			JSFUtils.enviarMensagemDeTexto("Paciente cadastrado com sucesso!");
			this.paciente = new Paciente();
		} catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}
	}

	public void excluirPaciente(Paciente paciente) {
			this.servicePaciente.excluirPaciente(paciente);
			JSFUtils.enviarMensagemDeTexto("Paciente excluído com sucesso.");
	}
	
	public List<Paciente> listarPacientes(){
		return this.servicePaciente.listarPacientes();
	}
}
