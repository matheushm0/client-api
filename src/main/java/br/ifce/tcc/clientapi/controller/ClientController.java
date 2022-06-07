package br.ifce.tcc.clientapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifce.tcc.clientapi.model.Client;
import br.ifce.tcc.clientapi.repository.ClientRepository;

@RestController
@RequestMapping("/v1/clients")
public class ClientController extends AbstractController {

	@Autowired ClientRepository clientRepository;
	
	@GetMapping
	public Page<Client> getClients(Pageable pageable) {
		return clientRepository.findAll(pageable);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createClient(@RequestBody @Valid Client client) {
		clientRepository.save(client);
		return created(client.getId());
	}
	
}
