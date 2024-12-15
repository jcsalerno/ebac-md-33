package com.cesar.ebac_md_33;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class SalvarDados {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void salvarDados() {
        // Criando uma nova marca
        Marca marca = new Marca();
        marca.setNome("Toyota");

        // Criando um carro
        Carro carro = new Carro();
        carro.setModelo("Corolla");
        carro.setMarca(marca);

        // Criando e adicionando detalhes ao carro
        Detalhe detalhe = new Detalhe();
        detalhe.setCor("Preto");
        detalhe.setCombustivel("Gasolina");
        carro.setDetalhe(detalhe);

        // Criando acessórios
        Acessorio acessorio1 = new Acessorio();
        acessorio1.setDescricao("Ar-condicionado");

        Acessorio acessorio2 = new Acessorio();
        acessorio2.setDescricao("Airbag");

        // Adicionando os acessórios ao carro
        carro.getAcessorios().add(acessorio1);
        carro.getAcessorios().add(acessorio2);

        // Persistindo os acessórios
        em.persist(acessorio1);
        em.persist(acessorio2);

        // Persistindo a marca, o carro e o detalhe
        em.persist(marca);
        em.persist(carro);
        em.persist(detalhe);
    }
}
