import java.util.ArrayList;

/**
 * Un QCM
 */
public class Questionnaire {
  /**
   * Les questions du QCM.
   */
  private ArrayList<Question> questions = new ArrayList<Question>();
  /**
   * Le numéro de la dernière question posée.
   */
  private int numeroQuestionEnCours = -1;
  /**
   * Le titre du Questionnaire.
   */
  private String titre;
  /**
   * Total des points gagnés par l'utilisateur
   */
  private int total = 0;

  /**
   * Crée un questionnaire avec un titre.
   * @param titre titre du questionnaire.
   */
  public Questionnaire(String titre) {
    this.titre = titre;
  }

  /**
   * Ajoute une question au questionnaire.
   * @param question
   */
  public void ajouterQuestion(Question question) {
    this.questions.add(question);
  }

  /**
   * Indique s'il reste des questions à poser.
   * @return true si et seulement s'il reste des questions à poser.
   */
  public boolean resteDesQuestions() {
    return numeroQuestionEnCours != questions.size() - 1;
  }

  /**
   * Réinitialise le QCM.
   * La prochaine question à poser sera la première question.
   */
  public void reinitialiser() {
    numeroQuestionEnCours = -1;
    total = 0;
  }

  /**
   * Retourne le résultat obtenu par l'utilisateur,
   * compte tenu des questions déjà posées.
   * La note est sur 20. Chaque bonne réponse
   * compte pour 1 point.
   * Par exemple, si l'utilisateur a répondu juste
   * à 3 questions sur 4 il aura la note de 15.
   * La note est arrondie à l'entier le plus proche.
   * @return la note sur 20.
   */
  public int resultat() {
    return Math.round(total / (float)(numeroQuestionEnCours + 1) * 20);
  }

  /**
   * Affiche la question suivante du questionnaire.
   */
  public void afficherQuestionSuivante() {
    if (numeroQuestionEnCours < questions.size() - 1) {
      numeroQuestionEnCours++;
      questions.get(numeroQuestionEnCours)
      .afficher("Question " + (numeroQuestionEnCours + 1) + ". ");
    }
  }

  /**
   * Lit la réponse au clavier la réponse de l'utilisateur
   * à la question qui vient d'être affichée.
   */
  public void lireReponseQuestion() {
    boolean bonneReponse = 
      questions.get(numeroQuestionEnCours).lireReponseAuClavier();
    if (bonneReponse) {
      total++;
    }
  }

  /**
   * Retourne le titre du QCM.
   * @return
   */
  public String titre() {
    return titre;
  }
  
  @Override
  public String toString() {
    return "Questionnaire [numeroQuestionEnCours=" + numeroQuestionEnCours
        + ", questions=" + questions + ", titre=" + titre + ", total=" + total
        + "]";
  }
}