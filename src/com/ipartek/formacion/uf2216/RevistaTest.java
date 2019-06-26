package com.ipartek.formacion.uf2216;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RevistaTest {

	Revista r = null;
	static final String NOMBRE_REVISTA = "Revista Prueba";
	static final String ISBN_REVISTA = "r7-xpJE5IA";
	static final int NUMERO_PAGINAS = 64;
	static final String FORMATO = "digital";

	@Before
	public void setUp() throws Exception {
		r = new Revista(NOMBRE_REVISTA, ISBN_REVISTA, NUMERO_PAGINAS, FORMATO);
	}

	@After
	public void tearDown() throws Exception {
		r = null;
	}

	@Test
	public void testRevista() {
		assertEquals(NOMBRE_REVISTA, r.getTitulo());
		assertEquals(ISBN_REVISTA, r.getIsbn());
		assertEquals(NUMERO_PAGINAS, r.getNumPags());
		assertEquals(true, r.isDigital());

		try {
			Revista rNull = new Revista(null, null, 3, null);
			assertEquals(null, rNull.getTitulo());
			assertEquals(null, rNull.getIsbn());
			assertEquals(0, rNull.getNumPags());
			assertEquals(null, rNull.isDigital());
			fail("Deberia de lanzar excepcion Revista");
		} catch (Exception e) {

		}
	}

	@Test
	public void testGetTitulo() {
		assertEquals(NOMBRE_REVISTA, r.getTitulo());

	}

	@Test
	public void testSetTitulo() throws Exception {
		r.setTitulo("Belladona");
		assertEquals("Belladona", r.getTitulo());

		try { // Prueba de length() < 3
			r.setTitulo("AA");
			fail("Deberia de lanzar excepcion Titulo");
		} catch (Exception e) {

		}

		try { // Prueba de length() == 3
			r.setTitulo("BOY");
			assertEquals("BOY", r.getTitulo());
		} catch (Exception e) {

		}

		try { // Prueba length() == 150
			r.setTitulo(
					"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
			assertEquals(
					"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO",
					r.getTitulo());
		} catch (Exception e) {

		}

		try { // Prueba length() > 150
			r.setTitulo(
					"BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
			fail("Deberia de lanzar excepcion Titulo");
		} catch (Exception e) {
			
		}
	}

	@Test
	public void testGetIsbn() {
		assertEquals(ISBN_REVISTA, r.getIsbn());
	}

	@Test
	public void testSetIsbn() throws Exception {

		r.setIsbn("PoX32-3xI8");
		assertEquals("PoX32-3xI8", r.getIsbn());

		try {
			r.setIsbn("PoX32-3xI84");
			fail("Deberia de lanzar excepcion ISBN");
		} catch (Exception e) {

		}

		try {
			r.setIsbn("PoX32-3x");
			fail("Deberia de lanzar excepcion ISBN");
		} catch (Exception e) {

		}

	}

	@Test
	public void testGetNumPags() {
		assertEquals(NUMERO_PAGINAS, r.getNumPags());
	}

	@Test
	public void testSetNumPags() throws Exception {
		r.setNumPags(234);
		assertEquals(234, r.getNumPags());

		try { // Prueba paginas < 1
			r.setNumPags(-1818551);
			fail("Deberia de lanzar excepcion Paginas");
		} catch (Exception e) {

		}

		try { // Prueba paginas = 1
			r.setNumPags(1);
			assertEquals(1, r.getNumPags());
		} catch (Exception e) {

		}
	}

	@Test
	public void testGetFormato() {
		assertEquals(true, r.isDigital());
	}

	public void testSetFormato() throws Exception {
		r.setDigital("papel");
		assertEquals(false, r.isDigital());

		try {
			r.setDigital("Periodico");
			fail("Deberia de lanzar excepcion");
		} catch (Exception e) {

		}
	}
}
