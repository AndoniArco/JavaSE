package com.ipartek.formacion.uf2216;

import java.util.ArrayList;

public class DAORevistaArrayList implements IPersistible<Revista> {

	// atributos
	private static DAORevistaArrayList INSTANCE;
	private ArrayList<Revista> lista = new ArrayList<Revista>();

	public static synchronized DAORevistaArrayList getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new DAORevistaArrayList();
		}

		return INSTANCE;

	}
	
	

	@Override
	public ArrayList<Revista> getAll() {
		
		return lista;
		
	}

	

	@Override
	public boolean insert(Revista pojo) {
			return lista.add(pojo);
	}

	
}
