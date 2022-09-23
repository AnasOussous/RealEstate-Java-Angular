//package com.RealEstate_BackEnd.controller;
//
//
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.validation.Valid;
//
//import com.RealEstate_BackEnd.model.Client;
//import com.RealEstate_BackEnd.repository.ClientRepository;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//public class UserController {
//	
//	  @Autowired
//	  private ClientRepository clientRepository;
//	  
//	  
//	
//	
//	@PreAuthorize("hasRole('ADMIN')")
//	@GetMapping("/users")
//	  public List<Client> getAllClients() {
//	    return clientRepository.findAll();
//	  }
//	
//	
//	
//	@PreAuthorize("hasRole('ADMIN')")
//	@GetMapping("/users/{id}")
//	  public ResponseEntity<Client> getClientsById(@PathVariable(value = "id") Long id)
//	      throws ResourceNotFoundException {
//	    Client Client =
//	        clientRepository
//	            .findById(id)
//	            .orElseThrow(() -> new ResourceNotFoundException("Client not found on :: " + id));
//	    return ResponseEntity.ok().body(Client);
//	  }
//	
//	
//				//	@PostMapping("/users")
//				//	  public Client createClient( @RequestBody Client Client) {
//				//	    return clientRepository.save(Client);
//				//	  }
//	
//	
//	@PreAuthorize("hasRole('ADMIN')")
//	 @PutMapping("/users/{id}")
//	  public ResponseEntity<Client> updateClient(
//	      @PathVariable(value = "id") Long id, @Valid @RequestBody Client ClientDetails)
//	      throws ResourceNotFoundException {
//
//	    Client Client =
//	        clientRepository
//	            .findById(id)
//	            .orElseThrow(() -> new ResourceNotFoundException("Client not found on :: " + id));
//	    
//       Client.setName(ClientDetails.getName());
//       Client.setPassword(ClientDetails.getPassword());
//       Client.setEmail(ClientDetails.getEmail());
//       Client.setTelephone(ClientDetails.getTelephone());
//       Client.setUsername(ClientDetails.getUsername());
//	    
//	   
//	    final Client updatedClient = clientRepository.save(Client);
//	    return ResponseEntity.ok(updatedClient);
//	  }
//	
//	 @PreAuthorize("hasRole('ADMIN')")
//	 @DeleteMapping("/users/{id}")
//	  public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Long id) throws Exception {
//	    Client Client =
//	        clientRepository
//	            .findById(id)
//	            .orElseThrow(() -> new ResourceNotFoundException("Client not found on :: " + id));
//
//	    clientRepository.delete(Client);
//	    Map<String, Boolean> response = new HashMap<>();
//	    response.put("deleted", Boolean.TRUE);
//	    return response;
//	  }
//	
//	 
//
//}
