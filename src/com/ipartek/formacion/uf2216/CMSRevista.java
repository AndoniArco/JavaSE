package com.ipartek.formacion.uf2216;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;


/**
 * CMS para gestionar revistas. Permite listar, crear y guardarlas en fichero.
 * @author Curso
 *
 */
public class CMSRevista {

	static Scanner sc = null;
	static final int OPCION_LISTAR = 1;
	static final int OPCION_CREAR = 2;
	static final int OPCION_GUARDAR_FICHERO = 3;
	static final int OPCION_SALIR = 4;
	static int opcion;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		System.out.println("****** BIENVENIDO AL MENU DE REVISTAS ******");

		do {
			System.out.println();
			System.out.println("****** ELIJA UNA OPCION ******");
			System.out.println();
			System.out.println("1) LISTAR REVISTAS");
			System.out.println("2) CREAR REVISTA");
			System.out.println("3) GUARDAR FICHERO");
			System.out.println("4) SALIR");
			System.out.println();

			try {
				opcion = Integer.parseInt(sc.nextLine());

				switch (opcion) {
				case OPCION_LISTAR:
					listarRevistas();
					break;
				case OPCION_CREAR:
					crearRevista();
					break;
				case OPCION_GUARDAR_FICHERO:
					guardarFichero();
					break;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("EL DATO INTRODUCIDO NO ES VALIDO");
			}

		} while (opcion != OPCION_SALIR);

		sc.close();

	}

	/**
	 * Metodo para crear revista por parametros. Siempre que un dato no sea correcto
	 * se lo volveremos a pedir. Una vez creada la revista le preguntamos si la
	 * quiere guardar o no.
	 */
	private static void crearRevista() {
		Revista revista = new Revista();
		boolean repetir = true;
		String titulo = null;
		String isbn = null;
		int numPags = -1;
		String formato = null;
		String guardar = null;
		String aux = null;

		System.out.println("-------CREAR REVISTA---------");
		System.out.println("-----------------------------------");

		do {
			try {

				if (titulo == null) {
					System.out.println("---------TITULO DE LA REVISTA----------");
					System.out.println("---------LONGITUD [3,150]----------");
					aux = sc.nextLine();
					revista.setTitulo(aux);
					titulo = aux;
				}

				if (isbn == null) {
					System.out.println("---------ISBN DE LA REVISTA----------");
					System.out.println("-----------LONGITUD [10]-----------");
					aux = sc.nextLine();
					revista.setIsbn(aux);
					isbn = aux;

				}

				if (numPags < Revista.LONGITUD_MIN_PAGINAS) {
					System.out.println("---------NUMERO DE PAGINAS DE LA REVISTA----------");
					System.out.println("-----------LONGITUD [MAYOR A 1]-----------");
					numPags = Integer.parseInt(sc.nextLine());
					revista.setNumPags(numPags);
				}

				if (formato == null) {
					System.out.println("---------FORMATO DE REVISTA----------");
					System.out.println("---------DIGITAL O PAPEL----------");
					aux = sc.nextLine();
					revista.setDigital(aux);
					formato = aux;
				}
				System.out.println("\n **********************************");
				System.out.println("El titulo de la revista es: " + titulo);
				System.out.println("El ISBN de la revista es: " + isbn);
				System.out.println("El numero de paginas de la revista es: " + numPags);
				System.out.println("El formato de la revista es: " + formato);
				System.out.println("\n **********************************");
				System.out.println("¿Estas seguro de que quieres guardar esta revista?");
				System.out.println("--------------------SI / NO --------------------");
				guardar = sc.nextLine();
				if (guardar.equalsIgnoreCase("si")) {
					DAORevistaArrayList.getInstance().insert(revista);
					repetir = false;
				} else {
					break;
				}

			} catch (Exception e) {

				System.out.println(e.getMessage());

			}

		} while (repetir);

	}

	/**
	 * Listamos las revistas de manera ordenada de mayor a menor numero de paginas.
	 */
	
	private static void listarRevistas() {

		if (DAORevistaArrayList.getInstance().getAll().size() == 0) {
			System.out.println("\n No existen revistas. \n");
		} else {
			Collections.sort(DAORevistaArrayList.getInstance().getAll());

			for (Revista r : DAORevistaArrayList.getInstance().getAll()) {
				System.out.println(r.toString());
			}
		}

	}

	/**
	 * Metodo para guardar los datos en un fichero de texto. El archivo .txt se
	 * guarda en la carpeta resources.
	 */
	private static void guardarFichero() {

		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("./resources/revistas.txt");
			pw = new PrintWriter(fichero);

			for (Revista r : DAORevistaArrayList.getInstance().getAll())
				pw.println(r.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Utilizamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
