package Test;

import static org.junit.Assert.*;

import org.junit.Test;
import Classes.Article;
import Classes.Contenu;
import Classes.Resume;

public class TestContenu {
	
	Article art = new Article("Ceci est un test afin de tester les getters/setters");
	Resume re = new Resume("Test unitaire");
	Contenu c = new Contenu(art,re);
	
	@Test
	public void testGetResume() {
		assertEquals("Test unitaire", c.getTexteResume());
	}

	@Test
	public void testGetArticle(){
		assertEquals("Ceci est un test afin de tester les getters/setters",c.getTexteArticle());
	}
	
	@Test
	public void testSetArticle(){
		String txt = "Voici un nouveau texte pour Article";
		c.setTexteArticle(txt);
		assertEquals("Voici un nouveau texte pour Article",c.getTexteArticle());
	}
	
	@Test
	public void testSetResume(){
		String txt = "ok";
		c.setTexteResume(txt);
		assertEquals("ok",c.getTexteResume());
	}
}
