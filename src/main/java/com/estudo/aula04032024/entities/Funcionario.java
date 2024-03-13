package com.estudo.aula04032024.entities;

public class Funcionario {
	
	private Long id;
	private String nomeCompleto;
	private String matricula;
	//private Long id_departamento;
	private Departamento departamento = new Departamento();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	/*public Long getId_departamento() {
		return id_departamento;
	}
	public void setId_departamento(Long id_departamento) {
		this.id_departamento = id_departamento;
	}*/
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	@Override
	public String toString() {
		return "id=" + id + "\n, nomeCompleto=" + nomeCompleto + "\n, matricula=" + matricula
				+ "\n, id_departamento=" + departamento.getId() + "]";
	}
	

}
