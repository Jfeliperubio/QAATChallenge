package org.autengineer.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

public class OrderDataGenerator {

    private static final String OUTPUT_FILE_PATH = "src/main/resources/order.json";

    public static void generateRandomOrderJson() {
        Order order = generateRandomOrder();
        writeOrderToJsonFile(order, OUTPUT_FILE_PATH);
    }

    private static Order generateRandomOrder() {
        Random random = new Random();
        int id = random.nextInt(1000);
        int petId = random.nextInt(100000);
        int quantity = random.nextInt(10) + 1;
        LocalDateTime shipDate = LocalDateTime.now().plusDays(random.nextInt(30));
        String status = getRandomStatus();
        boolean complete = random.nextBoolean();

        return new Order(id, petId, quantity, shipDate.toString(), status, complete);
    }

    private static String getRandomStatus() {
        String[] statuses = {"approved", "placed", "delivered"};
        Random random = new Random();
        return statuses[random.nextInt(statuses.length)];
    }

    private static void writeOrderToJsonFile(Order order, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), order);
            System.out.println("Archivo JSON generado correctamente: " + filePath);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        generateRandomOrderJson();
    }
}

class Order {
    private final int id;
    private final int petId;
    private final int quantity;
    private final String shipDate;
    private final String status;
    private final boolean complete;

    public Order(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", petId=" + petId +
                ", quantity=" + quantity +
                ", shipDate='" + shipDate + '\'' +
                ", status='" + status + '\'' +
                ", complete=" + complete +
                '}';
    }
}
