package com.probehub.controllers;

import com.probehub.models.ProbeTest;
import com.probehub.dto.TestDTO;
import com.probehub.services.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tests")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping
    public ResponseEntity<ProbeTest> createTest(@RequestBody TestDTO testDTO) {
        ProbeTest createdTest = testService.createTest(testDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTest);
    }

    @GetMapping
    public ResponseEntity<List<ProbeTest>> getAllTests() {
        List<ProbeTest> tests = testService.getAllTests();
        return ResponseEntity.ok(tests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProbeTest> getTestById(@PathVariable Long id) {
        ProbeTest test = testService.getTestById(id);
        return ResponseEntity.ok(test);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProbeTest> updateTest(@PathVariable Long id, @RequestBody TestDTO testDTO) {
        ProbeTest updatedTest = testService.updateTest(id, testDTO);
        return ResponseEntity.ok(updatedTest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable Long id) {
        testService.deleteTest(id);
        return ResponseEntity.noContent().build();
    }
}
