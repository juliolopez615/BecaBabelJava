package modelo.negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.entidad.Coche;

class TestGestorCoche {

	@Test
	void testCoche() {
		GestorCoche gestor = new GestorCoche();
		
		int idEsperado = 3;
		
		Coche cocheObtenido = gestor.buscarid(3);
		
		assertEquals(idEsperado, cocheObtenido.getId());	
	}

}
