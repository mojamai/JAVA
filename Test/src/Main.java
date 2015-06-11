/**
 * Crée et pose un QCM.
 */
public class Main {

  public static void main(String[] args) {
    Questionnaire questionnaire = new Questionnaire("QCM de géographie");
    Question question = new Question("Qu'est-ce que Java ?");
    question.ajouterReponse("Une île de l'océan Atlantique", false);
    question.ajouterReponse("Une île de l'océan Indien", true);
    questionnaire.ajouterQuestion(question);
    question = new Question("Combien d'habitants en France ?");
    question.ajouterReponse("Moins de 20 millions", false);
    question.ajouterReponse("Entre 20 et 50 millions", false);
    question.ajouterReponse("Plus de 50 millions", true);
    questionnaire.ajouterQuestion(question);
	// Pour indiquer que la prochaine question à poser sera la 1ère question
	// et initialiser le total des points obtenus par l'utilisateur.
    questionnaire.reinitialiser();
    System.out.println(questionnaire.titre());
    System.out.println();
    while (questionnaire.resteDesQuestions()) {
      // Affiche une question et lit la réponse de l'utilisateur
      questionnaire.afficherQuestionSuivante();
      questionnaire.lireReponseQuestion();
    }
    System.out.println();
    System.out.println("Votre note : " + questionnaire.resultat());
    // Prépare le questionnaire pour la prochaine fois
    questionnaire.reinitialiser();
  }

}