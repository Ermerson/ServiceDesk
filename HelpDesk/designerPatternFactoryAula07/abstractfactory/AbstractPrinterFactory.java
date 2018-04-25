package abstractfactory;

/**
 * @author 		Ermerson Rafael - 816122707
 * @category	Aplicações e Serviços
 * @since		21/02/2018
 * @version		v1.0.0.4
 */
public interface AbstractPrinterFactory {
	TextPrinter getPrinterInstance(String printerType);

}
