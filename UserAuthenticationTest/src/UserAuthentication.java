public class UserAuthentication {

    public boolean authenticate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        if (username.equals("admin") && password.equals("password123")) {
            return true; 
        } else {
            return false; 
        }
    }

}
