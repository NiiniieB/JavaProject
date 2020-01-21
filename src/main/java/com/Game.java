package com;
import org.slf4j.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game implements Commande {
    final static Scanner userInput = new Scanner(System.in);
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    private List<QuestionAnswer> listeQuestion = new ArrayList<>();
    private int step = 1;

    @Override
    public void InitGame() {
        LOG.debug("Bienvenue, le jeu commence dans un instant !! ");
        CreateQuestionAnswer();
    }

    @Override
    public void CreateQuestionAnswer() {
        listeQuestion.add( new QuestionAnswer("L'endroit où vivent toutes les sortes d'animaux est une arche de ? ", "noe"));
        listeQuestion.add( new QuestionAnswer("D'après un proverbe bien connu, le malheur des uns fait le bonheur des ? ", "autres"));
        listeQuestion.add( new QuestionAnswer("En France, quel numéro de téléphone doit-on composer pour joindre la police ? ", "17"));
        listeQuestion.add( new QuestionAnswer("Le sirop d'orgeat est un sirop qui contient de ?", "amande"));
        AskAnswer();
    }

    @Override
    public void AskAnswer() {
        for(QuestionAnswer i : listeQuestion){
            LOG.debug("Préparez vous la question arrive ! ");
            LOG.debug("La question est :");


            System.out.println(i.getQuestion());
            final String answer = userInput.next().toLowerCase();
            if(answer.equals(i.getAnswer())){
                if(step == 4) {
                    LOG.debug("Félicitations vous avez gagné un cookie !");
                    break;
                }
                LOG.debug("Bravo vous passez à l'étape suivante !");
                step++;

            }else{
                LOG.debug("perdu !");
            break;
        }
    }
}
}