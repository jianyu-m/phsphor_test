import com.sun.security.auth.module.UnixSystem;

/**
 * Created by jianyu on 6/21/17.
 */
public class Login {
    public static void main(String[] args) {
        UnixSystem system = new UnixSystem();
        system.getGroups();
    }
}
