package abstractfactory;

/**
 * @author 		Ermerson Rafael - 816122707
 * @category	Aplicações e Serviços
 * @since		21/02/2018
 * @version		v1.0.0.4
 */
public class TestAbstractPrinterFactory {
	public static void main(String[] args) {

		AbstractPrinterFactory printerFactory = new PrinterFactory();
		TextPrinter printer = printerFactory.getPrinterInstance("FILEPRINT");
		printer.print();

		System.out.println("************************************");

		printer = printerFactory.getPrinterInstance("SCREENPRINT");
		printer.print();
	}
}