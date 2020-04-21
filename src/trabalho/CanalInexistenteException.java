package trabalho;
public class CanalInexistenteException extends Exception {
    public CanalInexistenteException() {
        super("Não há esse canal");
    }
}