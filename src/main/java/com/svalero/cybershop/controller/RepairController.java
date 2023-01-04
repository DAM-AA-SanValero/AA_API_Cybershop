package com.svalero.cybershop.controller;

import com.svalero.cybershop.domain.Repair;
import com.svalero.cybershop.exception.ErrorMessage;
import com.svalero.cybershop.exception.RepairNotFoundException;
import com.svalero.cybershop.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RepairController {

    @Autowired
    RepairService repairService;

    @GetMapping("/repairs")
    public ResponseEntity<List<Repair>> getRepair(){
        return ResponseEntity.status(200).body(repairService.findAll());
    }

    @GetMapping("/repairs/{id}")
    public ResponseEntity<Repair> getRepair(@PathVariable long id) throws RepairNotFoundException{
        Repair repair = repairService.findById(id);
        return ResponseEntity.status(200).body(repair);
    }

    @PostMapping("/repairs")
    public ResponseEntity<Repair> addRepair(@Valid @RequestBody Repair repair){
        Repair newRepair = repairService.addRepair(repair);
        return ResponseEntity.status(201).body(newRepair);
    }

    @DeleteMapping("/repairs/{id}")
    public ResponseEntity<Void> deleteRepair(@PathVariable long id) throws RepairNotFoundException{
        repairService.deleteRepair(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("repairs/{id}")
    public ResponseEntity<Repair> updateRepair(@PathVariable long id, @RequestBody Repair repair)
            throws RepairNotFoundException{
        Repair updateRepair = repairService.updateRepair(id, repair);
        return ResponseEntity.status(200).body(updateRepair);
    }

    @ExceptionHandler(RepairNotFoundException.class)
    public ResponseEntity<ErrorMessage> clientNotFoundException(RepairNotFoundException rnfe){
        ErrorMessage notfound = new ErrorMessage(404,rnfe.getMessage());
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
