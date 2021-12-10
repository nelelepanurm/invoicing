package exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler (ApplicationException.class)
    public ResponseEntity<Object>handelError(ApplicationException ex){
        ExceptionDto response = new ExceptionDto(ex.getMessage());
        return new ResponseEntity<Object>(response,new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
