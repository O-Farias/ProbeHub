package com.probehub.controllers;

import com.probehub.models.ProbeTest; 
import com.probehub.dto.TestDTO;
import com.probehub.services.TestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class TestControllerTest {

    private TestService testService;
    private TestController testController;
    private ProbeTest sampleTest; 

    @BeforeEach
    public void setUp() {
        testService = Mockito.mock(TestService.class);
        testController = new TestController(testService);

        sampleTest = new ProbeTest(); 
        sampleTest.setId(1L);
        sampleTest.setTitle("Sample Test"); 
        sampleTest.setDescription("This is a sample test.");
    }

    @Test
    public void testGetAllTests() {
        List<ProbeTest> tests = Arrays.asList(sampleTest);

        Mockito.when(testService.getAllTests()).thenReturn(tests);

        ResponseEntity<List<ProbeTest>> response = testController.getAllTests();
        assertEquals(1, response.getBody().size());
        assertEquals("Sample Test", response.getBody().get(0).getTitle());
    }

    @Test
    public void testCreateTest() {
        Mockito.when(testService.createTest(any(TestDTO.class))).thenReturn(sampleTest);

        TestDTO testDTO = new TestDTO();
        testDTO.setTitle("Sample Test");
        testDTO.setDescription("This is a sample test.");

        ResponseEntity<ProbeTest> response = testController.createTest(testDTO);
        assertEquals("Sample Test", response.getBody().getTitle());
    }
}
