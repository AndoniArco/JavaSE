package com.ipartek.formacion.uf2216;

import java.util.ArrayList;

/**
 * Operaciones basicas de CRUD(necesarias para el DAO Revista)
 * @author Curso
 * @param <P>
 *
 */

public interface IPersistible<P> {

	ArrayList<P> getAll();
	
	boolean insert (P pojo);

	
}