package com.mastercard.gateway.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    private final Map<String, Map<String, Object>> store = new HashMap<>();

    @PostMapping
    public ResponseEntity<Map<String, Object>> authorise(@RequestBody Map<String, Object> req) {
        String id = UUID.randomUUID().toString();
        Map<String, Object> txn = new HashMap<>(req);
        txn.put("id", id);
        txn.put("status", "AUTHORISED");
        txn.put("timestamp", Instant.now().toString());
        store.put(id, txn);
        return ResponseEntity.status(201).body(txn);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> get(@PathVariable String id) {
        return store.containsKey(id) ? ResponseEntity.ok(store.get(id)) : ResponseEntity.notFound().build();
    }
}