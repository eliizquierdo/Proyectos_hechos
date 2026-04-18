package paquete;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPerson {
	

	@Test
	void testNombre() {
		Person p=new Person("Elizabeth",46);
		String nombre=p.getNombre();
		String nomEsperado="Elizabeth";
		assertEquals(nomEsperado, nombre);
	}
	
	@Test
	void testEdad() {
		Person p=new Person("Elizabeth",46);
		int edad=p.getEdad();
		int edadEsperada=46;
		assertEquals(edadEsperada, edad);
		
	}

}
