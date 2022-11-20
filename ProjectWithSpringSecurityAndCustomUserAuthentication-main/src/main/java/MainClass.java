import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass {

    public static void main(String[] args){

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        System.out.println(bCryptPasswordEncoder.encode("test"));

    }
}
