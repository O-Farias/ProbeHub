package com.probehub.services;

import com.probehub.models.Test;
import com.probehub.repositories.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    // Criar um novo teste
    public Test createTest(Test test) {
        return testRepository.save(test);
    }

    // Listar todos os testes
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    // Buscar um teste pelo ID
    public Test getTestById(Long id) {
        return testRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teste não encontrado com ID: " + id));
    }

    // Atualizar um teste existente
    public Test updateTest(Long id, Test updatedTest) {
        Test existingTest = getTestById(id);
        existingTest.setName(updatedTest.getName());
        existingTest.setDescription(updatedTest.getDescription());
        existingTest.setDuration(updatedTest.getDuration());
        return testRepository.save(existingTest);
    }

    // Remover um teste
    public void deleteTest(Long id) {
        Test test = getTestById(id);
        testRepository.delete(test);
    }
}
