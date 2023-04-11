package view;

import javax.swing.JOptionPane;

import br.edu.fateczl.lipe.FilaString.Fila;
import controller.ImpressoraController;

public class Principal {
	
	public static void main(String[] args) {
		int op = 0;
		Fila filaImpressao = new Fila();
		ImpressoraController iContr = new ImpressoraController();
		
		String documento;
		
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog("=========== MENU ===========\n"
											+ "Escolha a operacao:\n"
											+ "1 - Inserir documento\n"
											+ "2 - Imprimir documentos\n"
											+ "0 - Sair"));
			switch(op) {
				case 0:
					JOptionPane.showMessageDialog(null, "Ate a proxima!");
					break;
				case 1:
					documento = JOptionPane.showInputDialog("Insira o documento");
					validaEInsereDocumento(iContr, filaImpressao, documento);
					break;
				case 2:
					try {
						iContr.imprime(filaImpressao);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "Operaco invalida, tente novamente!");
			}
		} while(op > 0);
	}
	
	private static void validaEInsereDocumento(ImpressoraController iContr, Fila filaImpressao, String documento) {
		String[] validar = documento.split(";");
		try {
			var id = Integer.parseInt(validar[0]);
			if (!verificaFormato(validar[1]))
				JOptionPane.showMessageDialog(null, "Documento invalido, tente novamente!");
			else
				iContr.insereDocumento(filaImpressao, documento);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Documento invalido, tente novamente!");
		}
	}

	private static boolean verificaFormato(String arquivo) {
		String aux[] = arquivo.split("\\.");
		switch(aux[1].toLowerCase()) {
			case "pdf":
			case "doc":
			case "png":
			case "ppt":
			case "jpeg":
			case "eps":
			case "psd":
				return true;
		}
		
		return false;
	}
	
}
