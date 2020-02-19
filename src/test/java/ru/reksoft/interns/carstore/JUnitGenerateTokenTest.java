package ru.reksoft.interns.carstore;


import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import ru.reksoft.interns.carstore.jwt.JwtTokenUtil;


import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class JUnitGenerateTokenTest {

    @Test
    public void test() {

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        Map<String, Object> claims = new HashMap<>();
        jwtTokenUtil.setSecret("javainuse");

        String token = jwtTokenUtil.doGenerateToken(claims,"qwert12345");
        String userName = jwtTokenUtil.getUsernameFromToken(token);

        assertEquals(userName,"qwert12345");
    }


//    @Before
//    public void serUp() {
//        UserDetails userDetails = null;
//       String name = userDetails.getUsername();
//    }
//
//    void toGenerate() {
//        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
//        assertEquals("",jwtTokenUtil.generateToken())
//    }

}
