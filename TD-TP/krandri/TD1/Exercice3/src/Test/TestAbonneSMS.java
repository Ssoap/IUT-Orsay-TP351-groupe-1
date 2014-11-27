package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.AbonneSMS;
import Classes.Article;
import Classes.Contenu;
import Classes.Resume;

public class TestAbonneSMS {
		
	@Test
	public void testObtenirResume() {
		Article art = new Article("Ceci est un test afin de tester les getters/setters");
		Resume re = new Resume("Test unitaire");
		Contenu c = new Contenu(art,re);
		AbonneSMS a = new AbonneSMS(1, "nom", "prenom ",re);
		
		assertEquals("Test unitaire", a.obtenirResume());
	}
	
	@Test
	public void testObtenirInfos(){
		Article art = new Article("Ceci est un test afin de tester les getters/setters");
		Resume re = new Resume("Test unitaire");
		Contenu c = new Contenu(art,re);
		AbonneSMS a = new AbonneSMS(1, "nom", "prenom ",re);
		assertEquals(re.getTexteResume(), a.obtenirInfos());
	}
}
