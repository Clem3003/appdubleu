import { Component } from '@angular/core';
import {TableModule} from 'primeng/table';
import {Fieldset} from 'primeng/fieldset';
import {BaptismalSong, SongTypeEnum} from '../../../models/song.model';
import {PennePins} from '../../../models/pins.model';

@Component({
  selector: 'app-tab-pins',
  imports: [
    TableModule,
    Fieldset
  ],
  templateUrl: './tab-pins.html'
})
export class TabPins {

  protected pins: PennePins[] = [
    { id: '1', name: 'Abeille', definition: 'travail assidu bénévole dans une autre corporation estudiantine\n', remark: '' },
    { id: '2', name: 'Aigle germain', definition: 'Phiologie germanique', remark: '' },
    { id: '3', name: 'Alambic', definition: 'Chimie', remark: '' },
    { id: '4', name: 'Alambic et fourquet', definition: 'Brasserie', remark: '' },
    { id: '5', name: 'Ancre', definition: 'Amour de la navigation', remark: '' },
    { id: '6', name: 'Ane cadichon', definition: 'Blessé en guindaille', remark: '' },
    { id: '7', name: 'Anneaux olympiques', definition: 'Education physique', remark: '' },
    { id: '8', name: '* avec caducée médecine', definition: 'Kinésithérapie', remark: '' },
    { id: '9', name: 'Appareil photo', definition: 'Etudiant en photographie', remark: '' },
    { id: '10', name: 'Bacchus argenté', definition: 'Vice roi des bleus', remark: '' },
    { id: '11', name: 'Bacchus doré', definition: 'Roi des bleus', remark: '' },
    { id: '12', name: 'Balance', definition: 'Droit', remark: '' },
    { id: '13', name: 'Balance et glaive', definition: 'Criminologie', remark: '' },
    { id: '14', name: 'Ballon et cornu', definition: 'Assistant/jobbiste en labo', remark: '' },
    { id: '15', name: 'Bobine', definition: 'Physique', remark: '' },
    { id: '16', name: 'Bobine et éclairs', definition: 'Ingé industriel', remark: '' },
    { id: '17', name: 'Bourse', definition: 'Trésorier', remark: '' },
    { id: '18', name: 'Bouteille de champagne', definition: 'Coma éthylique prouvé', remark: '' },
    { id: '19', name: 'Bouteille de vin', definition: 'Amour du vin/ grosse cuite', remark: '' },
    { id: '20', name: 'Cadenas petit coeur', definition: 'Soumis', remark: '' },
    { id: '21', name: 'Caducée d\'Hermès', definition: 'Ingénieur commercial', remark: '' },
    { id: '22', name: 'Caducée des médecins', definition: 'Médecine', remark: '' },
    { id: '23', name: '* sur lauriers', definition: 'Vétérinaire', remark: '' },
    { id: '24', name: 'Caducée sur coupe', definition: 'Pharmacie', remark: '' },
    { id: '25', name: 'Caisse enregistreuse', definition: 'Comptabilité', remark: '' },
    { id: '26', name: 'Calice', definition: 'Séminariste', remark: '' },
    { id: '27', name: 'Caracole', definition: 'Namurois', remark: '' },
    { id: '28', name: 'Globe', definition: 'Géographie', remark: '' },
    { id: '29', name: 'Grappe de raisin', definition: 'Amour du vin / perte virginité', remark: '' },
    { id: '30', name: 'Grattoir et plume', definition: 'Histoire de l\'art archéologie', remark: '' },
    { id: '31', name: 'Grenouille argentée', definition: 'Vice délégué de cours', remark: '' },
    { id: '32', name: 'Grenouille dorée', definition: 'Délégué de cours/ prési de cercle', remark: '' },
    { id: '33', name: 'Homard', definition: 'Mène grand train de vie', remark: '' },
    { id: '34', name: 'Hure', definition: 'Luxembourgeois', remark: '' },
    { id: '35', name: 'Kangourou', definition: 'Grand dragueur', remark: '' },
    { id: '36', name: 'Koala', definition: 'S\'endort en guindaille', remark: '' },
    { id: '37', name: 'Lampe de pharmacien', definition: 'Infirmerie', remark: '' },
    { id: '38', name: 'Laurier double', definition: 'Sciences économiques', remark: '' },
    { id: '39', name: 'Lettres HPO', definition: 'Etudiant en orientale', remark: '' },
    { id: '40', name: 'Lime', definition: 'Gros baiseur', remark: '' },
  ];

}
