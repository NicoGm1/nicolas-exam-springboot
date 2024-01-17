package fr.nsurget.nicolasexamspringboot.appli_name.advisor;



import fr.nsurget.nicolasexamspringboot.appli_name.custom_response.ResponseException;
import fr.nsurget.nicolasexamspringboot.appli_name.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundResponse {

    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) // Modifie le code HTTP de la réponse
    @ExceptionHandler(NotFoundException.class) // L'exception qui doit être "catch"
    ResponseException notFoundResponseHandler(NotFoundException e) {
        return new ResponseException(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            e.getType(),
            e.getField(),
            e.getValue(),
            e.getMessage()
        );
    }

}
