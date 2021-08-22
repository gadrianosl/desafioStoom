package com.desafiostoom.CRUD_Endereco.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.desafiostoom.CRUD_Endereco.entity.Endereco;
import com.desafiostoom.CRUD_Endereco.repository.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnderecoController {
    @Autowired
    private EnderecoRepository _enderecoRepository;

    @RequestMapping(value = "/endereco", method = RequestMethod.GET)
    public List<Endereco> Get() {
        return _enderecoRepository.findAll();
    }

    @RequestMapping(value = "/endereco/{id}", method = RequestMethod.GET)
    public ResponseEntity<Endereco> GetById(@PathVariable(value = "id") long id) {
        Optional<Endereco> Endereco = _enderecoRepository.findById(id);
        if (Endereco.isPresent())
            return new ResponseEntity<Endereco>(Endereco.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/endereco", method = RequestMethod.POST)
    public Endereco Post(@Valid @RequestBody Endereco Endereco) {
        return _enderecoRepository.save(Endereco);
    }

    @RequestMapping(value = "/endereco/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Endereco> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Endereco newEndereco) {
        Optional<Endereco> oldEndereco = _enderecoRepository.findById(id);
        if (oldEndereco.isPresent()) {
            Endereco Endereco = oldEndereco.get();
            Endereco.setStreetName(newEndereco.getStreetName());
            Endereco.setNumber(newEndereco.getNumber());
            Endereco.setComplement(newEndereco.getComplement());
            Endereco.setNeighbourhood(newEndereco.getNeighbourhood());
            Endereco.setCity(newEndereco.getCity());
            Endereco.setState(newEndereco.getState());
            Endereco.setCountry(newEndereco.getCountry());
            Endereco.setZipcode(newEndereco.getZipcode());
            Endereco.setLatitude(newEndereco.getLatitude());
            Endereco.setLongitude(newEndereco.getLongitude());
            _enderecoRepository.save(Endereco);
            return new ResponseEntity<Endereco>(Endereco, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/endereco/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<Endereco> Endereco = _enderecoRepository.findById(id);
        if (Endereco.isPresent()) {
            _enderecoRepository.delete(Endereco.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
