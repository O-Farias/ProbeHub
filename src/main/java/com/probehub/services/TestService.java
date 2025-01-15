package com.probehub.services;

import com.probehub.models.ProbeTest;
import com.probehub.models.User;
import com.probehub.dto.TestDTO;
import com.probehub.repositories.TestRepository;
import com.probehub.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final TestRepository testRepository;
    private final UserRepository userRepository;

    public TestService(TestRepository testRepository, UserRepository userRepository) {
        this.testRepository = testRepository;
        this.userRepository = userRepository;
    }

    // Criar um novo teste associado a um usuário
    public ProbeTest createTest(TestDTO testDTO) {
        User user = userRepository.findById(testDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + testDTO.getUserId()));

        ProbeTest test = new ProbeTest();
        test.setTitle(testDTO.getTitle());
        test.setDescription(testDTO.getDescription());
        test.setUser(user);

        return testRepository.save(test);
    }

    // Listar todos os testes
    public List<ProbeTest> getAllTests() {
        return testRepository.findAll();
    }

    // Buscar um teste pelo ID
    public ProbeTest getTestById(Long id) {
        return testRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teste não encontrado com ID: " + id));
    }

    // Atualizar um teste existente
    public ProbeTest updateTest(Long id, TestDTO testDTO) {
        ProbeTest existingTest = getTestById(id);

        User user = userRepository.findById(testDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + testDTO.getUserId()));

        existingTest.setTitle(testDTO.getTitle());
        existingTest.setDescription(testDTO.getDescription());
        existingTest.setUser(user);

        return testRepository.save(existingTest);
    }

    // Remover um teste
    public void deleteTest(Long id) {
        ProbeTest test = getTestById(id);
        testRepository.delete(test);
    }
}
