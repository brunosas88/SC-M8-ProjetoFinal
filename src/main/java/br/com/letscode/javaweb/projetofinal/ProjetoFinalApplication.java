package br.com.letscode.javaweb.projetofinal;

import br.com.letscode.javaweb.projetofinal.model.BDRebeldes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoFinalApplication {

	public static BDRebeldes bdRebeldes = new BDRebeldes();

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFinalApplication.class, args);
	}

}
