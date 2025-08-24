import {AfterViewChecked, Component, ElementRef, ViewChild} from '@angular/core';
import {NgClass, NgForOf} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {ButtonDirective} from 'primeng/button';
import {Image} from 'primeng/image';
import {Avatar} from 'primeng/avatar';
import {InputText} from 'primeng/inputtext';

@Component({
  selector: 'app-conversation',
  imports: [
    NgForOf,
    NgClass,
    FormsModule,
    ButtonDirective,
    Image,
    Avatar,
    InputText
  ],
  templateUrl: './conversation.html'
})
export class Conversation implements AfterViewChecked {
  @ViewChild('messagesContainer') private messagesContainer!: ElementRef;

  user = {
    avatarUrl: 'https://i.pravatar.cc/50',
    firstName: 'Clément',
    lastName: 'Lemlijn',
    nickname: 'clem'
  };

  messages = [
    { text: 'Salut !', isMine: false },
    { text: 'Hello, ça va ?', isMine: true },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: true },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: true },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: true },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: true },
    { text: 'Oui et toi ?', isMine: true },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false },
    { text: 'Oui et toi ?', isMine: false }
  ];

  newMessage = '';

  ngAfterViewChecked() {
    this.scrollToBottom();
  }

  scrollToBottom() {
    try {
      this.messagesContainer.nativeElement.scrollTop = this.messagesContainer.nativeElement.scrollHeight;
    } catch(err) { }
  }

  sendMessage() {
    if (this.newMessage.trim() === '') return;
    this.messages.push({ text: this.newMessage, isMine: true });
    this.newMessage = '';
  }

  goBack() {
    console.log('Retour en arrière');
  }
}
