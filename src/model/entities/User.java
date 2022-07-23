package model.entities;

import java.io.Serializable;
import java.util.Objects;

/*Serializar a classe permitir que seus dados sejam transmitidos em bytes
 * a fim de transmiti-los em rede etc.
  */

public class User implements Serializable{
	/**
	 * Geração da versão da serialização dos dados desta classe
	 * a fim facilitar a comunicação de programas que utilizam versões diferente do Java
	 */
	private static final long serialVersionUID = -19536109510504220L;
	
	
	//Atributos dos objetos desta classe a serem criado posteriomente
	private Integer id;
	private String nome;
	private String userName;
	private String password;
	
	//Construtor sem parâmetros, pois permitiremos criar um objeto sem passar seus atributos
	public User() {
		
	}
   //Construtor com três parâmetros afim de passar valores aos atributos do objeto
	public User(String nome, String userName, String password, Integer id) {		
		this.nome = nome;
		this.userName = userName;
		this.password = password;
		this.id = id;
	}
	//Getters e Setters para permitir acesso a atributos privados
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		return Objects.hash(nome, password, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(password, other.password)
				&& Objects.equals(userName, other.userName)&& Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "id: " + id + "\n nome: " + nome + "\n userName: " + userName + "\n password: " + password ;
	}
	
	
	
	//ToString para informar os dados dos atributos de cada objeto que o chamar
	
	
	
}
