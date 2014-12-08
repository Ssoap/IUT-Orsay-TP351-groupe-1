package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.AbonneFullTextOnly;
import Classes.Article;
import Classes.Contenu;
import Classes.Resume;

public class TestAbonneFullTextOnly {
	
	@Test
	public void testObtenirArticle() {
		Article art = new Article("Article : Ceci est un test afin de tester les getters/setters");
		Resume re = new Resume("R�sum� : Test unitaire");
		Contenu c = new Contenu(art,re);
		AbonneFullTextOnly a = new AbonneFullTextOnly(1, "nom", "prenom ",art);
		
		assertEquals("Article : Ceci est un test afin de tester les getters/setters",a.obtenirTexteArticle());
	}
	
	@Test
	public void testObtenirInfos(){
		Article art = new Article("Article : Ceci est un test afin de tester les getters/setters");
		Resume re = new Resume("R�sum� : Test unitaire");
		Contenu c = new Contenu(art,re);
		
		AbonneFullTextOnly a = new AbonneFullTextOnly(1, "nom", "prenom ",art);
		assertEquals(art.getTexteArticle(), a.obtenirInfos());
	}
}
