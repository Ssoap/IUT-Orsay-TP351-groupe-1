package Test;

import static org.junit.Assert.*;

import org.junit.Test;
import Classes.*;

public class TestAbonneFullText {
	
	@Test
	public void testObtenirArticle() {
		Article art = new Article("Article : Ceci est un test afin de tester les getters/setters");
		Resume re = new Resume("Résumé : Test unitaire");
		Contenu c = new Contenu(art,re);
		AbonneFullText a = new AbonneFullText(1, "nom", "prenom ",c);
		
		assertEquals("Article : Ceci est un test afin de tester les getters/setters",a.obtenirArticle());
	}

	@Test
	public void testObtenirResume(){
		Article art = new Article("Article : Ceci est un test afin de tester les getters/setters");
		Resume re = new Resume("Résumé : Test unitaire");
		Contenu c = new Contenu(art,re);
		AbonneFullText a = new AbonneFullText(1, "nom", "prenom ",c);
		
		assertEquals("Résumé : Test unitaire",a.obtenirResume());
	}
	
	@Test
	public void testObtenirInfos(){
		Article art = new Article("Article : Ceci est un test afin de tester les getters/setters");
		Resume re = new Resume("Résumé : Test unitaire");
		Contenu c = new Contenu(art,re);
		AbonneFullText a = new AbonneFullText(1, "nom", "prenom ",c);
		
		re.setTexteResume("Résumé : resumé rapide");
		art.setTexteArticle( "Article : 1324");
		assertEquals("Article : 1324 Résumé : resumé rapide",a.obtenirInfos());
	}
}
