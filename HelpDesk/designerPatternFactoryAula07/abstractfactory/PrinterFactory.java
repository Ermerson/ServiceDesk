package abstractfactory;

/**
 * @author 		Ermerson Rafael - 816122707
 * @category	Aplicações e Serviços
 * @since		21/02/2018
 * @version		v1.0.0.4
 */
public class PrinterFactory implements AbstractPrinterFactory {

	@Override
	public TextPrinter getPrinterInstance(String printerType) {
		switch (printerType) {
		case "FILEPRINT": return new FilePrintTextPrinter();
		case "SCREENPRINT": return new ScreenPrintTextPrinter();
		}

		return null;
	}

}
