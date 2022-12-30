import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author Chunlong Zhang
 * @version 1.0.0
 * @ClassName TestOnPasswordEncoder.java
 * @Description @TODO
 * @createTime 2022年12月29日 14:49:00
 */

@RunWith(SpringRunner.class)
@SpringBootTest( classes = TestOnPasswordEncoder.class )
public class TestOnPasswordEncoder {
    // prepare password with 100
    static final int COUNT = 100;

    /**
     * 10 - 16.525 s
     * 11 - 37.945 s
     */
    @Test
    public void timeConsumingOnDecodePassword() {
//        HashMap<String, String> passwordMap = new HashMap<>( COUNT );
        ArrayList<String> l1 = new ArrayList<>(COUNT), l2= new ArrayList<>(COUNT);
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(10);

        for(int i = 0; i < COUNT; i ++ ) {
            UUID uuid = UUID.randomUUID();
            l1.add( uuid.toString() );
            l2.add( bcrypt.encode( uuid.toString() ) );
        }

        long start = System.currentTimeMillis();
        for( int i = 0; i < COUNT; i ++ ) {
            if( bcrypt.matches( l1.get( i ), l2.get( i ) ) == false ) {
                System.out.println( "WRONG" );
            };
        }

        System.out.println( "consume: " + (float)(System.currentTimeMillis() - start)/1000 + " s" );
    }
}
