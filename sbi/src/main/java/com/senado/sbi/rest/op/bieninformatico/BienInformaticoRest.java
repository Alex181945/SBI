package com.senado.sbi.rest.op.bieninformatico;

import com.senado.sbi.modelo.op.bieninformatico.BienInformaticoM;

public interface BienInformaticoRest {
	public void insertaBienInformatico(BienInformaticoM obj, String cToken);
	public boolean islResultado();
	public String getMensaje();
}
