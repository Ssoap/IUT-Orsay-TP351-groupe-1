package Classes;

public class ProgrammePrincipal {
	public static void main(String[] args){
		Article article = new Article("Article: Voici un article parlant de tout et de rien.");
		Resume resume =  new Resume("Résumé: Tout et rien.");
		Contenu nouvelles = new Contenu(article,resume);
		
		AbonneSMS abonne1 = new AbonneSMS(1,"Dupont","Jean", resume);
		AbonneFullText abonne2 = new AbonneFullText(2,"Dupond", "Serge", nouvelles);
		AbonneFullTextOnly abonne3 = new AbonneFullTextOnly(3,"Durant","Kevin",article);
		
		System.out.println(abonne1.getPrenom() +" "+abonne1.getNom()+ " affiche ses infos :" );
		System.out.println(abonne1.obtenirInfos());
		
		System.out.println(abonne2.getPrenom() +" "+abonne2.getNom()+ " affiche ses infos :" );
		System.out.println(abonne2.obtenirInfos());
		
		System.out.println(abonne3.getPrenom() +" "+abonne3.getNom()+ " affiche ses infos :" );
		System.out.println(abonne3.obtenirInfos());
	}
}
