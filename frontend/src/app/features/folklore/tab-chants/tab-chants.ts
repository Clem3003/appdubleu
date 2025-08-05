import {Component, inject, OnInit, signal, WritableSignal} from '@angular/core';
import {Accordion, AccordionContent, AccordionHeader, AccordionModule, AccordionPanel} from 'primeng/accordion';
import {HttpClient} from '@angular/common/http';
import {Panel} from 'primeng/panel';
import {IconField} from 'primeng/iconfield';
import {InputIcon} from 'primeng/inputicon';
import {InputText} from 'primeng/inputtext';
import {FormBuilder, FormGroup, ReactiveFormsModule} from '@angular/forms';
import {BaptismalSong, SongTypeEnum} from '../../../models/song.model';

@Component({
  selector: 'app-tab-chants',
  imports: [
    Accordion,
    AccordionPanel,
    AccordionHeader,
    AccordionContent,
    AccordionModule,
    Panel,
    IconField,
    InputIcon,
    InputText,
    ReactiveFormsModule
  ],
  templateUrl: './tab-chants.html'
})
export class TabChants implements OnInit {
  protected http = inject(HttpClient);
  protected fb = inject(FormBuilder);


  protected sacredSongs: BaptismalSong[] = [
    { id: '1', title: 'Saint-Laurent', songType: SongTypeEnum.SACRED_SONG, content: '' },
    { id: '2', title: 'La Brabançonne', songType: SongTypeEnum.SACRED_SONG, content: '' },
    { id: '3', title: 'Valeureux Liégeois', songType: SongTypeEnum.SACRED_SONG, content: '' },
    { id: '4', title: 'Ban Liégeois', songType: SongTypeEnum.SACRED_SONG, content: '' },
    { id: '5', title: 'Chant des étudiants wallons', songType: SongTypeEnum.SACRED_SONG, content: '' },
    { id: '6', title: 'Gaudéamous Igitur', songType: SongTypeEnum.SACRED_SONG, content: '' }
  ];
  protected filteredSacredSongs: WritableSignal<BaptismalSong[]> = signal<BaptismalSong[]>([]);
  protected committeeSongs: BaptismalSong[] = [
    { id: '1', title: 'ISIS', songType: SongTypeEnum.COMMITTEE_SONG, content: '' },
    { id: '2', title: 'Rivageois', songType: SongTypeEnum.COMMITTEE_SONG, content: '' },
    { id: '3', title: 'Sainte-Croix', songType: SongTypeEnum.COMMITTEE_SONG, content: '' },
    { id: '4', title: 'Sainte-Julienne', songType: SongTypeEnum.COMMITTEE_SONG, content: '' },
    { id: '5', title: 'Seraing', songType: SongTypeEnum.COMMITTEE_SONG, content: '' }
  ];
  protected filteredCommitteeSongs: WritableSignal<BaptismalSong[]> = signal<BaptismalSong[]>([]);
  protected traditionalSongs: BaptismalSong[] = [
    { id: '1', title: 'A-fond-Liégeois', songType: SongTypeEnum.TRADITIONAL_SONG, content: '' },
    { id: '2', title: 'Fanchon', songType: SongTypeEnum.TRADITIONAL_SONG, content: '' }
  ];
  protected filteredTraditionalSongs: WritableSignal<BaptismalSong[]> = signal<BaptismalSong[]>([]);

  protected form: FormGroup = this.fb.group({
    search: this.fb.control('', null)
  });

  ngOnInit() {
    this.initSongsContent();
  }

  private initSongsContent() {
    // Sacred
    this.http.get('assets/songs/sacred/Saint-Laurent.txt', { responseType: 'text' })
      .subscribe(data => {
        this.sacredSongs[0].content = data;
      });
    this.http.get('assets/songs/sacred/La_Brabançonne.txt', { responseType: 'text' })
      .subscribe(data => {
        this.sacredSongs[1].content = data;
      });
    this.http.get('assets/songs/sacred/Valeureux_Liégeois.txt', { responseType: 'text' })
      .subscribe(data => {
        this.sacredSongs[2].content = data;
      });
    this.http.get('assets/songs/sacred/Ban_Liégeois.txt', { responseType: 'text' })
      .subscribe(data => {
        this.sacredSongs[3].content = data;
      });
    this.http.get('assets/songs/sacred/Chant_des_étudiants_wallons.txt', { responseType: 'text' })
      .subscribe(data => {
        this.sacredSongs[4].content = data;
      });
    this.http.get('assets/songs/sacred/Gaudéamous_Igitur.txt', { responseType: 'text' })
      .subscribe(data => {
        this.sacredSongs[5].content = data;
      });
    // Comittee --------------------------------------------------------------------------------------------------------
    this.http.get('assets/songs/committee/ISIS.txt', { responseType: 'text' })
      .subscribe(data => {
        this.committeeSongs[0].content = data;
      });
    this.http.get('assets/songs/committee/Rivageois.txt', { responseType: 'text' })
      .subscribe(data => {
        this.committeeSongs[1].content = data;
      });
    this.http.get('assets/songs/committee/Sainte-Croix.txt', { responseType: 'text' })
      .subscribe(data => {
        this.committeeSongs[2].content = data;
      });
    this.http.get('assets/songs/committee/Sainte-Julienne.txt', { responseType: 'text' })
      .subscribe(data => {
        this.committeeSongs[3].content = data;
      });
    this.http.get('assets/songs/committee/Seraing.txt', { responseType: 'text' })
      .subscribe(data => {
        this.committeeSongs[4].content = data;
      });

    // Traditionnal ----------------------------------------------------------------------------------------------------
    this.http.get('assets/songs/traditional/A-fond-Liégeois.txt', { responseType: 'text' })
      .subscribe(data => {
        this.traditionalSongs[0].content = data;
      });
    this.http.get('assets/songs/traditional/Fanchon.txt', { responseType: 'text' })
      .subscribe(data => {
        this.traditionalSongs[1].content = data;
      });
    // Signals INIT

    this.filteredSacredSongs.set(this.sacredSongs)
    this.filteredCommitteeSongs.set(this.committeeSongs)
    this.filteredTraditionalSongs.set(this.traditionalSongs)

    this.form.valueChanges.subscribe((value) => {

      const filteredSacredSongsList: BaptismalSong[] = this.sacredSongs.filter(
        item => item.title.toLowerCase().includes(value.search.toLowerCase())
      );
      this.filteredSacredSongs.set(filteredSacredSongsList)

      const filteredCommitteeSongsList: BaptismalSong[] = this.committeeSongs.filter(
        item => item.title.toLowerCase().includes(value.search.toLowerCase())
      );
      this.filteredCommitteeSongs.set(filteredCommitteeSongsList)

      const filteredTraditionalSongsList: BaptismalSong[] = this.traditionalSongs.filter(
        item => item.title.toLowerCase().includes(value.search.toLowerCase())
      );
      this.filteredTraditionalSongs.set(filteredTraditionalSongsList)
    });
  }
}
