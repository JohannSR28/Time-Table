package tp1.umontreal.timeTable;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Horaire {
	
	public String[] semaine = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
	public String[] heuresPossibles = {"08h30","09h00","09h30","10h00","10h30","11h00","11h30","12h00","12h30",
			   "13h00","13h30","14h00","14h30","15h00","15h30","16h00","16h30","17h00","17h30","18h00",
			   "18h30","19h00","19h30","20h00","20h30","21h00","21h30","22h00","22h30","23h00","23h30"};
	public String debut;
	public String fin;

	public int joursActuelle = 0;
	public String type = "tp"; // ou th 

	
	
	public Horaire(int Numberjours) {
		this.joursActuelle = Numberjours;
	}
	
	public Horaire(int Numberjours, String debut, String fin, String type) {
		
		this.joursActuelle = Numberjours;
		this.debut = debut;
		this.fin = fin;
		this.type = type;

	}
	
	public void modifierJour() {
		
		System.out.println("Quel jour ce tient cette Horaire ?");
		
		for(int i = 0; i < this.semaine.length - 1 ; i++) {		 //affiche les jours de la semaine
	    	System.out.println( i+1 + "- " + this.semaine[i]);
		}
		
		System.out.println("Selectionnez un jours (entrez un chiffre) ?");

		
		String entrer = "0";
	    Scanner choixEntrer = new Scanner(System.in);
	    boolean bonChoix = false;
	    int Choix = 0;
	    
	      while(!bonChoix)   {
	   System.out.println("Entrer votre reponse : ");	  //demande et controle le jour entrer par l'utilisateur
		entrer = choixEntrer.next();
		
	  for(int i = 0; i < this.semaine.length - 1 ; i++)  {  
		   if( entrer.equalsIgnoreCase(String.valueOf(i+1)) ){      //enregiste le jour entrer par l'utilsateur
			   bonChoix = true;
			   Choix = i+1;
		}
		   }
	  }
	      
	      System.out.println("modification effectuee.");  //modifie le jour de l'horaire
	      this.joursActuelle = Choix;
		
		
		
		
		
		
		
		
	}

	public String demanderUneheure(int debutoufin) {
		
		String correspondance = "";
		
		String moment1 = "debute";
		String moment2 = "debut";     //permet de demander l'heure de debut ou de fin en fonction du parametre entré
		
		if(debutoufin == 0) {	
			moment1 = "fini";
			moment2 = "fin";		
		}
		
		String jours = this.semaine[this.joursActuelle-1];
		System.out.println("A quel heure " + moment1 + " le cours " + jours + " ? "); 

	   
	   Scanner heureEntrer = new Scanner(System.in);
	   String entrer = "";
	    
		System.out.println("\nEntrer une heure : ");

	    entrer = heureEntrer.nextLine();        //demande une heure 
	    
        String regex = "\\d\\d\\w\\d\\d";
        Pattern formatHeure = Pattern.compile(regex);
        Matcher matcher = formatHeure.matcher(entrer);
      
               
        
        if (matcher.find()) {                           //s'assure que l'heure entrée est dans le bon format
            correspondance = matcher.group();
          
        }else {
        	while(!matcher.find()) {
        	System.out.println("\nReesayer \nEntrer une heure (Ex: 08h00,09h30,22h00...) : "); 
    	    entrer = heureEntrer.nextLine();
    	    matcher = formatHeure.matcher(entrer);
    	    }
        	correspondance = matcher.group();
        
	                } 
	
	return correspondance; //retourne l'heure dans le bon format
	}
	
	
	public void creerUnHoraire() {
		
	 Horaire horaireCopier = new Horaire(this.joursActuelle);
	 
	String debut = horaireCopier.demanderUneheure(1);  //demande l'heure de début
	 
	 while(!estPresent(this.heuresPossibles,debut)) {
		 System.out.println("\nLes horaires doivent etre compris entre 08h30 et 23h30 et se presenter par intervalle de 30 min.");
		 debut = horaireCopier.demanderUneheure(1);	   // verifie que l'heure est sous la forme /d/dh00 ou /d/dh30
	 }
	 
	 System.out.println("Debut du cours : " + debut);
	 
	 
	 String fin = horaireCopier.demanderUneheure(0); //demande l'heure de fin
	 Boolean finValide = false;
	 
	 finValide = Integer.parseInt(fin.substring(0,2)) > Integer.parseInt(debut.substring(0,2));
	 finValide = finValide && estPresent(this.heuresPossibles,fin);   // condition pour s'assure que l'heure de fin est plus grande que l'heure de debut
	 	
	 while(!finValide) {
		 System.out.println("\nLes horaires doivent etre compris entre "+ debut +" et 23h30 et se presenter par intervalle de 30 min.");
		 fin = horaireCopier.demanderUneheure(0);	// verifie que l'heure est sous la forme /d/dh00 ou /d/dh30
		 
		 finValide = Integer.parseInt(fin.substring(0,2)) > Integer.parseInt(debut.substring(0,2));
		
		 if(!estPresent(this.heuresPossibles,fin)) {
			 finValide = false;
		 }
		 
	      } 
	  
	System.out.println("Fin du cours : " + fin);
 
	this.debut = debut;         // les valeurs de debut et de fin sont modifier suivant l'entré de 
	this.fin = fin;            //   l'utilisateur
	
	 
	}
	
	
	public void setType(int type) {
		
		switch(type){
			case 1:
				this.type = "tp";
			break;	
			case 2:
				this.type = "th";
			break;
			default:
		        System.out.println("Le type du cours sera mis a \"tp\" par defaut");
		        this.type = "tp";
		        break;
		}	
	}
	
	public String getType(int type) {
		
		String typeDeHoraire = "";
	
		switch(type){
		case 1:
			typeDeHoraire = "tp";
			break;
		case 2:
			typeDeHoraire = "th";
			break;
		default:
	        System.out.println("Le type du cours est \"tp\" par defaut");
	        typeDeHoraire = "tp";
	        break;		

		}
		return typeDeHoraire;	
	}
	
	public void demanderType() {
		
		System.out.println("\nL'heure donnee correspond a quel type d'horaire ? \n1- Travaux pratique(tp)"
				+ "\n2- Cour theorique(th) \n___ ");
		System.out.println("Entrer un chiffre : \n");            //affiche a l'utilisateur les types d'horaires

		
		int choixInt = 0;		
		Scanner choix = new Scanner(System.in);
		try{
			choixInt = choix.nextInt();                        //demande à l'utilisateur le type de l'horaire
			} catch(InputMismatchException exception){
			     choixInt = 0;	
			}
		
		
		if(choixInt == 0 || choixInt > 2) {
			System.out.println("Veuillez reessayer. \nL'heure donnee correspond a quel type d'horaire ? (Entrer un chiffre)"
					+ " \n1- Travaux pratique(tp) \n2- Cour theorique(th) \n___");
			System.out.println("Entrer un chiffre : \n");

			choix = new Scanner(System.in);              // demande une dernière fois le type de l'horaire en cas d'erreur
			try{   
				choixInt = choix.nextInt();
				} catch(InputMismatchException exception){
				     choixInt = 0;	
				       }
			
		}
		
		setType(choixInt);      //modifie le type de l'horaire
		
		System.out.println("L'horaire est maintenant associe au type " + this.type + ".");
	
	}
	
	
  public void afficher(String nomCours){
	  
	  String jours = this.semaine[this.joursActuelle-1];
	  
	  System.out.println("\n" +jours + " : ");
	  System.out.println(" De " + this.debut + " a " + this.fin + " : ");     //affiche le jour, l'heure de début, l'heure de fin le nom du cour et le type de l'horaire 
	  System.out.println(nomCours + " / " + this.type);
	  
  }
	


	public static boolean estPresent(String [] tableau, String heure) {
	    for ( String hour : tableau) {
	        if (heure.equals(hour)) {
	            return true;                       //retourne un boolean si le deuxieme parametre est un string qui appartient au tableau de string 
	        }                                      // placé en comme premier parametre  
	    }
	    return false;
	}
	
	
	
}