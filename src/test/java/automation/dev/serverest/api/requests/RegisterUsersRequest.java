package automation.dev.serverest.api.requests;

import automation.dev.serverest.api.support.BaseTest;
import automation.dev.serverest.api.models.NewUsersModel;
import io.restassured.response.Response;

public class RegisterUsersRequest extends BaseTest {

    /**
     * Método para registrar um novo usuário
     *
     * @param newUser Objeto contendo os dados do novo usuário
     * @return Response da chamada
     */

    public static Response registerUser(NewUsersModel newUser) {
        try {
            return requester
                    .body(newUser)
                    .when()
                    .post(USERS);
        } catch (Exception e) {
            throw new RuntimeException("Failed to register user: " + e.getMessage());
        }
    }
}