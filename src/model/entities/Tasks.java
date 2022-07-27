package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
/*Serializar a classe permitir que seus dados sejam transmitidos em bytes
 * a fim de transmiti-los em rede etc.
  */
public class Tasks implements Serializable{
	
	/*Serializar a classe permitir que seus dados sejam transmitidos em bytes
	 * a fim de transmiti-los em rede etc.
	  */
	private static final long serialVersionUID = -3921955477208356244L;
	
	//Atributos
	private Integer id;
	private String titulo;
	private String descricao;
	private Date   dataDaTarefa;
	private Boolean   doneTask;	
	
	private Users user;
	
	//Construtor sem parâmetros, pois permitiremos criar um objeto sem passar seus atributos
	public Tasks() {
		
	}

	//Construtor com três parâmetros afim de passar valores aos atributos do objeto
	public Tasks(String titulo, String descricao, Date dataDaTarefa, boolean doneTask, Integer id, Users user) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataDaTarefa = dataDaTarefa;
		this.doneTask = doneTask;
		this.id = id;
		this.user = user;
	}
	
	//Getters e Setters para permitir acesso a atributos privados

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataDaTarefa() {
		return dataDaTarefa;
	}

	public void setDataDaTarefa(Date dt) {
		this.dataDaTarefa = dt;
	}

	public Boolean getDoneTask() {
		return doneTask;
	}

	public void setDoneTask(Boolean done) {
		this.doneTask = done;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	/*
	 * Geração do hashCode e do equals para comparar os valores dos atributos pelo seu conteúdo
	 * e não por referência (apontamento de onde os valores se encontram)
	 */

	@Override
	public int hashCode() {
		return Objects.hash(dataDaTarefa, doneTask, descricao, titulo,id, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tasks other = (Tasks) obj;
		return Objects.equals(dataDaTarefa, other.dataDaTarefa) && Objects.equals(doneTask, other.doneTask)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(titulo, other.titulo)
				&& Objects.equals(id, other.id) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		String done = "";
			if(doneTask) {					
				done =  "Concluída!";
			}else {
				
				done = "Não concluída!";
			}
		
		return "id: " + id + ", \n título: " + titulo + "\n descrição: " + descricao + "\n data da tarefa: " + dataDaTarefa
				+ "\n status: " + done ;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user_id) {
		this.user = user_id;
	}

	
	//ToString para enviar informações dos atributos de cada objeto
	
	

}
