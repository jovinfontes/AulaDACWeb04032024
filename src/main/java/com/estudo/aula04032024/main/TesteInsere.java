package com.estudo.aula04032024.main;

import java.util.List;

import com.estudo.aula04032024.dao.DepartamentoDao;
import com.estudo.aula04032024.dao.FuncionarioDao;
import com.estudo.aula04032024.entities.Departamento;
import com.estudo.aula04032024.entities.Funcionario;

public class TesteInsere {

	public static void main(String[] args) throws ClassNotFoundException {
		// pronto para gravar
		//Departamento departamento = new Departamento();
		//departamento.setNomeDepartamento("Administração");*/

		// grave nessa conexão!!!
		DepartamentoDao depDao = new DepartamentoDao();
        
		Departamento dep = depDao.byId(1L);
		// método elegante
		//depDao.insereDepartamento(departamento);
		
		/*Funcionario funcionario = new Funcionario();
		funcionario.setNomeCompleto("Roberto Eduardo Gonçalves");
		funcionario.setMatricula("123.479-FF");
		funcionario.getDepartamento().setId(dep.getId());
		*/
		FuncionarioDao funDao = new FuncionarioDao();
		//funDao.insereFUncionario(funcionario);

		//System.out.println("Gravado!");
		
		//Funcionario funcionario = funDao.byId(2L);
		/*if (funcionario == null) {
			System.out.println("Registro não encontrado: ");
		}
		System.out.println("Código: " + funcionario.getId());
		System.out.println("Nome Completo: " + funcionario.getNomeCompleto());
		System.out.println("Matrícula: " + funcionario.getMatricula());*/
		
		
		/*List<Funcionario> funcionarios = funDao.all();
		
		for (Funcionario f: funcionarios) {
			/*System.out.println();
			System.out.println("Código: " + f.getId());
			System.out.println("Nome Completo: " + f.getNomeCompleto());
			System.out.println("Matrícula: " + f.getMatricula());
			System.out.println();
			System.out.println(f.toString());
		}*/
		
		Funcionario funcionario = funDao.buscarFuncComDepartamento(2L);
		System.out.println("Nome Completo: " + funcionario.getNomeCompleto());
		System.out.println("Matrícula: " + funcionario.getMatricula());
		System.out.println("Departamento: " + funcionario.getDepartamento().getNomeDepartamento());
        
	}

}
