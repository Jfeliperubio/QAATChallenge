package org.autengineer.util;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserDataGenerator {

    private static final Faker faker = new Faker();

    public static String generateRandomUserJson() {
        int id = faker.number().randomDigit();
        String username = faker.name().username();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String phone = faker.phoneNumber().cellPhone();
        int userStatus = faker.random().nextInt(2); // Random number between 0 and 1

        return String.format(
                "{\n" +
                        "  \"id\": %d,\n" +
                        "  \"username\": \"%s\",\n" +
                        "  \"firstName\": \"%s\",\n" +
                        "  \"lastName\": \"%s\",\n" +
                        "  \"email\": \"%s\",\n" +
                        "  \"password\": \"%s\",\n" +
                        "  \"phone\": \"%s\",\n" +
                        "  \"userStatus\": %d\n" +
                        "}", id, username, firstName, lastName, email, password, phone, userStatus);
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
