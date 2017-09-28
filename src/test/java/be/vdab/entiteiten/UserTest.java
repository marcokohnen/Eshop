package be.vdab.entiteiten;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    User user;

    @Before
    public void init() {
        user = new User("tesTUSer", "testPASwWd");
    }

    @Test
    public void testConstructor() {
        assertThat(user).isInstanceOf(User.class);
    }

    @Test
    public void getUserName() {
        assertThat(user.getUserName()).isEqualTo("tesTUSer");
    }

    @Test
    public void setUserName() {
        user.setUserName("UserKe");
        assertThat(user.getUserName()).isEqualTo("UserKe");
    }

    @Test
    public void getPassWord() {
        assertThat(user.getPassWord()).isEqualTo("testPASwWd");
    }

    @Test
    public void setPassWord() {
        user.setPassWord("extraTeSTPaSS");
        assertThat(user.getPassWord()).isEqualTo("extraTeSTPaSS");
    }

}