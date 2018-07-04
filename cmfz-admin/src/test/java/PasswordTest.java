import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by zzf_PC on 2018/7/4.
 */
public class PasswordTest {
    @Test
    public void test1(){
        //System.out.println(UUID.randomUUID().toString());
        System.out.println(DigestUtils.sha256Hex("123123" + "asd234"));
    }
}
