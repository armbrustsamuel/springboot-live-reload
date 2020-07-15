package com.sap.nfe.livereload;

import com.sap.nfe.livereload.model.Pessoa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
@RestController
public class LiveReloadApplication {

	@RequestMapping(method = RequestMethod.GET, path = "/")
	@ResponseBody
	public String currentTime() {
		return "The current time is " + new Date();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/usuario")
	@ResponseBody
	public Pessoa taxi() {
		Pessoa usuario = new Pessoa();
		usuario.setNome("Usuario");
		usuario.setIdade(26);
		return usuario;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiveReloadApplication.class, args);
	}

}
