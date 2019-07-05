package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.br.CPF;

import com.sun.istack.internal.NotNull;

/**
 * 
 * Classe que representa o paciente que será internado.
 * 
 * @author Vinícius Araújo
 * @Entity -> Informa ao JSF que é uma ENTIDADE (e criar uma tabela no banco de
 *         dados).
 * 
 */
@Entity
public class Paciente {

	/**
	 * Identificação de cada paciente no banco de dados
	 * 
	 * @SequenceGenerator e @GeneratedValue fazem com que o sistema gere uma
	 *                    numeração sequencial para cada paciente automaticamente.
	 * 
	 */
	@Id
	@SequenceGenerator(name = "CONTADOR_PACIENTES", sequenceName = "NUM_SEQ_PACIENTE", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTADOR_PACIENTES")
	private Integer id;
	
	@NotNull
	private String nomeDoPaciente;
	
	@NotNull
	private Integer idadeDoPaciente;
	
	@NotNull
	@CPF
	private String CPF;
	
	@NotNull
	private Character sexoDoPaciente;
	
	@NotNull
	private Date dataDeInternacao;
	
	public Paciente() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeDoPaciente() {
		return nomeDoPaciente;
	}

	public void setNomeDoPaciente(String nomeDoPaciente) {
		this.nomeDoPaciente = nomeDoPaciente;
	}

	public Integer getIdadeDoPaciente() {
		return idadeDoPaciente;
	}

	public void setIdadeDoPaciente(Integer idadeDoPaciente) {
		this.idadeDoPaciente = idadeDoPaciente;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public Character getSexoDoPaciente() {
		return sexoDoPaciente;
	}

	public void setSexoDoPaciente(Character sexoDoPaciente) {
		this.sexoDoPaciente = sexoDoPaciente;
	}

	public Date getDataDeInternacao() {
		return dataDeInternacao;
	}

	public void setDataDeInternacao(Date dataDeInternacao) {
		this.dataDeInternacao = dataDeInternacao;
	}
	
	public String getQualOSexo() {
		if (this.sexoDoPaciente == 'M') {
			return "Masculino";
		} else {
			return "Feminino";
		}
	}
	
}
