import static org.junit.jupiter.api.Assertions.assertTrue;

import com.twinkieman.weblab.DatabaseErrors;
import com.twinkieman.weblab.dao.UserDAOImpl;
import com.twinkieman.weblab.models.Game;
import com.twinkieman.weblab.models.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.twinkieman.weblab.utils.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.List;

class DAOTest {

    private static EntityManager em;

    @BeforeAll
    private static void init() throws DatabaseErrors.EntityManagerFactoryError {
        em = EntityManagerUtil.getEntityManager();
    }

    @Test
    public void testDao() throws DatabaseErrors.EntityManagerFactoryError {
        //
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.findById(1);
        List<Integer> progress = userDAO.getGameProgress(user);
        assertTrue(progress.toString().equals("110"));
    }

}
