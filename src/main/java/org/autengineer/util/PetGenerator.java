package org.autengineer.util;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PetGenerator {

    private static final Faker faker = new Faker();

    public static String createRandomPetJson() {
        long petId = faker.number().randomNumber();
        long categoryId = faker.number().randomNumber();
        long ownerId = faker.number().randomNumber();

        String petName = faker.artist().name();
        String animalName = faker.animal().name();
        String ownerName = faker.name().firstName();
        String photoUrl = faker.internet().url() + "/Photo.jpg";
        String status = getRandomStatus();

        return String.format(
                "{\n" +
                        "  \"id\": %d,\n" +
                        "  \"name\": \"%s\",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": %d,\n" +
                        "    \"name\": \"%s\"\n" +
                        "  },\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"%s\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": %d,\n" +
                        "      \"name\": \"%s\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"%s\"\n" +
                        "}", petId, petName, categoryId, animalName, photoUrl, ownerId, ownerName, status);
    }

    private static String getRandomStatus() {
        String[] statuses = {"available", "pending", "sold"};
        return statuses[faker.random().nextInt(statuses.length)];
    }

    // Escribe el JSON en el archivo especificado
    public static void writeJsonToFile(String json, String fileName, boolean overwrite) {
        String filePath = "src/main/resources/" + fileName;
        File file = new File(filePath);
        if (!file.exists() || overwrite) {
            try (FileWriter fileWriter = new FileWriter(filePath)) {
                fileWriter.write(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Verifica si el archivo existe en la ruta especificada
    public static boolean doesFileExist(String fileName) {
        return Files.exists(Paths.get("src/main/resources/" + fileName));
    }

    // Lee el contenido del archivo y lo retorna como una cadena JSON
    public static String readJsonFromFile(String fileName) {
        String filePath = "src/main/resources/" + fileName;
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
