package com.ipartek.formacion.uf2216;

public class Revista implements Leible, Comparable<Revista> {

	// atributos
	static final int LONGITUD_MIN_TITULO = 3;
	static final int LONGITUD_MAX_TITULO = 150;
	static final int LONGITUD_ISBN = 10;
	static final int LONGITUD_MIN_PAGINAS = 1;
	private String titulo;
	private String isbn;
	private int numPags;
	private boolean digital; // true == digital false == papel

	// constructor

	public Revista() {

	}

	public Revista(String pTitulo, String pIsbn, int pNumPags, String pDigital) throws Exception {
		super();
		setTitulo(pTitulo);
		setIsbn(pIsbn);
		setNumPags(pNumPags);
		setDigital(pDigital);
	}

	// getters y setters

	public String getTitulo() {
		return titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getNumPags() {
		return numPags;
	}

	public boolean isDigital() {
		return digital;
	}

	/**
	 * Setteamos el titulo en caso de que el numero de letras este comprendida entre
	 * [LONGITUD_MIN_TITULO,LONGITUD_MAX_TITULO] En caso contrario lanzamos
	 * excepcion avisando del error.
	 * 
	 * @param pTitulo String que nos dice el titulo de la revista.
	 * @throws Exception
	 * @see LONGITUD_MAX_TITULO , LONGITUD_MIN_TITULO
	 */
	public void setTitulo(String pTitulo) throws Exception {

		if (pTitulo.length() <= LONGITUD_MAX_TITULO && pTitulo.length() >= LONGITUD_MIN_TITULO) {
			this.titulo = pTitulo;
		} else {
			throw new Exception("\nEl titulo no cumple con el minimo de " + LONGITUD_MIN_TITULO
					+ " caracteres y el maximo de " + LONGITUD_MAX_TITULO+"\n");
		}

	}

	/**
	 * Setteamos el isbn de la revista en caso de que cumpla con el LONGITUD_ISBN
	 * necesario. En caso contrario lanzamos excepcion avisando del error.
	 * 
	 * @param pIsbn String que nos dice el codigo ISBN de la revista
	 * @throws Exception
	 * @see LONGITUD_ISBN
	 */
	public void setIsbn(String pIsbn) throws Exception {
		if (pIsbn.length() == LONGITUD_ISBN) {
			this.isbn = pIsbn;
		} else {
			throw new Exception("\nEl tamaño del ISBN es diferente a su longitud necesaria de " + LONGITUD_ISBN+"\n");
		}

	}

	/**
	 * Setteamos numero de paginas de la revista en caso que sea superior o igual a
	 * LONGITUD_MIN_PAGINAS. En caso contrario lanzamos excepcion avisando del
	 * error.
	 * 
	 * @param pNumPags integer que nos dice la cantidad de paginas de la revista
	 * @throws Exception
	 * @see LONGITUD_MIN_PAGINAS
	 */
	public void setNumPags(int pNumPags) throws Exception {
		if (pNumPags < LONGITUD_MIN_PAGINAS) {
			throw new Exception("\nEl tamaño de paginas es inferior al minimo de " + LONGITUD_MIN_PAGINAS+"\n");
		} else {
			this.numPags = pNumPags;
		}

	}

	/**
	 * Setteamos el formato de la revista, true en caso de ser digital, false en
	 * caso de ser de papel. En caso de que nos pase un formato distinto a estos,
	 * saltara una excepcion informando del error.
	 * 
	 * @param pFormato String que nos indica el formato de la revista.
	 * @throws Exception
	 */
	public void setDigital(String pFormato) throws Exception {

		if (pFormato.equalsIgnoreCase("digital")) {
			this.digital = true;
		} else if (pFormato.equalsIgnoreCase("papel")) {
			this.digital = false;
		} else {
			throw new Exception("El formato elegido no es valido.\n");
		}
	}

	// Otros metodos
	
	@Override
	public String toString() {
		return "Revista [titulo=" + titulo + ", isbn=" + isbn + ", numPags=" + numPags + ", digital=" + digital + "]";
	}

	@Override
	public int compareTo(Revista o) {

		return o.getNumPags() - this.numPags;
	}

}
