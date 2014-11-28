package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.Article;
import Classes.Contenu;
import Classes.Resume;

public class TestArticle {

	@Test
	public void testGetTexte() {
		Article art = new Article("Ceci est un test afin de tester les getters/setters");
		
		assertEquals("Ceci est un test afin de tester les getters/setters", art.getTexteArticle());
	}
	
	@Test
	public void testSetTexte(){
		Article art = new Article("Ceci est un test afin de tester les getters/setters");
		
		String txt = "Un nouveau texte";
		art.setTexteArticle(txt);
		
		assertEquals("Un nouveau texte",art.getTexteArticle());
	}

}
