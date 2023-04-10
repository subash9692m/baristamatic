package com.example.demo.controller;

import com.example.demo.Model.Cost;
import com.example.demo.Model.DrinkResponse;
import com.example.demo.Model.Ingredient;
import com.example.demo.Model.OrderRequest;
import com.example.demo.service.DrinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barista")
public class IngredientController {

    private final DrinkService drinkService;

    public IngredientController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }


    @PostMapping("/order")
    public ResponseEntity<DrinkResponse> getMyDrink(@RequestBody OrderRequest orderRequest){
        return new ResponseEntity<>(drinkService.makeMyDrink(orderRequest.getDrinkName()), HttpStatus.OK);
    }

    @GetMapping("/menu")
    public ResponseEntity<List<Ingredient>> getMenu(){
        return new ResponseEntity<>(drinkService.getMenu(), HttpStatus.OK);
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<Cost>> getInventory(){
        return new ResponseEntity<>(drinkService.getInventory(), HttpStatus.OK);
    }

    @PostMapping("/restock")
    public ResponseEntity<String> restock(){
       if (drinkService.restock()){
           return new ResponseEntity<>("Restock successful", HttpStatus.ACCEPTED);
        }
       else {
           return new ResponseEntity<>("Restock Not Required", HttpStatus.ACCEPTED);

       }

    }



}

