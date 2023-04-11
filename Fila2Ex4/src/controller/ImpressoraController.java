package controller;

import java.util.Random;

import javax.swing.JOptionPane;

import br.edu.fateczl.lipe.FilaString.Fila;

public class ImpressoraController {
	
	private Random tempo;
	
	public ImpressoraController() { tempo = new Random(); }
	
	public void insereDocumento(Fila f, String documento) {
		f.insert(documento);
	}
	
	public void imprime(Fila f) throws Exception {
		if (f.isEmpty())
			JOptionPane.showMessageDialog(null, "A fila de impressoes esta vazia");
		
		int tempoImpressao; 
		while(!f.isEmpty()) {
			tempoImpressao = tempo.nextInt(2) + 1; 
			System.out.println("Imprimindo...");
			Thread.sleep(tempoImpressao * 1000);
			String aux[] = f.remove().split(";");
			System.out.println("#PC: " + aux[0] + " Arquivo: "
					+ "" + aux[1]);
		}
	}

}
