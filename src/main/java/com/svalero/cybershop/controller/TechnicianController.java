package com.svalero.cybershop.controller;

import com.svalero.cybershop.domain.Technician;
import com.svalero.cybershop.exception.ErrorMessage;
import com.svalero.cybershop.exception.TechnicianNotFoundException;
import com.svalero.cybershop.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TechnicianController {

    @Autowired
    TechnicianService technicianService;

    @GetMapping("/technicians")
    public List<Technician> getTechnician(){
        return technicianService.findAll();
    }

    @GetMapping("/technicians/{id}")
    public Technician getTechnician(@PathVariable long id) throws TechnicianNotFoundException{
        return technicianService.findById(id);
    }

    @PostMapping("technicians")
    public void addTechnician(@RequestBody Technician technician){
        technicianService.addTechnician(technician);
    }

    @DeleteMapping("technicians/{id}")
    public void deleteTechnician(@PathVariable long id) throws TechnicianNotFoundException{
        technicianService.deleteTechnician(id);
    }
    @PutMapping("technicians/{id}")
    public Technician updateTechnician(@PathVariable long id, @RequestBody Technician technician) throws TechnicianNotFoundException{
        return technicianService.updatedTechnician(id, technician);

    }

    @ExceptionHandler(TechnicianNotFoundException.class)
    public ResponseEntity<ErrorMessage> clientNotFoundException(TechnicianNotFoundException tnfe){
        ErrorMessage notfound = new ErrorMessage(404,tnfe.getMessage());
        return new ResponseEntity<>(notfound, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> badRequestException(MethodArgumentNotValidException manve){

        //Indicar en que campo ha fallado el cliente
        Map<String, String> errors = new HashMap<>();
        manve.getBindingResult().getAllErrors().forEach(error -> {
            String fieldname = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldname, message);
        });

        ErrorMessage badRequest = new ErrorMessage(400, "Bad Request", errors);
        return new ResponseEntity<>(badRequest, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception e) {
        ErrorMessage errorMessage = new ErrorMessage(500, "Internal Server Error");
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
