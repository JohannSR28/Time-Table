package tp1.umontreal.timeTable;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Programme {
	
	public Emploidutemps timetable;
	

	public Programme() {
		
		this.timetable = new Emploidutemps();
		
//Quelque valeur pour demarrer le programme, ces valeurs peuvent être supprimer plus tard	
		
	    Cours cour1 = new Cours(2200,"MAT" , "Analyse numerique");
	    Cours cour2 = new Cours(2567,"IFT" , "Programmation dynamique");
	    Cours cour3 = new Cours(98744,"MAT", "Theorie du chaos");

	    
	    Horaire horaire1 = new Horaire(1,"13h00","15h00","tp");
	    Horaire horaire2 = new Horaire(1,"15h00","17h00","tp");
	    
	    Horaire horaire3 = new Horaire(4,"09h00","10h00","th");
	    Horaire horaire4 = new Horaire(2,"11h00","12h30","tp");
	    
	    Horaire horaire5 = new Horaire(4,"15h00","17h00","th");
	    Horaire horaire6 = new Horaire(2,"12h00","13h00","tp");

	    cour1.ajouterHoraire(horaire1);
	    cour1.ajouterHoraire(horaire2);
	    cour2.ajouterHoraire(horaire3);
	    cour2.ajouterHoraire(horaire4);
	    cour3.ajouterHoraire(horaire5);
	    cour3.ajouterHoraire(horaire6);
 
        this.timetable.ajouterCours(cour1);       
        this.timetable.ajouterCours(cour2);
        this.timetable.ajouterCours(cour3);  
        
	}
	
    public void ExcecuterProgramme() { 
    	
    	boolean programmeEnCours = true;
    	
   while(programmeEnCours){ 	
    	 
  	    System.out.println("\nMENU : \nQue voulez vous faire ? (entrer un chiffre)"); //présente les actions possibles a l'utilisateur
  	    System.out.println("\n1- Voir les Cour(s) Disponible(s) / Cour(s) inscrit(s) "
  	    		+ "\n2- Inscrire un etudiant a un cour "
  	    		+ "\n3- Creer un cour "
  	    		+ "\n4- Modifier un cour"
  	    		+ "\n5- Voir les details d'un cours"
  	    		+ "\n6- Voir l'emploi du temps"
  	    		+ "\n7- Fermer le programme ");

         
  	    String entrer = "0";
  	    Scanner choixEntrer = new Scanner(System.in);
  	    boolean bonChoix = false;
  	    int choixAction = 0;
  	    
  	      while(!bonChoix)   {
  	   System.out.println("\nEntrer votre reponse : ");	  
  		entrer = choixEntrer.next();
  		
  	  for(int i = 0; i < 7; i++)  {  
  		   if( entrer.equalsIgnoreCase(String.valueOf(i+1)) ){      
  			   bonChoix = true;
  			   choixAction = i+1;               //demander l'action a l'utilisateur, qu'elle action il souhaite réaliser ;
  		}
  		   }
  	  }
  	      
  	    if(choixAction == 1) { 	  
	    	  
  	    	this.timetable.afficherCoursDisponible();          //affiche simplement tous les cours enregistré
  	    	this.timetable.afficherCoursDansLemploiDuTemps();
    	
  	    }  else if(choixAction == 2) { 	  
  	    	
	    	this.timetable.ajouterCoursDansLemploiDuTemps();	//permet l'inscription à des cours 
	    	
	    }  else if(choixAction == 3) {
	    	
	    	       if( this.timetable.coursDisponible.size() + this.timetable.coursDansLemploiDuTemps.size() < 10 ) {    	 	
	    	         	Cours nouveauCours = creerCours();
	    	         	nouveauCours.demanderTousLesHoraires();  //crée un cour et l'ajoute si le nombre de cours enregisté est inférieur 
	    	         	                                            // a 10
	    	         	this.timetable.ajouterCours(nouveauCours);
	    	       } else {   
	    	    	  System.out.println("\n***Nombre maximal de cour atteint.***\n");  	    	   
	    	       }
	    	       
	    }  else if(choixAction == 4) {       
	    	       
	    	this.timetable.modifierCours();
	    		       
	    }else if(choixAction == 5) {       
	    	  
	    	this.timetable.afficherUnCourPrecis();
	    	
	    }  else if(choixAction == 6) {
	    	
	    	this.timetable.afficherEmploiduTemps();
	    	
	    }  else if(choixAction == 7) {
	    	
	    	programmeEnCours = false; 
	    	
	    }
  	    
	    
  	      
   } //<--- fin  de la boucle while 
   
        }
    
    
    
    
    
  	  public static Cours creerCours() {
			 //permet de créer un cours
  		  
			System.out.println("Creation d'un nouveau cours");
			System.out.println("");
			
			System.out.println("Veuillez entrer le numero cours (ex: 3400, 2700...) : ");
		    Scanner scannerNumero = new Scanner(System.in);
		    
		    int numero = 0;
		    try {
		    	numero = scannerNumero.nextInt();
		    } catch(InputMismatchException exception) {
		    	
		     System.out.println("Echec, numero du cours non initialise");
		     System.out.println(" "); 
		     
		      }
		    
			System.out.println("Veuillez entrer le sigle du cours (ex: IFT, MAT,...) : ");
		    Scanner scannerSigle = new Scanner(System.in); 
		    String sigle = scannerSigle.nextLine();

			System.out.println("Veuillez entrer le nom du cours : ");
		    Scanner scannerNom= new Scanner(System.in);
		    String nom = scannerNom.nextLine();
			
			Cours courCree = new Cours(numero, sigle.toUpperCase(), nom);
			
			courCree.modifierCredit();
			System.out.println("le cours, " + courCree.sigle + " " +courCree.numero + " : " + courCree.nomDuCour + ", a ete cree. ");

			return 	courCree; 
				
			}
			
	   
  	      
  	      
} 	      
  	      
  	      
  	  