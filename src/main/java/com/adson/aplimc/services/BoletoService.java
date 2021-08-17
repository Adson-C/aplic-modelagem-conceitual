package com.adson.aplimc.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.adson.aplimc.domain.PagamentoComBoleto;

@Service
public class BoletoService {

	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instantDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instantDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}
	
}
