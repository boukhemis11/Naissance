import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;




/**
 * 
 */

/**
 * @author boukh
 *
 */
public class LectureFichier {
	
	public static void main(String[] args) {

		try {
			File file = new File("C:/temp/naissances_depuis_1900.csv");
			List<String> lignes = FileUtils.readLines(file, "UTF-8");
			lignes.remove(0);
			ArrayList<Naissance> listeDesNaissances = new ArrayList<Naissance>();
			
			for (int i = 1; i < lignes.size(); i++) {
				String ligne = lignes.get(i);

				String[] morceaux = ligne.split(";");
				long annee = Long.parseLong(morceaux[1]);
				Date date = null;
				try {
					 date=new SimpleDateFormat("dd/MM/yyyy").parse(morceaux[2]);
				} catch (Exception e) {
					System.out.println("message :"+e.getMessage());
				}

				long nombre = Long.parseLong(morceaux[3]);

				Naissance naissance = new Naissance(annee, date, nombre);

				listeDesNaissances.add(naissance);
			}
			
			//afichage toute les données de l'année 1900
			listeDesNaissances.stream().filter(e -> e.getAnnee() == 1900).forEach(System.out::println);

			Long sum = listeDesNaissances.stream().filter(e -> e.getAnnee() == 1900).map(e -> e.getNombre()).reduce((t1, t2) -> t1 + t2).get();
			System.out.println("La somme est : " + sum);
			
			Long sum2 = listeDesNaissances.stream().filter(e -> e.getAnnee() == 1971).map(e -> e.getNombre()).reduce((t1, t2) -> t1 + t2).get();
			Long num = listeDesNaissances.stream().filter(e -> e.getAnnee() == 1971).map(e -> e.getNombre()).count();
			System.out.println("la moyenne est: "+sum2/num);
			


			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
