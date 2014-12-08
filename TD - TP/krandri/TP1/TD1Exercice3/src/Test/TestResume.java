package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.Article;
import Classes.Contenu;
import Classes.Resume;

public class TestResume {

	Resume re = new Resume("Test unitaire");

	@Test
	public void testGetResume() {
		assertEquals("Test unitaire", re.getTexteResume());
	}
	
	@Test
	public void testSetResume(){
		String txt = "ok";
		re.setTexteResume(txt);
		assertEquals("ok",re.getTexteResume());
	}

}
