package com.mycompany.service;

import com.mycompany.model.Cliente;
import com.mycompany.model.ClienteMongo; // <--- Importe o modelo Mongo
import com.mycompany.repository.ClienteRepository;
import com.mycompany.repository.ClienteMongoRepository; // <--- Importe o repo Mongo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository mysqlRepository;

    @Autowired
    private ClienteMongoRepository mongoRepository;

    public Cliente salvar(Cliente c) {
        Cliente salvoMysql = mysqlRepository.save(c);

        try {
            ClienteMongo copia = new ClienteMongo(
                    salvoMysql.getCpf(),
                    salvoMysql.getNome(),
                    salvoMysql.getTelefone(),
                    salvoMysql.getEmail(),
                    salvoMysql.getEndereco()
            );
            mongoRepository.save(copia);
            System.out.println(">>> Cliente salvo no MySQL e replicado no MongoDB!");
        } catch (Exception e) {
            System.err.println(">>> Erro ao salvar no Mongo: " + e.getMessage());
        }

        return salvoMysql;
    }


    public List<Cliente> listarTodos() {
        return mysqlRepository.findAll();
    }

    public Cliente buscarPorCpf(String cpf) {
        return mysqlRepository.findById(cpf).orElse(null);
    }

    public void deletar(String cpf) {
        mysqlRepository.deleteById(cpf);
    }
}