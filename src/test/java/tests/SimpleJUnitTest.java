package tests;

import org.junit.jupiter.api.*;

public class SimpleJUnitTest {  /*Место, где мы пишем наш Java тесты*/

    int result;

    @BeforeAll
    static void beforeAll(){    /* Всегда пишется со static. Вызывается один перед всеми тестами в этом тестовом классе*/
        System.out.println("### beforeAll()\n");
    }

    @BeforeEach
    void beforeEach(){  /*Метод, который выполняет действия для всех тестов*/
        System.out.println("###      beforeEach()");
        result = getResult();
    }

    @AfterEach
    void afterEach(){   /*Метод, который выполняет действия для всех тестов, но после завершения*/
        System.out.println("###      afterEach()\n");
        result = 0;
    }

    @AfterAll
    static void afterAll(){    /* Всегда пишется со static. Выполняет одно действие после всех тестов.
                                    Например, почистить базу данных*/
        System.out.println("### afterAll()\n");
    }

    @Test /*Метка, которая помогает JUnit определить, что дальше идет тест*/
    void firstTest() { /*По нажатию на зеленую стрелочку Метод firstTest
                                     превратится в Тест*/
        System.out.println("###         firstTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test /*Метка, которая помогает JUnit определить, что дальше идет тест*/
    void secondTest() { /*По нажатию на зеленую стрелочку Метод firstTest
                                     превратится в Тест*/
        System.out.println("###         secondTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test /*Метка, которая помогает JUnit определить, что дальше идет тест*/
    void thirdTest() { /*По нажатию на зеленую стрелочку Метод firstTest
                                     превратится в Тест*/
        System.out.println("###         thirdTest()");
        Assertions.assertTrue(result > 2);
    }

    private int getResult(){
        return 3;
    }

}
