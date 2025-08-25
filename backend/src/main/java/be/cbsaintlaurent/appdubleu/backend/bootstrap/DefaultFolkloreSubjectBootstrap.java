package be.cbsaintlaurent.appdubleu.backend.bootstrap;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.entity.FolkloreSubjectEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.repository.FolkloreSubjectRepository;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.service.FolkloreSubjectService;
import be.cbsaintlaurent.appdubleu.backend.domain.season.entity.BaptismalSeasonEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.season.repository.BaptismalSeasonRepository;
import be.cbsaintlaurent.appdubleu.backend.domain.season.service.BaptismalSeasonService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Year;

@Component
@AllArgsConstructor
@Slf4j
public class DefaultFolkloreSubjectBootstrap {

    private final FolkloreSubjectService service;
    private final FolkloreSubjectRepository repository;
    private final BaptismalSeasonRepository baptismalSeasonRepository;

    @PostConstruct
    public void initDefaultUsers() {
            createIfNotExists("Tchantchès", "La légende raconte que Tchantchès – François en wallon – est né par miracle le 25 août 760\\nentre deux pavés, entre la République libre d'Outremeuse et la commune libre de saint Pholien-des-Prés.\\nÀ sa naissance, le petit prodige brayait déjà une chanson à boire, la mère Gaspard. Ne cessant\\npas de brailler, son père adoptif décide de lui donner un biscuit trempé dans le pékèt et le\\nsèvre ensuite avec un hareng saur, ce qui provoque une soif inextinguible chez Tchantchès.\\nLors de son baptême, sa mère d'accueil lui cogne la tête sur le rebord des fonds baptismaux,\\nce qui explique son nez difforme et rougeâtre. À cause de son visage enlaidi, il reste à l'écart\\nde la foule jusqu'à ses dix ans durant lesquels il participe à la Saint-Mâcrawe où il est promené\\ndans tout le quartier, barbouillé de suie, sur une chaise à porteurs. Dès lors, il attire tellement\\nla sympathie populaire qu'il est élu prince du « Djus d'la Mouse » – Outremeuse en wallon. Il\\noublie alors sa laideur et se fait aimer de tous par sa bonté d'âme et ses espiègleries. Un jour,\\nalors qu'il se promène le long de la Meuse, il rencontre le chevalier Roland, neveu de\\nCharlemagne, avec qui il se lie d'amitié. Tchantchès est alors introduit à la cour et rencontre\\nCharlemagne. Inconsolable d'avoir dormi pendant la bataille de Roncevaux qui a coûté la vie\\nà son ami Roland, Tchantchès quitte le palais de Charlemagne à Aix-la-Chapelle et revient vivre\\ndans son quartier d'Outremeuse. Il meurt à l'âge de 40 ans, après une franche ripaille.\\nDans la tradition locale, Tchantchès incarne le prototype du « vrai Liégeois », mauvaise tête,\\nesprit frondeur, grand gosier, ennemi du faste et des cérémonies, indépendant mais au cœur\\nd'or, prompt à s'enflammer pour toutes les nobles causes.\\nÀ Liège, deux types de spectacles de marionnettes à tringle s'inspirent de cette légende : le\\npremier, l'« al brôtoule », est centré sur Tchantchès et Charlemagne n'est qu'un personnage\\nsecondaire tandis que le second raconte l'histoire de Charlemagne dans laquelle Tchantchès\\nfait quelques apparitions.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAztvjno4Zdfb5DmS71_Ja8RkZZ9O0R6Btmm6RC9O4lLzjX-TU7aCDxOM_YlRGM9BV8lIULH9P-nXWVC7WLdB13i47giUEqva7ZnjDm2A93A"); // TODO : REMOVE USER/PWD Admin/Admin123
    }

    private void createIfNotExists(String title, String content, String pictureURL) {
        if (!service.existsBySubjectTitle(title)) {
            FolkloreSubjectEntity folkloreSubjectEntity = new FolkloreSubjectEntity();
            folkloreSubjectEntity.setTitle(title);
            folkloreSubjectEntity.setContent(content);
            folkloreSubjectEntity.setPictureUrl(pictureURL);
            folkloreSubjectEntity.setCreatedBy(null);
            folkloreSubjectEntity.setCreatedAt(LocalDateTime.now());
            folkloreSubjectEntity.setBaptismalSeasonEntity(baptismalSeasonRepository.findFirstByActive(true));
            folkloreSubjectEntity.setActive(true);

            var response = repository.save(folkloreSubjectEntity);
        }
    }
}
