package tp0;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testGetFullName(){
        Person person = new Person("saker","youcef",23);
        assertEquals("saker youcef",person.getFullName(),"Le nom complet doit être 'youcef saker");
    }
    @Test
    void testAgeEgal18(){
        Person person = new Person("saker","youcef",19);
        assertTrue(person.isAdult(), "Une personne de 18 ans doit être majeure");
    }
    @Test
    void testAgeEstInferieurA18() {
        Person person = new Person("saker", "youcef", 17);
        assertFalse(person.isAdult(), "Une personne de 17 ans ne doit pas être majeure");
    }

    @Test
    void testAgeEstSuperieurA18() {
        Person person = new Person("saker", "youcef", 20);
        assertTrue(person.isAdult(), "Une personne de 20 ans doit être majeure");
    }
}