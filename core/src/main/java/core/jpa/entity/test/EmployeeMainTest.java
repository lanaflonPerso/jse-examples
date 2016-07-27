package core.jpa.entity.test;

import java.util.List;

import javax.persistence.*;

import org.junit.*;

import core.jpa.entity.Employee;

public class EmployeeMainTest {
    private static final String PERSISTENCE_UNIT_NAME = "EclipseLink";
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeClass
    public static void initJPA() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass - afterClass");
    }

    @Before
    public void initEmployee() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Test
    public void createEmployee() {
        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Employee employee = new Employee();
            employee.setName("Siva");
            employee.setAddress("KRP");
            entityManager.persist(employee);
            entityTransaction.commit();
        } catch (Exception exception) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    @Test
    public void updateEmployee() {
        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Employee employee = new Employee();
            employee.setName("Himansu Nayak");
            employee.setAddress("Bellandur");
            entityManager.persist(employee);
        } catch (Exception exception) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    @Test
    public void selectEmployee() {
        Query query = entityManager.createQuery("select emp from Employee emp");
        List<Employee> employees = query.getResultList();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("Size: " + employees.size());
    }

    @After
    public void afterEmployee() {

    }
}
