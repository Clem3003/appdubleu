package be.cbsaintlaurent.appdubleu.backend.bootstrap;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.repository.FolkloreSubjectRepository;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.service.FolkloreSubjectService;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.entity.QuestionEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.repository.QuestionRepository;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.service.QuestionService;
import be.cbsaintlaurent.appdubleu.backend.domain.season.repository.BaptismalSeasonRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
@Slf4j
public class DefaultFolkloreSubjectQuestionsBootstrap {

    private final QuestionService service;
    private final QuestionRepository repository;
    private final FolkloreSubjectService folkloreSubjectService;
    private final FolkloreSubjectRepository subjectRepository;
    private final BaptismalSeasonRepository baptismalSeasonRepository;

    @PostConstruct
    public void initDefaultUsers() {
            createIfNotExists("Quelle est la date de naissance légendaire de Tchantchès ?",
                    "14 juillet 1789",
                    "25 août 760",
                    "1er janvier 800",
                    "21 mars 1000",
                    2,true,"");
            createIfNotExists("Selon la légende, où Tchantchès serait-il né ?",
                    "Dans une ferme à Outremeuse",
                    "Entre deux pavés",
                    "Dans une barque sur la Meuse",
                    "Dans une taverne de Liège",
                    2,true,"");
            createIfNotExists("Quelle est la signification du nom “Tchantchès” en wallon ?",
                    "François",
                    "Jean",
                    "Pierre",
                    "Charles",
                    1,true,"");
            createIfNotExists("Entre quels deux territoires légendaires se situerait la naissance de Tchantchès ?",
                    "La principauté de Liège et Maastricht",
                    "La République libre d’Outremeuse et la commune libre de Saint-Pholien-des-Prés",
                    "La commune de Grivegnée et le quartier Saint-Léonard",
                    "La ville de Huy et la ville de Visé",
                    2,true,"");
        createIfNotExists("Dans le spectacle centré sur Tchantchès, quel rôle joue Charlemagne ?",
                "Le personnage principal",
                "Un personnage secondaire",
                "Il n’apparaît pas",
                "Le méchant",
                2,true,"");

        createIfNotExists("Quel est le sujet principal du second type de spectacle à Liège ?",
                "L’histoire de Charlemagne",
                "L’histoire de Roland",
                "La vie de Tchantchès",
                "La fondation de Liège",
                1,true,"");

        createIfNotExists("Dans le spectacle centré sur Charlemagne, comment apparaît Tchantchès ?",
                "Il est le héros principal",
                "Il n’apparaît pas",
                "Il fait quelques apparitions",
                "Il est le méchant",
                3,true,"");

        createIfNotExists("Pourquoi Tchantchès reste-t-il à l’écart de la foule jusqu’à ses dix ans ?",
                "Parce qu’il était malade",
                "Parce que son visage enlaidi le marginalise",
                "Parce qu’il était très timide",
                "Parce qu’il habitait loin du village",
                2,true,"");

        createIfNotExists("Lors de la Saint-Mâcrawe, comment est-il présenté dans le quartier ?",
                "Vêtu d’un costume royal",
                "Promené sur une chaise à porteurs, barbouillé de suie",
                "Portant une couronne de fleurs",
                "Sur un char fleuri décoré",
                2,true,"");

        createIfNotExists("Quel titre Tchantchès reçoit-il grâce à la sympathie populaire ?",
                "Roi de Liège",
                "Prince du « Djus d’la Mouse » (Outremeuse)",
                "Maire de la commune libre",
                "Seigneur des pavés",
                2,true,"");

        createIfNotExists("Qui Tchantchès rencontre-t-il lors d’une promenade le long de la Meuse ?",
                "Le roi Charlemagne",
                "Le chevalier Roland, neveu de Charlemagne",
                "Le duc de Bourgogne",
                "Le seigneur de Saint-Pholien",
                2,true,"");

        createIfNotExists("Où Tchantchès est-il introduit après sa rencontre avec Roland ?",
                "À la cour de Charlemagne",
                "Au château de Liège",
                "Dans une taverne d’Outremeuse",
                "Dans une abbaye",
                1,true,"");

        createIfNotExists("Pourquoi Tchantchès quitte-t-il le palais de Charlemagne ?",
                "Parce qu’il était malade",
                "Parce qu’il était inconsolable d’avoir dormi pendant la bataille de Roncevaux",
                "Parce qu’il voulait retourner à l’école",
                "Parce qu’il était exilé par Charlemagne",
                2,true,"");

        createIfNotExists("À quel âge Tchantchès meurt-il, et comment a-t-il passé sa fin de vie ?",
                "30 ans, en voyageant",
                "50 ans, en combattant",
                "40 ans, après une franche ripaille",
                "60 ans, en ermite",
                3,true,"");

        createIfNotExists("Dans la tradition locale, que représente Tchantchès ?",
                "Un héros national français",
                "Le prototype du « vrai Liégeois »",
                "Un roi légendaire belge",
                "Un saint protecteur",
                2,true,"");

        createIfNotExists("Quel trait de caractère décrit le mieux Tchantchès ?",
                "Servile et docile",
                "Mauvaise tête et esprit frondeur",
                "Timide et réservé",
                "Calculateur et froid",
                2,true,"");

        createIfNotExists("Comment est décrit le caractère social et moral de Tchantchès ?",
                "Ennemi du faste et des cérémonies",
                "Amoureux du luxe et des fêtes",
                "Indifférent aux causes nobles",
                "Toujours soumis aux puissants",
                1,true,"");

        createIfNotExists("Quelle est la qualité profonde de Tchantchès malgré son esprit rebelle ?",
                "Un coeur d’or",
                "Une grande richesse",
                "Un talent de stratège",
                "Une patience infinie",
                1,true,"");

        createIfNotExists("À Liège, quel type de spectacle est centré principalement sur Tchantchès ?",
                "L’« al brôtoule »",
                "Le théâtre antique",
                "La comédie musicale",
                "Le ballet classique",
                1,true,"");

        createIfNotExists("Quel effet provoquent le biscuit au pékèt et le hareng saur sur Tchantchès ",
                "Une soif inextinguible",
                "Une grande joie",
                "Un sommeil profond",
                "Une envie de danser",
                1,true,"");

        createIfNotExists("Qu’est-ce qui explique le nez difforme et rougeâtre de Tchantchès ?",
                "Il est né avec un nez spécial",
                "Sa mère d’accueil lui cogne la tête sur le rebord des fonds baptismaux",
                "Il s’est blessé en jouant dans la rue",
                "C’est une malédiction ancestrale",
                2,true,"");

        createIfNotExists("Quelle chanson à boire Tchantchès braillait-il déjà à sa naissance ?",
                "La mère Gaspard",
                "La chanson du hareng",
                "Le pékèt de Liège",
                "Le chant des pavés",
                1,true,"");

        createIfNotExists("Que donne le père adoptif à Tchantchès pour tenter de le calmer ?",
                "Un biscuit trempé dans le pékèt",
                "Un verre d’eau fraîche",
                "Une tranche de pain au beurre",
                "Un morceau de fromage",
                1,true,"");

        createIfNotExists("Avec quoi le père adoptif sert-il ensuite Tchantchès après le biscuit ?",
                "Un verre de vin rouge",
                "Un hareng saur",
                "Une tranche de jambon",
                "Un morceau de gâteau",
                2,true,"");
    }

    private void createIfNotExists(String prompt, String suggestedAnswer_1, String suggestedAnswer_2, String suggestedAnswer_3, String suggestedAnswer_4, Integer correctAnswer, boolean active, String pictureUrl) {
        if (!service.existsByQuestionPrompt(prompt)) {
            QuestionEntity questionEntity = new QuestionEntity();
            questionEntity.setPrompt(prompt);
            questionEntity.setFolkloreSubject(folkloreSubjectService.findByTitle("Tchantchès"));
            questionEntity.setSuggestedAnswer_1(suggestedAnswer_1);
            questionEntity.setSuggestedAnswer_2(suggestedAnswer_2);
            questionEntity.setSuggestedAnswer_3(suggestedAnswer_3);
            questionEntity.setSuggestedAnswer_4(suggestedAnswer_4);
            questionEntity.setCorrectAnswer(correctAnswer);
            questionEntity.setActive(active);
            questionEntity.setCreatedBy(null);
            questionEntity.setCreatedAt(LocalDateTime.now());
            var response = repository.save(questionEntity);
        }
    }
}
