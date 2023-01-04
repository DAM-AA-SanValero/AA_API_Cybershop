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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RepairController {

    @Autowired
    RepairService repairService;

    @GetMapping("/repairs")
    public List<Repair> getRepair(){
        return repairService.findAll();
    }

    @GetMapping("/repairs/{id}")
    public Repair getRepair(@PathVariable long id) throws RepairNotFoundException{
        return repairService.findById(id);
    }

    @PostMapping("/repairs")
    public void addRepair(@RequestBody Repair repair){
        repairService.addRepair(repair);
    }

    @DeleteMapping("/repairs/{id}")
    public void deleteRepair(@PathVariable long id) throws RepairNotFoundException{
        repairService.deleteRepair(id);
    }

    @PutMapping("repairs/{id}")
    public Repair updateRepair(@PathVariable long id, @RequestBody Repair repair) throws RepairNotFoundException{
        return repairService.updateRepair(id, repair);
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
