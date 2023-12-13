package tp1.umontreal.timeTable;

import java.util.LinkedList;
import java.util.Scanner;

public class Emploidutemps {

	public LinkedList<Cours> coursDansLemploiDuTemps = new LinkedList<Cours>() ;
	public LinkedList<Cours> coursDisponible = new LinkedList<Cours>() ;

	
	public Emploidutemps() {
		//this.coursDansLemploiDuTemps.add(null);
	}

	public void ajouterCours(Cours cours) {
		this.coursDisponible.add(cours);
	}
	
	public void ajouterCoursDansLemploiDuTemps(Cours cours) {
		this.coursDansLemploiDuTemps.add(cours);
	}
	
	public void retirerCoursDisponible(int typeDeCours) {
		 this.coursDisponible.remove(typeDeCours);

	} 
	
	public void retirerCoursEmploiDuTemps(int typeDeCours) {
		 this.coursDansLemploiDuTemps.remove(typeDeCours);
	}
	

	public boolean conflictEntreDeuxCours(Cours cour1, Cours cour2) {
		
		Boolean thereIsConflict = false;
		for(Horaire h1 : cour1.HorairesDuCours) {
			for(Horaire h2 : cour2.HorairesDuCours) {  //verifie si deux horaires de deux cours differents sont en conflit,
					                                   // determine donc si deux cours sont en conflit d'horaire
			if (conflitHoraireEntreDeuxHoraires(h1,h2) && (h1.joursActuelle == h2.joursActuelle)) {
				
				thereIsConflict = true;
	
			    }				
			}		
		}                                  
		return thereIsConflict;
	}
	
 public boolean conflictEntreDeuxCoursExplicit(Cours cour1, Cours cour2) {
		
		Boolean thereIsConflict = false;
		for(Horaire h1 : cour1.HorairesDuCours) {
			for(Horaire h2 : cour2.HorairesDuCours) {          // se comporte exactement comme la fonction "conflictEntreDeuxCours" sauf qu'un message
					                                            // indique clairement le jour et les horaires en conflits
			if (conflitHoraireEntreDeuxHoraires(h1,h2) && (h1.joursActuelle == h2.joursActuelle)) {
				
				thereIsConflict = true;
				System.out.println("\nConflit d'horaire le " + h1.semaine[h1.joursActuelle-1] + " entre les cours : ");
				h1.afficher(cour1.sigle + " "+ cour1.numero + " : "+ cour1.nomDuCour);
				h2.afficher(cour2.sigle + " "+ cour2.numero + " : "+ cour2.nomDuCour);
				
			    }				
			}		
		}
		return thereIsConflict;
	}
	
	
    public static boolean conflitHoraireEntreDeuxHoraires(Horaire horaire1, Horaire horaire2) {
    	  
    	String[] heuresPossibles = {"08h30","09h00","09h30","10h00","10h30","11h00","11h30","12h00","12h30",
 			   "13h00","13h30","14h00","14h30","15h00","15h30","16h00","16h30","17h00","17h30","18h00",
 			   "18h30","19h00","19h30","20h00","20h30","21h00","21h30","22h00","22h30","23h00","23h30"};
    	
    	boolean thereIsConflict = false;
    	
        LinkedList<String> horaire1Et2String = new LinkedList<String>() ;
    	
        horaire1Et2String.add(horaire1.debut) ;
        horaire1Et2String.add(horaire1.fin) ;
        horaire1Et2String.add(horaire2.debut) ;
        horaire1Et2String.add(horaire2.fin) ;  	  //les positions des horaires sont repérer dans le tableau heuresPossibles, puis les valeur sont stockées
                                                        // dans des linkedlist
    	
    	
        LinkedList<Integer> horaire1Et2Integer = new LinkedList<Integer>() ;
    	
        for(int j = 0; j<horaire1Et2String.size(); j++) {
        	
    	for(int i = 0; i < heuresPossibles.length; i++) {  //ne tient pas compte du jours
    		
    		if(horaire1Et2String.get(j).equalsIgnoreCase(heuresPossibles[i])) {
    			
    			horaire1Et2Integer.add(i);                                 
    		
    		}
    	}
        }
        
       boolean cond1 =  (horaire1Et2Integer.get(0) < horaire1Et2Integer.get(2)) && (horaire1Et2Integer.get(2) < horaire1Et2Integer.get(1));
       boolean cond2 =  (horaire1Et2Integer.get(2) < horaire1Et2Integer.get(0)) && (horaire1Et2Integer.get(0) < horaire1Et2Integer.get(3));
       
       //on compare alors les index pour determiner si il y'a un conflit d'horaire 
       
        if(cond1 || cond2) {
        	thereIsConflict = true;
        	
        }else {
        	thereIsConflict = false;
        }   
 	   
 	   return thereIsConflict;
    }
	
	
	public void afficherCoursDisponible() {
		
		System.out.println("\nCour(s) disponible(s) : ");
		
		for(int i = 0; i < this.coursDisponible.size(); i++) {			
			Cours cours = coursDisponible.get(i);
			System.out.println(i+1 + ". " + cours.sigle + " " + cours.numero + " : " + cours.nomDuCour );
			
		}
		
		if(this.coursDisponible.size() == 0 ) {
			System.out.println("   (vide)   ");
		}
				
	}
	
	public void afficherCoursDansLemploiDuTemps() {
			
			System.out.println("\nCour(s) de l'emploi du temps : ");
			
			for(int i = 0; i < this.coursDansLemploiDuTemps.size(); i++) {			
				Cours cours = coursDansLemploiDuTemps.get(i);
				System.out.println(i+1 + ". " + cours.sigle + " " + cours.numero + " : " + cours.nomDuCour );
				
			}
			
			if(this.coursDansLemploiDuTemps.size() == 0) {
				System.out.println("   (vide)   ");
			}
					
		}
	
	public void afficherUnCourPrecis() {
		
		Emploidutemps emploiDuTempsCopie = new Emploidutemps() ;
		emploiDuTempsCopie.coursDisponible = this.coursDisponible;
		emploiDuTempsCopie.coursDansLemploiDuTemps = this.coursDansLemploiDuTemps; 

		
		System.out.println("\nQuel type de cours souhaiter vous voir ?(entrer un chiffre) : \n1- Cour(s) disponible(s) "
				+ "\n2- Cour de l'emploi du temps \n3- Annuler" );
		
		String entrer = "0";
        Scanner choixEntrer = new Scanner(System.in);
        
 	   while( ! (entrer.equalsIgnoreCase("1")|| entrer.equalsIgnoreCase("2")|| entrer.equalsIgnoreCase("3")) ) {      
 		System.out.println("Entrer un chiffre (1,2 ou 3): \n");
 	    entrer = choixEntrer.next();                              // permet de contraidre l'utilisateur a entrer le nombre 1,2 ou 3
 	   }
 	   
 	   if(entrer.equalsIgnoreCase("1") && emploiDuTempsCopie.coursDisponible.size() == 0) {
	        System.out.println("Operation impossible");       //impossible car le nombre de cours disponible est zéro
	        
       } else if (entrer.equalsIgnoreCase("2") && emploiDuTempsCopie.coursDansLemploiDuTemps.size() == 0){
   	          System.out.println("Operation impossible");            //impossible car le nombre de cours dans l'emploi de temps est zéro
   	          
        } else if(entrer.equalsIgnoreCase("1")){
        	
        	 int choix = emploiDuTempsCopie.selectionnerCoursDisponible(); 
        	 emploiDuTempsCopie.coursDisponible.get(choix).afficherIntituleDuCours();   // prensentation de toutes les informations relatif au cours
        	 emploiDuTempsCopie.coursDisponible.get(choix).afficherHoraires();
        	 System.out.println("Nombre de Credit : " + emploiDuTempsCopie.coursDisponible.get(choix).credit );

        	
        	
        }  else if(entrer.equalsIgnoreCase("2")) {
        	
        	int choix = emploiDuTempsCopie.selectionnerCoursEmploiduTemps();
        	emploiDuTempsCopie.coursDansLemploiDuTemps.get(choix).afficherIntituleDuCours();
       	    emploiDuTempsCopie.coursDansLemploiDuTemps.get(choix).afficherHoraires();   // prensentation de toutes les informations relatif au cours
       	    System.out.println("Nombre de Credit : " + emploiDuTempsCopie.coursDansLemploiDuTemps.get(choix).credit );
        	
      }  else {}
		
		
		
	}
	
		
	
	
	public int selectionnerCoursDisponible() {
		
		Emploidutemps emploiDuTempsCopie = new Emploidutemps() ;
		emploiDuTempsCopie.coursDisponible = this.coursDisponible;               // on fait une copie de l'emploie du temps(afin d'appeler les fonction déja crées)
		emploiDuTempsCopie.coursDansLemploiDuTemps = this.coursDansLemploiDuTemps;
	    emploiDuTempsCopie.afficherCoursDisponible(); 
        emploiDuTempsCopie.afficherCoursDansLemploiDuTemps();                       //affiche les cours disponible 
      
      System.out.println("\nQuel cour souhaiter vous selectionner parmis les cours disponible ? (entrer un chiffre  parmis les cours disponibles)");
      
        LinkedList<Integer> nombreDeCours = new LinkedList<Integer>() ;
        
        for( int i = 0; i < emploiDuTempsCopie.coursDisponible.size(); i++) {
        	nombreDeCours.add(i+1);                   
        }
        
        String entrer = "0"; 
 	    boolean choixCorrecte = false;
 	   
 	    while( ! choixCorrecte ) {   
 		   
 		Scanner choixCours = new Scanner(System.in);          //demande a l'utilisateur de rentrer un nombre 
 	    entrer = choixCours.next();	                           // si l'entrer est correcte (inférieur au égale au nombre de cours disponible),
 		                                                       // cette dernière est retourné
 	    for(int i = 0; i < nombreDeCours.size(); i++) {
 	    	
 	    	if(String.valueOf(nombreDeCours.get(i)).equalsIgnoreCase(entrer)) {
 	    		choixCorrecte = true;
 	    		return i;
 	    		
 	    	}
 	    }
 	    System.out.println("\nVeuillez reessayer. Quel cour souhaiter vous selectionner parmis les cours disponible ? (entrer un chiffre)");
              }
 	    
  
             return 0;
 	   
	}
	
	
	public int selectionnerCoursEmploiduTemps() {   
		
		Emploidutemps emploiDuTempsCopie = new Emploidutemps() ;
		
		emploiDuTempsCopie.coursDisponible = this.coursDisponible;
		emploiDuTempsCopie.coursDansLemploiDuTemps = this.coursDansLemploiDuTemps;   // on fait une copie de l'emploie du temps(afin d'appeler les fonction déja crées)
   	  emploiDuTempsCopie.afficherCoursDisponible(); 
      emploiDuTempsCopie.afficherCoursDansLemploiDuTemps();  //affiche les cours de l'emploi du temps
      
      System.out.println("\nQuel cour souhaiter vous selectionner dans l'emploi du temps ? (entrer un chiffre)");
      
        LinkedList<Integer> nombreDeCours = new LinkedList<Integer>() ;
        
        for( int i = 0; i < emploiDuTempsCopie.coursDansLemploiDuTemps.size(); i++) {
        	nombreDeCours.add(i+1);
        }
        
        String entrer = "0"; 
 	    boolean choixCorrecte = false;
 	   
 	    while( ! choixCorrecte ) {   
 		   
 		Scanner choixCours = new Scanner(System.in);
 	    entrer = choixCours.next();	                       //demande a l'utilisateur de rentrer un nombre 
 	                                                        // si l'entrer est correcte (inférieur au égale au nombre de cours disponible),
                                                             // cette dernière est retourné
 	    for(int i = 0; i < nombreDeCours.size(); i++) {
 	    	
 	    	if(String.valueOf(nombreDeCours.get(i)).equalsIgnoreCase(entrer)) {
 	    		choixCorrecte = true;
 	    		return i;
 	    		
 	    	}
 	    }
 	    System.out.println("\nVeuillez reessayer. Quel cour souhaiter vous selectionner dans l'emploi du temps ? (entrer un chiffre)");
              }
 	    
  
             return 0;
 	   
	}
	
	
	public void ajouterCoursDansLemploiDuTemps() {
	
		boolean thereIsConflict = false ;
		
        Emploidutemps emploiDuTempsCopie = new Emploidutemps() ;
		emploiDuTempsCopie.coursDisponible = this.coursDisponible;
		emploiDuTempsCopie.coursDansLemploiDuTemps = this.coursDansLemploiDuTemps;  // on fait une copie de l'emploie du temps(afin d'appeler les fonction déja crées)
		
		System.out.println("Souhaiter vous ajouter un cours a l'emploi du temps ? (entrer un chiffre) \n1- Oui\n2- Non");
	      

        String entrer = "0";
        Scanner choixEntrer = new Scanner(System.in);
        
 	   while( ! (entrer.equalsIgnoreCase("1")|| entrer.equalsIgnoreCase("2"))) {      
 		System.out.println("Entrer un chiffre (1 ou 2): \n");
 	    entrer = choixEntrer.next();                             //permet de comfirmer la volonter de l'utilisateur de s'inscrire
 	   }
 	   if(entrer.equalsIgnoreCase("1") && emploiDuTempsCopie.coursDisponible.size() == 0) {}
       else if(entrer.equalsIgnoreCase("1")){   

	     int choix = emploiDuTempsCopie.selectionnerCoursDisponible();   //l'utilisateur sélectionne un cours disponible 
	
	     if(String.valueOf(choix+1).equalsIgnoreCase("0")) {}
	     else {
	        emploiDuTempsCopie.ajouterCoursDansLemploiDuTemps(emploiDuTempsCopie.coursDisponible.get(choix));	
	        emploiDuTempsCopie.coursDisponible.remove(choix);       // ce dernier est ajouter au cours inscrit
	        
	 	    boolean verifierConflit = emploiDuTempsCopie.verifierTousLesCoursDunEmploiduTempsExplicit();
	 	    
	 	    if(verifierConflit) {
	 	        System.out.println("\n***Le cours mentionne ne peux pas etre ajouter car il cree un conflict horaire***"); 
	 	    	emploiDuTempsCopie.ajouterCours(emploiDuTempsCopie.coursDansLemploiDuTemps.getLast());
	 	    	emploiDuTempsCopie.coursDansLemploiDuTemps.removeLast();	 // s'il y'a un conflit d'horaire, le cours est retirer des cours inscrit
	 	    }                                                                // et remis dans les cours disponible 
	 	    		   
	 	    	
		emploiDuTempsCopie.afficherCoursDisponible();
	    emploiDuTempsCopie.afficherCoursDansLemploiDuTemps();         //on affiche les différents cours présents
	 	    	
	 	    }
	  	
	     }
	      } 
	     
	
	public void retirerCours() {
		
		Emploidutemps emploiDuTempsCopie = new Emploidutemps() ;
		emploiDuTempsCopie.coursDisponible = this.coursDisponible;
		emploiDuTempsCopie.coursDansLemploiDuTemps = this.coursDansLemploiDuTemps;  // on fait une copie de l'emploie du temps(afin d'appeler les fonction déja crées)

		
		System.out.println("\nQuel type de cours souhaiter vous retirier ?(entrer un chiffre) : \n1- Cour(s) disponible(s) (action definitive) "
				+ "\n2- Cour de l'emploi du temps \n3- Annuler" );
		
		String entrer = "0";
        Scanner choixEntrer = new Scanner(System.in);
        
 	   while( ! (entrer.equalsIgnoreCase("1")|| entrer.equalsIgnoreCase("2")|| entrer.equalsIgnoreCase("3")) ) {      
 		System.out.println("Entrer un chiffre (1,2 ou 3): \n");
 	    entrer = choixEntrer.next();  //permet de demander quel type de cours l'utiisateur souhaite retirer( cours inscrit ou cour disponible )
 	   }
 	   
 	   if(entrer.equalsIgnoreCase("1") && emploiDuTempsCopie.coursDisponible.size() == 0) {
	        System.out.println("Operation impossible");  // impossible de retirer des cours si la liste des cours disponibles est vide
	        
       } else if (entrer.equalsIgnoreCase("2") && emploiDuTempsCopie.coursDansLemploiDuTemps.size() == 0){
   	          System.out.println("Operation impossible");  // impossible de retirer des cours si la liste des cours de l'emploi du temps est vide
   	          
        } else if(entrer.equalsIgnoreCase("1")){
        	
        	 int choix = emploiDuTempsCopie.selectionnerCoursDisponible();  // sélection du cour
        	 emploiDuTempsCopie.retirerCoursDisponible(choix);
        	 emploiDuTempsCopie.afficherCoursDisponible();           //le cour selectionner est retirer
        	
        	
        }  else if(entrer.equalsIgnoreCase("2")) {
        	
        	int choix = emploiDuTempsCopie.selectionnerCoursEmploiduTemps();// sélection du cour
        	emploiDuTempsCopie.retirerCoursEmploiDuTemps(choix);    //le cour selectionner est retirer
        	emploiDuTempsCopie.afficherEmploiduTemps();
        	
      }  else {}
		
		
		
	}
	
	public void modifierCours() {
		
		Emploidutemps emploiDuTempsCopie = new Emploidutemps() ;
		emploiDuTempsCopie.coursDisponible = this.coursDisponible; // on fait une copie de l'emploie du temps(afin d'appeler les fonction déja crées)
		emploiDuTempsCopie.coursDansLemploiDuTemps = this.coursDansLemploiDuTemps; 
		
		emploiDuTempsCopie.afficherCoursDisponible();
		emploiDuTempsCopie.afficherCoursDansLemploiDuTemps();

		
		System.out.println("\nQuel type de cours souhaiter vous modifier ?(entrer un chiffre) : \n1- Cour(s) disponible(s) "
				+ "\n2- Cour de l'emploi du temps \n3- Annuler" );
		
		String entrer = "0";
        Scanner choixEntrer = new Scanner(System.in);
        
 	   while( ! (entrer.equalsIgnoreCase("1")|| entrer.equalsIgnoreCase("2")|| entrer.equalsIgnoreCase("3")) ) {      
 		System.out.println("Entrer un chiffre (1,2 ou 3): \n"); //permetde forcer l'utilisateur à rentrer 1,2 ou 3
 	    entrer = choixEntrer.next();                
 	   }
 	   
 	  if(entrer.equalsIgnoreCase("1") && emploiDuTempsCopie.coursDisponible.size() == 0) {
	        System.out.println("Operation impossible"); // impossible de modifier des cours si la liste des cours disponibles est vide
	        
     } else if (entrer.equalsIgnoreCase("2") && emploiDuTempsCopie.coursDansLemploiDuTemps.size() == 0){
 	          System.out.println("Operation impossible"); // impossible de modifier des cours si la liste des cours de l'emploi du temps est vide
 	          
      } else if(entrer.equalsIgnoreCase("1")){
      	
      	 int choix = emploiDuTempsCopie.selectionnerCoursDisponible(); 
      	 emploiDuTempsCopie.coursDisponible.get(choix).demanderToutesLesModifications(); //demande et réalise les modifications du cours disponible
      	 System.out.println("Presentation du cours : ");          
        	emploiDuTempsCopie.coursDisponible.get(choix).afficherPlanning();
        	
      	
      }  else if(entrer.equalsIgnoreCase("2")) {
      	
      	int choix = emploiDuTempsCopie.selectionnerCoursEmploiduTemps();
     	 emploiDuTempsCopie.coursDansLemploiDuTemps.get(choix).demanderToutesLesModifications(); //demande et réalise les modifications du coursde l'emploi du temps
      	 System.out.println("Presentation du cours : ");
     	emploiDuTempsCopie.coursDisponible.get(choix).afficherPlanning();


    }  else {}
		
 	
		
	}
	
	


	 
 
	

		
	
	public boolean verifierTousLesCoursDunEmploiduTemps() {  //retoure un boolean qui permet de savoir s'il y'a un comflit entre deux cours
		
	boolean thereIsConflict = false;	
		
       Emploidutemps emploiDuTempsCopie = new Emploidutemps() ;
		emploiDuTempsCopie.coursDisponible = this.coursDisponible;
		emploiDuTempsCopie.coursDansLemploiDuTemps = this.coursDansLemploiDuTemps;
		
		
		for(int i = 0; i < emploiDuTempsCopie.coursDansLemploiDuTemps.size() ; i++){
			
			for(int j = 0; j < emploiDuTempsCopie.coursDansLemploiDuTemps.size() ; j++) {
				
	if(emploiDuTempsCopie.conflictEntreDeuxCours(emploiDuTempsCopie.coursDansLemploiDuTemps.get(i), emploiDuTempsCopie.coursDansLemploiDuTemps.get(j))) {		
		thereIsConflict = true;
	}		
	 }
		}

		return  thereIsConflict;
		
	}
	
	public boolean verifierTousLesCoursDunEmploiduTempsExplicit() { //retoure un boolean qui permet de savoir s'il y'a un comflit entre deux cours
		                                                             // affiche un message qui explique la raison du conflit
	boolean thereIsConflict = false;	
		
       Emploidutemps emploiDuTempsCopie = new Emploidutemps() ;
		emploiDuTempsCopie.coursDisponible = this.coursDisponible;
		emploiDuTempsCopie.coursDansLemploiDuTemps = this.coursDansLemploiDuTemps;
		
		
		for(int i = 0; i < emploiDuTempsCopie.coursDansLemploiDuTemps.size() ; i++){
			
			for(int j = 0; j < emploiDuTempsCopie.coursDansLemploiDuTemps.size() ; j++) {
				
	if(emploiDuTempsCopie.conflictEntreDeuxCoursExplicit(emploiDuTempsCopie.coursDansLemploiDuTemps.get(i), emploiDuTempsCopie.coursDansLemploiDuTemps.get(j))) {		
		thereIsConflict = true;
	}		
	 }
		}

		return  thereIsConflict;
		
	}

	public void afficherEmploiduTemps() {  //Affiche l'emploi de temps sur une semaine
		
		    Emploidutemps emploiDuTempsCopie = new Emploidutemps() ;
			emploiDuTempsCopie.coursDisponible = this.coursDisponible;
			emploiDuTempsCopie.coursDansLemploiDuTemps = this.coursDansLemploiDuTemps;
			
			int totalCredit = 0;
			for(Cours c: this.coursDansLemploiDuTemps) {
				totalCredit += c.credit;
			}
		
			LinkedList<Horaire> TousLesHorairesEmploiDuTemps = new LinkedList<Horaire>() ;
		    LinkedList<String> TousLesNomsDeCoursPourLesHoraires = new LinkedList<String>() ;
		    
		    
		    for(int i = 0;  i < this.coursDansLemploiDuTemps.size(); i++){
		    
		    	Cours coursActuelle = this.coursDansLemploiDuTemps.get(i);
		    	
		    	for(int j = 0;  j < coursActuelle.HorairesDuCours.size(); j++) {
				   
		    		 String nomCours =  coursActuelle.sigle + " " + coursActuelle.numero + " : " + coursActuelle.nomDuCour;
				     Horaire horaire = coursActuelle.HorairesDuCours.get(j);
				     TousLesNomsDeCoursPourLesHoraires.add(nomCours);
				     TousLesHorairesEmploiDuTemps.add(horaire);	
		    	}

		    }
			

	    	Horaire horaire = new Horaire(1);
	    	
	    	for(int i = 0; i < horaire.semaine.length -1; i++) {
	    		
	    		 System.out.println("\n" + horaire.semaine[i] + " : ");
	    		 	
	    		for(int j = 0; j < TousLesHorairesEmploiDuTemps.size(); j++) {
	    			
	    			if(TousLesHorairesEmploiDuTemps.get(j).joursActuelle == i+1){
	    				
	 	System.out.println(" De " + TousLesHorairesEmploiDuTemps.get(j).debut + " a " + TousLesHorairesEmploiDuTemps.get(j).fin + " : ");
	    System.out.println(TousLesNomsDeCoursPourLesHoraires.get(j) + " / " + TousLesHorairesEmploiDuTemps.get(j).type);
	    				
	    			}
	             }   	    	
	           }
	    	
	    	System.out.println("\n--------------------------------------");
	    	System.out.println("TOTAL CREDIT EN COURS : " + totalCredit );
	    	System.out.println("--------------------------------------");

		
}
	
	}
	