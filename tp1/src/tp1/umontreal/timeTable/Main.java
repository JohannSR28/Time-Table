package tp1.umontreal.timeTable;


public class Main {

		public static void main(String[] args) {	
				
		    System.out.println("\nNB: Vous devez d'abord fermer le programme pour voir l'affichage des tests. ");
		
			
		  Programme programme = new Programme();
		  programme.ExcecuterProgramme();
		
		  
		    System.out.println("QUELQUES TESTS : \n");

		  //Quelques test :
		      
		    Emploidutemps timeTableTest = new Emploidutemps();
		    
		    Cours cour1 = new Cours(2200,"MAT" , "Analyse complexe ");
		    Cours cour2 = new Cours(2567,"IFT" , "Recherche de modele stochastiques ");
		    Cours cour3 = new Cours(9900,"MAT", "Algebre 3");

		    System.out.println("//verifier l'affichage du cour1 (sans horaire)");
		    System.out.println("Planning du cour1 : ");
		    cour1.afficherPlanning();
		    
		    Horaire horaire1 = new Horaire(1,"13h00","14h00","th");  //le premier paramètre représente le jour  (1 = lundi, 2 = samedi)
		    Horaire horaire2 = new Horaire(1,"14h00","16h00","tp");  // les deux qui suivent sont l'heure de début et l'heure de fin
		                                                             // le dernier paramètre est le type de l'horaire 
		    Horaire horaire3 = new Horaire(4,"09h00","10h00","th");
		    Horaire horaire4 = new Horaire(2,"11h00","12h30","tp");
		  
		    Horaire horaire5 = new Horaire(4,"15h00","17h00","th");
		    Horaire horaire6 = new Horaire(2,"12h00","13h00","tp");

		    cour1.ajouterHoraire(horaire1);
		    cour1.ajouterHoraire(horaire2);   
		    cour1.afficherIntituleDuCours();   //on affiche le nom et les horaires du cour1
		    cour1.afficherHoraires();
		    
		    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		    
		    cour2.ajouterHoraire(horaire3);
		    cour2.ajouterHoraire(horaire4);
		    cour2.afficherIntituleDuCours();   //on affiche le nom et les horaires du cour2
		    cour2.afficherHoraires();

		    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

		    
		    cour3.ajouterHoraire(horaire5);
		    cour3.ajouterHoraire(horaire6);
		    cour3.afficherIntituleDuCours();    //on affiche le nom et les horaires du cour3
		    cour3.afficherHoraires();
		    
		    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		    
		    System.out.println("//verifier l'affichage du cour1 (avec des horaires)");
		    System.out.println("Planning du cour1 : ");
		    cour1.afficherPlanning();

		    
		    System.out.println("//verifier s'il y'a des conflits entre certains horaires : \n");
  System.out.println(" conflit entre horaire 1 et horaire 2 : " + cour1.conflitHoraireEntreDeuxHoraires(horaire1, horaire2) + "\n" );
  System.out.println(" conflit entre horaire 3 et horaire 5 : " + cour1.conflitHoraireEntreDeuxHoraires(horaire3, horaire5) + "\n");
  System.out.println(" conflit entre horaire 4 et horaire 6 : " + cour1.conflitHoraireEntreDeuxHoraires(horaire4, horaire6) + "\n");
           
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            
		  System.out.println("//verifier si l'affichage de l'emploi du temps sans cours ");
             timeTableTest.afficherCoursDisponible();
             timeTableTest.afficherCoursDisponible();
             timeTableTest.afficherEmploiduTemps();
             
		    
		    timeTableTest.ajouterCours(cour1);       
		    timeTableTest.ajouterCours(cour2);  //ajout des cours à liste des cours disponobles
		    timeTableTest.ajouterCours(cour3);  
		  
	System.out.println("//verifier s'il y'a des conflits entre certains cours\n");

 System.out.println("1er cas :\n conflit entre cour1 et cour2 : " + timeTableTest.conflictEntreDeuxCoursExplicit(cour1, cour2) + "\n" ); //pas de conflits
 System.out.println("\n2eme cas :\n conflit entre cour1 et cour3 : " + timeTableTest.conflictEntreDeuxCoursExplicit(cour1, cour3) + "\n");  //pas de conflicts
 System.out.println("\n3eme cas :\n conflit entre cour2 et cour3 : " + timeTableTest.conflictEntreDeuxCoursExplicit(cour2, cour3) + "\n");  //conflit 
		  	  
		   
			}
		
	   }