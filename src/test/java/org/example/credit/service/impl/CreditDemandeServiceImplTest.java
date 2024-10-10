package org.example.credit.service.impl;

import static org.junit.jupiter.api.Assertions.*;


import org.example.credit.model.CreditDemande;
import org.example.credit.repository.DemandeCreditRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class CreditDemandeServiceImplTest {

    @Mock
    private DemandeCreditRepository demandeCreditRepository;

    @InjectMocks
    private CreditDemandeServiceImpl creditDemandeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void testGetAllDemandes_ShouldReturnNonEmptyList_WhenDemandesExist() {
        List<CreditDemande> demandeList = Arrays.asList(new CreditDemande(), new CreditDemande());

        when(demandeCreditRepository.findAll()).thenReturn(demandeList);

        List<CreditDemande> result = creditDemandeService.getAllDemandes();

        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        verify(demandeCreditRepository, times(1)).findAll();
    }

    @Test
    void testGetAllDemandes_ShouldReturnEmptyList_WhenNoDemandesExist() {
        when(demandeCreditRepository.findAll()).thenReturn(Collections.emptyList());
        List<CreditDemande> result = creditDemandeService.getAllDemandes();
        assertTrue(result.isEmpty());
        verify(demandeCreditRepository, times(1)).findAll();
    }

    @Test
    void testGetAllDemandes_ShouldReturnSingleDemande_WhenOneDemandeExists() {
        List<CreditDemande> demandeList = Collections.singletonList(new CreditDemande());
        when(demandeCreditRepository.findAll()).thenReturn(demandeList);
        List<CreditDemande> result = creditDemandeService.getAllDemandes();

        assertEquals(1, result.size());
        verify(demandeCreditRepository, times(1)).findAll();
    }




    @Test
    void testGetDemandeById_ShouldReturnDemande_WhenIdIsValid() {
        CreditDemande demande = new CreditDemande();
        demande.setNumero(1L);
        demande.setNom("TestNom");

        when(demandeCreditRepository.findById(1L)).thenReturn(Optional.of(demande));

        CreditDemande result = creditDemandeService.getDemandeById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getNumero());
        assertEquals("TestNom", result.getNom());
        verify(demandeCreditRepository, times(1)).findById(1L);
    }

    @Test
    void testGetDemandeById_ShouldReturnNull_WhenIdIsInvalid() {
        CreditDemande result = creditDemandeService.getDemandeById(9L);
        assertNull(result);
    }

    @Test
    void testGetDemandeById_ShouldThrowException_WhenRepositoryFails() {
        when(demandeCreditRepository.findById(anyLong())).thenThrow(new RuntimeException("Erreur inattendue"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            creditDemandeService.getDemandeById(1L);
        });

        assertEquals("Erreur inattendue", exception.getMessage());
        verify(demandeCreditRepository, times(1)).findById(1L);
    }
}
