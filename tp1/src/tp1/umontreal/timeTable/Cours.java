package tp1.umontreal.timeTable;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.*;
public class Cours {
	
	
	public int numero;
	public String sigle;
	public String nomDuCour;
	public LinkedList<Horaire> HorairesDuCours = new LinkedList<Horaire>() ;
	public int credit = 3;
	
	public Cours(int numero, String sigle, String nomDuCour) {
		
		this.numero = numero;                  // constructeur, les autres attributs non mentionnés resteront vide cependant
		this.sigle = sigle;
		this.nomDuCour = nomDuCour;
		
	}
	
	
	public void afficherIntituleDuCours() {
		
		System.out.println("Intitule du cours : ");
		System.out.println(this.sigle + " " + this.numero + " : " + this.nomDuCour);  

	}
	
	
	public int getNumero(){
		return this.numero;
	}
	public String getSigle(){
		return this.sigle;
	}
	public String getNomDuCours(){
		return this.nomDuCour;
	}
	public int getCredit(){
		return this.credit;
	}
	
	
	public void setNumero(int numero ){
		this.numero = numero ;
	}
	public void setSigle(String sigle){
		this.sigle =  sigle;
	}
	public void setNomDuCours(String nomDuCour){
		this.nomDuCour = nomDuCour;
	}
	public void setCredit(int credit){
		this.credit = credit ;
	}
	
	
    public void ajouterHoraire(Horaire horaire) {
    	this.HorairesDuCours.add(horaire);
    }
    
    
    
    public void demanderHoraire() {   // demande un horaire auquelle se tient le cours, c'est à dire ,le jour ,une heure de début et  une heure de fin
    	 
    	
    	Horaire horaire = new Horaire(1);
    	
    	System.out.println("A quelle jour se deroulera le cours ? ");
    	
    	for(int i = 0; i < horaire.semaine.length - 1 ; i++ ) {
    		
    		System.out.println( i+1 + ". " + horaire.semaine[i]);  //afficche les jour de la semaine
	
    	}
    	
    	String entrer = "0"; 
 	    String[] joursChoisie = {"1","2","3","4","5","6"};
 	    boolean choixCorrecte = false;
 	   
 	   while( ! choixCorrecte ) {   
 		   
 		System.out.println("Entrer un chiffre (EX: 1,3,5..) : \n");	
 		Scanner jourEntrer = new Scanner(System.in);                      //l'utilisateur reste conicé dans la boucle while tant que 
 	    entrer = jourEntrer.next();	                                        // le jour donné n'est pas correcte
 		
 	    for(int i = 0; i < joursChoisie.length; i++) {
 	    	
 	    	if(joursChoisie[i].equalsIgnoreCase(entrer)) {
 	    		choixCorrecte = true;
 	    	}
 	    }
 
 	              }
 
 	   horaire = new Horaire(Integer.parseInt(entrer));    //un nouvel horaire est crée avec le jour entrer
 	   
 	   String nomDuCour = this.sigle + " " + this.numero + " : " + this.nomDuCour;
 	   
 	   horaire.creerUnHoraire();                        // les heures de debut et de fin sont fixées
 	   horaire.demanderType();                          // le type est fixé
 	   
 	   System.out.println("/Les donnees suivants ont ete enregistre/ ");
 	   
 	   horaire.afficher(nomDuCour);
 	   this.HorairesDuCours.add(horaire);                 //le  nouvel horaire est ensuite ajouté à la liste de cours disponible
      	
    }
    
    
   public void modifierNomDuCours() {
	   
	   System.out.println("\nVeuillez entrer le nom du cours : ");
	   String entrer = "";
       Scanner choixEntrer = new Scanner(System.in);  // demande le nom du cours 
       
	   while( entrer == "" ) {      
	 		System.out.println("Entrer le nom du cours :");
	 	    entrer = choixEntrer.next();                // permet de s'assurer que le nom du cours n'est pas vide 
	 	   }
	   
	   
	   this.nomDuCour = entrer;
	  
	   System.out.println("Nom du cours modifiee.");

	   
   }   
   
   
 public void modifierSigle() {
	   
	   System.out.println("\nVeuillez entrer le Sigle du cours : ");
	   String entrer = "";
       Scanner choixEntrer = new Scanner(System.in);        // demande le sigle du cour
       
	   while( entrer == "" ) {      
	 		System.out.println("Entrer le nom du cours :");
	 	    entrer = choixEntrer.next();                  // permet de s'assurer ue le sigle du cour n'est pas vide 
	 	   }
	   
	   
	   this.sigle = entrer;
	  
	   System.out.println("Sigle du cours modifiee.");

	   
   }   
 
 public void modifierNumero() {
	   
	   System.out.println("Entrer le numero du cours : ");
       Scanner entrer = new Scanner(System.in);
                                                                         //demande le numero du cour
     try {  
		  int numero = entrer.nextInt();  
		  if(numero < 0 || numero > 99999) {
		    	 System.out.println( "Cette valeur est trop eleve ou trop basse.");    // si la valeur du numero n'est pas entre 0 et 99999
		    	 System.out.println( "Le numero de ce cour sera " + this.numero + ".");// aucune modifcation n'est faite
		  }else {
			  this.numero = numero;
	          System.out.println("\nModification effectuee. \n"); //si l'entrer n'est pas de type int, aucune modification n'est faites

		  }
		  
		  
	     } catch (InputMismatchException e){
	    	 System.out.println( "Le nombre de credit sera " + this.numero + ".");
		  }

	   
 }   


   
   
   
   
  public void modifierCredit() {
	  
	
		          System.out.println("\nEntrez le nombre de credit pour ce cours : \n");
		          Scanner entrer2 = new Scanner(System.in);
		                                                          //demande le nombre de crédit 
		        try {  
				  int credit = entrer2.nextInt();  
				  if(credit < 0 || credit > 8) {
				    	 System.out.println( "Cette valeur est trop eleve ou trop basse.");     // si la valeur du credit est trop bas ou trop haut			                                                                                  // aucune modifcation n'est faite
				    	 System.out.println( "Le nombre de credit sera " + this.credit + ".");  // aucune modifcation n'est faite
				  }else {
					  this.credit = credit;
			          System.out.println("\nModification effectuee. \n"); 

				  }
				  
				  
			     } catch (InputMismatchException e){
			    	 System.out.println( "Le nombre de credit sera " + this.credit + "."); //si l'entrer n'est pas de type int, aucune modification n'est faites
				  }
		     
	  

  }
  
  
  public void demanderToutesLesModifications() {
	  
	  Cours courCopie = new Cours(this.numero, this.sigle, this.nomDuCour);
	  courCopie.HorairesDuCours = this.HorairesDuCours;              //permet de faire une copie du cours qu'on manipulera plus tard
	  courCopie.credit =  this.credit;
	  
	  
	  System.out.println("\nQue desirer vous modifier? (entrer un chiffre)"); //présente les actions possibles a l'utilisateur
	    System.out.println("1- Nom du cours\n2- Sigle du cours\n3- Nombre de credit \n4- Numero du cours\n5- Modifier un horaire"
	    		+ "\n6- ajouter un horaire \n7- annuler");

       
	    String entrer = "0";
	    Scanner choixEntrer = new Scanner(System.in);
	    boolean bonChoix = false;
	    int choixAction = 0;
	    
	      while(!bonChoix)   {
	   System.out.println("Entrer votre reponse : ");	  
		entrer = choixEntrer.next();
		
	  for(int i = 0; i < 7; i++)  {  
		   if( entrer.equalsIgnoreCase(String.valueOf(i+1)) ){      
			   bonChoix = true;
			   choixAction = i+1;               //demander l'action a l'utilisateur, ce qu'il désire modifier;
		}
		   }
	  }
	      if(choixAction == 1) { 	  
	    	  courCopie.modifierNomDuCours();       //modifie le nom du cours
              this.nomDuCour = courCopie.nomDuCour;
              
	      } else if (choixAction == 2 ) {  
	    	  courCopie.modifierSigle();      //modifie le sigle du cours
              this.sigle = courCopie.sigle;
              
	      } else if (choixAction == 3 ) {	    	  
	    	  courCopie.modifierCredit();
              this.credit = courCopie.credit;  //modifie le nombre de credit du cours
 
	      } else if (choixAction == 4 ){  
	    	  courCopie.modifierNumero();
	    	  this.numero = courCopie.numero;
	    	 	  
	      } else if (choixAction == 5) {
         	  courCopie.modifierHoraire();          //modifie l'horaire d'un cours
	    	  this.HorairesDuCours = courCopie.HorairesDuCours;  
	    	  
	      }else if (choixAction == 6) {
         	  courCopie.demanderHoraire();          //demande un nouvel horaire et l'ajoute au horaire du cours
	    	  this.HorairesDuCours = courCopie.HorairesDuCours;
	      }

  }
  
  public void afficherHoraires() {
	  
	  System.out.println("\nHoraires : ");
		
		for(int i = 0; i < this.HorairesDuCours.size(); i++) {			
			Horaire horaire = this.HorairesDuCours.get(i);
			System.out.println(i+1 + ". De " + horaire.debut + " a " + horaire.fin + " ("+ horaire.semaine[horaire.joursActuelle-1]+")"
					+ " ("+ horaire.type +")");
			
		}
		
		if(this.HorairesDuCours.size() == 0 ) {
			System.out.println("   (vide)   ");
		}
	  
  }
  
  public int selectionnerHoraire() {  //permet à l'utilisateur de séléctionner un horaire
 
    System.out.println("\nQuel horaire souhaiter vous selectionner ? (entrer un chiffre)");
    
    String entrer = "0";
    Scanner choixEntrer = new Scanner(System.in);               
    boolean bonChoix = false;
    
      while(!bonChoix)   {
   	   System.out.println("Entrer votre reponse : ");	  
	   entrer = choixEntrer.next();
	
  for(int i = 0; i < this.HorairesDuCours.size(); i++)  {
	  
	   if( entrer.equalsIgnoreCase(String.valueOf(i+1)) ){   
		   Horaire horaire = this.HorairesDuCours.get(i);
		   System.out.println(i+1 + ". De " + horaire.debut + " a " + horaire.fin + " ("+ horaire.semaine[horaire.joursActuelle]+")"
					+ " ("+ horaire.type +")"); 
		   
		   bonChoix = true;
		   return i;            }
	    
  }
	   }
   
	 return 0; 
  }
  
  
  
  public void modifierHoraire() {
	  
	  Cours courCopie = new Cours(this.numero, this.sigle, this.nomDuCour);
	  courCopie.HorairesDuCours = this.HorairesDuCours;      //permet de faire une copie du cours qu'on manipulera plus tard
	  courCopie.credit =  this.credit;
	  
	  courCopie.afficherIntituleDuCours();  //présente les détails du cours
      courCopie.afficherHoraires();
	  	  
	  int choix = courCopie.selectionnerHoraire();
	  Horaire horaireChoisie = this.HorairesDuCours.get(choix); //selectionner l'horaire qu'on souhaite modifier
      
	  
	  horaireChoisie.afficher(this.sigle + " " + this.numero + " : " + this.nomDuCour);
	  
	    System.out.println("\nQue desirer vous modifier? (entrer un chiffre)"); //présente les actions possibles a l'utilisateur
	    System.out.println("1- Jour de l'horaire\n2- Heure(defut et fin)\n3- Type de l'horaire (tp ou th)\n4- Annuler");

         
	    String entrer = "0";
	    Scanner choixEntrer = new Scanner(System.in);
	    boolean bonChoix = false;
	    int choixAction = 0;
	    
	      while(!bonChoix)   {
	   System.out.println("Entrer votre reponse : ");	  
		entrer = choixEntrer.next();
		
	  for(int i = 0; i < 4; i++)  {  
		   if( entrer.equalsIgnoreCase(String.valueOf(i+1)) ){      
			   bonChoix = true;
			   choixAction = i+1;               //demander l'action a l'utilisateur, ce qu'il désire modifier;
		}
		   }
	  }
	      
	      if(choixAction == 1) { 
	    	  horaireChoisie.modifierJour();   //modifie le jour de l'horaire
 
	      } else if (choixAction == 2 ) {
	    	  horaireChoisie.creerUnHoraire();  //modifie l'heure de debut et l'heure de fin de l'horaire 

	      } else if (choixAction == 3 ) {	    	  
	    	  horaireChoisie.demanderType();    //modifie le type de l'horaire
 
	      } else {}
	      
    this.HorairesDuCours.get(choix).afficher(this.sigle + " " + this.numero + " : " + this.nomDuCour);  //presente l'horaire final avec ses modofications
	  
	  
  }

  

public void demanderTousLesHoraires() {  //continue par demander des horaires à  l'utilisateur
	                                    // jusqu'a ce que ce dernier entre "NON"

	 String entrer = "0";
	 boolean thereIsConflit = false;
	 
	 while(!entrer.equalsIgnoreCase("2")) {
		 
		 System.out.println("\nVoulez vous ajouter un horaire a ce cours ? \n1.Oui \n2.Non ");
		 Scanner choix = new Scanner(System.in);
	   
	   
	   while( ! (entrer.equalsIgnoreCase("1")|| entrer.equalsIgnoreCase("2"))) {      
		System.out.println("Entrer un chiffre (1 ou 2): \n");
	    entrer = choix.next();                                         
	   }
	   
	   if(entrer.equalsIgnoreCase("1")) {
		   Cours coursCopie =  new Cours(this.numero,this.sigle,this.nomDuCour);
		   coursCopie.HorairesDuCours = this.HorairesDuCours;
		   
		   coursCopie.demanderHoraire();
		   
		   thereIsConflit = coursCopie.verifierTousLesHorairesDunCours();
		   if(thereIsConflit) {
			   System.out.println("L'horaire ne peut pas etre ajoute car il cree un conflit");
		   }else {this.HorairesDuCours = coursCopie.HorairesDuCours;}
		   
		   
		   
		   entrer = "0";
		   
	   }
	 }
	   
  }    
  
  
     
	
    public void afficherPlanning() {  // affiche toutes les horaires du cours ainsi que les jours associé (sur toute la semaine)
    	
    	Horaire horaire = new Horaire(1);
    	String nomCours =  this.sigle + " " + this.numero + " : " + this.nomDuCour ;
    	
    	for(int i = 0; i < horaire.semaine.length -1; i++) {
    		
    		 System.out.println("\n" + horaire.semaine[i] + " : ");
    		 
    		for(Horaire h : this.HorairesDuCours) {
    			
    			if(h.joursActuelle == i+1){
    				
    				System.out.println(" De " + h.debut + " a " + h.fin + " : ");
    			  	System.out.println(nomCours + " / " + h.type);
    				
    			}
             }
    		
    	}
    	System.out.println("\n--------------------------------------");
    	
    }
    
    public boolean conflitHoraireEntreDeuxHoraires(Horaire horaire1, Horaire horaire2) {
  
    	String[] heuresPossibles = {"08h30","09h00","09h30","10h00","10h30","11h00","11h30","12h00","12h30",
 			   "13h00","13h30","14h00","14h30","15h00","15h30","16h00","16h30","17h00","17h30","18h00",
 			   "18h30","19h00","19h30","20h00","20h30","21h00","21h30","22h00","22h30","23h00","23h30"};
    	
    	boolean thereIsConflict = false;
    	
        LinkedList<String> horaire1Et2String = new LinkedList<String>() ;
    	
        horaire1Et2String.add(horaire1.debut) ;
        horaire1Et2String.add(horaire1.fin) ;
        horaire1Et2String.add(horaire2.debut) ;                  //les positions des horaires sont repérer dans le tableau heuresPossibles, puis les valeur sont stockées
        horaire1Et2String.add(horaire2.fin) ;  	                 // dans des linkedlist
    	
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
        	System.out.println("Conflit d'horaire");
        	thereIsConflict = true;
        	
        }else {
        	System.out.println("Pas de conflit d'horaire");
        	thereIsConflict = false;
        }   
 	   
 	   return thereIsConflict;
    }
    
    
	public boolean verifierTousLesHorairesDunCours() { //verifie tous les horaire d'un cours pour voir s'il y a un conflit d'horaires

		boolean thereIsConflict = false;
		
		 Cours coursCopie =  new Cours(this.numero,this.sigle,this.nomDuCour);
		 coursCopie.HorairesDuCours = this.HorairesDuCours;
		 
		for(int i = 0; i < coursCopie.HorairesDuCours.size(); i++) {
			
			for(int j = 0; j < coursCopie.HorairesDuCours.size(); j++) {
				
				if(i != j && (coursCopie.HorairesDuCours.get(i).joursActuelle == coursCopie.HorairesDuCours.get(j).joursActuelle)) {
					
boolean verificateur = coursCopie.conflitHoraireEntreDeuxHoraires(coursCopie.HorairesDuCours.get(i), coursCopie.HorairesDuCours.get(j));
			
           if(verificateur) {
        	   thereIsConflict = true; 
           }				
				}	
			}
		}
			
		return thereIsConflict;
	}
	


}