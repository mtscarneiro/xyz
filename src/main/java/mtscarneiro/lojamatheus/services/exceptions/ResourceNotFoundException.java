package mtscarneiro.lojamatheus.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("There is no data that has the id = " + id + ".");
    }
}
