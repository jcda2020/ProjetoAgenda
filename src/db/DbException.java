package db;

public class DbException extends RuntimeException{
	//https://www.alura.com.br/artigos/entendendo-o-serialversionuid?gclid=CjwKCAjwrNmWBhA4EiwAHbjEQLLorzsUIJqexI2r4Bp9kAicPBaQ5mAEwtmpfOOMjLTNRub4fIV3yxoC-9gQAvD_BwE
	private static final long serialVersionUID = 1L;
	
	public DbException(String msg) {
		super(msg);
		
	}

}
