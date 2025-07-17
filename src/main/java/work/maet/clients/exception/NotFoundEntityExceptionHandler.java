package work.maet.clients.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class NotFoundEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoFoundEntityException.class)
    public Map<String, String> handleNoFoundEntity(NoFoundEntityException exception) {
        var map = new HashMap<String, String>();
        map.put("message", exception.getMessage());
        map.put("timestamp", OffsetDateTime.now().toString());
        return map;
    }
}
