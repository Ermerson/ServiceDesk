package logfactory;/** * @author 		Ermerson Rafael - 816122707 * @category	Aplica��es e Servi�os * @since		21/02/2018 * @version		v1.0.0.4 */public class EscrevedorLogArquivo extends EscrevedorLog {	protected FerramentaLog criarFerramentaLog() {		return new FerramentaLogArquivo();	}}