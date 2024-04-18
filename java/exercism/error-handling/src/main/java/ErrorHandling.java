import java.io.FileNotFoundException;
import java.util.Optional;

import javax.imageio.IIOException;

class ErrorHandling {

    void handleErrorByThrowingIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    void handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(String message) {
        throw new IllegalArgumentException(message);
    }

    void handleErrorByThrowingAnyCheckedException() throws Exception {
        throw new FileNotFoundException();
    }

    void handleErrorByThrowingAnyCheckedExceptionWithDetailMessage(String message) throws Exception {
        throw new FileNotFoundException(message);
    }

    void handleErrorByThrowingAnyUncheckedException() throws RuntimeException {
        throw new NullPointerException();
    }

    void handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage(String message) throws RuntimeException {
        throw new NullPointerException("This is the detail message.");
    }

    void handleErrorByThrowingCustomCheckedException() throws Exception {
        throw new CustomCheckedException();
    }

    void handleErrorByThrowingCustomCheckedExceptionWithDetailMessage(String message) throws Exception {
        throw new CustomCheckedException(message);
    }

    void handleErrorByThrowingCustomUncheckedException() throws RuntimeException {
        throw new CustomUncheckedException();
    }

    void handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage(String message) throws RuntimeException {
        throw new CustomUncheckedException(message);
    }

    Optional<Integer> handleErrorByReturningOptionalInstance(String integer) {
        try {
            return Optional.of(Integer.parseInt(integer));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
